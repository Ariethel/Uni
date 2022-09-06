import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.BorderLayout;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.GridLayout;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.*;


public class Gui {
	static final String DBURL = "jdbc:mysql://localhost/progetto?serverTimezone=Europe/Rome";
	static final String USER = "root"; // admin su portatile -> root su fisso
	static final String PASS = "root";
	static final String QueryVista = "SELECT * FROM utenti"; //Visualizzazione elenco tuple
	static final String QueryUpdate1 = "UPDATE utenti\n" // Update data scadenza abbonamento mensile
										+ "SET ScadenzaAbbonamento = adddate(DataIscrizione, INTERVAL 30 DAY)\n"
										+ "WHERE Tipo = \"Abbonato\" AND TipoAbbonamento = \"Mensile\";";
	static final String QueryUpdate2 = "UPDATE utenti\n" // Update data scadenza Abbonamento annuale
										+ "SET ScadenzaAbbonamento = adddate(DataIscrizione, INTERVAL 365 DAY)\n"
										+ "WHERE Tipo = \"Abbonato\" AND TipoAbbonamento = \"Annuale\" ";
	static final String QueryUpdate3 = "UPDATE utenti\n" // Update data scadenza periodo di prova
										+ "SET ScadenzaProva = adddate(DataIscrizione, INTERVAL 5 DAY)\n"
										+ "WHERE Tipo = \"Free\" ";
	private JFrame frame;
	private JTextField txtCf;
	private JTextField txtNome;
	private JTextField txtCognome;
	private JTextField txtCitta;
	private JTextField txtCv;
	private JTextField txtVia;
	private JTextField txtTipo;
	private JTextField txtDataiscr;
	private JTextField txtTipoabbonamento;
	private JButton btnRefresh;
	private JTextArea textArea;
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Gui window = new Gui();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Gui() {
		initialize();
	}

	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		frame.getContentPane().add(panel, BorderLayout.NORTH);
		panel.setLayout(new GridLayout(0, 4, 0, 0));
		
		txtCf = new JTextField();
		txtCf.setText("CF(16)");
		panel.add(txtCf);
		txtCf.setColumns(10);
		
		txtNome = new JTextField();
		txtNome.setText("Nome(20)");
		panel.add(txtNome);
		txtNome.setColumns(10);
		
		txtCognome = new JTextField();
		txtCognome.setText("Cognome(20)");
		panel.add(txtCognome);
		txtCognome.setColumns(10);
		
		txtCitta = new JTextField();
		txtCitta.setText("Citta(20)");
		panel.add(txtCitta);
		txtCitta.setColumns(10);
		
		txtCv = new JTextField();
		txtCv.setText("CV");
		panel.add(txtCv);
		txtCv.setColumns(10);
		
		txtVia = new JTextField();
		txtVia.setText("Via(20)");
		panel.add(txtVia);
		txtVia.setColumns(10);
		
		txtTipo = new JTextField();
		txtTipo.setText("Tipo(20)");
		panel.add(txtTipo);
		txtTipo.setColumns(10);
		
		txtDataiscr = new JTextField();
		txtDataiscr.setText("DataIscr");
		panel.add(txtDataiscr);
		txtDataiscr.setColumns(10);
		
		txtTipoabbonamento = new JTextField();
		txtTipoabbonamento.setText("TipoAbbonamento");
		panel.add(txtTipoabbonamento);
		txtTipoabbonamento.setColumns(10);
		
		JButton btnInserisci = new JButton("Inserisci");
		btnInserisci.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String cf = txtCf.getText();
				String Nome = txtNome.getText();
				String Cognome = txtCognome.getText();
				String Citta = txtCitta.getText();
				int cv = Integer.parseInt(txtCv.getText());
				String via = txtVia.getText();
				String tipo = txtTipo.getText();
				String dataIsc = txtDataiscr.getText();
				String tipoAbb = txtTipoabbonamento.getText();
				JOptionPane.showInputDialog("INSERT INTO utenti(CF, Nome, Cognome, Citta, CV, Via, Tipo, DataIscrizione, TipoAbbonamento) VALUES (" + "\"" + cf +"\",\""+ Nome +"\",\""+ Cognome +"\",\""+ Citta +"\",\""+ cv +"\",\""+ via +"\",\""+ tipo +"\",\""+ dataIsc +"\",\""+ tipoAbb + "\")", e);
				String QueryInserimento = "INSERT INTO utenti(CF, Nome, Cognome, Citta, CV, Via, Tipo, DataIscrizione, TipoAbbonamento) VALUES (" + "\"" + cf +"\",\""+ Nome +"\",\""+ Cognome +"\",\""+ Citta +"\",\""+ cv +"\",\""+ via +"\",\""+ tipo +"\",\""+ dataIsc +"\",\""+ tipoAbb + "\")"; // Query Inserimento
				textArea.setText("");
				try (Connection conn = DriverManager.getConnection(DBURL, USER, PASS);
						Statement stmt = conn.createStatement();){
					stmt.executeUpdate(QueryInserimento);
				}catch(SQLException t) {
					t.printStackTrace();
				}
				
			}
		});
		panel.add(btnInserisci);
		
		JButton btnUpdatedate = new JButton("UpdateDate");
		btnUpdatedate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textArea.setText("");
				try (Connection conn = DriverManager.getConnection(DBURL, USER, PASS);
						Statement stmt = conn.createStatement();){
					stmt.executeUpdate(QueryUpdate1);
					stmt.executeUpdate(QueryUpdate2);
					stmt.executeUpdate(QueryUpdate3);
				}catch(SQLException t) {
					t.printStackTrace();
				}
			}
		});
		panel.add(btnUpdatedate);
		
		JButton btnCancella = new JButton("Cancella");
		btnCancella.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String cf = txtCf.getText();
				String Nome = txtNome.getText();
				String Cognome = txtCognome.getText();
				String Citta = txtCitta.getText();
				int cv = Integer.parseInt(txtCv.getText());
				String via = txtVia.getText();
				String tipo = txtTipo.getText();
				String dataIsc = txtDataiscr.getText();
				String tipoAbb = txtTipoabbonamento.getText();
				String QueryDelete = "DELETE FROM utenti WHERE CF = "+ "\"" + cf + "\"" +" AND Nome = " + "\"" + Nome + "\"" +" AND Cognome = " + "\"" + Cognome + "\"" + " AND Citta = " + "\"" + Citta  + "\"" +" AND"
						+ " CV = " + "\"" + cv + "\"" +" AND Via = " + "\"" +via + "\"" +" AND Tipo = " + "\"" +tipo + "\"" + " AND DataIscrizione = " + "\"" + dataIsc + "\"" + " AND"
						+ " TipoAbbonamento = " + "\"" + tipoAbb+ "\""; // Query delete
				JOptionPane.showInputDialog("DELETE FROM utenti WHERE CF = "+ "\"" + cf + "\"" +" AND Nome = " + "\"" + Nome + "\"" +" AND Cognome = " + "\"" + Cognome + "\"" + " AND Citta = " + "\"" + Citta  + "\"" +" AND"
						+ " CV = " + "\"" + cv + "\"" +" AND Via = " + "\"" +via + "\"" +" AND Tipo = " + "\"" +tipo + "\"" + " AND DataIscrizione = " + "\"" + dataIsc + "\"" + " AND"
						+ " TipoAbbonamento = " + "\"" + tipoAbb+ "\"", e);
				textArea.setText(""); 
				try (Connection conn = DriverManager.getConnection(DBURL, USER, PASS);
						Statement stmt = conn.createStatement();){
					stmt.executeUpdate(QueryDelete);
				}catch(SQLException t) {
					t.printStackTrace();
				}
			}
		});
		panel.add(btnCancella);
		
		btnRefresh = new JButton("Refresh");
		btnRefresh.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textArea.setText("");
				try (Connection conn = DriverManager.getConnection(DBURL, USER, PASS);
						Statement stmt = conn.createStatement();
						ResultSet rs = stmt.executeQuery(QueryVista);){
					while(rs.next())
						textArea.append(rs.getString("CF")+ " " + rs.getString("Nome")+ " " + rs.getString("Cognome")+ " " +
										  rs.getString("Citta")+ " " + rs.getInt("CV")+ " " + rs.getString("Via")+ " " +
										  rs.getString("Tipo")+ " " + rs.getString("DataIscrizione")+ " " + rs.getString("TipoAbbonamento") + " " + rs.getString("ScadenzaAbbonamento")+ " " +rs.getString("ScadenzaProva")+"\n");
				}catch(SQLException t) {
					t.printStackTrace();
				}
			}
		});
		frame.getContentPane().add(btnRefresh, BorderLayout.EAST);
		
		textArea = new JTextArea();
		frame.getContentPane().add(textArea, BorderLayout.CENTER);
	}

}
