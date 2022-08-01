import java.util.Deque;
import java.util.LinkedList;

public class JavaDeque{
    public static void main(String[] args) {
        Deque<Integer> d = new LinkedList<>();
        d.offerFirst(10);
        d.offerFirst(15);
        d.offerLast(5);
        d.offerLast(28);
        System.out.println(d.peekFirst());
        System.out.println(d.peekLast());
        d.pollFirst();
        d.pollLast();
        System.out.println(d.peekFirst());
        System.out.println(d.peekLast());
    }
}