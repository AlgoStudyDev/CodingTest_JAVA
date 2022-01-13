package programmers.greedy;
import java.util.*;

public class 재욱_섬연결하기 {
    int[] findParent;                                //부모와 자식의 정보가 담긴 배열

    public int find(int child) {                    //부모 찾기
        if (findParent[child] == child) {
            return child;
        } else {
            return findParent[child] = find(findParent[child]);
        }
    }

    public int solution(int n, int[][] costs) {
        //가중치 기준으로 오름차순
        Arrays.sort(costs, (o1, o2) -> {
            Integer a = o1[2];
            Integer b = o2[2];
            return a.compareTo(b);
        });

        findParent = new int[n];                                //초기배열에서 부모는 자기 자신.
        for (int i = 0; i < n; i++) {
            findParent[i] = i;
        }

        int answer = 0;
        for (int i = 0; i < costs.length; i++) {
            int firstIsland = find(costs[i][0]);
            int SecondIsland = find(costs[i][1]);
            if (firstIsland != SecondIsland) {            //부모가 같지 않다면 연결이 안된 최솟값이므로
                findParent[SecondIsland] = firstIsland;    //연결
                answer += costs[i][2];
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        int n = 4;
        int[][] costs = {{0,1,1},{0,2,2},{1,2,5},{1,3,1},{2,3,8}};
        재욱_섬연결하기 o = new 재욱_섬연결하기();
        System.out.println(o.solution(n, costs));
    }
}
