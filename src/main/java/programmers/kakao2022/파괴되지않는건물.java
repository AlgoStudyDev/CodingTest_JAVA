package programmers.kakao2022;

public class 파괴되지않는건물 {
    static int[][]map;
    static int n;
    static int m;
    static int answer;

    public void attack(int r1,int c1, int r2, int c2, int degree) {
        for (int i=r1;i<=r2;i++) {
            for (int j=c1;j<=c2;j++) {
                map[i][j]+=degree;
            }
        }
    }

    public void check_map() {
        for (int i=0;i<n;i++) {
            for (int j=0;j<m;j++) {
                if (map[i][j]>0) {
                    answer++;
                }
            }
        }
    }

    public void print_map() {
        for (int i=0;i<n;i++) {
            for (int j=0;j<m;j++) {
                System.out.print(map[i][j]+" ");
            }
            System.out.println();
        }
    }



    public int solution(int[][] board, int[][] skill) {
        // int answer = 0;
        // map=board.clone();
        map=board;
        n=board.length;
        m=board[0].length;
        answer=0;
        // 마지막 최종단계에서 -> 빨리 찾을까?

        //type -> 1이면 공격, type이 -> 2이면 회복
        for (int i=0;i<skill.length;i++) {
            int type=skill[i][0];
            int r1=skill[i][1];
            int c1=skill[i][2];
            int r2=skill[i][3];
            int c2=skill[i][4];
            int degree=skill[i][5];

            if (type==1) {
                degree*=-1;
            }
            attack(r1,c1,r2,c2,degree);

            // System.out.println("check_map");
            // 한번 돌때 map 확인
            // print_map();
        }
        check_map();

        return answer;
    }
}
