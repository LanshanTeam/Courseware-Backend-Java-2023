package org.example;

public class TreadSynchronized {
    public static void main(String[] args) {
        synchronized (TreadSynchronized.class){
            System.out.println("获得锁");
            synchronized (TreadSynchronized.class){
                System.out.println("再次获得锁");
            }
        }
    }
}
