package inflearn.section8;
import java.util.*;
// 합이 홀수 일때 2로 나누면 절대 반이 될수 없음 -> 따라서 NO로 처리
// 합이 짝수 일때 dfs로 부분 집합 나누면 됨
    // dfs로 해당 원소 사용한다, 안한다로 풀면 됨
    // check 배열은 필요 없음 -> 이유는 dfs 원소의 합을 넣었기 때문에 hap으로 비교하면 됨
// 시간 단축을 위해 ck boolean을 사용 -> ck이면 dfs 더이상 타지 않고 종료 (가지치기)

public class 합이같은부분집합 {
    static int total;
    static int arr[];
    static int n;
    static boolean ck;

    public static void dfs(int l, int hap) {
        if (ck) return; // 시간 단축

        if (l==n) {
            // 이고 hap이 2로 나누었을때 절반과 같으면 종료
            if (hap*2==total) {
                ck=true;
            }
        }

        else {
            dfs(l+1,hap+arr[l]); // 사용
            dfs(l+1,hap); // 안사용
        }


    }

    public static void main(String[] args) {
        Scanner scan=new Scanner(System.in);
        n=scan.nextInt();
        arr=new int[n];
        total=0;
        int max=0;
        ck=false;
        for (int i=0;i<n;i++) {
            arr[i]=scan.nextInt();
            total+=arr[i];
        }

        if (total%2!=0) {
            System.out.println("NO");
        }
        else {
            // dfs
            dfs(0,0);
            if (ck) System.out.println("YES");
            else System.out.println("NO");
        }

    }
}
