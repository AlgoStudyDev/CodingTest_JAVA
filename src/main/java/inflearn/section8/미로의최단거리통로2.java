package inflearn.section8;
import java.util.*;
public class 미로의최단거리통로2 {

    static int map[][];
    static int dis[][];
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
        map[x][y]=1; // map에 방문처리 (첫번쨰 방문처리)

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
                        if (map[nx][ny]==0) {
                            map[nx][ny]=1; // map에 방문처리
                            dis[nx][ny]=dis[xx][yy]+1; // 기존 거리에 +1
//                            dis[nx][ny]=1; // 방문 처리
                            queue.add(new Point(nx,ny));
                        }
                    }
                }
            }
        }

    }

//    public static void bfs(int x, int y){
//        Queue<Point> Q=new LinkedList<>();
//        Q.offer(new Point(x, y));
//        map[x][y]=1;
//        while(!Q.isEmpty()){
//            Point tmp=Q.poll();
//            for(int i=0; i<4; i++){
//                int nx=tmp.x+dx[i];
//                int ny=tmp.y+dy[i];
//                if(nx>=0 && nx<7 && ny>=0 && ny<7 && map[nx][ny]==0){
//                    map[nx][ny]=1;
//                    Q.offer(new Point(nx, ny));
//                    dis[nx][ny]=dis[tmp.x][tmp.y]+1;
//                }
//            }
//        }
//    }

    public static void main(String[] args) {
        n=7;
        Scanner scan=new Scanner(System.in);
        dis=new int[n][n];
        map=new int[n][n];
        for (int i=0;i<n;i++) {
            for (int j=0;j<n;j++) {
                map[i][j]=scan.nextInt();
            }
        }

        bfs(0,0);

//        for (int i=0;i<n;i++) {
//            for (int j=0;j<n;j++) {
//                System.out.print(dis[i][j]+" ");
//            }
//            System.out.println();
//        }

        if (dis[n-1][n-1]==0) {
            System.out.println(-1);
        }
        else {
            System.out.println(dis[n-1][n-1]);
        }


    }
}
