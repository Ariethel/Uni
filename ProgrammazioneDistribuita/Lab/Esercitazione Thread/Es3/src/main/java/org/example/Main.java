package org.example;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        int N_THREADS = 8;
        int array[] = new int[1200000];
        for (int i = 0; i < array.length; i++) {
            array[i] = i;
        }

        Worker[] workers = new Worker[N_THREADS];
        Thread[] threads = new Thread[N_THREADS];
        long sum = 0;
        int sizeworker = array.length/ N_THREADS;
        long inizio = System.currentTimeMillis();
        for (int i = 0; i < N_THREADS; i++){
            //Calcolo inizio e fine per ogni thread
            int start = i * sizeworker;
            int end = (i + 1) * sizeworker;
            if (i == N_THREADS - 1) {
                end = array.length;
            }

            workers[i] = new Worker(start, end, array, sum);
            threads[i] = new Thread(workers[i]);
            threads[i].start();
        }

        for (int i = 0; i < N_THREADS; i++){
            threads[i].join();
            sum += workers[i].getSum();
        }
        long fine = System.currentTimeMillis();

        System.out.println("sum = " + sum + " time: " + (fine - inizio));


    }
}