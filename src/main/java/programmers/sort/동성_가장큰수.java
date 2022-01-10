package programmers.sort;
import java.util.*;
public class 동성_가장큰수 {

    public static String solution(int[] numbers) {
        String answer = "";


        ArrayList<String>arrayList=new ArrayList<>();
        // 숫자 -> 문자로 변경
        String[]nums=new String[numbers.length];
        for (int i=0;i<numbers.length;i++) {
            nums[i]=Integer.toString(numbers[i]);
            arrayList.add(nums[i]);
        }


        // 람다를 통한 정렬
        Arrays.sort(nums,(o1,o2)->(o2+o1).compareTo(o1+o2));
        Collections.sort(arrayList,(o1, o2) -> (o2+o1).compareTo(o1+o2));
        System.out.println("배열정렬:"+Arrays.toString(nums));
        System.out.println("arrayList정렬:"+arrayList.toString());

        for (String s:arrayList) {
            answer+=s;
        }

        if (arrayList.get(0).equals("0")) {
            return "0";
        }

        System.out.println(answer);

        return answer;
    }

    public static void main(String[] args) {
//        int numbers[]={6, 10, 2};
        int numbers[]={3, 30, 34, 5, 9};
        solution(numbers);


    }
}
