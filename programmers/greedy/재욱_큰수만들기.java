package programmers.greedy;
import java.util.*;

/*
* String 간의 대소비교는 불가능이지만 char간에 대소 비교는 operator로 가능함
* 그 점을 이용해서 stack의 가장 위 char형 숫자와 for문을 통해서 들어오는 number.charAt(i)을 비교해서
* pop과 push를 통해 스택에는 가장 큰 수만 남게 된다
* 스택에서 pop을 통해 숫자를 버릴 때마다, k를 1만큼 뺀다(숫자를 버리는 행위이기 때문)
* 어쩌면 그리디보다 스택에 좀더 가깝지 않나 싶은 그리디 문제였다.
*  */

public class 재욱_큰수만들기 {
    public String solution(String number, int k) {
        StringBuilder stringBuilder = new StringBuilder();
        Stack<Character> stack = new Stack<>();

        for(int i = 0; i < number.length(); i++){ // "1 9 2 4"
            while (!stack.isEmpty() && stack.peek() < number.charAt(i) && k > 0){
                stack.pop(); //
                k -= 1;
            }
            stack.push(number.charAt(i)); // '9', '4'
        }

        while (k > 0){
            stack.pop();
            k -= 1;
        }

        while (!stack.isEmpty()){
            stringBuilder.append(stack.pop());
        }

        return stringBuilder.reverse().toString();
    }

    public static void main(String[] args) {
        String number = "1924"; // 94
        재욱_큰수만들기 o = new 재욱_큰수만들기();
        int k = 2;
        System.out.println(o.solution(number, k));
    }
}
