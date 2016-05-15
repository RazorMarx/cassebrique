//Auteur: Simon Quentin
//Cadre: Vaccance 
//Fichier: InterfaceCasseBrique.java

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class InterfaceCasseBrique extends JFrame implements ActionListener{
	private static final long serialVersionUID = 1L;
	private JButton[] niveau;
	private JButton bNew, bExit,bExit1;
	public JPanel pHome, pLevel,pLevelpere,pHomepere,placeHolder;
	private FrameBrique fb;

	public InterfaceCasseBrique()
	{
		super();
		this.setRootPaneCheckingEnabled(true);
		this.setTitle("Casse Brique");
		this.setSize(500,500);
		this.setVisible(true);
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		this.bNew = new JButton("Nouvelle Partie");
		this.bNew.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				listeLevel();
				remove(pHomepere);
			}});
		this.bExit= new JButton("Quitter");
		this.bExit.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}});
		this.bExit1= new JButton("Quitter");
		this.bExit1.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}});
		this.niveau=new JButton[10];
		this.pHome = new JPanel();
		this.pHome.setLayout(new GridLayout(2,1,5,5));
		this.pHome.add(bNew);
		this.pHome.add(bExit);
		this.pHomepere = new JPanel();
		this.pHomepere.add(pHome);
		this.add(pHomepere);
		this.placeHolder = new JPanel();
		this.placeHolder.setPreferredSize(new Dimension(500,150));
		this.add(placeHolder,BorderLayout.NORTH);
	}
	
	public void listeLevel()
	{
		this.placeHolder.setPreferredSize(new Dimension(500,50));
		this.pLevel = new JPanel();
		this.pLevel.setLayout(new GridLayout(0,1,5,5));
		for(int i=0; i<10;i++){
			niveau[i]=new JButton("Niveau "+(i+1));
			niveau[i].addActionListener(this);
			niveau[i].setPreferredSize(new Dimension(180,30));
			pLevel.add(niveau[i]);
		}
		this.pLevel.add(bExit1);
		this.pLevelpere = new JPanel();
		this.pLevelpere.add(pLevel);
		this.add(pLevelpere);
		this.validate();
	}

	public void actionPerformed(ActionEvent e) {
		String choix = e.getActionCommand();
		this.remove(pLevelpere);
		this.placeHolder.setPreferredSize(new Dimension(500,0));
		
		if(choix.equals("Niveau 1"))
			this.fb = new FrameBrique(1,4);
		else if(choix.equals("Niveau 2"))
			this.fb = new FrameBrique(2,4);
		else if(choix.equals("Niveau 3"))
			this.fb = new FrameBrique(3,4);
		else if(choix.equals("Niveau 4"))
			this.fb = new FrameBrique(4,4);
		else if(choix.equals("Niveau 5"))
			this.fb = new FrameBrique(5,4);
		else if(choix.equals("Niveau 6"))
			this.fb = new FrameBrique(6,4);
		else if(choix.equals("Niveau 7"))
			this.fb = new FrameBrique(7,4);
		else if(choix.equals("Niveau 8"))
			this.fb = new FrameBrique(8,4);
		else if(choix.equals("Niveau 9"))
			this.fb = new FrameBrique(9,4);
		else if(choix.equals("Niveau 10"))
			this.fb = new FrameBrique(10,4);
	
		
		this.add(fb,BorderLayout.CENTER);
		
		MonThread calculColision=new MonThread(fb.plateau,this);
	    calculColision.start();
	  
		FrameBrique.fin=false;
		FrameBrique.VIE=3;
		FrameBrique.start=false;
		FrameBrique.pause=true;
		FrameBrique.backX=false;
		FrameBrique.backY=true;
		
		this.fb.plateau.requestFocus();
		this.pack();
		this.revalidate();
		this.repaint();
	}
	
	
	
	public void changerPanel()
	{
		this.placeHolder.setPreferredSize(new Dimension(500,150));
		this.remove(fb);
		this.add(pHomepere);
		this.revalidate();
		this.repaint();
	}
}

