package programmers.stacknqueue;

import java.util.*;
/*
* 파이썬으로 풀 때처럼 [[중요도, 순서], [중요도, 순서]] 방법으로 배열 안에 두 개의 요소를 같이 삽입해서
* 구분하는 방법으로 풀려고 했지만 자바에서는 그런 식으로 하지않고, 따로 클래스를 만들어서 이중 배열을 만들어야했다.
* 확실히 파이썬으로 하다가 자바로 넘어가는 과정은 어색하다. 그래도 힘내야한다!
* 프로그래머스 '프린터' 문제, 레벨 2, 2021.10.19*/
class Pair {
    int priority;
    int location;

    Pair(int priority, int location) {
        this.priority = priority;
        this.location = location;
    }
}

class Printer {
    public int solution(int[] priorities, int location) {
        int answer = 0;
        Queue<Pair> queue = new LinkedList<>();

        for (int i = 0; i < priorities.length; i++) {
            queue.add(new Pair(priorities[i], i));
        }

        int now = 0;
        while (!queue.isEmpty()) {
            Pair current = queue.poll();
            boolean check = false;
            for (Pair temp : queue) {
                if (temp.priority > current.priority) {
                    check = true;
                    break;
                }
            }
            if (check) {
                queue.add(current);
            } else {
                now += 1;
                if (current.location == location) {
                    answer = now;
                    break;
                }
            }
        }
        return answer;
    }
}