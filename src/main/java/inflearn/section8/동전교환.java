package inflearn.section8;
import java.util.*;

//3
//1 2 5
//15
public class 동전교환 {

    static int n;
    static int target;
    static Integer arr[];
    static int answer;

    public static void dfs(int l, int hap) {
        if (answer<l) return;
        if (hap>target) return; // 더이상 할 필요도 없음.
        else if (hap==target)  {
            if (l<answer) answer=l; // 갱신
        }
        else {
            for (int i=0;i<n;i++) {
                dfs(l+1,hap+arr[i]);
            }
        }
    }

    public static void main(String[] args) {

        Scanner scan=new Scanner(System.in);
        n=scan.nextInt();
        arr=new Integer[n];
        for (int i=0;i<n;i++) {
            arr[i]=scan.nextInt();
        }
        target=scan.nextInt();

        Arrays.sort(arr,Collections.reverseOrder());

        answer=1000000;
        dfs(0,0);
        System.out.println(answer);

    }
}
