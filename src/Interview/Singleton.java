package Interview;

// 饿汉式单例
class Singleton1 {

    private static Singleton1 instance = new Singleton1();

    private Singleton1(){}

    public Singleton1 getInstance() {
        return instance;
    }

}

// 懒汉式单例, 线程不安全
class Singleton2 {

    private static Singleton2 instance;

    private Singleton2(){}

    public Singleton2 getInstance() {
        if (instance==null){
            instance = new Singleton2();
        }
        return instance;
    }
}

// 懒汉式单例, 双重检查, 线程安全, JVM乱序执行可能会影响, 所以加上volatile
// 在内部加上synchronized比外部开销小, 因为只有几个线程会进入synchronized区域
class Singleton3 {

    private volatile static Singleton3 instance;

    private Singleton3(){}

    public Singleton3 getInstance() {
        if (instance==null){
            synchronized (Singleton3.class) {
                if (instance == null)
                    instance = new Singleton3();
            }
        }
        return instance;
    }
}

// 懒汉式单例, 内部类方式, 线程安全
class Singleton4 {

    private static class InnerClass{
        private static final Singleton4 instance = new Singleton4();
    }

    private Singleton4(){}

    public Singleton4 getInstance() {
        return InnerClass.instance;
    }
}
