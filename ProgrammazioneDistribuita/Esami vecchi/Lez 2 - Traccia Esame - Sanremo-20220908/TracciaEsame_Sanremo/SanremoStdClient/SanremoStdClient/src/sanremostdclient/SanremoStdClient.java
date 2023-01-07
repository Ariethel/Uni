package sanremostdclient;

import canzoneSanremo.CanzoneEJBRemote;
import canzoneSanremo.Canzone;
import java.util.List;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

public class SanremoStdClient {
    
    private static CanzoneEJBRemote ejb;

    public static void main(String[] args) throws NamingException {
        Context ctx = new InitialContext();
        
        ejb = (CanzoneEJBRemote) ctx.lookup("java:global/SanremoBean/CanzoneEJB!canzoneSanremo.CanzoneEJBRemote");
        
        printAll();
        
        String category = "Pop";
        printByCategory(category);
        
        Integer votes = 500;
        printByVotes(votes);
        votes = 5;
        printByVotes(votes);
    }

    private static void printAll() {
        List<Canzone> list = ejb.trovaTutteCanzoni();
        System.out.println("Tutte le canzoni di Sanremo:");
        for(Canzone o : list){
            System.out.println(o);
        }
    }

    private static void printByCategory(String category) {
        List<Canzone> list = ejb.trovaPerCategoria(category);
        System.out.println("Tutte le canzoni " + category + " di Sanremo:");
        for(Canzone o : list){
            System.out.println(o);
        }
    }

    private static void printByVotes(Integer votes) {
        List<Canzone> list = ejb.trovaPerVoti(votes);
        System.out.println("Tutte le canzoni con più di " + votes + " voti:");
        if(list == null)
            System.out.println("La risposta è NULL");
        else{
            for(Canzone o : list){
                System.out.println(o);
            }
        }
        
    }
    
    
    
}
