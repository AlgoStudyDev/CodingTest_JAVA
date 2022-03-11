package programmers.level2;

import java.util.*;
public class 동성_카카오프렌즈_컬러링북_dfs {
    static int dx[]={0,1,0,-1};
    static int dy[]={1,0,-1,0};
    static int max;
    static int check[][];
    static int mm;
    static int nn;
    static int map[][];
    static int temp_cnt; //추가
    static int maxSizeOfOneArea;

    public void dfs(int x,int y) {
        // 4방향 상하좌우
        for (int i=0;i<4;i++) {
            int nx=x+dx[i];
            int ny=y+dy[i];

            if (nx>=0 && nx<mm && ny>=0 && ny<nn) {
                if (map[nx][ny]==map[x][y] && check[nx][ny]==0) {
                    check[nx][ny]=1; // 방문처리
                    temp_cnt++; // 블록의 개수 증가 // 아직 방문안했으면 증가
                    dfs(nx,ny);
                }
            }
        }
    }

    public int[] solution(int m, int n, int[][] picture) {

        maxSizeOfOneArea=0;
        temp_cnt=0;
        max=0;
        mm=m;
        nn=n;
        check=new int[mm][nn];
        map=new int[mm][nn];

        for (int x = 0; x < picture.length; x++) {
            for (int y = 0; y < picture[x].length; y++) {
                map[x][y] = picture[x][y];
            }
        }
        int value=0;
        for (int i=0;i<mm;i++) {
            for (int j=0;j<nn;j++) {
                if (map[i][j]!=0 && check[i][j]==0) {
                    check[i][j]=1;
                    temp_cnt++;
                    value++;
                    dfs(i,j);
                }

                // 여기가 핵심, 원래는 dfs(i,j,cnt) // cnt를 넣어줬는데 이러면 cnt가 모든 블록을 다 검색하지 못하고 소멸되는 문제 발생 -> 따라서 temp_cnt를 전역으로 만들고 증가시켜줌
                if(temp_cnt > maxSizeOfOneArea) maxSizeOfOneArea = temp_cnt;
                temp_cnt = 0;

            }
        }
        int []answer={value,maxSizeOfOneArea};

        return answer;
    }

}
