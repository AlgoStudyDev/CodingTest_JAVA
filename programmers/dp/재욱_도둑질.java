package programmers.dp;


// 몰라서 100% 인터넷 참조했고, 원리를 이해하려고 했습니다 ㅎㅎㅎ
public class 재욱_도둑질 {
    public int solution(int[] money) {
        int length = money.length;
        int[] dp1 = new int[length - 1];
        int[] dp2 = new int[length];

        dp1[0] = money[0];
        dp1[1] = money[0];
        dp2[0] = 0;
        dp2[1] = money[1];
        for (int i = 2; i < length - 1; i++) {
            dp1[i] = Math.max(dp1[i - 2] + money[i], dp1[i - 1]);
        }
        for (int i = 2; i < length; i++) {
            dp2[i] = Math.max(dp2[i - 2] + money[i], dp2[i - 1]);
        }

        return Math.max(dp1[length - 2], dp2[length - 1]);
    }

    public static void main(String[] args) {
        재욱_도둑질 o = new 재욱_도둑질();
        System.out.println();
    }
}
