package backjoon;

import java.util.*;

// 코드는 맞는데 시간초과 발생
public class 벽부수고이동 {

    static int n;
    static int m;
    static int check[][];
    static int map[][];

    static int dx[]={0,1,0,-1};
    static int dy[]={1,0,-1,0};
    static int min=Integer.MAX_VALUE;
    public static void dfs(int x, int y, int hap, int wild) {
        // 종료 조건
        if (x==n-1 && y==m-1) {
            // 종료
            if (hap<min) {
                min=hap;
            }
        }
        else {
            // map이 0이면 이동
            for (int i=0;i<4;i++) {
                int nx=x+dx[i];
                int ny=y+dy[i];

                if (nx>=0 && nx<n && ny>=0 && ny<m) {
                    // map이 0이라면 이동 가능
                    // map이 1이라면 이동 불가능 -> wild 카드 사용

                    if (map[nx][ny]==0) {
                        if (check[nx][ny]==0) {
                            // 이동 가능
                            check[nx][ny]=1;
                            dfs(nx,ny,hap+1,wild);
                            check[nx][ny]=0; // 다시 방문하기 위해 풀어줌
                        }
                    }
                    else if (map[nx][ny]==1 && wild==1){
                        if (check[nx][ny]==0 ) {
                            check[nx][ny]=1;
                            dfs(nx,ny,hap+1,wild-1);
                            check[nx][ny]=0; // 다시 방문하기 위해 풀어줌
                        }
                    }
                }
            }
        }

    }
    public static void main(String[] args) {
        Scanner scan=new Scanner(System.in);
        n=scan.nextInt();
        m=scan.nextInt();
        map=new int[n][m];

        for (int i=0;i<n;i++) {
            String str=scan.next();
            for (int j=0;j<m;j++) {
                map[i][j]=Integer.parseInt(str.charAt(j)+"");
            }
        }

        check=new int[n][m];

        dfs(0,0,1,1);
        if (min==Integer.MAX_VALUE) {
            System.out.println(-1);
        }
        else {
            System.out.println(min);
        }

    }
}
