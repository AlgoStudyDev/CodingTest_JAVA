package inflearn.section7_dfs;
import java.util.*;

public class 송아지찾기bfs {

    static int[]dx={-1,1,5};
    static int target;
    static int answer;

    static int check[];

    public static void bfs(int start) {
        Queue<Integer>queue=new LinkedList<>();
        check[start]=1;
        queue.add(start);


        while (!queue.isEmpty()) {
            int size=queue.size();
            for (int i=0;i<size;i++) { // 큐 사이즈 만큼 돌음
                int k=queue.poll(); //여기서 큐를 뽑고
                for (int j=0;j<3;j++) { // 3개의 방향

                    int nx=k+dx[j]; // 큐를 추가하고
                    if (nx>=1 && nx<=10000 && check[nx]==0) {
                        queue.add(nx);
                        check[nx]=1; // 다시 못하게 한다.
                    }
                    // queue.add(nx);
                }
            }
            answer++; // 1번 돌았으니깐 증가

            // 만약 큐에 target이 담기면 종료
            if (queue.contains(target)) {
                System.out.println(answer);
                return;
            }
        }

    }
    public static void main(String[] args) {
        Scanner scan=new Scanner(System.in);
        int start=scan.nextInt();
        target=scan.nextInt();
        answer=0;
        bfs(start);
    }
}
