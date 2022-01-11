package programmers.bruteforce;
import java.util.*;
public class 동성_소수찾기 {
    static int numArray[]; // 문제를 담을 공간
    static int check[];
    static int answer[]; // 정답을 담을 공간
    static int n;
    static int m;
    static ArrayList<Integer> answerList;

    public static void dfs(int l) {
        if (l==m) {
            // 출력
        }
        else {
            for (int i=0;i<n;i++) {
                if (check[l]==0) {
                    check[l]=1;
                    answer[l]=numArray[i];
                    dfs(l+1);
                    check[l]=0;
                }
            }
        }
    }

    public static int solution(String numbers) {
        int answer = 0;

        String []array=numbers.split("");
        n=array.length; // 전체 갯수
        numArray=new int[n];
        check=new int[n];
        m=n; // 뽑은 갯수
        for (int i=0;i<array.length;i++) {
            numArray[i]=Integer.parseInt(array[i]);
        }

        System.out.println(Arrays.toString(numArray));

        dfs(0);


        return answer;
    }

    public boolean isPrime(int num) {
        boolean answer=true;

        for (int i=2;i<num;i++) {
            if (num%i==0) {
                answer=false;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        solution("17");
    }
}
