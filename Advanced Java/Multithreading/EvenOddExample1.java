class Even implements Runnable {
    private Object lock;

    public Even(Object lock) {
        this.lock = lock;
    }

    public void printEven() {
        synchronized (lock) {
            for (int i = 0; i <= 10; i += 2) {
                System.out.print(i + " ");
                lock.notify(); // Notify the other thread
                try {
                    if (i < 10) {
                        lock.wait(); // Wait for the other thread to notify
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void run() {
        printEven();
    }
}

class Odd implements Runnable {
    private Object lock;

    public Odd(Object lock) {
        this.lock = lock;
    }

    public void printOdd() {
        synchronized (lock) {
            for (int i = 1; i <= 10; i += 2) {
                System.out.print(i + " ");
                lock.notify(); // Notify the other thread
                try {
                    if (i < 9) {
                        lock.wait(); // Wait for the other thread to notify
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void run() {
        printOdd();
    }
}

public class EvenOddExample1 {
    public static void main(String args[]) {
        Object lock = new Object();
        Thread even = new Thread(new Even(lock));
        Thread odd = new Thread(new Odd(lock));
        even.start();
        odd.start();
        try {
            even.join();
            odd.join();
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("\nAfter both have executed");
    }
}
