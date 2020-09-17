package Interview;

public class MultiThread2 {


    public static void main(String[] args) {
        new MultiThread2().init();
    }

    public void init() {

        Object lock = new Object();

        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (lock) {
                    System.out.println("Thread1 print A");
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("Thread1 print B");
                    System.out.println("Thread1 print C");
                }
            }
        });

        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {

                synchronized (lock) {
                    System.out.println("Thread2 print A");
                    System.out.println("Thread2 print B");
                    System.out.println("Thread2 print C");
                    lock.notify();
                }

            }
        });

        thread1.start();
        thread2.start();
    }

    public void printNum(String threadName) {
        int i = 0;
        while (i++<3) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(threadName + " is printing " + i);
        }
    }


}


