package inflearn.section9;
import java.util.*;

public class 씨름선수2 {
    static class Info{
        int key;
        int weight;

        Info(int key, int weight) {
            this.key=key;
            this.weight=weight;
        }

    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        ArrayList<Info> arrayList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int key = scan.nextInt(); //키
            int weight = scan.nextInt(); // 몸무게

            arrayList.add(new Info(key, weight)); //키, 몸무게
        }

        // key 순으로 내림차순 정렬
        Collections.sort(arrayList,(o1,o2)->((o2.key)-(o1.key)));

//        for (Info info:arrayList) {
//            System.out.println(info.key+" "+info.weight);
//        }

        int maxWeight=0;
        int answer=0;
        for (Info info:arrayList) {
            if (info.weight>maxWeight) {
                answer++;
                maxWeight=info.weight;
            }
        }

        System.out.println(answer);

    }
}
