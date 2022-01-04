package programmers.hash;

import java.util.HashMap;
import java.util.Map;
/*
*
* 프로그래머스 '폰번호 목록' 문제, 레벨 2, 2021.10.21*/
class 재욱_전화번호목록 {
    public boolean solution(String[] phoneBook) {
        HashMap<String, Integer> hashMap = new HashMap<>();

        for (int i = 0; i < phoneBook.length; i++) {
            hashMap.put(phoneBook[i], i);
        }

        for (Map.Entry<String, Integer> element : hashMap.entrySet()) {
            System.out.println("key 값은 " + element.getKey() + " " + "value값은 " + element.getValue());
        }

        for (String phone : phoneBook) {
            for (int j = 1; j < phone.length(); j++) {
                if (hashMap.containsKey(phone.substring(0, j))) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        재욱_전화번호목록 재욱전화번호목록 = new 재욱_전화번호목록();
        String[] phoneBook = {"119", "97674223", "1195524421"};
        System.out.println(재욱전화번호목록.solution(phoneBook));
    }

}