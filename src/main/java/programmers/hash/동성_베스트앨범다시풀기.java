package programmers.hash;
import java.util.*;
public class 동성_베스트앨범다시풀기 {

    public static class Music{
        int idx;
        int plays;
        String genre;

        Music(int idx, int plays,String genre) {
            this.idx=idx;
            this.plays=plays;
            this.genre=genre;
        }

    }

    public static int[] solution(String[] genres, int[] plays) {


        // 먼저 장르 선정
        // 장르 선정하기 위해서는 장르와 value -> value를 내림차순으로
        HashMap<String, Integer>genre=new HashMap<>();

        for (int i=0;i<genres.length;i++) {
            String key=genres[i];
            int value=plays[i];
            genre.put(key,genre.getOrDefault(key,0)+value);
        }
        // value 기준으로 오름차순 정렬
        // value 기준으로 오름차순하기 위해서는 key에 대한 arraylist를 만들어야 함.
        List<String>arraylist=new ArrayList<>(genre.keySet());
        // 정렬
        Collections.sort(arraylist,(o1,o2)->genre.get(o2).compareTo(genre.get(o1)));
        System.out.println(genre.toString());


//        ArrayList<Music>result=new ArrayList<>();
//        for (int i=0;i<genres.length;i++) {
//            result.add(new Music(genres[i],i,plays[i]));
//        }

        ArrayList<Integer>answers=new ArrayList<>();
        // 장르내 노래 선정
        for (String gen:arraylist) {
            ArrayList<Music>lists=new ArrayList<>();

            for (int i=0;i<genres.length;i++) {
                if (gen.equals(genres[i])) {
                    lists.add(new Music(i,plays[i],genres[i]));
                }
            }


            // 내림차순 정렬
            Collections.sort(lists,(o1,o2)->(o2.plays-o1.plays));

            answers.add(lists.get(0).idx);

            if (lists.size()!=1) {
                answers.add(lists.get(1).idx);
            }
        }



//        System.out.println(answers.toString());
        int[] answer = new int[answers.size()];
        for (int i=0;i<answer.length;i++) {
            answer[i]=answers.get(i);
        }

        System.out.println(Arrays.toString(answer));


        return answer;
    }

    public static void main(String[] args) {

        String gen[]={"classic", "pop", "classic", "classic", "pop"};
        int plays[]={500, 600, 150, 800, 2500};

        solution(gen,plays);

    }

}
