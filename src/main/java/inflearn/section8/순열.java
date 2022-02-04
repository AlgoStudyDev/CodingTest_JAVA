package inflearn.section8;
import java.util.*;
//3 2
//3 6 9

public class 순열 {

    static int arr[];
    static int check[];
    static int ans[];
    static int n;
    static int m;

    public static void dfs(int l) {
        if (l==m) {
            // 종료
            System.out.println(Arrays.toString(ans));
        }
        else {
            for (int i=0;i<n;i++) {
                if (check[i]==0) { // 원소 사용 여부, 사용 안했으면
                    check[i]=1; // 원소 사용을 1로 처리
                    ans[l]=arr[i]; //답에는 i번째 원소를 넣어줌
                    dfs(l+1); // 다음으로 진행
                    check[i]=0; // 다시 풀어줌 (다시 사용하기 위해서)
                }
            }
        }


    }

    public static void main(String[] args) {
        Scanner scan=new Scanner(System.in);
        n=scan.nextInt();
        m=scan.nextInt();
        arr=new int[n];
        check=new int[n]; // 원소 사용 여부
        ans=new int[m];

        for (int i=0;i<n;i++) {
            arr[i]=scan.nextInt();
        }

        dfs(0);


    }
}
