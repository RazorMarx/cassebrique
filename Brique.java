//Auteur: Simon Quentin
//Cadre: Vaccance 
//Fichier: Brique.java

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JComponent;

public class Brique extends JComponent{

	private static final long serialVersionUID = 1L;
	private int vie;
	private int x,y,w,h;
	private Image bloc;

	public Brique(int x,int y,int w,int h)
	{
		this.setPreferredSize(new Dimension(w,h));
		this.x = x;
		this.y = y;
		this.w = w;
		this.h = h;
		this.vie = 1;
		try {
			bloc = ImageIO.read(getClass().getResource("img/vert.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public Brique(int x,int y,int w,int h,String couleur)
	{
		this(x,y,w,h);
		try {
			bloc = ImageIO.read(getClass().getResource("img/"+couleur+".png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public Brique(int x,int y,int w,int h,int vie, String couleur)
	{
		this(x,y,w,h);
		this.vie=vie;
		try {
			bloc = ImageIO.read(getClass().getResource("img/"+couleur+".png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		g.drawImage(bloc, x, y,this);
	}
	
	public void setVie(int e)
	{
		this.vie = e;
	}
	
	public int getVie()
	{
		return vie;
	}
	
	public int briqueX()
	{
		return x;
	}
	
	public int briqueY()
	{
		return y;
	}
	
	public int briqueW()
	{
		return w;
	}
	
	public int briqueH()
	{
		return h;
	}
	
	public void setBriqueX(int x)
	{
		this.x = x;
	}
	
	public void mort()
	{
		this.vie--;
		if(this.vie==0){
			this.x=2500;
			this.y=0;
			this.w=0;
			this.h=0;
		}
	}
	
	
	public boolean collisionD(Bille bille)
	{
	   if( (bille.getPosX() == this.x + this.w)       
		&& (bille.getPosY()+ 10 <= this.y + this.h)
		&& (bille.getPosY() + bille.getHauteurBille() -10>= this.y)
		|| (bille.getPosX()+5 == this.x + this.w)       
		&& (bille.getPosY()+5 <= this.y + this.h)
		&& (bille.getPosY()+5 >= this.y)
		|| (bille.getPosX()+5 == this.x + this.w)       
		&& (bille.getPosY()+15 <= this.y + this.h)
		&& (bille.getPosY()+15 >= this.y))
	   {
		   this.mort();
	          return true;
	   }
	   else
		   return false;
	} 
	
	
	public boolean collisionG(Bille bille)
	{
	   if( (bille.getPosX() + bille.getLargeurBille() == this.x)       
		&& (bille.getPosY()+10 <= this.y + this.h)
		&& (bille.getPosY()+10>= this.y)
		|| (bille.getPosX() + 15 == this.x)       
		&& (bille.getPosY()+5 <= this.y + this.h)
		&& (bille.getPosY()+5>= this.y)
		|| (bille.getPosX() + 15 == this.x)       
		&& (bille.getPosY()+15 <= this.y + this.h)
		&& (bille.getPosY()+15>= this.y))
	   {
			this.mort();
			return true;
	   }
	   return false;
	} 
	
	public boolean collisionB(Bille bille)
	{
	   if((bille.getPosY() == this.y + this.h)
		&& (bille.getPosX() +10 >= this.x) 
		&& (bille.getPosX() +10 <= this.w+this.x)
		|| (bille.getPosY()+5 == this.y + this.h)
		&& (bille.getPosX() +5 >= this.x) 
		&& (bille.getPosX() +5 <= this.w+this.x)
		|| (bille.getPosY()+5 == this.y + this.h)
		&& (bille.getPosX() +15 >= this.x) 
		&& (bille.getPosX() +15 <= this.w+this.x))
	   {
		   this.mort();
		   return true;
	   }
	   return false;
	}
	   
	public boolean collisionH(Bille bille)
	{
	   if( (bille.getPosY() +bille.getHauteurBille() == this.y)
		&& (bille.getPosX() +10 >= this.x) 
		&& (bille.getPosX() +10 <= this.w+this.x)
		|| (bille.getPosY() +15 == this.y)
		&& (bille.getPosX() +5 >= this.x) 
		&& (bille.getPosX() +5 <= this.w+this.x)
		|| (bille.getPosY() +15 == this.y)
		&& (bille.getPosX() +15 >= this.x) 
		&& (bille.getPosX() +15 <= this.w+this.x))
	   {
		   this.mort();
		   return true;
	   }
	  return false;
	}
}