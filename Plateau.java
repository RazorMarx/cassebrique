//Auteur: Simon Quentin
//Cadre: Vaccance 
//Fichier: Plateau.java

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;
import java.util.ArrayList;
import javax.imageio.ImageIO;
import javax.swing.JPanel;


public class Plateau extends JPanel implements KeyListener{
	
	private static final long serialVersionUID = 1L;
	protected Bille bille;
	protected ArrayList<Brique> brique;
	protected Barre barre;
	protected int sizeX;
	protected int sizeY;
	private Image fond,coeur,instruction;
	private boolean victory = false;
	private Font font;
	private boolean[] keys;
	public Musique musique;
	private boolean mOn;
	
	
	public Plateau(ArrayList<Brique> lesBrique, int sizeX, int sizeY)
	{
		super();
		this.setLayout(null);
		this.sizeX=sizeX;
		this.sizeY=sizeY;
		this.mOn=true;
		this.musique=new Musique();
		this.musique.musiqueOn();
		this.setPreferredSize(new Dimension(sizeX,sizeY));
		this.font=new Font(" TimesRoman ",Font.BOLD,30);
		this.bille = new Bille(sizeX/2,sizeY-120);;
		this.barre = new Barre((sizeX/2)-40,sizeY-100,80,15);
		this.brique = lesBrique;
		this.keys = new boolean[50];
		for(int i=0;i<2;i++)
			keys[i]=false;
		try {
			this.fond = ImageIO.read(getClass().getResource("img/fond.png"));
			this.coeur = ImageIO.read(getClass().getResource("img/coeur.png"));
			this.instruction=ImageIO.read(getClass().getResource("img/instruction.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		this.add(bille);
		for(int i=0;i<this.brique.size();i++)
			this.add(brique.get(i));
		this.add(barre);
		
		this.bille.setBounds(0,0,sizeX,sizeY);
		for(int i=0;i<this.brique.size();i++)
			this.brique.get(i).setBounds(0,0,sizeX,sizeY);
		this.barre.setBounds(0,0,sizeX,sizeY);
		
		this.setVisible(true);
		this.setEnabled(true);
		this.setFocusable(true);
		this.requestFocusInWindow(true);
		this.addKeyListener(this);
	}
	
	public void vitesse()
	{
		int temp=0;
		for(int i=0;i<this.brique.size();i++)
		      if (this.brique.get(i).briqueX()==2500)
		    	 temp++;
		
		if(temp>2*(this.brique.size())/3)
			FrameBrique.dificulte=2;
		else if(temp>this.brique.size()/3)
			FrameBrique.dificulte=3;
		
		
	}
	
	public boolean victoire()
	{
		int temp=0;
		for(int i=0;i<this.brique.size();i++)
		      if (this.brique.get(i).briqueX()==2500)
		    	 temp++;
		if(temp==this.brique.size()){
			this.victory=true;
			return true;
		}	
		else
			return false;
	}
	
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		g.setColor(Color.white);
		g.setFont(font);
		g.drawImage(fond, 0, 0, this.getWidth(), this.getHeight() , this);
		for(int i=0;i<FrameBrique.VIE;i++)
			g.drawImage(coeur,(i*30)+10,this.getHeight()-25,this);
		if(victory)
			g.drawString("VICTOIRE !",-70+getWidth()/2, getHeight()/2);
		if(FrameBrique.pause)
			g.drawImage(instruction,this.getWidth()-320,this.getHeight()-40,this);
	}
	
	public boolean mOn()
	{
		return this.mOn;
	}
	
	public void keyPressed(KeyEvent e) {
		if(e.getKeyCode()==37)
	    keys[0] = true;
		if(e.getKeyCode()==39)
		keys[1] = true;
	    
		if(e.getKeyCode()==KeyEvent.VK_Q){
			System.exit(0);
		}
		
		if(e.getKeyCode()==KeyEvent.VK_M){
			if(this.mOn==true){
				this.mOn=false;
				this.musique.stop();
			}
			else{
				this.mOn=true;
				this.musique.musiqueOn();
			}
		}
		
	    if(e.getKeyCode()==KeyEvent.VK_SPACE){
	    	if(!FrameBrique.start)
	    		FrameBrique.start= true;
			if(FrameBrique.pause)
				FrameBrique.pause = false;
			else if(!FrameBrique.pause)
				FrameBrique.pause = true;
		}	    
	    
	    else if(e.getKeyCode()==KeyEvent.VK_RIGHT){
			if(barre.getXBarre()<this.getWidth()-80){
				if(!FrameBrique.start){
					barre.setXBarre(barre.getXBarre()+15);
					bille.setPosX(bille.getPosX()+15);
				}
			}
		}
	    
		else if(e.getKeyCode()==KeyEvent.VK_LEFT){
			if(barre.getXBarre()>0){
				if(!FrameBrique.start){
					bille.setPosX(bille.getPosX()-15);
					barre.setXBarre(barre.getXBarre()-15);
				}
			}
		} 
	    this.repaint();
	}

	public void keyReleased(KeyEvent e) {
		if(e.getKeyCode()==37)
	     keys[0] = false;
		else if(e.getKeyCode()==39)
		 keys[1] = false;
	}

	public void keyTyped(KeyEvent e) {}

	public void update() {
	    if(keys[0]){
	    	if(barre.getXBarre()>0){
				barre.setXBarre(barre.getXBarre()-2);
				if(FrameBrique.pause)
					bille.setPosX(bille.getPosX()-2);
			}
	    }

	    if(keys[1]){
	    	if(barre.getXBarre()<this.getWidth()-80){
				barre.setXBarre(barre.getXBarre()+2);
				if(FrameBrique.pause)
					bille.setPosX(bille.getPosX()+2);
			}
	    }
	}
}	  