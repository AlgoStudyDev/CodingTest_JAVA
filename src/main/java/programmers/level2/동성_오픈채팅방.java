//package programmers.level2;
//import java.util.*;
//
//// 첫번쨰 for문에서는 방에 들어온 사람 enter, change일 경우에만 name이 변경됨 -> 누가 변경되었는지 hashmap으로 변경
//// 두번째 for문에서는 변경된 아이디에 따라 기록 넣기
//
//public class 동성_오픈채팅방 {
//    public String{} solution(String{} record) {
//        ArrayList<String>arraylist=new ArrayList<>();
//        HashMap<String,String>hashmap=new HashMap<>();
//        for (String str:record) {
//            String strArr{}=str.split(" ");
//            String check=strArr{0};
//            String key=strArr{1};
//
//
//            if (check.equals("Enter") || check.equals("Change")) {
//                String value=strArr{2};
//                hashmap.put(key,value);
//            }
//
//        }
//        // System.out.println(hashmap.toString());
//        // 마지막꺼부터 시작해서 enter or leave면 그에 맞는거 출력
//        for (String str:record) {
//            String strArr{}=str.split(" ");
//            String check=strArr{0};
//            String key=strArr{1};
//
//            String name=hashmap.get(key);
//            if (check.equals("Enter")) {
//                arraylist.add(name+"님이 들어왔습니다.");
//            }
//            else if (check.equals("Leave")) {
//                arraylist.add(name+"님이 나갔습니다.");
//            }
//
//        }
//        // System.out.println(arraylist.toString());
//        String{} answer = new String{arraylist.size()};
//        for (int i=0;i<arraylist.size();i++) {
//            answer{i}=arraylist.get(i);
//        }
//        return answer;
//    }
//}
