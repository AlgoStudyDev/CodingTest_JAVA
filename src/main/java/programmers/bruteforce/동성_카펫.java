package programmers.bruteforce;
import java.util.*;

// brown 격자 8<=x<=5000
// yellow 격자 1<=y<=2000000
// 카펫의 가로 길이 >= 세로 길이
public class 동성_카펫 {
    public int[] solution(int brown, int yellow) {
        int xx=0;
        int yy=0;
        for (int y=1;y<=5000;y++) { // x>=y이기 때문에 y부터 시작
            boolean check=false;
            for (int x=y;x<=5000;x++) {
                int temp_brown=2*(x+y-2);
                int temp_yellow=(x-2)*(y-2);
                if (temp_brown==brown && temp_yellow==yellow) {
                    xx=x;
                    yy=y;
                    check=true;
                    break;
                }
            }

            if (check) {
                break;
            }
        }
        int[] answer = {xx,yy};
        // System.out.println("xx"+xx);
        // System.out.println("yy"+yy);


        return answer;
    }

}
