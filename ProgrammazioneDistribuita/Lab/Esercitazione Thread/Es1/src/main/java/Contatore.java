public class Contatore {
    public void Contatore(){
        this.count = 0;
    }


    //Se inc non fosse synchronized i thread potrebbero accedere contemporaneamente al contatore, creando
    //un risultato sbagliato
    public synchronized void inc(){
        this.count += 1;
    }

    public int getCount(){
        return count;
    }

    public void reset(){
        count = 0;
    }
    private int count;
}
