package programmers.stackQueue;
import java.util.*;
public class 동성_기능개발 {
    public int[] solution(int[] progresses, int[] speeds) {

        // 큐 생성
        Queue<Integer> queue=new LinkedList<>();
        for (int i=0;i<progresses.length;i++) {
            int val=100-progresses[i];

            int mod=val%speeds[i];
            int res=val/speeds[i];
            // System.out.println(mod);
            // System.out.println(res);
            if (mod>0) {
                progresses[i]=res+1;
            }
            else {
                progresses[i]=res;
            }
            queue.add(progresses[i]);
        }

        // System.out.println(Arrays.toString(progresses));
        // System.out.println(queue.toString());

        ArrayList<Integer>arrayList=new ArrayList<>();
        while (!queue.isEmpty()) {
            int res=queue.poll();
            int time=1;

            while (!queue.isEmpty()) {
                int next=queue.peek();
                if (res>=next) {
                    queue.poll();
                    time++;
                }
                else {
                    break;
                }
            }
            arrayList.add(time);

        }

        // System.out.println(arrayList.toString());
        int[] answer =new int[arrayList.size()];
        for (int i=0;i<arrayList.size();i++) {
            answer[i]=arrayList.get(i);
        }

        return answer;
    }
}
