package org.example;

public class Main {
    public static void main(String[] args) {
        int N_THREADS = 4;
        int array[] = new int[1200000];
        for (int i = 0; i < array.length; i++) {
            array[i] = i;
        }

        long sum = 0;
        int sizeworker = array.length/ N_THREADS;
        long inizio = System.currentTimeMillis();
        for (int i = 0; i < N_THREADS; i++){
            int start = i * sizeworker;
            int end = (i + 1) * sizeworker;
            if (i == N_THREADS - 1) {
                end = array.length;
            }
            Worker worker = new Worker(start, end, array);
            Thread thread = new Thread(worker);
            thread.run();
            sum += worker.getSum();
        }
        long fine = System.currentTimeMillis();

        System.out.println("sum = " + sum + " time: " + (fine - inizio));


    }
}