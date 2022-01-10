package programmers.sort;
import java.util.*;
public class 동성_K번째수 {

    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];


        for (int i=0;i<commands.length;i++) {
            int start=commands[i][0]-1;
            int end=commands[i][1];
            int find=commands[i][2];

            // System.out.println("end:"+end);
            // System.out.println(Arrays.toString(commands[i]));
            int[]arr=Arrays.copyOfRange(array,start,end);
            Arrays.sort(arr);
            // System.out.println(Arrays.toString(arr));

            int value=arr[find-1];
            // System.out.println(value);
            answer[i]=value;

        }


        return answer;
    }

    public static void main(String[] args) {

        int []origin={1,2,3,4,5};
        int []arr=Arrays.copyOfRange(origin,2,4);
        System.out.println(Arrays.toString(arr));
    }
}
