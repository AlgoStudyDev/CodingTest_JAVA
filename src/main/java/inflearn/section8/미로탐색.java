package inflearn.section8;
import java.util.*;
public class 미로탐색 {
    static int dx[]={0,1,0,-1};
    static int dy[]={1,0,-1,0};

    static int check[][];
    static int map[][];
    static int answer;
    static int n;

    static void dfs(int i,int j) {
        if (i==n-1 && j==n-1) { // 종료
            // 목적지에 도착했으면 answer 1 증가
            answer++;
        }
        else {
            // dfs
            for (int k=0;k<4;k++) {
                int nx=i+dx[k];
                int ny=j+dy[k];

                if (nx>=0 && nx<=n-1 && ny>=0 && ny<=n-1) {
                    if (map[nx][ny]==0 &&check[nx][ny]==0) { // map이 0인곳만 갈수 있음
                        check[nx][ny]=1; // 방문 처리
                        dfs(nx,ny); // dfs 진행
                        check[nx][ny]=0; // 방문 완료 후 풀어줌, 다시 가게
                    }
                }
            }

        }


    }


    public static void main(String[] args) {
        Scanner scan=new Scanner(System.in);
        n=7;
        check=new int[n][n];
        map=new int[n][n];
        for (int i=0;i<n;i++) {
            for (int j=0;j<n;j++) {
                map[i][j]=scan.nextInt();
            }
        }
        answer=0;
//        for (int i=0;i<n;i++) {
//            for (int j=0;j<n;j++) {
//                System.out.print(map[i][j]+" ");
//            }
//            System.out.println();
//        }
        check[0][0]=1;
        dfs(0,0);
        System.out.println(answer);

    }

}
