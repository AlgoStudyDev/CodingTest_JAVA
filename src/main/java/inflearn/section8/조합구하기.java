package inflearn.section8;
// 조합은 dfs (int l, int start) 로 구함
import java.util.*;
public class 조합구하기 {

    static int n;
    static int m;
    static int arr[];
    static int ans[];

    static void dfs(int l, int start) {

        if (l==m) {
            // 종료
            System.out.println(Arrays.toString(ans));
            return; // return을 쓰거나 아니면 if ~else문을 사용할 것.

        }

        // 다음 시작부터 뻗어나가기
        for (int i=start;i<n;i++) {
            ans[l]=arr[i];
//            System.out.println(l);
//            System.out.println(Arrays.toString(ans));
            dfs(l+1,i+1);
        }
    }

    public static void main(String[] args) {

        Scanner scan=new Scanner(System.in);
        n=scan.nextInt();
        m=scan.nextInt();

        arr=new int[n];
        ans=new int[m];
        // 원소를 담음
        for (int i=0;i<n;i++) {
            arr[i]=i+1;
        }
//        System.out.println(Arrays.toString(arr));
        dfs(0,0);
    }

}
