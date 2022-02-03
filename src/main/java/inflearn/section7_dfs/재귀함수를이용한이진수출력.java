package inflearn.section7_dfs;
import java.util.*;
// 10진수 입력 -> 재귀함수로 2진수 구하기
public class 재귀함수를이용한이진수출력 {

    static ArrayList<Integer> arraylist=new ArrayList<>();
    // 1. dfs(재귀로 문제 풀이)
    public static void dfs(int n) {
        if (n==0) { // n이 0이면 종료
            // 여기서 모아진것 출력
            Collections.sort(arraylist,Collections.reverseOrder());
            System.out.println(arraylist.toString());
        }
        else {
            arraylist.add(n%2); // 나머지 저장
            dfs(n/2);
        }

    }

    // 2. while을 이용하여 이진수 출력
    public static void while_2(int n) {
        // 몫이
        while (n==0) {
            // n이면 종료
            arraylist.add(n%2);
            n=n/2;
        }
        Collections.sort(arraylist,Collections.reverseOrder());
        System.out.println(arraylist.toString());

    }

    public static void main(String[] args) {
        Scanner scan=new Scanner(System.in);
        int n=scan.nextInt();
        dfs(n);
        while_2(n);
    }

}
