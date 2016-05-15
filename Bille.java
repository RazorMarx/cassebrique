//Auteur: Simon Quentin
//Cadre: Vaccance 
//Fichier: Bille.java

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JComponent;

public class Bille extends JComponent{

	private static final long serialVersionUID = 1L;
	private int posX,posY;
	private int largeurBille,hauteurBille;
	private Image bille;
	
	public Bille(int posX, int posY)
	{
		super();
		this.posX = posX;
		this.posY = posY;
		this.largeurBille = 20;
		this.hauteurBille = 20;
		this.setPreferredSize(new Dimension(largeurBille,hauteurBille));
		try {
			this.bille= ImageIO.read(getClass().getResource("img/bille.png"));
		} 
		catch (IOException e) {
			e.printStackTrace();
		}
	}

	public int getPosY() {
		return posY;
	}

	public void setPosY(int posY) {
		this.posY = posY;
	}

	public int getPosX() {
		return posX;
	}

	public void setPosX(int posX) {
		this.posX = posX;
	}

	public int getLargeurBille() {
		return largeurBille;
	}

	public void setLargeurBille(int largeurBille) {
		this.largeurBille = largeurBille;
	}

	public int getHauteurBille() {
		return hauteurBille;
	}

	public void setHauteurBille(int hauteurBille) {
		this.hauteurBille = hauteurBille;
	}
	
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		g.drawImage(bille, posX, posY, this);
	}
}