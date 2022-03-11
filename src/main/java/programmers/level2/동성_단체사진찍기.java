package programmers.level2;

import java.util.*;
public class 동성_단체사진찍기 {


    static int check[];
    static String ans[];
    static int N;
    static String arr[]={"A","C", "F", "J", "M", "N", "R", "T"};
    static int m;
    static String m_data[];
    static int max;

    static void dfs(int l) {
        if (l==N) {
//            System.out.println(Arrays.toString(ans));
            if (check(ans)) {
                max++;
            }
        }
        else {
            for (int i=0;i<8;i++) {
                if (check[i]==0) {
                    check[i]=1; // 방문처리
                    ans[l]=arr[i];
                    dfs(l+1);
                    check[i]=0;
                }
            }
        }
    }

    static boolean check(String[]res) {

        boolean check_boolean=false;
        for (int i=0;i< m_data.length;i++) {
            String data=m_data[i];
            String dataArr[]=data.split("");
//            System.out.println(Arrays.toString(dataArr));
            String first=dataArr[0];
            String two=dataArr[2];
            String calc=dataArr[3];
            int val=Integer.parseInt(dataArr[4]);

            // 자바 String에서 글자찾기
            int first_idx=0;
            int two_idx=0;
            for (int idx=0;idx<res.length;idx++) {
                if (res[idx].equals(first)) {
                    first_idx=idx;
                }
                else if (res[idx].equals(two)) {
                    two_idx=idx;
                }
            }

//            System.out.println(first_idx+" "+two_idx);
            int result=Math.abs(two_idx-first_idx)-1;
            if (calc.equals("=")) {
                if (result==val) {
                    check_boolean=true;
                }
                else {
                    check_boolean=false;
                    break;
                }
            }
            else if (calc.equals("<")) {
                if (result<val) {
                    check_boolean=true;
                }
                else {
                    check_boolean=false;
                    break;
                }

            }
            else if (calc.equals(">")){
                if (result>val) {
                    check_boolean=true;
                }
                else {
                    check_boolean=false;
                    break;
                }
            }

        }

        return check_boolean;

    }

    public static int solution(int n, String[] data) {
        m=n; //조건
        max=0;
        m_data=data;
        N=8;
        check=new int[8];
        ans=new String[8];
        dfs(0);

//        String test[]={"T", "R", "N", "M", "J", "F", "C", "A"};
//        check(test);
        // System.out.println(max);
        int answer = max;
        return answer;
    }

    public static void main(String[] args) {
        String data[]={"N~F=0", "R~T>2"};
        solution(2,data);
    }
}
