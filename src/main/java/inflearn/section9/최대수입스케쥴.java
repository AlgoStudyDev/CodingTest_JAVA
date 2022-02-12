package inflearn.section9;
import java.util.*;
public class 최대수입스케쥴 {

    static class Profit implements Comparable<Profit>{
        int value;
        int day;

        Profit(int value, int day) {
            this.value=value;
            this.day=day;
        }

        // 내림차순
        @Override
        public int compareTo(Profit profit) {
            return profit.day-this.day;
        }
    }

    public static void main(String[] args) {
        Scanner scan=new Scanner(System.in);
        int n=scan.nextInt();

        PriorityQueue<Integer> pq=new PriorityQueue<>(Collections.reverseOrder());
        int maxDay=0;
        ArrayList<Profit> arrayList=new ArrayList<>();


        for (int i=0;i<n;i++) {
            int value=scan.nextInt();
            int day=scan.nextInt();

            arrayList.add(new Profit(value,day));
            maxDay=Math.max(maxDay,day);
        }


        // 정렬
        Collections.sort(arrayList);
//        for (Profit profit:arrayList) {
//            System.out.println(profit.day+" "+profit.value);
//        }

        // max_day
        int answer=0;
        for (int i=maxDay;i>=1;i--) {
            // 여기서 i가 날짜랑 같은거 다 넣기
            for (int j=0;j<arrayList.size();j++) {
                int arraylist_day=arrayList.get(j).day;
                int arraylist_value=arrayList.get(j).value;
                if (arraylist_day==i) {
                    pq.add(arraylist_value);
                }
            }

            // pq에서 뽑기
//            System.out.println("pq 확인");
//            System.out.println(pq.toString());
            if(!pq.isEmpty()) {
                answer+=pq.poll();
            }
        }
        System.out.println(answer);

    }
}
