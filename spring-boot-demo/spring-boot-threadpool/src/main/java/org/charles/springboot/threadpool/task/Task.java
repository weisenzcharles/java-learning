package org.charles.springboot.threadpool.task;

public class Task implements Runnable {
    private int i = 0;

    public Task(int i) {
        this.i = i;
    }

    @Override
    public void run() {
        System.out.println("线程 " + Thread.currentThread().getName() + " 执行后 i 的值为：" + i);
        try {
            Thread.sleep(1000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
