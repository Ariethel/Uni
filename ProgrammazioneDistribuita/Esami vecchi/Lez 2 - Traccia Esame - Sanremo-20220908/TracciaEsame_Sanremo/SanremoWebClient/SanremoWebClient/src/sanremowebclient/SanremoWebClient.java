package sanremowebclient;

import canzonesanremo.Canzone;

public class SanremoWebClient {

    public static void main(String[] args) {
        
        Integer id = 2;
        Integer voti = 501;
        
        Canzone c = trovaPerId(id);
        c.setVotiRicevuti(voti);
        aggiornaCanzone(c);
    }


    private static Canzone trovaPerId(int arg0) {
        canzonesanremo.CanzoneEJBService service = new canzonesanremo.CanzoneEJBService();
        canzonesanremo.CanzoneEJB port = service.getCanzoneEJBPort();
        return port.trovaPerId(arg0);
    }

    private static void aggiornaCanzone(canzonesanremo.Canzone arg0) {
        canzonesanremo.CanzoneEJBService service = new canzonesanremo.CanzoneEJBService();
        canzonesanremo.CanzoneEJB port = service.getCanzoneEJBPort();
        port.aggiornaCanzone(arg0);
    }
   
    
}
