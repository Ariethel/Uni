package org.example;

import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Random rand = new Random();
        int N_THREADS = 8;
        long pointsNumber = 1000000000;
        long sizeWorker = pointsNumber/N_THREADS;
        int insideCircle = 0;
        int outsideCircle = 0;

        for (int i = 0; i < N_THREADS; i++){
            Worker w = new Worker(sizeWorker);
            Thread t = new Thread(w);
            t.run();
            insideCircle += w.getInsideCircle();
            outsideCircle += w.getOutsideCircle();
        }

        double pi = 4.0 * (insideCircle / (double)pointsNumber);
        System.out.println("PI: " + pi);
    }
}