package inflearn.section8;
import java.util.*;
// 메모제이션 + 조합의 DFS를 이용
public class 조합의경우의수 {

    static int dy[][];
    static int n;
    static int m;


    public static int dfs(int n, int r) {
        if (dy[n][r]>0) return dy[n][r]; // 가지치기로 더 빠르게
        // 종료 조건
        if (n==r || r==0) return dy[n][r]=1;

        else {
            return dy[n][r]=dfs(n-1,r-1)+dfs(n-1,r);
        }
    }

    public static void main(String[] args) {
        Scanner scan=new Scanner(System.in);
        n=scan.nextInt();
        m=scan.nextInt();
        dy=new int[35][35]; // 최대한 크게 잡음
        dfs(n,m);
        System.out.println(dy[n][m]);
    }

}
