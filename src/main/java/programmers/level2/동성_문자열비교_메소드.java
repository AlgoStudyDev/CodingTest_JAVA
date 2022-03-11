package programmers.level2;
import java.util.*;
public class 동성_문자열비교_메소드 {
    public static void main(String[] args) {
        String str1="ABCD";
        String str2="AC";

        // 연속된 문자열 찾음
        if (str1.contains("AC")) {
            System.out.println(true);
        }
        else {
            System.out.println(false);
        }

        // 중간에 문자열 여부 확인 - indexOf
        System.out.println(str1.indexOf("AB"));
        if (str1.indexOf("AC")!=-1) {
            System.out.println("indexOf"+true);
        }

    }
}
