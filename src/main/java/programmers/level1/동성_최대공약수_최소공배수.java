package programmers.level1;

import java.util.*;
public class 동성_최대공약수_최소공배수 {
    public int[] solution(int n, int m) {
        int maxValue=maxPrime(n,m);
        int minValue=minMulti(maxValue,n,m);
        int[]answer={maxValue,minValue};
        return answer;
    }

    // 최대 공약수구하기
    // 1. 두 수중 가장 작은 값 구하기
    // 2. 그 값으로 둘다 나누어 떨어지면 최대 공약수 (아니면 -1 씩 감소)
    public int maxPrime(int a, int b) {
        int min=0;
        if (a<b) min=a;
        else min=b;

        // 두수를 나눈다.
        while(true) {
            if (a%min==0 && b%min==0) break;
            min--;
        }

        return min;
    }

    // 최소 공배수
    // 주어진 n,m을 최대 공약수로 나눈 값
    int minMulti(int gcd,int a,int b) {
        int total=gcd;
        total*=(a/gcd)*(b/gcd);
        return total;
    }
}
