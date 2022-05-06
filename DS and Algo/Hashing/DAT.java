public class DAT{
    private int table[];
    public DAT(){
        table = new int[1000];
    }

    public void insert(int i){
        table[i] = 1;
    }

    public void delete(int i){
        table[i] = 0;
    }

    public boolean search(int i){
        return (table[i]==1)?true:false;
    }
}

class Main{
    public static void main(String[] args) {
        DAT dat = new DAT();
        dat.insert(10);
        dat.insert(0);
        System.out.println(dat.search(10));
        dat.delete(10);
        System.out.println(dat.search(10));
    }
}