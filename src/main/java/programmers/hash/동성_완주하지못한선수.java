package programmers.hash;
import java.util.*;
public class 동성_완주하지못한선수 {
  public String solution2(String[] participant, String[] completion) {
        String answer = "";

        HashMap<String,Integer>parti=new HashMap<String, Integer>();

        // Default
        for (String par:participant) {
            parti.put(par,parti.getOrDefault(par,0)+1);
        }

        for (String comple:completion) {
            parti.put(comple,parti.get(comple)-1);
        }


        // System.out.println(parti.toString());
        // value가 1이상인 것은 아직 동명의 미완주자가 있음 -> return
        for (String strKey:parti.keySet()) {
            int value=parti.get(strKey);
            if (value!=0) {
                return strKey;
            }
        }

        return answer;
    }

}
