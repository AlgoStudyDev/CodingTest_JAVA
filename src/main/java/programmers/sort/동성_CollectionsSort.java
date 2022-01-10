package programmers.sort;
import java.util.*;
public class 동성_CollectionsSort {
    static class Coffee {
        int price;
        String name;

        public int getPrice() {
            return this.price;
        }

        Coffee(int price, String name) {
            this.price=price;
            this.name=name;
        }

    }

    public static void main(String[] args) {
        // Collections Sort -> arraylist를 정렬하고 싶을대 사용
        // 1. 숫자 정렬
        List<Integer>arrayList=Arrays.asList(22,44,11,33);

        Collections.sort(arrayList); // 오름차순 정렬
        System.out.println(arrayList.toString()); // [11, 22, 33, 44]

        Collections.sort(arrayList,(o1,o2)->o2.compareTo(o1)); // 내림차순 정렬
        System.out.println(arrayList.toString()); // [44, 33, 22, 11]

        // 2. 문자 정렬
        List<String>strList=Arrays.asList("22","44","11","555");
        Collections.sort(strList);
        System.out.println(strList.toString());

        Collections.sort(strList,(o1,o2)->o2.compareTo(o1));
        System.out.println(strList.toString());

        // 3. class 정렬
        List<Coffee>classList=new ArrayList<>();
        classList.add(new Coffee(100,"americano"));
        classList.add(new Coffee(5,"tea"));
        classList.add(new Coffee(500,"coffee"));
        classList.add(new Coffee(1,"bread"));

        // 3-1. int에 의해 정렬될때는 -를 이용
        Collections.sort(classList,(o1,o2)-> o1.getPrice()-(o2.getPrice())); // 오름차순 정렬
        for (Coffee coffee:classList) {
            System.out.println(coffee.name+" "+coffee.getPrice());
        }

        /*
           class의 숫자에 의한 오름차순 정렬
            bread 1
            tea 5
            americano 100
            coffee 500
         */

        System.out.println("=====================");

        Collections.sort(classList,(o1,o2)-> o2.getPrice()-(o1.getPrice())); // 내림차순 정렬
        for (Coffee coffee:classList) {
            System.out.println(coffee.name+" "+coffee.getPrice());
        }
        /*
           class의 숫자에 의한 내림차순 정렬
            coffee 500
            americano 100
            tea 5
            bread 1
         */


        System.out.println("=====================");

        // 3-2. 문자에 의한 정렬
        Collections.sort(classList,(o1,o2)->(o1.name).compareTo(o2.name)); // 오름차순 정렬
        for (Coffee coffee:classList) {
            System.out.println(coffee.name+" "+coffee.getPrice());
        }

        /*
           class의 문자에 의한 오름차순 정렬
            americano 100
            bread 1
            coffee 500
            tea 5
         */


        System.out.println("=====================");
        Collections.sort(classList,(o1,o2)->(o2.name).compareTo(o1.name)); // 내림차순 정렬
        for (Coffee coffee:classList) {
            System.out.println(coffee.name+" "+coffee.getPrice());
        }
        /*
           class의 문자에 의한 내림차순 정렬
            tea 5
            coffee 500
            bread 1
            americano 100
         */



    }
}
