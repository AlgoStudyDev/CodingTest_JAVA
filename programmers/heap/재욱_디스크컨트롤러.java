package programmers.heap;

import java.security.spec.RSAOtherPrimeInfo;
import java.util.*;

// 작업 시간을 기준으로 오름차순하는 것에는 성공했고,
class Pair {
    int startTime;
    int workingTime;

    public Pair(int startTime, int workingTime, int index) {
        this.startTime = startTime;
        this.workingTime = workingTime;
    }

    public int getStartTime() {
        return startTime;
    }

    public int getWorkingTime() {
        return workingTime;
    }
}

public class 재욱_디스크컨트롤러 {
    public int solution(int[][] jobs) {
        int answer = 0;
        int time = 0;
        List<Pair> array = new ArrayList<>();

        for (int i = 0; i < jobs.length; i++) {
            array.add(new Pair(jobs[i][0], jobs[i][1], i));
        }
        //Collections.sort(array, (v1, v2) -> v1.workingTime - v2.workingTime);
        array.sort(Comparator.comparing(v -> v.workingTime));

        // array.sort(Comparator.comparing(Pair::getWorkingTime));
        // array.sort(Comparator.comparing(Pair::getWorkingTime).thenComparing(Comparator.comparing(Pair::getStartTime).reversed()));

        while (!array.isEmpty()) {
            for (int i = 0; i < array.size(); i++) {
                if (array.get(i).startTime <= time) {
                    time += array.get(i).workingTime; // 작업시간을 time에 더하기
                    answer += time - array.get(i).startTime; // 총 걸리는 시간(answer)은 time에서 시작 시간(startTime)을 빼서 더하기
                    array.remove(i); // 작업이 완료됐다면 제거하기
                    break;
                }
                if (i == array.size() - 1) { // for문으로 작업을 다 돌았다면 time + 1 해주기
                    time += 1;
                }
            }
        }
        return answer / jobs.length;
    }

    public static void main(String[] args) {
        재욱_디스크컨트롤러 obj = new 재욱_디스크컨트롤러();
        int[][] jobs = {{0, 3}, {1, 9}, {2, 6}};
        System.out.println(obj.solution(jobs));
    }
}
