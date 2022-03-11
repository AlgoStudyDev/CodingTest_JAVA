package programmers.heap;
import java.util.*;

/*
    1. 2개의 우선순위 큐 생성 (min, max)
	- 한쪽은 최소값을 나오게, 한쪽은 최대값이 나오게 하기 위해서
    2. operations에 따라 연산자 확인 (Insert, Delete인지)
        - operations을 split을 이용하여 연산자, 숫자로 나누기
    3. operation에 따라
        3-1. Insert면 minPq, maxPq에 둘다 값 넣어줌
        3-2. Delete이고 만약 삭제값이 1(최대값이면) maxPq에서 값을 뺌, 이 값 또한 minPq에서 remove로 지워줌
        3-3. Delete이고 만약 삭제값이 1(최소값이면) minPq에서 값을 뺌, 이 값 또한 maxPq에서 remove로 지워줌

    4. 나온값 확인 후 배열에 넣어준다.
 */

public class 동성_이중우선순위큐 {
    public int[] solution(String[] operations) {

//        1. 2개의 우선순위 큐 생성 (min, max)
        PriorityQueue<Integer>minPq=new PriorityQueue<>();
        PriorityQueue<Integer>maxPq=new PriorityQueue<>(Collections.reverseOrder()); // 최대값 출력

//        2. operations에 따라 연산자 확인 (Insert, Delete인지)
        for (String s:operations) {
            String temp[]=s.split(" "); // 공백 반드시 써주기
            String oper=temp[0];
            String val=temp[1];
            int value=Integer.parseInt(val);

//            3. operation에 따라
            // 삽입
            if (oper.equals("I")) {
                minPq.add(value);
                maxPq.add(value);
            }
            // 삭제
            else {
                int removeValue;
                // 3-2. 최대값 삭제
                if (value==1) {
                    // 만약 pq가 있으면 삭제
                    if (!maxPq.isEmpty()) {
                        removeValue=maxPq.poll();  // 최대값 삭제
                        minPq.remove(removeValue); // 최대값은 remove로 검색 후 삭제
                    }

                }
                // 3-3. 최솟값 삭제
                else {
                    // 만약 pq가 있으면 삭제
                    if (!minPq.isEmpty()) {
                        removeValue=minPq.poll();  //최소값 삭제
                        maxPq.remove(removeValue); // 최소값은 remove로 검색 후 삭제
                    }

                }
            }
        }


        System.out.println(maxPq.toString());
        System.out.println(minPq.toString());

        //   4. 나온값 확인 후 배열에 넣어준다.
        int[] answer = new int[2];
        if (minPq.isEmpty()) {
            answer[0]=0;
            answer[1]=0;
        }
        else {
            answer[0]=maxPq.poll();
            answer[1]=minPq.poll();
        }

        return answer;
    }

}
