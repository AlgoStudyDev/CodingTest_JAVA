package programmers.level2;

import java.util.*;
public class 동성_튜플 {
    public int[] solution(String s) {

        String str[]=s.split("");
        ArrayList<ArrayList>arraylist=new ArrayList<>();
        int i=1;
        for (;i<str.length-1;i++) {
            // System.out.println(str[i]);
            String value=str[i];

            if (value.equals("{")) {

                String temp="";
                for (int j=i+1;j<str.length-1;j++) {
                    if (str[j].equals("}")) {
                        // System.out.println(templist.toString());
                        // System.out.println(temp);
                        String tempArr[]=temp.split(",");
                        // System.out.println(Arrays.toString(tempArr));
                        ArrayList<String>templist=new ArrayList<>(Arrays.asList(tempArr));
                        arraylist.add(templist);
                        break;
                    }
                    else {
                        // templist.add(str[j]);
                        temp+=str[j];
                    }
                }
            }


        }

        // System.out.println(arraylist.toString());
        // 2. arraylist 개수 만큼 오름차순
        Collections.sort(arraylist,(o1,o2)->(o1.size()-(o2.size())));
        // System.out.println(arraylist.toString());

        ArrayList<String>resultList=new ArrayList<>();
        HashSet<String>hashset=new HashSet<>();

        for (ArrayList arr:arraylist) {

            // System.out.println(arr.toString());
            // System.out.println(arr.size());
            for (int k=0;k<arr.size();k++) {
                // System.out.println("k:"+arr.get(k));
                String val=(String)arr.get(k); // 캐스팅 해줘야함.
                if (!hashset.contains(val)) {
                    hashset.add(val);
                    resultList.add(val);
                }
            }
        }


        // System.out.println(resultList.toString());
        int[] answer = new int[resultList.size()];
        for (int k=0;k<resultList.size();k++) {
            answer[k]=Integer.parseInt(resultList.get(k));
        }


        return answer;
    }
}
