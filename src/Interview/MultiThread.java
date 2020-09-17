package Interview;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

// Runnable + synchronized
class MyThread implements Runnable {

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

// Runnable + Lock
class MyThread2 implements Runnable {

    private int money = 100;
    // 生成可重入锁
    private Lock lock = new ReentrantLock();

    @Override
    public void run() {

        while (true) {
            // 加锁
            lock.lock();
            try {
                System.out.println(Thread.currentThread().getName() + "get the lock");
                if (money>0) {
                    System.out.println(Thread.currentThread().getName() + "正在花第" + money + "块钱");
                    money--;
                } else {
                    break;
                }
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                // 释放锁
                lock.unlock();
            }

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}

// Thread + synchronized
class MyThread3 extends Thread {

    private int money = 100;
    Object lock = new Object();

    public MyThread3(String name){
        this.setName(name);
    }

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

        // 实现runnable接口可以共享数据
        MyThread task = new MyThread();
//        MyThread2 task = new MyThread2();
        Thread thread1 = new Thread(task,"小张");
        Thread thread2 = new Thread(task,"小王");
        Thread thread3 = new Thread(task,"小猪");

        thread1.start();
        thread2.start();
        thread3.start();


//        // 继承Thread不共享数据
//        Thread thread1 = new MyThread3("小张");
//        Thread thread2 = new MyThread3("小王");
//        Thread thread3 = new MyThread3("小猪");
//
//        thread1.start();
//        thread2.start();
//        thread3.start();
    }

}