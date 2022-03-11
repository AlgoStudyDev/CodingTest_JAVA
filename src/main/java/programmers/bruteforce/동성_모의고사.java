package programmers.bruteforce;
import java.util.*;
public class 동성_모의고사 {

    static int size;

    public int[] solution(int[] answers) {


        size=answers.length;
        Map<Integer,Integer>map=new HashMap<>();

        int[]person1={1,2,3,4,5};
        int[]person2={2,1,2,3,2,4,2,5};
        int[]person3={3,3,1,1,2,2,4,4,5,5};

        // 1. personList -> 푼 문제 수에 대하여 answer 개수를 출력
        map.put(1,personList(person1,answers));
        map.put(2,personList(person2,answers));
        map.put(3,personList(person3,answers));
        // System.out.println(map.toString());
        // 출력 : {3=0, 2=0, 1=5}

        // 2. value 기준으로 오름차순 정렬
        ArrayList<Integer>keyList=new ArrayList<>(map.keySet());
        Collections.sort(keyList,(o1,o2)->map.get(o2).compareTo(map.get(o1)));
        // System.out.println(keyList);

        // 3. 만약 동일한다면 다음것도 포함
        ArrayList<Integer>answersList=new ArrayList<>();
        int maxValue=map.get(keyList.get(0));
        answersList.add(keyList.get(0));

        for (int i=1;i<keyList.size();i++) {
            if (maxValue==map.get(keyList.get(i))) {
                answersList.add(keyList.get(i));
            }else {
                break;
            }
        }

        // 4. 출력
        int[] answer = new int[answersList.size()];
        for (int i=0;i<answersList.size();i++) {
            answer[i]=answersList.get(i);
        }

        return answer;
    }

    // personList -> arraylist로 만들고, 정답과 비교하여 정답 개수를 return
    public int personList(int[]person,int []answers) {
        int div=size/person.length;
        ArrayList<Integer>arraylist=new ArrayList<>();
        for (int k=0;k<div;k++) {
            for (int j=0;j<person.length;j++) {
                arraylist.add(person[j]);
            }
        }
        int mod=size%person.length;
        if (mod>0) {
            for (int p=0;p<mod;p++) {
                arraylist.add(person[p]);
            }
        }

        int answer=0;
        for (int i=0;i<answers.length;i++) {
            if (arraylist.get(i)==answers[i]) {
                answer++;
            }
        }

        return answer;
    }


}
