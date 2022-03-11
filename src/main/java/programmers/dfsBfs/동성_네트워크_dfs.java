package programmers.dfsBfs;

public class 동성_네트워크_dfs {

    static int check[];
    static int nn;


    public void dfs(int node, int check[], int computers[][]) {

        for (int i=0;i<computers.length;i++) {
            if (computers[node][i]==1 && check[i]==0) {
                check[i]=1;
                dfs(i,check,computers);
            }
        }

    }

    public int solution(int n, int[][] computers) {
        int answer = 0;
        nn=n;
        check=new int[n];
        for (int i=0;i<n;i++) {
            for (int j=0;j<n;j++) {
                if (check[i]==0 && computers[i][j]==1) {
                    check[i]=1;
                    dfs(i,check,computers);
                    answer++;
                }
            }
        }

        return answer;
    }
}
