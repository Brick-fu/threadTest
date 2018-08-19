package com.brick.thread.test1;

public class Demo1 implements Runnable{

    @Override
    public synchronized void run() {
        while(true){
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("线程启动了！！！");

        }
    }

    public static void main(String[] args){
        Demo1 demo=new Demo1();
        Thread thread=new Thread(demo);
        thread.start();
        while(true){
            synchronized (demo){
                System.out.println("主线程启动了！！！");
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                demo.notify();
            }
        }
    }
}
