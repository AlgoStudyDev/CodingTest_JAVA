package programmers.dp;

public class 재욱_등굣길 {

    public int solution(int m, int n, int[][] puddles) {
        int mod = 1000000007;
        int[][] matrix = new int[n + 1][m + 1];

        for (int[] puddle : puddles) {
            matrix[puddle[1]][puddle[0]] = -1; // 우물을 matrix에 만들기
        }

        matrix[1][1] = 1; // 처음 시작이기에 1로 초기화, 오른쪽/아래쪽으로만 이동가능
        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < m + 1; j++) {
                if (matrix[i][j] == -1) {
                    continue;
                }
                if (matrix[i - 1][j] > 0) { // 현재 위치의 바로 위가 0보다 크다면
                    matrix[i][j] += matrix[i - 1][j] % mod; // 현재 위치값은 바로 위값을 더하기
                }
                if (matrix[i][j - 1] > 0) { // 현재 위치의 바로 왼쪽이 0보다 크다면
                    matrix[i][j] += matrix[i][j - 1] % mod; // 현재 위치값은 바로 왼쪽값을 더하기
                }
            }
        }

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }

        return matrix[n][m] % mod;
    }

    public static void main(String[] args) {
        재욱_등굣길 o = new 재욱_등굣길();
        int m = 4;
        int n = 3;
        int[][] puddles = {{2, 2}};
        System.out.println(o.solution(m, n, puddles));
    }
}
