package programmers.level1;

//arr1	           arr2	                return
//[[1,2],[2,3]]	[[3,4],[5,6]]	[[4,6],[7,9]]
//[[1],[2]]	    [[3],[4]]	        [[4],[6]]
public class 동성_행렬의덧셈_2중배열값구하기 {
    public int[][] solution(int[][] arr1, int[][] arr2) {
        int[][] answer = new int[arr1.length][arr1[0].length];
        for (int i=0;i<arr1.length;i++) {
            for (int j=0;j<arr1[i].length;j++) {
                answer[i][j]=arr1[i][j]+arr2[i][j];
            }
        }

        return answer;
    }
}
