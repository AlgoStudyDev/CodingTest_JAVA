package programmers.stacknqueue;

import java.util.*;

/*
 *
 * 프로그래머스 '다리를 지나는 트럭' 문제, 레벨 2, 2021.10.20*/
public class 재욱_다리를지나가는트럭 {

    public int solution(int bridge_length, int weight, int[] truck_weights) {
        Queue<Integer> queue = new LinkedList<>();
        int sum = 0;
        int time = 0;

        for (int truck : truck_weights) {

            while (true) {
                if (queue.isEmpty()) { // 다리 큐가 비어있는 경우
                    queue.add(truck); // 다리 위에 트럭 올리기
                    sum += truck; // 올린 트럭 무게만큼 합계 생성
                    time += 1; // 트럭이 다리 위에 올라갔으니 시간은 + 1
                    break;
                } else if (queue.size() == bridge_length) { // 다리에 올라간 트럭 수가 최대치면
                    sum -= queue.poll(); // 다리 합계를 대기 중인 첫 번째 트럭의 무게만큼 내리기
                } else {
                    if (sum + truck > weight) { // 다리 위의 트럭 무게랑 현재 올라갈 트럭 무게가 최대치보다 크다면
                        queue.add(0); // 다리에 0을 넣고, 트럭 밀어내기
                        time += 1; // 시간 보내기
                    } else { // 다리 위의 트럭 무게랑 현재 올라갈 트럭 무게가 최대치보다 작다면
                        queue.add(truck); // 다리에 트럭을 올리고
                        sum += truck; // 다리 위의 트럭 무게를 올리고
                        time += 1; // 트럭을 올렸으니 시간 올리기
                        break;
                    }
                }
            }
        }
        return time + bridge_length;
    }
}
