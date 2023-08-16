public class ThreeThreadsSequentially{

    public static void main(String[] args) {
        NumberPrinter printer = new NumberPrinter();
        
        Thread thread1 = new Thread(() -> printer.printNumbers(1));
        Thread thread2 = new Thread(() -> printer.printNumbers(2));
        Thread thread3 = new Thread(() -> printer.printNumbers(3));
        
        thread1.start();
        thread2.start();
        thread3.start();
    }
}

class NumberPrinter {
    private int currentValue = 1;
    private final Object lock = new Object();
    
    public void printNumbers(int threadId) {
        synchronized (lock) {
            while (currentValue <= 100) {
                if ((currentValue % 3) == (threadId - 1)) {
                    System.out.println("Thread " + threadId + ": " + currentValue);
                    currentValue++;
                    lock.notifyAll();
                } else {
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
        }
    }
}
