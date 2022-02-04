package inflearn.section8;
import java.util.*;
public class 미로의최단거리통로 {

    static int map[][];
    static int check[][];
    static int n;
    static int dx[]={0,1,0,-1};
    static int dy[]={1,0,-1,0};
    static int answer=0;
    static class Point{
        int x;
        int y;
        Point (int x, int y) {
            this.x=x;
            this.y=y;
        }
    }

    public static void bfs(int x, int y) {
        Queue<Point> queue=new LinkedList<>();
        queue.add(new Point(x,y));
        check[x][y]=1; // 방문 처리

        while(!queue.isEmpty()) {
            int size=queue.size();

            for (int i=0;i<size;i++) {
                Point point=queue.poll();
                int xx=point.x;
                int yy=point.y;

                for (int k=0;k<4;k++) {
                    int nx=xx+dx[k];
                    int ny=yy+dy[k];

                    // 이 4방향이 갈 수 있으면 큐에 넣어줌
                    if (nx>=0 && nx<n && ny>=0 && ny<n) {
                        if (map[nx][ny]==0 && check[nx][ny]==0) {
                            check[nx][ny]=1; // 방문 처리
                            queue.add(new Point(nx,ny));
                        }
                    }
                }
            } // 4방향 순환하고 for문을 다 사용했으면 answer++증가 해주기
            answer++;
            // 그리고 큐 안에 도착지가 있으면 종료
            for (Point point1:queue) {
                if (point1.x==n-1 && point1.y==n-1) {
                    System.out.println(answer);
                    return;
                }
            }
        }

    }

    public static void main(String[] args) {
        n=7;
        Scanner scan=new Scanner(System.in);
        check=new int[n][n];
        map=new int[n][n];
        for (int i=0;i<n;i++) {
            for (int j=0;j<n;j++) {
                map[i][j]=scan.nextInt();
            }
        }

        bfs(0,0);


    }
}
