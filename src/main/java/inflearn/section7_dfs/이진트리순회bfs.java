package inflearn.section7_dfs;
import java.util.*;
public class 이진트리순회bfs {

    static class Point{
        int left;
        int right;
        Point (int left, int right) {
            this.left=left;
            this.right=right;
        }
    }

    static HashMap<Integer, Point>hashmap=new HashMap<>();
    public static void bfs(int node) {
        Queue<Integer>queue=new LinkedList<>();
//        check[1]=1; // 1번 노드 사용
        queue.add(node);

        while(!queue.isEmpty()) {
            int size=queue.size();
            for (int i=0;i<size;i++) {
                int k=queue.poll(); // 뽑고
                System.out.print(k+" ");
                if (hashmap.containsKey(k)) { // 추가
                    Point point=hashmap.get(k);
                        queue.add(point.left);
                        queue.add(point.right);
                }
            }
        }
    }

    public static void main(String[] args) {
        hashmap.put(1,new Point(4,5));
        hashmap.put(4,new Point(8,10));
        hashmap.put(5,new Point(6,7));


        bfs(1);

    }

}
