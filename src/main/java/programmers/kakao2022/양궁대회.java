package programmers.kakao2022;
import java.util.*;
public class 양궁대회 {

    class Solution {
        static int nn;
        static int apeech[];
        static int lion[];
        static int res[]={-1};
        static int max=-10000;

        public void dfs(int l) {
            if (l==nn) { // 종료
                int a_point=0;
                int l_point=0;
                for (int i=0;i<11;i++) {
                    if (apeech[i]!=0 || lion[i]!=0) {
                        if (lion[i]>apeech[i]) {
                            l_point+=10-i; // 라이언이 점수 가져감
                        }else {
                            a_point+=10-i;
                        }
                    }
                }

                if (l_point>a_point) { // 값 갱신
                    if (l_point-a_point>=max) {
                        max=l_point-a_point;
                        res=lion.clone();
                    }
                }


            }else {
                for (int j=0;j<11;j++) {
                    if (lion[j]<=apeech[j]) { //작거나 같을경우에만 돌림, 라이언이 더 커지면 dfs를 더 돌 필요없음.
                        lion[j]++;
                        dfs(l+1);
                        lion[j]--;
                    } else {
                        break;
                    }
                }
            }


        }

        public int[] solution(int n, int[] info) {
            // int[] answer = {};
            apeech=info.clone();
            nn=n;
            lion=new int[11];
            dfs(0);
            return res;
        }
    }
}
