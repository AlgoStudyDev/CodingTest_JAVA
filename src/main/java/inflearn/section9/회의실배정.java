package inflearn.section9;

import java.util.*;
public class 회의실배정 {

    static class Room implements Comparable<Room>{
        int start;
        int end;

        int getStart() {
            return start;
        }

        int getEnd() {
            return end;
        }

        Room(int start, int end) {
            this.start=start;
            this.end=end;
        }


        @Override
        public int compareTo(Room o) {
            if (this.end==o.end) return this.start-o.start;
            else {
                return this.end-o.end;
            }
        }
    }

    public static void main(String[] args) {
        ArrayList<Room>arrayList=new ArrayList<>();
        Scanner scan=new Scanner(System.in);
        int n=scan.nextInt();

        for (int i=0;i<n;i++) {
            int start=scan.nextInt();
            int end=scan.nextInt();
            arrayList.add(new Room(start,end));
        }


        // 종료 기점으로 오름차순 정렬, 그리고 나서 (같을 경우)는 시작 시간기준으로 내림차순 정렬
//        Comparator<Room>reverseStart=Comparator.comparing(Room::getStart).reversed(); // 안의 내림차순은 따로 만들어서 지정해줘야 함.
//        arrayList.sort(Comparator.comparing(Room::getEnd).thenComparing(reverseStart));
        Collections.sort(arrayList);



//        for (Room room:arrayList) {
//            System.out.println(room.start+" "+room.end);
//        }

        int et=0;
        int answer=0;
        for (Room room:arrayList) {
            if (room.start>=et) {
                et=room.end; //
                answer++;
            }
        }
        System.out.println(answer);





    }
}
