package programmers.heap;
import java.util.*;
public class 동성_우선순위큐오름차순정렬TEST {
    static class Book implements Comparable<Book> {
        int value;
        String writer;
        Book(int value, String writer) {
            this.value=value;
            this.writer=writer;
        }
        public int getValue() {
            return this.value;
        }
        public String getWriter() {
            return this.writer;
        }
        //  오름차순 정렬 (큰게 뒤로)
        @Override
        public int compareTo(Book book) {
            if (this.value>book.getValue()) return 1;
            else if (this.value<book.getValue()) return -1;
            return 0;
        }
    }

    public static void main(String[] args) {
        PriorityQueue<Book> priorityQueue = new PriorityQueue<>();
        priorityQueue.add(new Book(3650, "sds"));
        priorityQueue.add(new Book(31, "ds"));
        priorityQueue.add(new Book(1, "sjs"));
        priorityQueue.add(new Book(365, "hey"));
        while (!priorityQueue.isEmpty()) {
            Book book = priorityQueue.poll();
            System.out.println("가격 : " + book.getValue() + " 작가 : " + book.getWriter());
        }
    }

}
