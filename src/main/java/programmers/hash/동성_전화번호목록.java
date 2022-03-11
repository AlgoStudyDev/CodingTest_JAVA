package programmers.hash;
import java.util.*;
public class 동성_전화번호목록 {
    public boolean solution(String[] phone_book) {
        boolean answer = true;

        // 배열 정렬
        Arrays.sort(phone_book);

        // 배열 출력
        // System.out.println(Arrays.toString(phone_book));

        String str=phone_book[0];
        for (int i=1;i<phone_book.length;i++) {
            boolean val=phone_book[i].startsWith(str);
            // System.out.println(val);

            if (val) {
                return false;
            }
            else {
                str=phone_book[i];
            }

        }

        return answer;
    }
}
