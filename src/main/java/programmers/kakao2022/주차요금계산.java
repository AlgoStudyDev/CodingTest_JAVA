package programmers.kakao2022;

import java.util.*;

public class 주차요금계산 {
    public int[] solution(int[] fees, String[] records) {

        HashMap<String, ArrayList<String>> hashmap = new HashMap<>();

        for (String record : records) {
            String time = record.split(" ")[0];
            String number = record.split(" ")[1];
            String state = record.split(" ")[2];
            int num = changeTime(time);
            boolean check = true;

            ArrayList<String> templist = new ArrayList<>();
            String temp = state + "-" + time;

            if (hashmap.containsKey(number)) {
                templist = hashmap.get(number);
                templist.add(temp);
            } else {
                templist.add(temp);
            }
            hashmap.put(number, templist);
        }

        // System.out.println(hashmap.toString());

        HashMap<String, Integer> resultmap = new HashMap<>();
        for (String key : hashmap.keySet()) {
            // int value=hashmap.get(key);
            ArrayList<String> arrlist = hashmap.get(key);
            ArrayList<Integer> inlist = new ArrayList<>();
            ArrayList<Integer> outlist = new ArrayList<>();

            for (String str : arrlist) {
                String strArr = str.split("-")[1];
                if (str.startsWith("IN")) {
                    inlist.add(changeTime(strArr));
                } else {
                    outlist.add(changeTime(strArr));
                }
            }
            // inlist가 더 많다면 outlist에 출차 추가하기
            if (inlist.size() > outlist.size()) {
                outlist.add(changeTime("23:59"));
            }

            int value = 0;
            for (int i = 0; i < inlist.size(); i++) {
                value += outlist.get(i) - inlist.get(i); //출차-입차하고 값 누적하기
            }
            resultmap.put(key, value); // 누적된 값 map에 기록
        }
        // System.out.println(resultmap.toString());
        HashMap<Integer, Integer> resmap = new HashMap<>();
        int[] answer = new int[resultmap.size()];
        for (String key : resultmap.keySet()) {
            int value = resultmap.get(key);
            int money = fees[1];
            if (value > fees[0]) {
                // int temp=(int) Math.ceil((value-fees[0])/fees[2]); // 소수점 안나옴 -> double로 나눠야 함
                int temp = (int) Math.ceil((value - fees[0]) / (double) fees[2]);
                // double temp=(value-fees[0])/(double)fees[2];
                // System.out.println("temp"+temp);
                money += (temp * fees[3]);
                // System.out.println("money"+money);
            }
            resmap.put(Integer.parseInt(key), money);
        }
        // 차량번호 기준으로 정렬 -> map의 key를 기준으로 정렬
        ArrayList<Integer> arraylist = new ArrayList<>(resmap.keySet()); // key를 list에 다 넣는다.!
        Collections.sort(arraylist, (o1, o2) -> (o1.compareTo(o2)));
        // System.out.println(arraylist.toString());
        for (int i = 0; i < arraylist.size(); i++) {
            answer[i] = resmap.get(arraylist.get(i));
        }


        return answer;
    }

    // 시간을 분으로 변경
    public int changeTime(String value) {
        String hour = value.split(":")[0];
        String min = value.split(":")[1];

        int res = Integer.parseInt(hour) * 60 + Integer.parseInt(min);
        return res;
    }

}
