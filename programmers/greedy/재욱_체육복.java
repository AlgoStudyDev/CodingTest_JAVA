package programmers.greedy;

import java.util.*;

/*
'여벌의 체육복을 도둑맞은 경우'와 '여벌의 체육복을 타인에게 나눠주는 경우'를 나누지 않고
한번에 이중 for문으로 돌리다보니 케이스5와 12가 계속 틀렸다. 이후에 알아보니 전자의 경우를 먼저 처리해야
결과가 제대로 나오는 상황이었다. (구현은 쉽지만 미세한 조건을 알지 못 한다면 틀릴 문제였다)
*/

public class 재욱_체육복 {
    public int solution(int n, int[] lost, int[] reserve) {
        int answer = n - lost.length;
        Arrays.sort(lost);
        Arrays.sort(reserve);

        for (int i = 0; i < lost.length; i++) { // 여벌 체육복을 가져온 학생이 도난당한 경우
            for (int j = 0; j < reserve.length; j++) {
                if (lost[i] == reserve[j]) {
                    answer++;
                    lost[i] = -1;
                    reserve[j] = -1;
                    break;
                }
            }
        }

        for (int i = 0; i < lost.length; i++) { // 도난당한 학생에게 체육복 빌려주는 경우
            for (int j = 0; j < reserve.length; j++) {
                if ((lost[i] - 1 == reserve[j]) || (lost[i] + 1 == reserve[j])) {
                    answer++;
                    reserve[j] = -1;
                    break;
                }
            }
        }
        return answer;

//        int answer = n - lost.length;
//        Arrays.sort(lost);
//        Arrays.sort(reserve);
//
//        for (int i = 0; i < lost.length; i++) {
//            for (int j = 0; j < reserve.length; j++) {
//                if (lost[i] == reserve[j]) {
//                    answer += 1;
//                    reserve[j] = -1;
//                    lost[i] = -1;
//                    break;
//                }
//                if (Math.abs(lost[i] - reserve[j]) == 1) {
//                    answer += 1;
//                    reserve[j] = -1;
//                    break;
//                }
//            }
//        }
//        return answer;
    }

    public static void main(String[] args) {
        int n = 5;
        int[] lost = {2, 4};
        int[] reserve = {1, 3, 5};
        재욱_체육복 o = new 재욱_체육복();
        System.out.println(o.solution(n, lost, reserve));
    }
}
