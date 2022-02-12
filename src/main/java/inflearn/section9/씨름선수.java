package inflearn.section9;
import java.util.*;
public class 씨름선수 {

    static class Info{
        int weight;
        int key;

        Info(int weight, int key) {
            this.weight=weight;
            this.key=key;
        }

    }

    public static void main(String[] args) {
        Scanner scan=new Scanner(System.in);
        int n=scan.nextInt();
        ArrayList<Info>arrayList=new ArrayList<>();
        for (int i=0;i<n;i++) {
            int weight=scan.nextInt();
            int key=scan.nextInt();

            arrayList.add(new Info(weight,key));
        }


        int answer=0;
        for (Info info:arrayList) {
            int h=info.key;
            int w=info.weight;

            boolean check=false;
            for (Info info1:arrayList) {
                int h2=info1.key;
                int w2=info1.weight;
//                System.out.println("origin"+h+" "+w);
//                System.out.println("비교:"+h2+" "+w2);

                if (h<h2 && w<w2) {
                    check=true;
                    break;
                }
            }
            if (check) {
                answer++;
            }
        }
        System.out.println(n-answer);



    }
}
