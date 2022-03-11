package programmers.stackQueue;
import java.util.*;
public class 동성_프린터 {
    static class Printer{
        int idx;
        int priority;

        Printer(int idx, int priority) {
            this.idx=idx;
            this.priority=priority;
        }
    }

    public int solution(int[] priorities, int location) {
        int answer = 0;
        Queue<Printer> queue=new LinkedList<>();
        for (int i=0;i<priorities.length;i++) {

            Printer printer=new Printer(i,priorities[i]);
            queue.add(printer);

        }

        // System.out.println(queue.toString());

        int time=1;
        while (!queue.isEmpty()) {
            Printer printer=queue.poll();
            int idx=printer.idx;
            int first_priority=printer.priority;
            boolean check=true;


            // 1번 문제 -> Queue가 무한히 돌면 안됨
//             while (!queue.isEmpty()) {
//                 Printer next_printer=queue.peek();
//                 int next_priority=next_printer.priority;
//                 int next_idx=next_printer.idx;

//                 // 큰게 존재
//                 if (first_priority<next_priority) {
//                     queue.add(new Printer(idx,first_priority));
//                     check=false;
//                     break;
//                 }

//                 // else {
//                 //     if (idx==location) {
//                 //         return time;
//                 //     }
//                 //     time++;
//                 // }
//             }

            // -> for Each로 수정 (1번만 돌게 만든다)
            for (Printer nextPrinter:queue) {
                int next_priority=nextPrinter.priority;
                int next_idx=nextPrinter.idx;

                if (first_priority<next_priority) {
                    queue.add(new Printer(idx,first_priority));
                    check=false;
                    break;
                }

            }

            // 다 돌았는데 큰게 없으면 뽑느다.
            if (check) {
                if (idx==location) {
                    return time;
                }
                time++;
            }

        }



        return answer;
    }
}
