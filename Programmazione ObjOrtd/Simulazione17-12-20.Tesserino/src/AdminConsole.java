import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class AdminConsole {

	public static void main(String[] args) throws IOException {
		FileOutputStream fp = new FileOutputStream("giggino.bin");
		ObjectOutputStream os = new ObjectOutputStream(fp);
		
		
		TesserinoStudenti ts1 = new TesserinoStudenti(1, "a", "a", "1a1", "A", 2022, 10, false);
		TesserinoStudenti ts2 = new TesserinoStudenti(2, "b", "b", "2b2", "B", 2022, 10, true);
		TesserinoPersonale tp1 = new TesserinoPersonale(3, "d", "d", "docente", "informatica", 0);
		TesserinoPersonale tp2 = new TesserinoPersonale(4, "c", "c", "amministrativa", "matematica", 0);
			
		PagamentoPasti pp = new PagamentoPasti();
		pp.aggiungiTesserino(ts1);
		pp.aggiungiTesserino(ts2);
		pp.aggiungiTesserino(tp1);
		pp.aggiungiTesserino(tp2);
		
		os.writeObject(pp);
		
		fp.close();
		os.close();

	}

}
