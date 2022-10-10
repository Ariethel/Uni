package org.example;

public class Smiley extends Thread {
    synchronized public void run() {
        synchronized (Smiley.class){
            while(true) {
                try {
                    // INSERISCI IL TUO CODICE QUI
                    printDuePunti();
                    printTrattino();
                    printParentesi();
                } catch (InterruptedException e)
                { e.printStackTrace(); }
            }
        }

    }
    private void printParentesi() throws InterruptedException{
        System.out.println(")"); Thread.sleep(100);
    }
    private void printTrattino() throws InterruptedException{
        System.out.print("-"); Thread.sleep(100);
    }
    private void printDuePunti() throws InterruptedException{
        System.out.print(":"); Thread.sleep(100);
    }
    public static void main(String[] args) {
        new Smiley().start();
        new Smiley().start();
    }
}