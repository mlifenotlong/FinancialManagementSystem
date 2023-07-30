package com.wj.util;

public class ThreadAB {

    public static class Thread1  extends java.lang.Thread {
        @Override
        public void run(){
            System.out.println("a");
        }

    }
    public static class Thread2  extends java.lang.Thread {
        @Override
        public void run(){
            System.out.println("b");
        }

    }

    public static void main(String[] args) throws InterruptedException {
        int count=0;
        while (count<=100){
            Thread1 thread1=new Thread1();
            Thread2 thread2=new Thread2();

            synchronized (thread1){
                thread1.start();
                thread1.wait();
                thread2.notify();
            }
            synchronized (thread2){
                thread2.start();
                thread2.wait();
                thread1.notify();
            }

            count++;
        }

    }
}
