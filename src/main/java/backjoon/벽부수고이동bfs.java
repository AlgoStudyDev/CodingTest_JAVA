package backjoon;
import java.util.*;
public class 벽부수고이동bfs {

    static int n;
    static int m;
    static int check[][][];
    static int map[][];

    static int dx[]={0,1,0,-1};
    static int dy[]={1,0,-1,0};

    static int wild;

    static class Point{
        int x;
        int y;
        int dis;
        int wall; // 벽을 부수지 않으면 0 , 벽을 부수면 1 (현재 상태)
        Point(int x, int y,int dis, int wall) {
            this.x=x;
            this.y=y;
            this.dis=dis;
            this.wall=wall;
        }
    }

    static int bfs(int x, int y) {
        // 들어온거 방문처리
        check[x][y][0]=1; // 0은 벽을 부수지 않고 방문한 노드의 방문 여부
        check[x][y][1]=1; // 1은 벽을 부수면서 방문한 노드의 방문 여부
        Queue<Point>queue=new LinkedList<>();
        queue.add(new Point(x,y,1,0)); // 첫번째꺼 큐에 넣음

        //

        while(!queue.isEmpty()) {
            int size=queue.size();
            for (int i=0;i<size;i++) {
                Point point=queue.poll();

                // 종료 조건 , 가장 빠르게 오면 종료
                if (point.x==n-1 && point.y==m-1) {
                    return point.dis;
                }

                for (int j=0;j<4;j++) {
                    int nx=point.x+dx[j];
                    int ny= point.y+dy[j];

                    // nx ny가 맵에 있는 경우만 진행
                    if (nx>=0 && nx<n && ny>=0 && ny<m) {
                        // 조건 1. 벽이 아니라면 이동
                        if (map[nx][ny]==0) {
                            if (check[nx][ny][point.wall]==0) { //현재 지점이 벽이 아니고, 아직 방문하지 않았으면 방문
                                check[nx][ny][point.wall]=1;
                                queue.add(new Point(nx,ny,point.dis+1,point.wall)); // 큐에 넣음, 벽의 상태
                            }
                        }

                        // 조건 2. 벽일때는 조건 확인하고 부수면서 이동
                        else if (map[nx][ny]==1) {
                            if (point.wall==0 && check[nx][ny][1]==0) { //아직 벽을 부수는 기술을 쓰지 않았고, 벽을 부수면서 이동한 배열이 방문하지 않았으면
                                check[nx][ny][1]=1;
                                queue.add(new Point(nx,ny,point.dis+1,1));// 방문처리
                            }
                        }
                    }
                }
            }

        }

        return -1;
    }

    public static void main(String[] args) {


        Scanner scan=new Scanner(System.in);
        n=scan.nextInt();
        m=scan.nextInt();

        map=new int[n][m];
        check=new int[n][m][2]; //방문 배열
        for (int i=0;i<n;i++) {
            String str=scan.next();
            for (int j=0;j<m;j++) {
                map[i][j]=Integer.parseInt(str.charAt(j)+"");
            }
        }

        System.out.println(bfs(0,0));

    }

}
