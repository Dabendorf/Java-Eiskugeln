package eissorten;

import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.text.NumberFormatter;

/**
 * Diese Klasse ist die Hauptklasse des Eissorten-Projektes, welche sowohl die Grafik als auch interne Berechnungen umfasst.
 * 
 * @author Lukas Schramm
 * @version 1.0
 *
 */
public class Eissorten {
	
	private JFrame frame1 = new JFrame("Eissorten");
	private NumberFormat format1 = NumberFormat.getInstance(); 
	private NumberFormat format2 = NumberFormat.getInstance();
	private NumberFormat format3 = NumberFormat.getInstance();
	private NumberFormat format4 = NumberFormat.getInstance();
	private NumberFormat format5 = NumberFormat.getInstance();
	private NumberFormat format6 = NumberFormat.getInstance();
	private NumberFormat format7 = NumberFormat.getInstance();
	private NumberFormat format8 = NumberFormat.getInstance();
    private NumberFormatter formatter1 = new NumberFormatter(format1);
    private NumberFormatter formatter2 = new NumberFormatter(format2); 
    private NumberFormatter formatter3 = new NumberFormatter(format3); 
    private NumberFormatter formatter4 = new NumberFormatter(format4); 
    private NumberFormatter formatter5 = new NumberFormatter(format5); 
    private NumberFormatter formatter6 = new NumberFormatter(format6); 
    private NumberFormatter formatter7 = new NumberFormatter(format7); 
    private NumberFormatter formatter8 = new NumberFormatter(format8); 
	private JButton buttonSpendieren = new JButton("Essen!");
	private JLabel ausgabelabel = new JLabel("Eiskugeln:");
	private JLabel restgeldlabel = new JLabel("Restgeld:");
	private JLabel eislabel1 = new JLabel("Himbeer");
	private JLabel eislabel2 = new JLabel("Stracciatella");
	private JLabel eislabel3 = new JLabel("Vanille");
	private JLabel eislabel4 = new JLabel("Cocos");
	private JLabel eislabel5 = new JLabel("Franzakeneis");
	private JLabel eislabel6 = new JLabel("Dabendorfer Eis");
	private JLabel anzKugeln = new JLabel("");
	private JLabel anzRestgeld = new JLabel("");
	private JLabel sonderangebot1 = new JLabel();
	private JLabel sonderangebot2 = new JLabel();
	private JLabel sonderangebot3 = new JLabel();
	private JLabel sonderangebot4 = new JLabel();
	private JLabel sonderangebot5 = new JLabel();
	private JLabel sonderangebot6 = new JLabel();
	private JLabel sonderangebot7 = new JLabel();
	private JTextField wahleis = new JTextField();
	private JFormattedTextField geldvorhanden = new JFormattedTextField(formatter1);
	private JFormattedTextField nfpreis1 = new JFormattedTextField(formatter2);
	private JFormattedTextField nfpreis2 = new JFormattedTextField(formatter3);
	private JFormattedTextField nfpreis3 = new JFormattedTextField(formatter4);
	private JFormattedTextField nfpreis4 = new JFormattedTextField(formatter5);
	private JFormattedTextField nfpreis5 = new JFormattedTextField(formatter6);
	private JFormattedTextField nfpreis6 = new JFormattedTextField(formatter7);
	private JFormattedTextField nfpreis7 = new JFormattedTextField(formatter8);
	private JList<String> eisliste = new JList<String>();
	private DefaultListModel<String> eislisteModel = new DefaultListModel<String>();
	private JScrollPane eislisteScrollPane = new JScrollPane(eisliste);
	    
	public Eissorten() {
		frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame1.setPreferredSize(new Dimension(550,300));
		frame1.setMinimumSize(new Dimension(550,300));
		frame1.setMaximumSize(new Dimension(825,460));
		frame1.setResizable(true);
		Container cp = frame1.getContentPane();
		cp.setLayout(new GridBagLayout());
	    
		JPanel links = new JPanel();
		links.setLayout(new GridBagLayout());
		ArrayList<Object> namen = new ArrayList<Object>();
		namen.add(geldvorhanden);namen.add(eislabel1);namen.add(eislabel2);namen.add(eislabel3);namen.add(eislabel4);namen.add(eislabel5);
		namen.add(eislabel6);namen.add(wahleis);namen.add(ausgabelabel);namen.add(restgeldlabel);
		ArrayList<Object> preise = new ArrayList<Object>();
		preise.add(buttonSpendieren);preise.add(nfpreis1);preise.add(nfpreis2);preise.add(nfpreis3);preise.add(nfpreis4);
		preise.add(nfpreis5);preise.add(nfpreis6);preise.add(nfpreis7);preise.add(anzKugeln);preise.add(anzRestgeld);
		ArrayList<JLabel> sonderangebote = new ArrayList<JLabel>();
		JLabel platzhalter1 = new JLabel();
		JLabel platzhalter2 = new JLabel();
		JLabel platzhalter3 = new JLabel();
		sonderangebote.add(platzhalter1);sonderangebote.add(sonderangebot1);sonderangebote.add(sonderangebot2);sonderangebote.add(sonderangebot3);
		sonderangebote.add(sonderangebot4);sonderangebote.add(sonderangebot5);sonderangebote.add(sonderangebot6);sonderangebote.add(sonderangebot7);
		sonderangebote.add(platzhalter2);sonderangebote.add(platzhalter3);
		
		for(int i=0;i<10;i++) {
			links.add((Component) namen.get(i),new GridBagFelder(0,i,1,1,0.33,0.1));
			links.add((Component) preise.get(i),new GridBagFelder(1,i,1,1,0.33,0.1));
			links.add(sonderangebote.get(i),new GridBagFelder(2,i,1,1,0.33,0.1));
			((Component)namen.get(i)).setPreferredSize(new Dimension(0,0));
			((Component)preise.get(i)).setPreferredSize(new Dimension(0,0));
			sonderangebote.get(i).setPreferredSize(new Dimension(0,0));
			sonderangebote.get(i).setHorizontalAlignment(SwingConstants.CENTER);
			sonderangebote.get(i).setFont(new Font("Harlow Solid Italic", Font.BOLD + Font.ITALIC, 12));
			sonderangebote.get(i).setOpaque(true);
		}
		
	    geldvorhanden.setText("20.00");
	    geldvorhanden.setToolTipText("Verfügbares Geld");
	    geldvorhanden.setHorizontalAlignment(SwingConstants.RIGHT);
	    buttonSpendieren.setMargin(new Insets(2, 2, 2, 2));
	    buttonSpendieren.addActionListener(new ActionListener() { 
	    	public void actionPerformed(ActionEvent evt) { 
	    		spendieren();
	    	}
	    });
	    buttonSpendieren.setBackground(new Color(0xFFC800));
	    wahleis.setText("Spezialeis");
	    buttonSpendieren.setHorizontalAlignment(SwingConstants.RIGHT);
	    nfpreis1.setHorizontalAlignment(SwingConstants.RIGHT);
	    nfpreis2.setHorizontalAlignment(SwingConstants.RIGHT);
	    nfpreis3.setHorizontalAlignment(SwingConstants.RIGHT);
	    nfpreis4.setHorizontalAlignment(SwingConstants.RIGHT);
	    nfpreis5.setHorizontalAlignment(SwingConstants.RIGHT);
	    nfpreis6.setHorizontalAlignment(SwingConstants.RIGHT);
	    nfpreis7.setHorizontalAlignment(SwingConstants.RIGHT);
	    anzKugeln.setHorizontalAlignment(SwingConstants.RIGHT);
	    anzRestgeld.setHorizontalAlignment(SwingConstants.RIGHT);
	    buttonSpendieren.setHorizontalAlignment(SwingConstants.RIGHT);
	    eislabel1.setHorizontalAlignment(SwingConstants.RIGHT);
	    eislabel2.setHorizontalAlignment(SwingConstants.RIGHT);
	    eislabel3.setHorizontalAlignment(SwingConstants.RIGHT);
	    eislabel4.setHorizontalAlignment(SwingConstants.RIGHT);
	    eislabel5.setHorizontalAlignment(SwingConstants.RIGHT);
	    eislabel6.setHorizontalAlignment(SwingConstants.RIGHT);
	    wahleis.setHorizontalAlignment(SwingConstants.RIGHT);
	    wahleis.setToolTipText("Such es Dir aus!");
	    ausgabelabel.setHorizontalAlignment(SwingConstants.RIGHT);
	    restgeldlabel.setHorizontalAlignment(SwingConstants.RIGHT);
	    nfpreis1.setText("0.90");
	    nfpreis2.setText("1.20");
	    nfpreis3.setText("1.00");
	    nfpreis4.setText("1.10");
	    nfpreis5.setText("2.00");
	    nfpreis6.setText("3.00");
	    nfpreis7.setText("0.75");
	    sonderangebot5.setText("Gefährlich!");
	    sonderangebot5.setBackground(new Color(0x0099CC));
	    sonderangebot6.setText("Exklusiv!");
	    sonderangebot6.setBackground(new Color(0xFFAFAF));
	    
	    frame1.add(links,new GridBagFelder(0,0,1,1,0.7,1));
	    frame1.add(eislisteScrollPane,new GridBagFelder(1,0,1,1,0.3,1));
	    eisliste.setModel(eislisteModel);
	    links.setPreferredSize(new Dimension(0,0));
	    eislisteScrollPane.setPreferredSize(new Dimension(0,0));
	    format1.setGroupingUsed(false);
	    format2.setGroupingUsed(false);
	    format3.setGroupingUsed(false);
	    format4.setGroupingUsed(false);
	    format5.setGroupingUsed(false);
	    format6.setGroupingUsed(false);
	    format7.setGroupingUsed(false);
	    format8.setGroupingUsed(false);
	    formatter1.setAllowsInvalid(false);
	    formatter2.setAllowsInvalid(false);
	    formatter3.setAllowsInvalid(false);
	    formatter4.setAllowsInvalid(false);
	    formatter5.setAllowsInvalid(false);
	    formatter6.setAllowsInvalid(false);
	    formatter7.setAllowsInvalid(false);
	    formatter8.setAllowsInvalid(false);
	    frame1.pack();
		frame1.setLocationRelativeTo(null);
		frame1.setVisible(true);
	}
	
	/**
	 * Diese Methode rechnet aus, wie viel Eis zur Verfuegung steht und gibt das Rueckgeld aus.
	 */
	private void spendieren() {
		try {
			eislisteModel.removeAllElements();
			Random wuerfel = new Random();
			double taschengeld = Double.parseDouble(geldvorhanden.getText());
		    double sorte1 = Double.parseDouble(nfpreis1.getText());
		    double sorte2 = Double.parseDouble(nfpreis2.getText());
		    double sorte3 = Double.parseDouble(nfpreis3.getText());
		    double sorte4 = Double.parseDouble(nfpreis4.getText());
		    double sorte5 = Double.parseDouble(nfpreis5.getText());
		    double sorte6 = Double.parseDouble(nfpreis6.getText());
		    double sorte7 = Double.parseDouble(nfpreis7.getText());

		    int anzahl = 0;
		    double[] preise = new double[7];
		    preise[0] = sorte1;preise[1] = sorte2;preise[2] = sorte3;preise[3] = sorte4;preise[4] = sorte5;preise[5] = sorte6;preise[6] = sorte7;
		    
		    double min = Integer.MAX_VALUE;
		    for(double p:preise) {
		    	if(p<min) {
		    		min = p;
		    	}
		    }

		    while(taschengeld>=min) {
		    	int eissorte = wuerfel.nextInt(7);
		    	if(preise[eissorte]<=taschengeld) {
		    		anzahl++;
		    		taschengeld -= preise[eissorte];
			    	switch(eissorte) {
			    	case 0:
				        eislisteModel.addElement((anzahl)+" "+eislabel1.getText());
				        break;
				    case 1: 
				        eislisteModel.addElement((anzahl)+" "+eislabel2.getText());
				        break;
				    case 2: 
				        eislisteModel.addElement((anzahl)+" "+eislabel3.getText());
				        break;
				    case 3: 
				        eislisteModel.addElement((anzahl)+" "+eislabel4.getText());
				        break;
				    case 4: 
				        eislisteModel.addElement((anzahl)+" "+eislabel5.getText());
				        break;
				    case 5: 
				        eislisteModel.addElement((anzahl)+" "+eislabel6.getText());
				        break;
				    case 6: 
				        eislisteModel.addElement((anzahl)+" "+wahleis.getText());
				        break;
				    default:break;
			    	}
		    	}
		    }
		    taschengeld = Math.round(taschengeld*100.0)/100.0;
		    anzKugeln.setText(String.valueOf(anzahl)+" ");
		    anzRestgeld.setText(String.valueOf(taschengeld)+" ");
		} catch(Exception e) {
			JOptionPane.showMessageDialog(null, "Du hast falsche Werte eingetragen."+System.getProperty("line.separator")+"Wenn Du dies nicht korrigierst"+System.getProperty("line.separator")+"bekommst Du kein Eis!", "Falscheingabe", JOptionPane.WARNING_MESSAGE);
		}
	}
	
	public static void main(String[] args) {
		new Eissorten();
	}
}