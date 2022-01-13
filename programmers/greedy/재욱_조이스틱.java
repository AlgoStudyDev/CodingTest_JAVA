package programmers.greedy;

import java.util.Arrays;


// 마지막 min 계산 원리 알아오기!!!
public class 재욱_조이스틱 {
    public int solution(String name) {
        int answer = 0;
        char[] alphabet = new char[26];
        int index = 0;
        int len = name.length();
        int min = len - 1; // A가 하나도 없어서 모두 방문해야할 때 이동거리는 최대임

        for (char i = 'A'; i <= 'Z'; i++) {
            alphabet[index] = i;
            index += 1;
        }

        for (int i = 0; i < len; i++) {
            answer += Math.min(Arrays.binarySearch(alphabet, name.charAt(i)), // name.charAt(i) = 'B'
                    Math.abs(26 - Arrays.binarySearch(alphabet, name.charAt(i))));
            int nextPosition = i + 1; // 1

            while (nextPosition < len && name.charAt(nextPosition) == 'A') {
                nextPosition += 1; // i = 0, nextPosition = 2
            }
            System.out.println(i);
            System.out.println(nextPosition);
            System.out.println((i * 2) + len - nextPosition);
            System.out.println("=============================");
            min = Math.min(min, (i * 2) + len - nextPosition);
        }


        return answer + min;
    }

    public static void main(String[] args) {
        재욱_조이스틱 o = new 재욱_조이스틱();
        String name = "JAN"; // AAAA -> JANX -> [9, 0 ,13, 3]
        System.out.println(o.solution(name));
    }
}
