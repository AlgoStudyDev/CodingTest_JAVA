package programmers.dfsBfs;
import java.util.*;
public class 동성_네트워크_크루스칼 {
    static int unf[];

    public int find(int v) {
        if (unf[v]==v) return v;
        else return unf[v]=find(unf[v]);
    }
    public void union(int a,int b) {
        int fa=find(a); //1
        int fb=find(b); //2

        if (fa!=fb) {
            unf[fa]=fb; //unf[1]=2
        }
    }

    public int solution(int n, int[][] computers) {

        unf=new int[n]; //1,2,3,4,5 -> unf[v] - 1,2,3,4,5
        for (int i=0;i<n;i++) {
            unf[i]=i;
        }



        for (int i=0;i<n;i++) {
            for (int j=0;j<n;j++) {
                if (i!=j && computers[i][j]==1) {
                    int fa=find(i); // 1
                    int fb=find(j); // 2

                    if (fa!=fb) {
                        union(i,j);
                    }
                }
            }
        }

        for (int i=0;i<unf.length;i++) {
//            find(i);
            System.out.println(unf[i]);
        }

        int answer=0;
        HashSet<Integer>hashset=new HashSet<>();
        for (int i=0;i<unf.length;i++) {
            hashset.add(unf[i]);
        }
        answer=hashset.size();



        return answer;
    }

}
