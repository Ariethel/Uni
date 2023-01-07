package dpcmstdclient;

import dpcm.*;
import java.util.List;
import java.util.Scanner;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

public class DPCMStdClient {

    private static DecretoEJBRemote ejb;

    public static void main(String[] args) throws NamingException {
        Context ctx = new InitialContext();
        
        ejb = (DecretoEJBRemote) ctx.lookup("java:global/DPCM/DecretoEJB!dpcm.DecretoEJBRemote");
        
        List<Decreto> decreti = ejb.trovaTuttiDecreti();
        for(Decreto d: decreti)
            System.out.println(d);
        
        System.out.print("Inserisci la categoria di interesse: ");
        Scanner s = new Scanner(System.in);
        String categoria = s.next();
        decreti = ejb.trovaPerCategoria(categoria);
        System.out.println("Decreti della categoria " + categoria);
        for(Decreto d: decreti)
            System.out.println(d);
        
        System.out.print("Inserisci un valore numerico: ");
        Integer x = s.nextInt();
        decreti = ejb.trovaPerNumeroPresentazioniStampa(x);
        System.out.println("Decreti con più di " + x + " presentazioni stampa:");
        for(Decreto d: decreti)
            System.out.println(d);
        
    }
    
}
