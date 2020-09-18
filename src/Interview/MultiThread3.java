package Interview;


public class MultiThread3 {

    public static void main(String[] args) {
        new MultiThread3().init1();
    }

    private int money = 100;

    private final Object lock = new Object();

    public void write (int change) {
        // use lock or use synchronized
        synchronized (lock) {
            money += change;
        }
    }

    public void write (String name, int change) {
        // use lock or use synchronized
        synchronized (lock) {
            System.out.println(name + "正在花第" + money + "块钱");
            money += change;
        }
    }

    public void read () {
        System.out.println("Money is " + money);
    }

    public void init1() {

        Thread thread1 = new Thread(() -> {
            int i = 0;

            while (i++<2000) write(-1);
            System.out.println("money减少完成");

        });

        Thread thread2 = new Thread(() -> {
            int j = 0;

            while (j++<2000) write(1);
            System.out.println("money增加完成");
        });

        thread1.start();
        thread2.start();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        read();

    }


    public void init2() {

        new Thread(() -> {

            while (money>0) {
                write("Thread1", -1);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        }).start();

        new Thread(() -> {

            while (money>0) {
                write("Thread2",-1);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        }).start();

    }
}
