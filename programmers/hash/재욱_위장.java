package programmers.hash;

import java.util.*;
/*
* 해시로 풀 접근은 간단하게 했지만, 경우의 수를 도출하는데 있어서 애를 먹어서 파이썬 코드르 참조해서 풀었다.
* 'answer *= (element.getValue() + 1)'라는 코드가 나온 이유는 각 종류의 옷마다 안 입는 경우를 다 포함해서 answer에 곱하고,
* 마지막에 옷을 전부 입지 않은 1가지 경우를 빼서 반환한다. 이렇게 하면 정답을 도출할 수 있다.
* 해시 접근법은 쉬웠지만 정답인 경우의 수 도출이 좀 어색한 문제였던 것 같은데 수학을 잘 한다면 매우 쉬웠을 것 같다.
* 프로그래머스 '위장' 문제, 레벨 2, 2021.10.21*/
public class 재욱_위장 {
    public int solution(String[][] clothes) {
        int answer = 1;
        Map<String, Integer> hash = new HashMap<>();

        for (String[] clothe : clothes) {
            if (!hash.containsKey(clothe[1])) {
                hash.put(clothe[1], 1);
            } else {
                hash.put(clothe[1], hash.get(clothe[1]) + 1);
            }
        }

        for (Map.Entry<String, Integer> element : hash.entrySet()) {
            answer *= (element.getValue() + 1);
        }

        return answer - 1;
    }
}
