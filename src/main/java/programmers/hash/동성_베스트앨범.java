package programmers.hash;
import java.util.*;
public class 동성_베스트앨범 {

    static class Music{
        String genre;
        int play;
        int idx;

        public Music(String genre, int play, int idx) {
            this.genre = genre;
            this.play = play;
            this.idx = idx;
        }
    }


    public int[] solution(String[] genres, int[] plays) {

        Map<String, Integer> genreMap=new HashMap<>();
        // 1. 장르 선정 및 내림차순 정렬
        for (int i=0;i<genres.length;i++) {
            String key=genres[i];
            int value=plays[i];

            genreMap.put(key,genreMap.getOrDefault(key,0)+value);

            // ArraList
            ArrayList<Integer>arraylist=new ArrayList<>();
            arraylist.add(i);
            arraylist.add(value);

        }
        System.out.println(genreMap.toString());
        // value 기준으로 내림차순 정렬
        List<String>keySetList=new ArrayList<>(genreMap.keySet());
        Collections.sort(keySetList,(o1,o2)->genreMap.get(o2).compareTo(genreMap.get(o1)));

        // 2. 장르 내 노래 선정
        ArrayList<Music> result=new ArrayList<>();
        for (String gern:keySetList) {
            ArrayList<Music>list= new ArrayList<>();

            for (int i=0;i< genres.length;i++) {
                if (genres[i].equals(gern)) {
                    list.add(new Music(gern,plays[i],i));
                }
            }

            // play 기준으로 내림차순 정렬
            Collections.sort(list,(o1,o2)->o2.play-o1.play);
            result.add(list.get(0));
            if (list.size()!=1) {
                result.add(list.get(1));
            }
        }

        int answer[]=new int[result.size()];
        for (int i=0;i< result.size();i++) {
            answer[i]=result.get(i).idx;
        }
        return answer;

    }




}
