package thread;

/**
 * @author zengjia
 * @date 2021-12-21 16:11:14
 */
public class OddEvenPrint {
    private static final Object monitor = new Object();
    private static volatile int num = 0;
    private static volatile int max = 100;

    public static void main(String[] args) {
        OddPrint odd = new OddPrint();
        EvenPrint even = new EvenPrint();
        new Thread(odd).start();
        new Thread(even).start();
    }

    static class OddPrint implements Runnable {
        @Override
        public void run() {
            while (max > 0) {
                synchronized (monitor) {
                    if ((num & 1) == 1) {
                        try {
                            monitor.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    System.out.println("偶数：" + num);
                    num++;
                    max--;
                    monitor.notify();
                }
            }
        }
    }

    static class EvenPrint implements Runnable {
        @Override
        public void run() {
            while (max >0) {
                synchronized (monitor) {
                    if ((num & 1) == 0) {
                        try {
                            monitor.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    System.out.println("奇数：" + num);
                    num++;
                    max--;
                    monitor.notify();
                }
            }
        }
    }
}
