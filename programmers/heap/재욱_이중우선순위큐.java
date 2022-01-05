package programmers.heap;

import java.util.*;

public class 재욱_이중우선순위큐 {

    public int[] solution(String[] operations) {
        int[] answer = new int[2];
        List<Integer> array = new ArrayList<>();

        for (String order : operations) {
            if (order.charAt(0) == 'I') { //값 추가
                int number = Integer.parseInt(order.substring(2));
                array.add(number);
            } else if (!array.isEmpty()) {
                if (order.equals("D 1")) { // 최대값 삭제
                    array.remove(array.size() - 1);
                } else if (order.equals("D -1")) { // 최솟값 삭제
                    array.remove(0);
                }
            }
            Collections.sort(array);
        }

        if (!array.isEmpty()) {
            answer[0] = array.get(array.size() - 1);
            answer[1] = array.get(0);
        }
        return answer;
    }

    public static void main(String[] args) {
        재욱_이중우선순위큐 m = new 재욱_이중우선순위큐();
        String[] operations = {"I -45", "I 653", "D 1", "I -642", "I 45", "I 97", "D 1", "D -1", "I 333"};
        System.out.println(m.solution(operations));
    }
}
