package org.example;

public class Main {
    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        int array[] = new int[120000000];
        for (int i = 0; i < 120000000; i++){
            array[i] = 42;
        }
        long end = System.currentTimeMillis();
        System.out.println("Tempo impiegato senza thread: " + (end-start));

        //Versione con 2 thread
        start = System.currentTimeMillis();
        int array2[] = new int[120000000];
        int worker = array2.length/2;
        for (int i = 0; i < 2; i++){
            MyThread t = new MyThread(worker * i, worker * (i+1) , array2);
            Thread thread = new Thread(t);
            thread.start();
        }
        end = System.currentTimeMillis();
        System.out.println("Tempo con 2 thread: " + (end-start));

        //Versione con 4 thread
        start = System.currentTimeMillis();
        int array3[] = new int[120000000];
        worker = array2.length/4;
        for (int i = 0; i < 4; i++){
            MyThread t = new MyThread(worker * i, worker * (i+1) , array2);
            Thread thread = new Thread(t);
            thread.start();
        }
        end = System.currentTimeMillis();
        System.out.println("Tempo con 2 thread: " + (end-start));

    }
}