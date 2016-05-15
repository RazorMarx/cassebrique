//Auteur: Simon Quentin
//Cadre: Vaccance 
//Fichier: Barre.java

import java.awt.Graphics;
import java.awt.Image;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JComponent;

public class Barre extends JComponent{
	private static final long serialVersionUID = 1L;
	private Image barre;
	private int x,y,w,h;
	
	public Barre(int x,int y,int w,int h){
		this.x =x;
		this.y =y;
		this.w =w;
		this.h =h;
		try{
			this.barre= ImageIO.read(getClass().getResource("img/barre.png"));
		}
		catch(IOException e) {
			e.printStackTrace();
		}
	}
	public int getXBarre()
	{
		return this.x;
	}
	
	public int getYBarre()
	{
		return this.y;
	}
	
	public void setXBarre(int x)
	{
		this.x=x;
	}
	
	public void moveG()
	{
		this.x=this.x-15;
	}
	public void moveD()
	{
		this.x=this.x+15;
	}
	
	
	public boolean collision(Bille bille)
	{
	   if((bille.getPosX() >= this.x + this.w)
		|| (bille.getPosX() + bille.getLargeurBille() <= this.x)
		|| (bille.getPosY() >= this.y + this.h)
		|| (bille.getPosY() + bille.getHauteurBille() <= this.y))
	          return false; 
	   else
	          return true; 
	}
	
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		g.drawImage(barre,this.x,this.y,this);
	}
}