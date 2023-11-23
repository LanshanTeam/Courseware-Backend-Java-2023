package org.example;

import java.util.concurrent.*;

public class poolTest {
    public static void main(String[] args) {
        ExecutorService pools = new ThreadPoolExecutor(
                3, 5, 8,
                TimeUnit.SECONDS,
                new ArrayBlockingQueue<>(6),
                Executors.defaultThreadFactory(),
                new ThreadPoolExecutor.AbortPolicy());
        pools.execute(() -> {
            for (int i = 0; i < 50; i++) {
                System.out.println(Thread.currentThread() + "开炮" + "第" + i + "次");
            }
        });

        pools.execute(() -> {
            for (int i = 0; i < 50; i++) {
                System.out.println(Thread.currentThread() + "熄火" + "第" + i + "次");
            }
        });
    }
}
