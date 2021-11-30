import java.io.Serializable;
import java.util.ArrayList;
import java.util.GregorianCalendar;

public class AgendaMultimediale implements Serializable{
	public AgendaMultimediale(){}
	
	
	public void addSms(Sms msg) {
		coll.add(msg);
	}
	
	public Sms returnMinData(ArrayList<Sms> coll) {
		Sms min = new Sms();
		for (Sms sms : coll) {
			if (sms.getData().before(min.getData()))
				min = sms;
		}
		
		return min;
	}
	
	public Sms returnMinSender(ArrayList<Sms> coll) {
		Sms min = new Sms();
		for (Sms sms : coll) {
			if (min.getMittente() == null || sms.getMittente().compareTo(min.getMittente()) < 0)
				min = sms;
		}
		return min;
	}
	
	public ArrayList<Sms> getListByDate() {
		ArrayList<Sms> curr = new ArrayList<Sms>();
		curr = this.coll;
		ArrayList<Sms> ordered = new ArrayList<Sms>();
		while(!curr.isEmpty()) {
			Sms min = returnMinData(curr);
			ordered.add(min);
			curr.remove(min);
		}
		
		return ordered;
	}
	
	public ArrayList<Sms> getListBySender() {
		ArrayList<Sms> curr = new ArrayList<Sms>();
		curr = this.coll;
		ArrayList<Sms> ordered = new ArrayList<Sms>();
		while(!curr.isEmpty()) {
			Sms min = returnMinSender(curr);
			ordered.add(min);
			curr.remove(min);
		}
		
		return ordered;
	}
	
	ArrayList<Sms> coll = new ArrayList<Sms>();
}
