package inflearn.section9;
import java.util.*;
public class 결혼식 {

    static class Time implements Comparable<Time>{
        int start;
        int end;

        Time(int start, int end) {
            this.start=start;
            this.end=end;
        }

        @Override
        public int compareTo(Time o) {
            return this.end-o.end;
        }
    }

    public static void main(String[] args) {
        ArrayList<Time> arrayList=new ArrayList<>();
        Scanner scan=new Scanner(System.in);
        int n=scan.nextInt();

        for (int i=0;i<n;i++) {
            int start=scan.nextInt();
            int end=scan.nextInt();
            arrayList.add(new Time(start,end));
        }

        Collections.sort(arrayList);

//        for (Time time:arrayList) {
//            System.out.println(time.start+" "+time.end);
//        }

        // 종료 시간 기준으로
        int max=0;
        int idx=0;
        for (;idx<n;idx++) {

            int next_idx=idx+1;
            int time=arrayList.get(idx).end; // 종료시간
            int temp=1;
            for (;next_idx<n;next_idx++) {
                   if (time>arrayList.get(next_idx).start) {
                       temp++;
                   }
            }

            if (max<temp) {
                max=temp;
            }
        }
        System.out.println(max);



    }
}
