package programmers.sort;
import java.util.*;
public class 동성_sort {

    public static void main(String[] args) {

        // Arrays.sort정렬은 -> Wrapper class를 사용해야 함 (int 안됨)
        Integer nums[]={3,100,5,2,4,7,8};
        // 기본 정렬 (오름차순)
        Arrays.sort(nums);
        System.out.println(Arrays.toString(nums)); // [2, 3, 4, 5, 7, 8, 100]

        // 내림차순으로 정렬
        // 1. 람다를 이용한 방법 -> 숫자는 compareTo를 사용
        Arrays.sort(nums,(o1,o2)->(o2).compareTo(o1));
        System.out.println(Arrays.toString(nums)); // [100, 8, 7, 5, 4, 3, 2]
        // 2. Collections.reverseOrder()를 이용한 방법
        Arrays.sort(nums,Collections.reverseOrder());
        System.out.println(Arrays.toString(nums)); // [100, 8, 7, 5, 4, 3, 2]

        // 문자 정렬
        String strNums[]={"3","100","1","500","8","200"};
        Arrays.sort(strNums); // 오름차순 정렬
        System.out.println(Arrays.toString(strNums));  // [1, 100, 200, 3, 500, 8] -> 사전순으로 정렬됨

        Arrays.sort(strNums,(o1,o2)->(o2).compareTo(o1)); // 내림차순 정렬
        System.out.println(Arrays.toString(strNums)); // [8, 500, 3, 200, 100, 1]

        // 가장 큰 수를 구하고 싶을때
        Arrays.sort(strNums,(o1,o2)->(o2+o1).compareTo(o1+o2));
        System.out.println(Arrays.toString(strNums)); // [8, 500, 3, 200, 1, 100]


    }
}
