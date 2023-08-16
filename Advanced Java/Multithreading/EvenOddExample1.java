class Even implements Runnable{
    private Object lock;
    public Even(Object lock){
        this.lock = lock;
    }
    public void printEven(){
        synchronized(lock){
            for(int i=0;i<=10;i++){
                if(i%2==0){
                    System.out.print(i+" ");
                    lock.notifyAll();
                    try{
                        lock.wait();
                    }catch(InterruptedException e){
                        e.printStackTrace();
                    }
                }
            }
        }
    }
    public void run(){
        printEven();
    }
}
class Odd implements Runnable{
    private Object lock;
    public Odd(Object lock){
        this.lock = lock;
    }
    public void printOdd(){
        synchronized(lock){
            for(int i=0;i<=10;i++){
                if(i%2!=0){
                    System.out.println(i+" ");
                    lock.notifyAll();
                     try{
                        lock.wait();
                    }catch(InterruptedException e){
                        e.printStackTrace();
                    }
                }
            }
        }
    }
    
    public void run(){
        printOdd();
    }
}
public class EvenOddExample1{
    public static void  main(String args[]){
        Object lock = new Object();
        Thread even = new Thread(new Even(lock));
        Thread odd = new Thread(new Odd(lock));
        even.start();
        odd.start();
    }
}