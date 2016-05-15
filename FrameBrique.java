//Auteur: Simon Quentin
//Cadre: Vaccance 
//Fichier: FrameBrique.java

import java.awt.BorderLayout;

import javax.swing.JPanel;

public class FrameBrique extends JPanel{
	
	private static final long serialVersionUID = 1L;
	Plateau plateau;
	private Niveau level;
	static boolean backY = true;
	static boolean backX = false;
	static boolean pause = true;
	static boolean start = false;
	static boolean fin = false;
	static int VIE = 3;
	static public int dificulte;
	
	public FrameBrique(int niveau,int difficulte)
	{
		super();
		this.setLayout(new BorderLayout());
		FrameBrique.dificulte = difficulte;
		this.level = new Niveau(niveau);
		this.plateau = new Plateau(level.getListeBrique(),level.getSizeX(),level.getSizeY());
		this.add(plateau,BorderLayout.CENTER);
	}
}