package programmers.sort;

import test.Main;

import java.util.Arrays;

public class 재욱_가장큰수 {
    public String solution(int[] numbers) {
//        StringBuilder answer = new StringBuilder();
//        String[] str = new String[numbers.length];
//        for (int i = 0; i < numbers.length; i++) {
//            str[i] = Integer.toString(numbers[i]);
//        }
//
//        Arrays.sort(str, Collections.reverseOrder());
//        for (int i = 0; i < str.length - 1; i++) {
//            if (Integer.parseInt(str[i]) % 10 == 0) {
//                int temp1 = Integer.parseInt(str[i] + str[i + 1]);
//                int temp2 = Integer.parseInt(str[i + 1] + str[i]);
//                if (temp2 > temp1) {
//                    String temp = str[i];
//                    str[i] = str[i + 1];
//                    str[i + 1] = temp;
//                }
//            }
//        }
//        if(str[0].equals("0")){
//            return "0";
//        }
//        for (String s : str) {
//            answer.append(s);
//        }
//        return answer.toString();

        String[] answer = new String[numbers.length];
        StringBuilder stringBuilder = new StringBuilder();

        for (int i = 0; i < numbers.length; i++) {
            answer[i] = Integer.toString(numbers[i]);
        }

//        Arrays.sort(answer, new Comparator<String>() {
//            @Override
//            public int compare(String o1, String o2) {
//                return (o2 + o1).compareTo(o1 + o2);
//            }
//        });

        Arrays.sort(answer, (o1, o2) -> (o2 + o1).compareTo(o1 + o2)); //두 수를 번갈아가며 합친 수 중 큰 값을 앞으로 정렬(내림차순 정렬)

        if (answer[0].equals("0")) {
            return "0";
        }

        for (String s : answer) {
            stringBuilder.append(s);
        }

        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        int[] numbers = {3, 30, 34, 5, 9, 0};
        재욱_가장큰수 s = new 재욱_가장큰수();
        System.out.println(s.solution(numbers));
    }
}
