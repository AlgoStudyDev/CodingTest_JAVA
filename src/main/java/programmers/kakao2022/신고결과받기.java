package programmers.kakao2022;

import java.util.*;
// 어려웠던 점 -> 동일 유저가 신고했을때 1명으로 처리 ex) mary -> frod, mary ->frod신고했으면 mary ->frod (1)임
// 이 부분은 동일 신고 유저를 없애기 위해 value를 HashSet으로 설정하였음
// 그리고 이 hashMap에서 정지당한 유저 (stop_map)을 뽑음 -> map이기 때문에 신고한 동일 유저가 나오지 않는 점을 이용
public class 신고결과받기 {

    public int[] solution(String[] id_list, String[] report, int k) {

        HashMap<String, HashSet<String>> hashmap=new HashMap<>();
        for (int i=0;i<report.length;i++) {

            String key=report[i].split(" ")[0];
            String value=report[i].split(" ")[1];

            HashSet<String>hashset=new HashSet<>();
            if (hashmap.containsKey(key)) {
                hashset=hashmap.get(key);
                hashset.add(value);
            }
            else {
                hashset.add(value);
            }
            hashmap.put(key,hashset);
        }

        // 신고당한 map -> value가 k번이상이면 정지
        // hashmap에서 신고당한 유저 리스트 뽑기
        HashMap<String, Integer> stop_map=new HashMap<>();
        for (String str:hashmap.keySet()) {
            String key=str;
            HashSet<String>hashset =hashmap.get(key);
            for (String hash:hashset) {
                stop_map.put(hash,stop_map.getOrDefault(hash,0)+1);
            }

        }
        // id_list의 값을 확인 -> hashmap에서의 value 확인 -> stop_map을 뒤짐 -
        int[] answer = new int[id_list.length];

        for (int i=0;i<id_list.length;i++) {
            String key=id_list[i];
            int value=0;
            if (hashmap.containsKey(key)) {
                HashSet<String> hashset=hashmap.get(key);
                for (String str:hashset) {
                    int v=stop_map.get(str);
                    if (v>=k) value++;
                }
            }

            answer[i]=value;
        }

        return answer;
    }
}
