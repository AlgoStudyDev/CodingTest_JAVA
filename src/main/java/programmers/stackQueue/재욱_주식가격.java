package programmers.stackQueue;

import java.util.*;
/*
*
* 프로그래머스 '주식가격' 문제, 레벨 2, 2021.10.20*/
public class 재욱_주식가격 {
    public int[] solution(int[] prices) {
        int time;
        List<Integer> answer = new ArrayList<>();

        for (int i = 0; i < prices.length - 1; i++) {
            time = -1;
            for (int j = i + 1; j < prices.length; j++) {
                if (prices[i] > prices[j]) {
                    time = j - i;
                    break;
                }
            }
            if (time == -1) {
                time = prices.length - i - 1;
            }
            answer.add(time);
        }

        answer.add(0); // 마지막에 항상 0을 삽입해주기
        return answer.stream().mapToInt(i -> i).toArray();
    }
}
