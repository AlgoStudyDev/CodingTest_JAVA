package inflearn.section7_dfs;
// 이진 트리 순회 -> 전위순회, 중위순회, 후위순회 구하기

import java.util.*;

public class 이진트리순회_어려움 {

    static HashMap<Integer,Point> hashMap=new HashMap<>();

    static class Point {
        int left;
        int right;
        Point (int left, int right) {
            this.left=left;
            this.right=right;
        }
    }

    static void dfs(int l) {
        // 언제 종료?
        // 포함이 안되어 있으면 종료
        if (!hashMap.containsKey(l)) {
            return;
        } else {
            System.out.println();
        }
        // 전위 순회
        System.out.println(l);
        dfs(hashMap.get(l).left); // 왼쪽 탐색
        dfs(hashMap.get(l).right); // 오른쪽 탐색
    }

    public static void main(String[] args) {
        // Node 입력
        // HashMap -> 1,
        hashMap.put(1,new Point(2,3));
        hashMap.put(2,new Point(4,5));
        hashMap.put(3,new Point(6,7));

        dfs(1);

    }


}
