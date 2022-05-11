import java.util.ArrayList;
import java.util.LinkedList;

public class Chaining{
    int bucket;
    ArrayList<LinkedList<Integer>> table;
    public Chaining(int hash){
        bucket = hash;
        table = new ArrayList<LinkedList<Integer>>();
        for(int i = 0;i<bucket;i++)
            table.add(new LinkedList<Integer>());
    }

    void insert(Integer k){
        int i = k%bucket;
        table.get(i).add(k);
    }

    boolean search(Integer k){
        int i = k%bucket;
        return table.get(i).contains(k);
    }

    void remove(Integer k){
        int i = k%bucket;
        table.get(i).remove(k);
    }

    public static void main(String[] args) {
        Chaining mh = new Chaining(7);
        mh.insert(70);
        mh.insert(71);
        mh.insert(56);
        mh.insert(9);
        mh.insert(72);
        System.out.println(mh.search(72));
        mh.remove(72);
        System.out.println(mh.search(72));
    }
}