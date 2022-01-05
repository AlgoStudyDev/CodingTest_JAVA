package programmers.sort;

import java.util.Arrays;

public class 재욱_H_Index {
    public int solution(int[] citations) {
        int answer = 0;
        int len = citations.length;
        Arrays.sort(citations);
        for (int i = 0; i < len; i++) {
            int h = len - i;
            if (citations[i] >= h) {
                answer = h;
                break;
            }
        }
        return answer;
    }

//    public int solution(int[] citations) {
//        int answer = 0;
//        int len = citations.length;
//        Arrays.sort(citations);
//
//        for (int i = 0; i < len; i++) {
//            int temp = len - i;
//            if (temp >= citations[i]) {
//                answer = citations[i];
//            } else {
//                answer = Math.max(answer, temp);
//            }
//        }
//        return answer;
//    }
}
