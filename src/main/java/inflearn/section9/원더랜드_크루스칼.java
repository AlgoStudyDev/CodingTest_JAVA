package inflearn.section9;
import java.util.*;
public class 원더랜드_크루스칼 {

    static int unf[];

    static class Edge implements Comparable<Edge>{
        int v1;
        int v2;
        int cost;

        Edge(int v1,int v2, int cost) {
            this.v1=v1;
            this.v2=v2;
            this.cost=cost;
        }

        // cost 기준으로 오름차순 (작은것부터 출력하기 위해)
        @Override
        public int compareTo(Edge edge) {
            return this.cost-edge.cost;
        }
    }

    static int find(int a) {
        if (unf[a]==a) return a;
        else {
            return unf[a]=find(unf[a]);
        }
    }

    static void union(int a, int b) {
        int fa=find(a);
        int fb=find(b);
        if (fa!=fb) {
            unf[fa]=fb;
        }
    }

    public static void main(String[] args) {
        Scanner scan=new Scanner(System.in);
        int n=scan.nextInt();
        int m=scan.nextInt();
        unf=new int[n+1];  //1~n개
        // 자기자신으로 맞추기
        for (int i=1;i<=n;i++) unf[i]=i;

        ArrayList<Edge> arrayList=new ArrayList<>();
        // 입력
        for (int i=1;i<=m;i++) {
            int a=scan.nextInt();
            int b=scan.nextInt();
            int c=scan.nextInt();

            arrayList.add(new Edge(a,b,c));
        }

        Collections.sort(arrayList);

        // 정렬된거 확인해보기
        for (Edge edge:arrayList) {
            System.out.println(edge.cost+" "+ edge.v1+" "+ edge.v2);
        }

        // arraylist에 있는거 하나씩 빼고 선 연결
        int answer=0;
        for (Edge edge:arrayList) {
            int v1=edge.v1;
            int v2=edge.v2;
            int cost=edge.cost;

            int fa=find(v1);
            int fb=find(v2);

            if (fa!=fb) {
                union(v1,v2);
                answer+=cost;
            }

        }

        // 다 했으면 경로 압축
        for (int i=1;i<=n;i++) {
            find(i);
        }

        System.out.println(Arrays.toString(unf));
        System.out.println(answer);

    }
}
