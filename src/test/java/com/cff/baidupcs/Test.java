package com.cff.baidupcs;

public class Test {

    public static ThreadLocal<Integer> threadLocal = new InheritableThreadLocal<Integer>();

    public static void main(String args[]){
        threadLocal.set(new Integer(123));

        Thread thread = new MyThread();
        thread.start();

        System.out.println("main = " + threadLocal.get());
        
        Thread thread2 = new MyThread2();
        thread2.start();

    }

    static class MyThread extends Thread{
        @Override
        public void run(){
        	threadLocal.set(1223424234);
            System.out.println("MyThread = " + threadLocal.get());
        }
    }
    
    static class MyThread2 extends Thread{
        @Override
        public void run(){
//        	threadLocal.set(1223424234);
            System.out.println("MyThread2 = " + threadLocal.get());
        }
    }
}