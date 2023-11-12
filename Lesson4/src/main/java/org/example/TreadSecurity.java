package org.example;

public class TreadSecurity {
    static class Counter{
        private int count = 0;
        public int increment() {
            synchronized (this){
                return ++this.count;
            }
        }

        public int getCount() {
            return count;
        }
    }

    private static final int ans = 50000;

    public static void main(String[] args) throws InterruptedException {

        Counter counter = new Counter();
        Thread thread1 = new Thread(() -> {
            for(int i = 0;i<ans;i++){
                counter.increment();
            }
        });
        Thread thread2 = new Thread(() -> {
            for(int j = 0;j<ans;j++){
                counter.increment();
            }
        });
        thread1.start();
        thread2.start();

        thread1.join();
        thread2.join();

        System.out.println("最终结果：" + counter.getCount());
    }
}
