import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.GregorianCalendar;


public class Main {

	public static void main(String[] args) throws IOException, ClassNotFoundException {
		AgendaMultimediale am = null;
		File fp = new File("agenda.bin");
		GregorianCalendar data = new GregorianCalendar();
		
		if (fp.exists()) {
			ObjectInputStream is = new ObjectInputStream(new FileInputStream(fp));
			am = (AgendaMultimediale) is.readObject();
			is.close();
		}else {
			am = new AgendaMultimediale();
			Sms sm1 = new Sms("Giovanni","123abc","Ciao",data.getTime());
			am.addSms(sm1);
			Sms sm2 = new Sms("Peppiniello","123def","Mondo",data.getTime());
			am.addSms(sm2);
			ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream(fp));
			os.writeObject(am);
			os.close();
		}
	}

}
