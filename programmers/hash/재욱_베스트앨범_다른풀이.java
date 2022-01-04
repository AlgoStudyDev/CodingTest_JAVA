package programmers.hash;

import java.util.*;
/*
 * 지난 번에 풀어보고
 * 프로그래머스 '베스트 앨범' 문제, 레벨 3, 2021.10.21*/
class Triple {
    String genre;
    int play;
    int index;

    public Triple(String genre, int play, int index) {
        this.genre = genre;
        this.play = play;
        this.index = index;
    }
}

class BestAlbumAnotherSolve {
    public int[] solution(String[] genres, int[] plays) {
        List<Integer> answer = new ArrayList<>();
        Map<String, Integer> music = new HashMap<>();
        List<Triple> playList = new ArrayList<>();

        for (int i = 0; i < genres.length; i++) {
            playList.add(new Triple(genres[i], plays[i], i));
        }

        for (int i = 0; i < genres.length; i++) {
            if (!music.containsKey(genres[i])) {
                music.put(genres[i], plays[i]);
            } else {
                music.put(genres[i], music.get(genres[i]) + plays[i]);
            }
        }

        List<String> musicList = new ArrayList<>(music.keySet()); // music의 key가 들어간 String 타입의 ArrayList 선언
        Collections.sort(musicList, (v1, v2) -> (music.get(v2).compareTo(music.get(v1)))); // music의 value인 플레이 횟수를 장르를 내림차순으로 정렬하기
        Collections.sort(playList, (v1, v2) -> v2.play - v1.play); // Triple의 play 기준으로 내림차순 소팅

        // Collections.sort(musicList); // 문자열 오름차순
        // Collections.sort(musicList, Collections.reverseOrder()); // 문자열 내림차순
        // Collections.sort(playList, (o1, o2) -> o1.play - o2.play); // 오름차순 소팅

        for (String genre : musicList) {
            int count = 0;
            for (Triple triple : playList) {
                if ((genre).equals(triple.genre)) {
                    answer.add(triple.index);
                    count += 1;
                    if (count > 1) {
                        break;
                    }
                }
            }
        }
        return answer.stream().mapToInt(i -> i).toArray();
    }
}
