package programmers.stacknqueue;

import java.util.*;

/*
큐를 이용한 문제라고 하지만 ArrayList, Set을 이용해서 풀었고, 결국 정렬된 ArrayList가 큐의 역할을 한 것 같다
* 프로그래머스 '기능개발' 문제, 레벨 2, 2021.10.19*/
class 재욱_기능개발 {
    public int[] solution(int[] progresses, int[] speeds) {
        double remaining;
        int completed;
        List<Integer> array = new ArrayList<>();

        for (int i = 0; i < progresses.length; i++) {
            remaining = 100 - progresses[i];

            if (remaining / speeds[i] != (int) (remaining / speeds[i])) {
                completed = (int) (remaining / speeds[i]) + 1;
            } else {
                completed = (int) (remaining / speeds[i]);
            }
            array.add(completed);
        }

        for (int i = 0; i < array.size() - 1; i++) {
            int first = array.get(i);
            int second = array.get(i + 1);
            if (second < first) {
                array.set(i + 1, first);
            }
        }

        Set<Integer> hashSet = new HashSet<>(array);
        int[] answer = new int[hashSet.size()];
        List<Integer> result = new ArrayList<>(hashSet);
        result.sort(Comparator.naturalOrder());

        for (int i = 0; i < result.size(); i++) {
            int count = 0;
            for (Integer integer : array) {
                if (result.get(i) == integer) {
                    count += 1;
                }
            }
            answer[i] = count;
        }
        return answer;
    }

    public static void main(String[] args) {
        재욱_기능개발 재욱기능개발 = new 재욱_기능개발();
        int[] progresses = {95, 90, 99, 99, 80, 99};
        int[] speeds = {1, 1, 1, 1, 1, 1};
        System.out.println(Arrays.toString(재욱기능개발.solution(progresses, speeds)));
    }
}
