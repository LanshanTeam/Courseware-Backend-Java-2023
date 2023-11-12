package org.example;

public class AnonyTest {
    public static void main(String[] args) {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                // 线程需要执行的任务代码
                System.out.println("子线程开始启动....");
                for (int i = 0; i < 30; i++) {
                    System.out.println("run i:" + i);
                }
            }
        });
        thread.start();
    }
}
