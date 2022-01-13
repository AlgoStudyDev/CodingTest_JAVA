package programmers.dfsBfs;

import java.util.*;
public class 동성_네트워크_bfs {

    static int check[];
    static int nn;

    public void bfs(int i, int[][] computers, int []check) {
        Queue<Integer>queue=new LinkedList<>();
        queue.add(i);

        while (!queue.isEmpty()) {
            int size=queue.size();
            for (int k=0;k<size;k++) {
                int com=queue.poll();

                // com과 연결되어 있는 것 -> 찾기, 1이면 -> 큐에 넣기
                for (int j=0;j<nn;j++) {
                    if (computers[com][j]==1 && check[j]==0) {
                        queue.add(j);
                        check[j]=1; // 방문처리
                    }
                }

            }

        }
    }

    public int solution(int n, int[][] computers) {
        int answer = 0;
        check=new int[n];
        nn=n;

        for (int i=0;i<n;i++) {
            for (int j=0;j<n;j++) {
                if (computers[i][j]==1 && check[i]==0) {
                    check[i]=1;
                    bfs(i,computers,check);
                    answer++;
                }
            }
        }

        return answer;
    }


}
