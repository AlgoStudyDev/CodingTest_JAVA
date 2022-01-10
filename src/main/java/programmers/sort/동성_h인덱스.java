package programmers.sort;
import java.util.*;
public class 동성_h인덱스 {
    public static int solution(int[] citations) {
        int answer = 0;
        // arraylist로 변경
        ArrayList<Integer> arraylist=new ArrayList<>();
        for (int i:citations) {
            arraylist.add(i);
        }
        // 내림차순 정렬
        Collections.sort(arraylist,(o1,o2)->(o2).compareTo(o1));
        System.out.println(arraylist.toString()); //[6,5,3,1,0]

        // 하나씩 꺼내서 값 비교
        int i=arraylist.get(0);
        System.out.println("i"+i);
        for (;i>=0;i--) {
            int hIdx=i;
            int value=0;
            int namuzi=0;
            int j=i;
            for (;j>=0;j--) {

                if (j>=hIdx) {
                    value++;
                }
                else {
                    // 전체 개수에서 j만큼 빼준다
                    namuzi=arraylist.size()-j;
                    break;
                }

            }
            // namuzi=0; value=1
//            System.out.println("hIdx"+hIdx);
//            System.out.println("value"+value);
//            System.out.println("namuzi"+namuzi);
            if (value<=hIdx && namuzi>=hIdx) {
                System.out.println("hIdx"+hIdx);
                return hIdx;
            }


        }
        return answer;
    }

    public static void main(String[] args) {
//        solution(new int arr={{3, 0, 6, 1, 5})
        int arr[]={3,0,6,1,5};
        solution(arr);


    }

}
