package inflearn.section8;
import java.util.*;
public class 바둑이승차 {
    static boolean flag; // 시간 단축
    static int n;
    static int arr[];
    static int c;
    static int max;


    public static void dfs(int l, int hap) {
        if (flag) return; // 시간 단축
        if (l==n) {
            if (hap>c) return; // 사용 불가
            else if (max<hap){
                max=hap; // 사용 가능, max값 갱신
            }
        }
        else {
            dfs(l+1,hap+arr[l]); // 사용
            dfs(l+1,hap); // 안사용

        }
    }

    public static void main(String[] args) {
        Scanner scan=new Scanner(System.in);
        c=scan.nextInt();
        n=scan.nextInt();
        max=0;
        arr=new int[n];
        for (int i=0;i<n;i++) {
            arr[i]=scan.nextInt();
        }
        dfs(0,0);
        System.out.println(max);

    }
}
