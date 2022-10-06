package org.example;

public class MyThread implements Runnable{


    public MyThread(int start, int end, int[] array){
        this.start = start;
        this.end = end;
        this.array = array;
    }

    @Override
    public void run() {
        for (int i = start; i <= start; i++){
            array[i] = 42;
        }
    }


    private int start, end;
    private int[] array;
}
