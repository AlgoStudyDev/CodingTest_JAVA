package inflearn.section8;
import java.util.*;

//5 20
//10 5
//25 12
//15 8
//6 3
//7 4

public class 최대점수구하기 {

    static int maxTime;
    static int n;
    static int max; // 점수 최종합
    static int arr[];
    static int timeArr[];

    public static void dfs(int l, int hap, int time) {
        if (l==n) {
            if (time>maxTime) return; // 사용 못함
            else if (hap>max) {
                max=hap; // 갱신
            }
        }
        else {
            dfs(l+1,hap+arr[l],time+timeArr[l]); // 사용
            dfs(l+1,hap,time); // 안사용
        }
    }

    public static void main(String[] args) {
        Scanner scan=new Scanner(System.in);
        n=scan.nextInt();
        maxTime=scan.nextInt();
        max=0;
        arr=new int[n];
        timeArr=new int[n];
        for (int i=0;i<n;i++){
            arr[i]=scan.nextInt();
            timeArr[i]=scan.nextInt();
        }

//        System.out.println("출력");
//        System.out.println(Arrays.toString(arr));
//        System.out.println(Arrays.toString(timeArr));

        dfs(0,0,0);
        System.out.println(max);


    }

}
