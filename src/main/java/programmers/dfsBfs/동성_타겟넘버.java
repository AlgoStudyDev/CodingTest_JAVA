package programmers.dfsBfs;
import java.util.*;
public class 동성_타겟넘버 {

    static int res; //targetNumber
    static int ans[]; // numbers[]
    static int n; //numbers[]의 개수

    static int answer; //정답

    public static void dfs(int l, int hap) {

        if (l==n) {
            if (hap==res) { // 여기에서 주의점은 if(l==n && hap==res)로 하면 안됨 -> if문에 못걸리기 때문에 다음 else 문 실행시키기 때문에 에러 발생
                answer++;
            }
        }
        else {
            dfs(l+1,hap+ans[l]);
            dfs(l+1,hap-ans[l]);
        }


    }

    public static int solution(int[] numbers, int target) {
        n=numbers.length;
        ans=new int[n];
        for (int i=0;i<n;i++) {
            ans[i]=numbers[i];
        }
        res=target;
        answer=0;
        dfs(0,0);

        return answer;
    }

    public static void main(String[] args) {
        int arr[]={1,1,1,1,1};
        solution(arr,5);
    }
}
