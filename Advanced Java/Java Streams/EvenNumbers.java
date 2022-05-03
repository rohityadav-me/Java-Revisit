import java.util.Arrays;

import java.util.List;

public class EvenNumbers{
    public static void main(String[] args){
        List<Integer> numList = Arrays.asList(5,10,20,3,4,8,12,22,13);
        numList.stream().filter(x->x%2==0).filter(x->x>10).forEach(System.out::println); // This stream will print all even numbers greater than 10
    }
}