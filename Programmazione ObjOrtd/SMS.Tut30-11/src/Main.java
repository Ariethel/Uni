import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.GregorianCalendar;


public class Main {

	public static void main(String[] args) throws IOException, ClassNotFoundException {
		AgendaMultimediale am = null;
		File fp = new File("agenda.bin");
		GregorianCalendar data = new GregorianCalendar();
		
		if (fp.exists()) {
			ObjectInputStream is = new ObjectInputStream(new FileInputStream(fp));
			am = (AgendaMultimediale) is.readObject();
			System.out.println("-- By Date --");
			ArrayList<Sms> byDate = am.getListByDate();
			for (Sms sms : byDate) {
				System.out.println(sms.toString());
			}
			/*
			 * System.out.println("-- By Sender --"); ArrayList<Sms> bySender =
			 * am.getListBySender(); for (Sms sms : bySender) {
			 * System.out.println(sms.toString()); }
			 */
			is.close();
		}else {
			am = new AgendaMultimediale();
			Sms sm1 = new Sms("B-Giovanni","123abc","Ciao",data.getTime());
			am.addSms(sm1);
			Sms sm2 = new Sms("A-Peppiniello","123def","Mondo",data.getTime());
			am.addSms(sm2);
			ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream(fp));
			os.writeObject(am);
			os.close();
		}
	}

}
