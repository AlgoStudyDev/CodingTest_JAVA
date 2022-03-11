package programmers.level2;

import java.util.*;
// 최단거리 구하기 - bfs Queue
// dis map에 거리 기록하기
public class 동성_게임맵최단거리 {

    static int dx[]={0,1,0,-1};
    static int dy[]={1,0,-1,0};
    static int dis[][];
    class Point{
        int x;
        int y;
        Point(int x,int y) {
            this.x=x;
            this.y=y;
        }
    }

    public int solution(int[][] maps) {
        int answer = 0;
        int m=maps.length;
        int n=maps[0].length;
        dis=new int[m][n]; // 거리를 기록함
        Queue<Point>queue=new LinkedList<>();
        queue.add(new Point(0,0));

        dis[0][0]=1;

        while(!queue.isEmpty()) {
            int size=queue.size();

            for (int i=0;i<size;i++) {
                Point p=queue.poll();
                int x=p.x;
                int y=p.y;
                for (int j=0;j<4;j++) {
                    int nx=x+dx[j];
                    int ny=y+dy[j];

                    if (nx>=0 && nx<m && ny>=0 && ny<n) {
                        if (maps[nx][ny]!=0) {
                            maps[nx][ny]=0; // 방문처리
                            dis[nx][ny]=dis[x][y]+1;
                            queue.add(new Point(nx,ny));
                        }
                    }
                }
            }

        }

        if (dis[m-1][n-1]==0) {
            answer=-1;
        } else {
            answer=dis[m-1][n-1];
        }


        return answer;
    }
}
