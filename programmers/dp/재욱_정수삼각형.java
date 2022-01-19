package programmers.dp;

public class 재욱_정수삼각형 {

    public int solution(int[][] triangle) {
        int answer = 0;

        for (int i = 1; i < triangle.length; i++) { // i = 0은 어차피 1개이기에, i는 1부터 시작
            for (int j = 0; j < i + 1; j++) {
                if (j == 0) { // 첫 column(열)인 경우
                    triangle[i][j] += triangle[i - 1][j];
                } else if (j == i) { // (1,1), (2,2), (3,3)...
                    triangle[i][j] += triangle[i - 1][j - 1];
                } else { // 나머지 모든 행렬
                    triangle[i][j] += Math.max(triangle[i - 1][j], triangle[i - 1][j - 1]);
                }
            }
        }

        for (int number : triangle[triangle.length - 1]) { // 마지막 row에서 최대값 뽑기
            if (number > answer) {
                answer = number;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        재욱_정수삼각형 o = new 재욱_정수삼각형();
        int[][] triangle = {{7}, {3, 8}, {8, 1, 0}, {2, 7, 4, 4}, {4, 5, 2, 6, 5}};
        System.out.println(o.solution(triangle));
    }
}
