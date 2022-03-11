package programmers.kakao2022;
import java.util.*;

public class K진수에서소수개수구하기 {

    public int solution(int n, int k) {
        int answer = 0;

        // int k=211020101011;
        // String ss="211020101011";
        // String str[]=ss.split("0");
        // System.out.println(Arrays.toString(str));

        // k진법으로 변환
        StringBuilder sb=new StringBuilder();
        while (n/k!=0) {
            int div=n%k;
            n=n/k;
            // System.out.println("div:"+div+"n:"+n);
            sb.append(div);

            // 마지막꺼 꼭 넣어주기
            if (n/k==0) {
                sb.append(n);
            }
        }
        // 넣어주고 반대로 저장했기 때문에 reverse 해주기
        sb.reverse();
        String temp[]=sb.toString().split("0"); //0을 기준으로 나누기
        // System.out.println(Arrays.toString(temp));

        // 소수인지 찾기
        // String sr="00010";
        // System.out.println(isPrime(sr,2));
        for (String str:temp) {
            if (!str.equals("")) {
                if (isPrime(str)) answer++;
            }
        }

        return answer;
    }


    public boolean isPrime(String value) {
        // k 진법 -> 10 진법으로 변경하기
        // int temp=Integer.parseInt(value);
        Long temp=Long.parseLong(value);
        // System.out.println("temp:"+temp);
        boolean check=true;
        if (temp<2) return false;
        // 2부터 자기 자신 전까지 나누었을때 나누어떨어지면 소수가 아님,
        // temp의 범위를 제곱근까지만 설정
        // int limit = (int) Math.sqrt(temp);
        for (int i=2;i<temp;i++) {
            if (temp%i==0) return false;
        }

        return true;
    }
}
