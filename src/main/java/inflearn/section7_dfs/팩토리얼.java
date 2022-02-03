package inflearn.section7_dfs;
import java.util.*;
// n이 주어지고 재귀함수로 팩토리얼 구하기
public class 팩토리얼 {
    static int n;
    public static void factorial(int k, int hap){
        if (k==n) {
            // 종료
            System.out.println(hap);
            return; // return 반드시 명시
        }
        factorial(k+1,hap*(k+1)); //1*2

    }

    public static void main(String[] args) {
        Scanner scan =new Scanner(System.in);
        n=scan.nextInt();
        factorial(1,1);
    }
}
