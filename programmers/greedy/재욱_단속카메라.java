package programmers.greedy;

import java.util.*;

class Car {
    int startEntry;
    int endEntry;

    public Car(int start, int end) {
        this.startEntry = start;
        this.endEntry = end;
    }
}

public class 재욱_단속카메라 {
    public int solution(int[][] routes) {
        int camera = 0;
        List<Car> carList = new ArrayList<>();
        int cameraPosition = -30001;

        for (int[] route : routes) {
            carList.add(new Car(route[0], route[1])); // 차 진입시기, 나가는 시기
        }

        carList.sort(Comparator.comparingInt(v -> v.endEntry)); // [[-20,-15], [-18,-13], [-14,-5], [-5,-3]]
        // Arrays.sort(routes, (a, b) -> Integer.compare(a[1], b[1]));

        for(Car car : carList){
            if(cameraPosition < car.startEntry){
                camera += 1;
                cameraPosition = car.endEntry;
            }
        }
        return camera;
    }

    public static void main(String[] args) {
        재욱_단속카메라 i = new 재욱_단속카메라();
        int[][] routes = {{-20, -15}, {-14, -5}, {-18, -13}, {-5, -3}};
        System.out.println(i.solution(routes));
    }
}
