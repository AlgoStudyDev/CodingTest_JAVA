package programmers.level2;
// 정사각형 길치 찾기
// 1. 패딩값 넣기
// 2. 정사각형은 (왼쪽, 위쪽, 대각선쪽에서 최소값 +1 로 갱신하기)
// 3. 최대값과 비교하기
public class 동성_가장큰정사각형찾기_dp {
    public int solution(int [][]board)
    {
        int answer = 0;
        int m=board.length;
        int n=board[0].length;
        int maps[][]=new int[m+1][n+1]; // 패딩값 입력
        for (int i=0;i<m;i++) {
            for (int j=0;j<n;j++) {
                maps[i+1][j+1]=board[i][j];
            }
        }

        // for (int i=0;i<m+1;i++) {
        //     for (int j=0;j<n+1;j++) {
        //         System.out.print(maps[i][j]+" ");
        //     }
        //     System.out.println();
        // }

        // 시작점에서 dp로 구하기
        for (int i=0;i<m+1;i++) {
            for (int j=0;j<n+1;j++) {

                if (maps[i][j]!=0) {
                    // dp 값 갱신
                    // min은 2개값만 비교가능하므로 나눠서 계산
                    maps[i][j]=Math.min(Math.min(maps[i][j-1],maps[i-1][j-1]),maps[i-1][j])+1;
                    answer=Math.max(maps[i][j],answer);
                }
            }
        }
        answer=answer*answer;

        return answer;
    }
}
