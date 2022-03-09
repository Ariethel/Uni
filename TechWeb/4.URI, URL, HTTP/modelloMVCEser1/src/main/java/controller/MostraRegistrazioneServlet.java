package controller;

import model.UtenteBean;

import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.annotation.*;
import jakarta.servlet.http.*;


@WebServlet("/mostra-registrazione-servlet")
public class MostraRegistrazioneServlet extends HttpServlet {
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // lettura del valore inserito dall'utente nel campo di input cognomeUtenteForm (ed ora presente nella richiesta come parametro)
        String cognome = request.getParameter("cognomeUtenteForm");

        // INSERIRE QUI LE RIMAMENTI LETTURE DEI PARAMETRI NELLA REQUEST

        // creazione dell'istanza del bean UtenteBean e suo caricamento con i dati  del form presi dalla richiesta
        UtenteBean utenteBean = new UtenteBean(cognome); // AGGIORNARE IL BEAN CON I RIMANENTI DATI

        //memorizzazione del bean nella richiesta. Al bean viene dato nome "utenteBeanxJSP"
        // questo nome verrà utilizzato nella jsp Per richiamare la proprietà cognomeUtenteBean presente nel bean
        request.setAttribute("utenteBeanxJSP", utenteBean);

        // preparazione al passaggio del controllo alla jsp  mostraDatiUtente.jsp
        String address = "/WEB-INF/results/mostraDatiUtente.jsp" ;
        RequestDispatcher dispatcher =
                request.getRequestDispatcher(address);

        // passaggio di controllo alla jsp passandogli anche la request (contenente in particolare il bean)  da leggere
        // e la response da inviare al server. (La scrittura nella response è opera di Tomcat ed il programmatore
        // non deve scrivere nulla nella jsp per realizzarla.)
        dispatcher.forward(request, response);

        //NOTA: dopo la linea 27 la request contiene sia il bean con nome utenteBeanxJSP  che i parametri del form
        // ma la jsp accederà solo al bean (come è prassi nel modello MVC)
    }
}
