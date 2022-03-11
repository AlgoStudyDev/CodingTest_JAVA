package programmers.level1;
import java.util.*;
// Arrays.copyOfRange("원본배열","시작인덱스","끝인덱스"); //마지막 인덱스는 포함 안됨
public class 동성_핸드폰번호가리기_copyOfRange {
    public String solution(String phone_number) {
        String answer = "";
        String phoneArr[]=phone_number.split("");
        int start=phoneArr.length-4;
        int end=phoneArr.length; //끝은 포함 안됨
        String copyArr[]=Arrays.copyOfRange(phoneArr,start,end);
        // System.out.println(Arrays.toString(copyArr));

        // 0~끝에서 4자리를 제외한 거는 *로 채우기
        for (int i=0;i<start;i++) {
            answer+="*";
        }

        for (String val:copyArr) {
            answer+=val;
        }

        return answer;
    }
}
