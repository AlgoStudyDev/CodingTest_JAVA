package programmers.kakao2022;

import java.util.*;
public class 양과늑대 {

    static HashMap<Integer,ArrayList>graph; // [0]-> [1,8], [1]->[2,4], [8]->[7,9]...
    static int max;
    static int infos[];
    // 현재 노드 번호, 양의 수, 늑대의 수, 다음으로 방문할 수 있는 노드의 집합
    public void dfs(int node, int sheep, int wolf, ArrayList<Integer>list) {
        // 현재 노드에 양이 있다면 양 증가, 아니라면 늑대 증가
        if (infos[node]==0) sheep+=1;
        else wolf+=1;

        // 양의 수와 늑대 수 비교
        if (sheep<=wolf) return; // 늑대가 더 많으면 종료, 더 이상 갈 필요 없음.
        max=Math.max(max,sheep); // 현재 양의 수와 최대값에 있는 것과 비교하여 최대값 갱신

        // List<Integer> nextlist=new ArrayList<>();
        ArrayList<Integer> nextlist=new ArrayList<>();
        nextlist.addAll(list); // 새로 만들고 전부 복사

        if (graph.containsKey(node)) { // 현재 방문한 그래프에 더 방문할 노드가 있다면 nextlist에 추가
            nextlist.addAll(graph.get(node));
        }
        // 현재 방문한 거는 지움
        nextlist.remove(Integer.valueOf(node));

        // System.out.println("nextlist"+nextlist.toString()); //1,8 번 노드 방문
        // 다음꺼 방문하기
        for (int next:nextlist) {
            dfs(next,sheep,wolf,nextlist);
        }
        return;

    }

    public int solution(int[] info, int[][] edges) {
        int answer = 0;
        max=0;
        graph=new HashMap<>();
        infos=info.clone();
        // 1. 그래프 만들기
        for (int edge[]:edges) {
            int key=edge[0];
            int value=edge[1];
            ArrayList<Integer>arraylist=new ArrayList<>();
            if (graph.containsKey(key)) {
                arraylist=graph.get(key);
                arraylist.add(value);
            }
            else {
                arraylist.add(value);
            }
            graph.put(key,arraylist);
        }
        // System.out.println(graph.toString());
        // 다음에 방문할 리스트
        ArrayList<Integer>nodelist=new ArrayList<>();
        nodelist.add(0); // 처음은 무조건 방문

        dfs(0,0,0,nodelist); // 현재 노드 번호, 양의 수, 늑대의 수, 다음으로 방문할 수 있는 노드의 집합

        return max;
    }
}
