package programmers.hash;
import java.util.*;
public class 동성_위장 {
    public int solution(String[][] clothes) {


        HashMap<String,Integer>hashmap=new HashMap<>();

        for (int i=0;i<clothes.length;i++) {

            String key=clothes[i][1];
            // String value=clothes[i][0];
            hashmap.put(key,hashmap.getOrDefault(key,0)+1);

        }

        System.out.println(hashmap.toString());
        int answer = 1;

        for (String key:hashmap.keySet()) {
            answer*=hashmap.get(key)+1;
        }

        answer-=1;
        return answer;
    }
}
