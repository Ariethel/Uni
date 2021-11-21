import java.util.GregorianCalendar;

public class TestProdotto {

	public static void main(String[] args) {
		GregorianCalendar dataAttuale = new GregorianCalendar();
		Alimentare insalata = new Alimentare(50, 1, 100, true, "insalata", "zio peppe", dataAttuale, 1);
		
		insalata.mettiInOfferta(0.5, dataAttuale);
		
		System.out.println(insalata.getDescrizione() + " di " + insalata.getMarca() + " in offerta a " + insalata.getPrezzo());
		insalata.controllaOfferta();
		System.out.println(insalata.getDescrizione() + " di " + insalata.getMarca() + " non in offerta a " + insalata.getPrezzo());
		
	}

}
