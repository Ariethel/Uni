package org.example;

public class Worker implements Runnable{
    public Worker (long sizeWorker){
        this.sizeWorker = sizeWorker;
    }

    @Override
    public void run() {
        for (int i = 0; i < this.sizeWorker; i++){
            double x = Math.random();
            double y = Math.random();

            if((x*x) + (y*y) < 1)
                this.insideCircle++;
            else
                this.outsideCircle++;
        }
    }

    public int getInsideCircle(){
        return insideCircle;
    }

    public int getOutsideCircle(){
        return outsideCircle;
    }
    private long sizeWorker;
    private int insideCircle, outsideCircle;
}
