package inflearn.section7_dfs;
import java.util.*;
// 10을 입력 -> 10개의 피보나치 구하기
// 출력 : 1 1 2 3 5 8 13 21 34 55
public class 피보나치재귀 {

    static ArrayList<Integer> arraylist=new ArrayList<>();
    static int n;
    static int[]dp;
    // 방법 1.
    static void dfs(int l, int curr, int prev) {
        if (l==n) {
            // 종료 -> 그만 구함
            System.out.println(arraylist.toString());
            return;
        }
        else {
//            arraylist.add(l);
            arraylist.add(curr+prev); // 피보나치란 그 전값 + 현재 값
            dfs(l+1,curr+prev,curr); // 2, 1
        }
    }

    // 방법 2. dfs+DP를 이용해서 구하기
    // return 반드시 명시하기
    public static int dfs2(int l) {

        if (dp[l]>0) return dp[l];
        if (l==0 || l==1) {
            return dp[l]=1;
        }

        return dp[l]=dfs2(l-2)+dfs2(l-1); // dp[2] dfs2(0)+dfs2(1)

    }


    public static void main(String[] args) {
        Scanner scan =new Scanner(System.in);
        n=scan.nextInt();
//        arraylist.add(1); // 초기값
//        dfs(1,1,0); // 현재값, 그전값


        dp=new int[n]; // 10개
        // 하나하나 차근 차근 구하기
        for (int i=0;i<n;i++) {
            System.out.print(dfs2(i)+" ");
        }



    }
}
