package programmers.heap;

import java.util.*;

public class 동성_더맵게 {

    public int solution(int[] scoville, int K) {
        int answer = 0;

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i : scoville) {
            pq.add(i);
        }
        // 가장 작은것 뽑고 + 두번째로 작은것 *2 -> 다시 넣어줌 -> 이때 모든 지수가 K이상
        int time = 0;
        while (!pq.isEmpty()) {
            // 가장 작은거 뽑음
            int first = pq.poll();

            // 이게 K이상인지 확인
            if (first >= K) return time;

            // 두번째를 뽑을수 있으면 뽑음 -> 못뽑으면 -1 return
            try {
                int second = pq.poll();
                int res = first + second * 2;
                pq.add(res);
                time++;
                if (pq.peek() >= K) {
                    return time;
                }
            } catch (Exception e) {
                return -1;
            }

        }
        return answer;
    }
}
