
public class TestQuiz {

	public static void main(String[] args) {
		DataSet dSet = new DataSet();
		Quiz q1 = new Quiz(6, "C");
		Quiz q2 = new Quiz(9, "A");
		
		dSet.add(q1);
		dSet.add(q2);
		System.out.println("Punteggio medio " + dSet.getAverage());
		Quiz quiz = (Quiz)dSet.getMinimum();
		System.out.println("Il punteggio minore e' " + quiz.getPunteggio() + "e la lettera corrispondente e' " + quiz.getVoto());
		quiz = (Quiz)dSet.getMaximum();
		System.out.println("Il punteggio maggiore e' " + quiz.getPunteggio() + "e la lettera corrispondente e' " + quiz.getVoto());
	}

}
