package programmers.hash;

import java.util.*;
/*
* 해시 문제로 푸니깐 금방 풀렸다.
* 처음에는 범위를 안 보고 이중배열로 풀다가 효율성에서 막혀서 해시로 금방 풀었다. 어쩌면 파이썬보다
* 자바가 해시에 관해서는 더 좋을지도 모르겠다.
* 프로그래머스 '완주하지 못한 선수' 문제, 레벨 1, 2021.10.21*/
class 재욱_완주하지못한선수 {
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        Map<String, Integer> hash = new HashMap<>();

        for (String participator : participant) {
            if (!hash.containsKey(participator)) {
                hash.put(participator, 1);
            } else {
                hash.put(participator, hash.get(participator) + 1);
            }
        }

        for (String complete : completion) {
            if (hash.containsKey(complete)) {
                hash.put(complete, hash.get(complete) - 1);
            }
        }

        for (Map.Entry<String, Integer> element : hash.entrySet()) {
            if (element.getValue() != 0) {
                answer = element.getKey();
                break;
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        재욱_완주하지못한선수 재욱완주하지못한선수 = new 재욱_완주하지못한선수();
        String[] participant = {"mislav", "stanko", "mislav", "ana"};
        String[] completion = {"stanko", "ana", "mislav"};
        System.out.println(재욱완주하지못한선수.solution(participant, completion));
    }
}
