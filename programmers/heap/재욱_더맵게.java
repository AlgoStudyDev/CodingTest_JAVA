package programmers.heap;

import java.util.PriorityQueue;

// 프로그래머스 heap 문제, 레벨 2, 2021.01.05, scoville 과 minHeap을 헷갈려서 10분만에 푼 문제를 30분이나 끌었다. 유심히 보자

public class 재욱_더맵게 {
    public int solution(int[] scoville, int K) {
        int count = 0;
        //PriorityQueue<Restaurant> maxHeap = new PriorityQueue<>(Collections.reverseOrder()); 최대힙
        PriorityQueue<Integer> minHeap = new PriorityQueue<>(); // 최소힙

        for (int number : scoville) {
            minHeap.add(number);
        }

        while (minHeap.size() >= 2) {
            count += 1;
            int first = minHeap.poll();
            int second = minHeap.poll();
            int spicy = first + (second * 2);
            minHeap.add(spicy);
            if (check(minHeap, K)) {
                return count;
            }
        }
        return -1;
    }

    public boolean check(PriorityQueue<Integer> heap, int K) {
        boolean chk = true;
        if (K > heap.peek() && !heap.isEmpty()) {
            chk = false;
        }
        return chk;
    }

    public static void main(String[] args) {
        int[] scoville = {1, 2, 3, 9, 10, 12};
        int K = 7;
        재욱_더맵게 object = new 재욱_더맵게();
        System.out.println(object.solution(scoville, K));
    }
}
