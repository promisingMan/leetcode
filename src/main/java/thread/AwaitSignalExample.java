package thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class AwaitSignalExample {

    private Lock lock = new ReentrantLock();
    private Condition condition = lock.newCondition();

    public void before() {
        lock.lock();
        try {
            System.out.println("before");
            condition.signalAll();
        } finally {
            lock.unlock();
        }
    }

    public void after() {
        lock.lock();
        try {
            condition.await();
            System.out.println("after");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    static Object object = new Object();

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newCachedThreadPool();
        AwaitSignalExample example = new AwaitSignalExample();
        executorService.execute(() -> example.after());
        executorService.execute(() -> example.before());

        Thread t1 = new Thread(() -> {
            synchronized (object) {
                try {
                    System.out.println("t1 start");
                    Thread.sleep(5000);
                    System.out.println("t1 end");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        t1.start();
        Thread t2 = new Thread(() -> {
//            Scanner scanner = new Scanner(System.in);
//            scanner.nextInt();
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (object) {
                System.out.println("t2 start");
                System.out.println("t2 start");
            }
        });

        t2.start();
        System.out.println(t2.isInterrupted());
        t2.interrupt();
        System.out.println(t2.isInterrupted());

        System.out.println("main run");
    }

}