package org.example;

public class Worker implements Runnable{

    public Worker(int start, int end,int[] array, long sum) {
        this.start = start;
        this.end = end;
        this.array = array;
        this.sum = sum;
    }

    @Override
    public void run() {
        for (int i = start; i < end; i++) {
            this.sum += array[i];
        }
    }


    public long getSum(){
        return this.sum;
    }
    private int[] array;
    private int start, end;
    private long sum;
}
