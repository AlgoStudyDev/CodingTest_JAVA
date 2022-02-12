package inflearn.section9;
import java.util.*;
public class 친구인가 {

    static int unf[];

    static int find(int v) {
        if (unf[v]==v) {
            return v;
        }
        else {
            return unf[v]=find(unf[v]);
        }
    }

    static void union(int a,int b) {
        int fa=find(a); //unf[a]가 아니라 find
        int fb=find(b);

        if (fa!=fb) {
            unf[fa]=fb; //unf[fa] 집합으로 맞춰줘야 함.
        }
    }

    public static void main(String[] args) {
        Scanner scan=new Scanner(System.in);

        int n=scan.nextInt();
        int m=scan.nextInt();

        // n개 만큼
        unf =new int[n+1]; // 1부터 진행
        // 자기자신으로 만들어줌
        for (int i=1;i<=n;i++) {
            unf[i]=i;
        }

        // m개 만큼 친구
        for (int i=1;i<=m;i++) {
            int a=scan.nextInt();
            int b=scan.nextInt();
            int fa=unf[a];
            int fb=unf[b];
//            union(a,b);
            if (fa!=fb) {
                union(a,b);
            }
        }

        // 마지막 입력
        int v1=scan.nextInt();
        int v2=scan.nextInt();


        // 경로 압축
        for (int i=0;i<n;i++) {
            find(i);
        }
//        find(v1);
//        find(v2);

//        System.out.println(Arrays.toString(unf));
        for (int i=0;i< unf.length;i++) {
            System.out.println("i:"+i+" "+"unf[i]"+unf[i]);
        }

        if (unf[v1]==unf[v2]) {
            System.out.println("YES");
        }
        else {
            System.out.println("NO");
        }


    }
}
