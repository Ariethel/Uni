package org.example;

import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Random rand = new Random();
        int N_THREADS = 4;
        long pointsNumber = 10000000;
        long sizeWorker = pointsNumber/N_THREADS;
        int insideCircle = 0;
        int outsideCircle = 0;
        Worker[] w = new Worker[N_THREADS];
        Thread[] t = new Thread[N_THREADS];

        for (int i = 0; i < N_THREADS; i++){
            w[i] = new Worker(sizeWorker);
            t[i] = new Thread(w[i]);
            t[i].start();
        }

        for(int i = 0; i < N_THREADS;i++){
            try {
                t[i].join();
                insideCircle += w[i].getInsideCircle();
                outsideCircle += w[i].getOutsideCircle();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        double pi = 4.0 * (insideCircle / (double)pointsNumber);
        System.out.println("PI: " + pi);
    }
}