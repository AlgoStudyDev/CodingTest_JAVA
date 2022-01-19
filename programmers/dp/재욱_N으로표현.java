package programmers.dp;
/*
* 여태까지 연산한 횟수인 count와 이전까지의 연산 결괏값 prev을 파라미터로 넘기며 DFS를 수행한다.
* 종료 조건은 2가지이다.
* count가 8을 초과한 경우 answer는 -1이다.
* count가 8 이하일 때 target 수가 만들어진 경우 answer를 최솟값으로 갱신한다.
* 각 dfs()마다 한 자리씩 늘려가며 네 개의 사칙 연산을 추가로 하도록 재귀 호출한다.
* 더 연구해올것!!!!!!!!!!!!
* */
public class 재욱_N으로표현 {
    private int n;
    private int target;
    private int answer = Integer.MAX_VALUE;

    public int solution(int N, int number) {
        n = N; // 5
        target = number; // 12
        dfs(0, 0);
        return answer == Integer.MAX_VALUE ? -1 : answer;
    }

    private void dfs(int count, int temp) { // DFS (N, number, 사용 횟수, 만든값)
        if (count > 8) { // 사용 횟수가 8보다 크면 -1 리턴
            answer = -1;
            return;
        }

        if (temp == target) { // 계산값(temp)이 target과 일치하고 사용 횟수가 최솟값이면 갱신
            answer = Math.min(answer, count);
            return;
        }

        int number = n; // +N, -N, *N, /N 에 대해 사칙연산 추가 (재귀)
        for (int i = 0; i < 8 - count; i++) {
            int cnt = count + i + 1; // cnt는 지금까지 계산한 연산횟수, temp는 이전까지 계산값

            dfs(cnt, temp + number); // 10 + 5 = 15, 15 + 55
            dfs(cnt, temp - number); // 10 - 5 = 5,
            dfs(cnt, temp / number); // 10 / 5 = 2,
            dfs(cnt, temp * number); // 10 * 5 = 50,

            number = number * 10 + n; // 5, 55, 555, 5555, 55555, 555555
        }
    }
}
