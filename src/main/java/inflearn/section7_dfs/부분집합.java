package inflearn.section7_dfs;
// dfs로 부분집합 구하기
// 원소 5개 {1,3,5,7,9}
import java.util.*;
public class 부분집합 {

    static int check[]; // 원소 사용여부
    static int n;
    static int ans[]; // 정답을 담을 공간
    static int arr[]; // 원소를 담을 공간

    static int count;
    public static void dfs(int l) {
        if (l==n) {
            // 원소를 다 사용
            // 사용한것만 뽑음
            for (int i=0;i<n;i++) {
                if (check[i]==1) {
                    System.out.print(ans[i]+" ");
                }
            }
            count++;
            System.out.println();
        }
        else {
            // 사용
            check[l]=1;
            ans[l]=arr[l]; // 사용
            dfs(l+1);

            // 안사용
            check[l]=0;
            ans[l]=0;
            dfs(l+1);

        }

    }

    public static void main(String[] args) {
        Scanner scan=new Scanner(System.in);
        n=scan.nextInt(); // 5개
        check=new int[n]; // n개 만큼
        ans=new int[n]; // n개
        arr=new int[n];
        for (int i=0;i<n;i++) {
            arr[i]=scan.nextInt(); //{1,3,5,7,9}
        }

        dfs(0);
        System.out.println("총 몇개:"+count);
    }


}
