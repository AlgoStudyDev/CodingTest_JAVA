package programmers.level2;

import java.util.*;
public class 동성_피로도_dfs {
    class Game {
        int require;
        int spend;

        Game(int require, int spend) {
            this.require=require;
            this.spend=spend;
        }
    }

    static ArrayList<Game>arraylist;
    static int max;
    // static ArrayList<Game>answerlist;
    static int ans[][];
    static int check[];
    static int n;
    static int K;
    static int energe;

    public void dfs(int l){
        if (l==n) {
            int temp=K;
            int value=0;
            for (int an[]: ans) {
                int require=an[0];
                int spend=an[1];

                if (require<=temp) {
                    temp-=spend;
                    value++;
                }

            }

            if (value>max) {
                max=value;
            }

            K=energe;
        }
        else {
            for (int i=0;i<n;i++) {
                if (check[i]==0) {
                    check[i]=1;
                    // answerlist.add(arraylist.get(i));
                    ans[l][0]=arraylist.get(i).require;
                    ans[l][1]=arraylist.get(i).spend;
                    dfs(l+1);
                    check[i]=0;
                }
            }
        }

    }

    public int solution(int k, int[][] dungeons) {
        int answer = -1;
        max=0;
        n=dungeons.length;
        check=new int[dungeons.length];
        energe=k;
        K=k;
        // answerlist=new ArrayList<>();
        arraylist=new ArrayList<>();
        ans=new int[n][2];
        for (int[]dun:dungeons) {
            // System.out.println(dun[0]+" "+dun[1]);
            arraylist.add(new Game(dun[0],dun[1]));
        }
        dfs(0);
        // System.out.println(max);
        answer=max;


        return answer;
    }
}
