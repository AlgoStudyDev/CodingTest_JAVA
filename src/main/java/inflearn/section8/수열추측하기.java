package inflearn.section8;
import java.util.*;
// 순열과 이항계수 (개수)를 이용하여 수열 추측하기
public class 수열추측하기 {

    static int bin[];
    static int dy[][];
    static int arr[];
    static int n;
    static int target;
    static int ck[];

    static int binomial(int n, int r) {
        if (dy[n][r]>0) return dy[n][r];
        if (n==r || r==0) return dy[n][r]=1;
        else {
            return dy[n][r]=binomial(n-1,r-1)+binomial(n-1,r);
        }
    }

    static void dfs(int l, int hap) {
        // 순열 다 구하면 종료
        if (l==n) {
            // 종료
            System.out.println("target"+target);
            System.out.println("hap"+hap);
            if (hap==target) {
                System.out.println(Arrays.toString(arr));
            }
        }
        else {
            for (int i=1;i<=n;i++) {
                if (ck[i]==0) {
                    ck[i]=1;
                    arr[l]=i;
                    dfs(l+1,hap+(arr[l]*bin[l]));
                    ck[i]=0;
                }
            }
        }


    }

    public static void main(String[] args) {
        Scanner scan=new Scanner(System.in);
        n=scan.nextInt();
        target=scan.nextInt();
        bin=new int[n];
        dy=new int[35][35];
//        binomial(n-1); // n 개수 만큼 생성
        for (int i=0;i<=n-1;i++) {
            bin[i]=binomial(n-1,i);
        }
        System.out.println(Arrays.toString(bin));
        arr=new int[n];
        ck=new int[n+1];
//        for (int i=0;i<n;i++) {
//            arr[i]=i+1;
//        }
        dfs(0,0);
    }

}
