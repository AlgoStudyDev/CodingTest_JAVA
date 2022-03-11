package programmers.level1;
// 자리수의 합 구하기 (String을 이용)
public class 동성_하샤드수 {
    public boolean solution(int x) {
        boolean answer = true;

        String str=Integer.toString(x);
        String strArr[]=str.split("");
        int total=0;
        for (String s:strArr) {
            total+=Integer.parseInt(s);
        }
        // System.out.println(total);
        if (x%total==0) {
            answer=true;
        }
        else {
            answer=false;
        }

        return answer;
    }
}
