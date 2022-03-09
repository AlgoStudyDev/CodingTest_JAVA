package programmers.level1;

import java.util.*;
// 달을 전부 다 적고
// 요일을 적는다
// 지난 달 만큼 더하고 + 요일을 더한다
// -1은 0부터 시작하기 떄문에 -1을 해준다
// 7로 나눈 나머지를 이용해 요일을 계산한다.


public class 동성_2016 {
    public String solution(int a, int b) {
        int month[]={31,29,31,30,31,30,31,31,30,31,30,31};
        String day[]={"FRI","SAT","SUN","MON","TUE","WED","THU"};

        // 시작은 1.1 (금)부터 시작
        // 전체 날짜 구하기
        int total=0;

        // 몇월 달인지 더하기
        for (int i=0;i<a-1;i++) {
            total+=month[i];
        } // 1월이라면 -> 0, 2월이라면 -> 0+31

        // 일 더하기
        total+=b; // 1월 4일 이라면 => 4
        System.out.println(total);
        total-=1; //0부터 시작하기 때문에 -1해주기

        // 요일 구하기 35/7 =0
        String answer = day[total%7];
        return answer;
    }

}
