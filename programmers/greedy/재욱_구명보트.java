package programmers.greedy;

import java.util.Arrays;

public class 재욱_구명보트 {
    public int solution(int[] people, int limit) {

        /*처음에 바로 앞에 있는 배열요소로만 구하다가 실패하고,
        생각을 바꿔서 small and big 전략을 취했습니다*/

        int answer = 0;
        int start = 0;     // 첫 배열인덱스
        int end = people.length - 1; // 마지막 배열인덱스
        Arrays.sort(people);

        while (start < end + 1) {
            if (start == end) {  // 둘이 같은 경우면 다 비교해서 혼자 남은 거니깐
                answer++;      // 나올때 +1 해주기
                break;
            }
            if (people[start] + people[end] <= limit) {  // 한계값보다 적은 경우 두 수를 빼줘야하기 때문에
                answer++;
                start++;                           // 인덱스 양쪽 모두 움직입니다
                end--;
            } else {                                  // 한계값보다 큰 경우 한 개의 수만 빼줍니다
                answer++;
                end--;
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        int[] people = {70, 50, 80, 50};
        int limit = 100;
        재욱_구명보트 o = new 재욱_구명보트();
        System.out.println(o.solution(people, limit));
    }
}
