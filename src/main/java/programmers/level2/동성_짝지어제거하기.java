package programmers.level2;
import java.util.*;

// Stack을 이용하여 제거하기

public class 동성_짝지어제거하기 {
    public int solution(String s)
    {
        int answer = -1;
        Stack<String>stack=new Stack<>();
        String strArr[]=s.split("");

        for (String str:strArr) {
            if (!stack.isEmpty() && stack.peek().equals(str)) {
                stack.pop();
            }
            else {
                stack.push(str);
            }
        }

        if (stack.isEmpty()) answer=1;
        else {
            answer=0;
        }

        return answer;
    }

}
