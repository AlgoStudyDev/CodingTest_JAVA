package programmers.heap;
import java.util.*;
public class 동성_디스크컨트롤러 {
    static class Info {
        int req;
        int time;

        public Info(int req, int time) {
            this.req = req;
            this.time = time;
        }
    }

    public int solution(int[][] jobs) {

        Info info;

        // 큐에 넣기
//        Queue<Info>queue=new LinkedList<>();
        LinkedList<Info> queue = new LinkedList<>();
        for (int i = 0; i < jobs.length; i++) {
            System.out.println();
            int req = jobs[i][0];
            int end = jobs[i][1];
            // System.out.println(req + "," + end);

            info = new Info(req, end);
            queue.offer(info);
        }

        // 넣은 큐를 정렬하기
        Collections.sort(queue, new Comparator<Info>() {
            @Override
            public int compare(Info o1, Info o2) {
                return o1.req - o2.req;
            }
        });
//        while (!queue.isEmpty()) {
//            Info out=queue.poll();
//            System.out.println("req:"+out.req+"end:"+out.time);
//        }


        for (Info temp:queue) {
            System.out.println("출력");
            System.out.println(temp.req+" "+temp.time);
        }

        // 우선 순위 큐 만들기 - 우선순위큐에 넣을때는 Compare을 이용해 뒤에 인자를 바탕으로 정렬이 되어야 된다.
        PriorityQueue<Info> pq = new PriorityQueue<>(new Comparator<Info>() {
            @Override
            public int compare(Info o1, Info o2) {
                return o1.time - o2.time;
            }
        });


        int answer=0;
        int cnt=0;
        int time=queue.peek().req; // 가장 짧은 요청 시간


        while(cnt< jobs.length) {
            //
            while(!queue.isEmpty() && queue.peek().req<=time) { // 큐가 비어있지 않고, 요청시간 안에 들어 있으면
                pq.offer(queue.poll()); // 큐에서 빼서 pq에 넣어줌, 이때 반복으로 넣어줌
            }
            if (!pq.isEmpty()) { // pq가 비어있지 않으면
                Info temp=pq.poll(); // 그 값을 빼서 처리, 이때 빠진 값은 작업이 제일 빠른 거임
                time+=temp.time; // 현재 시간에 + 더해줌
                // answer+=time-temp.req; //
                answer=answer+time-temp.req; // 누적 답에 현재 시간에서 요청 시간을 빼줌
                cnt++;  // 작업을 완료하였기 때문에 cnt 증가
            }
            else {
                time++; // pq가 비어있으면 -> time 1 증가 (계속 시간 보내기 위해서)
            }
        }

        answer=answer/cnt;
        return answer;
    }
}
