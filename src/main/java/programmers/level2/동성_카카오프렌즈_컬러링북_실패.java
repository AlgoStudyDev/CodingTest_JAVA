package programmers.level2;

import javax.xml.transform.SourceLocator;

public class 동성_카카오프렌즈_컬러링북_실패 {

    static int dx[]={0,1,0,-1};
    static int dy[]={1,0,-1,0};
    static int max;
    static int check[][];
    static int mm;
    static int nn;
    static int map[][];
    static int temp_cnt; //추가
    static int maxSizeOfOneArea;

    public static void dfs(int x,int y, int val) {
        if (max<val) {
            max=val;
        }
        // 4방향 상하좌우
        for (int i=0;i<4;i++) {
            int nx=x+dx[i];
            int ny=y+dy[i];

            if (nx>=0 && nx<mm && ny>=0 && ny<nn) {
                if (map[nx][ny]==map[x][y] && check[nx][ny]==0) {
                    check[nx][ny]=1; // 방문처리
//                    temp_cnt++; // 블록의 개수 증가 // 아직 방문안했으면 증가
                    dfs(nx,ny,val+1);
                }
            }
        }
    }

    public static int[] solution(int m, int n, int[][] picture) {

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
//                    temp_cnt++;
                    value++;
                    dfs(i,j,1);
                }

                // 여기가 핵심, 원래는 dfs(i,j,cnt) // cnt를 넣어줬는데 이러면 cnt가 모든 블록을 다 검색하지 못하고 소멸되는 문제 발생 -> 따라서 temp_cnt를 전역으로 만들고 증가시켜줌
//                if(temp_cnt > maxSizeOfOneArea) maxSizeOfOneArea = temp_cnt;
//                temp_cnt = 0;

            }
        }
        int []answer={value,maxSizeOfOneArea};
        System.out.println(value+" "+max);

        return answer;
    }

    public static void main(String[] args) {
//        int map[][]={{1, 0, 0, 0, 0, 1}, {1, 0, 0, 0, 0, 1}, {1, 0, 0, 0, 0, 1}, {1, 0, 0, 0, 0, 1}, {1, 0, 0, 0, 0, 1}, {1, 1, 1, 1, 1, 1}};
//        solution(6,6,map);
        int map2[][]={{1,1,1,0},{1,1,1,0},{0,0,0,1},{0,0,0,1},{0,0,0,1},{0,0,0,1}};
        solution(6,4,map2);
//        System.out.println(solution(6,6,map));
        // 반례 조건 -> 중간에 끊김 합이 안됨, 해당 코드에서는 중간에 끊김이 발생하기 때문에 선을 이을수 없음 이유는 오른쪽, 아래, 왼쪽, 위 순으로 이동하기 때문에
        /*
            1110
            1220
            1001
            0001
            0003
            0003 의 경우 1이 오른쪽으로 갔다가 다시 밑에 1을 갈수 없음.
        */
        int map3[][]={{1, 1, 1, 0}, {1, 2, 2, 0}, {1, 0, 0, 1}, {0, 0, 0, 1}, {0, 0, 0, 3}, {0, 0, 0, 3}};
        solution(6,4,map3);
    }
}
