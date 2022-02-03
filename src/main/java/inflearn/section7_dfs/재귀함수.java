package inflearn.section7_dfs;

import java.util.*;
// n 입력 -> 1~N까지 입력하는 코드 작성
public class 재귀함수 {

    static int n;
    static void dfs(int l) {
        if (l==n+1) {
            // 종료
            return;
        }
        System.out.print(l+" ");
        dfs(l+1);

    }

    public static void main(String[] args) {
        Scanner scan=new Scanner(System.in);
        n=scan.nextInt();
        dfs(1);
    }
}
