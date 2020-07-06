package Interview;

import java.util.concurrent.Callable;

class ThreadTask implements Runnable {

    private int money = 100;
    Object lock = new Object();

    @Override
    public void run() {
        while (true){
            synchronized (lock){
                System.out.println(Thread.currentThread().getName() + "get the lock");
                if (money>0){
                    System.out.println(Thread.currentThread().getName() + "正在花第" + money + "块钱");
                    money--;
                } else {
                    break;
                }
            }

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }
}

class main{

    public static void main(String[] args) {
        ThreadTask task = new ThreadTask();
        Thread thread1 = new Thread(task,"小张");
        Thread thread2 = new Thread(task,"小王");
        Thread thread3 = new Thread(task,"小猪");

        thread1.start();
        thread2.start();
        thread3.start();

    }

}




