//Auteur: Simon Quentin
//Cadre: Vaccance 
//Fichier: MonThread.java

public class MonThread extends Thread{
	
	private Plateau plateau;
	private InterfaceCasseBrique f;
	public boolean mOn;
	
	
	public MonThread(Plateau plateau, InterfaceCasseBrique f)
	{
		this.plateau=plateau;
		this.f = f;
	}
	
	public void run(){
		while(!FrameBrique.fin){
			System.out.println();
			
			 
			 int x = this.plateau.bille.getPosX();
			 int y = this.plateau.bille.getPosY();
			
			for(int i=0;i<plateau.brique.size();i++){
			      if (this.plateau.brique.get(i).collisionD(plateau.bille)){
			    	  FrameBrique.backX= false;
			    	  if(this.plateau.mOn())
			    	  this.plateau.musique.rebond();
			      }
			      if (this.plateau.brique.get(i).collisionG(plateau.bille)){
			    	  FrameBrique.backX= true;
			    	  if(this.plateau.mOn())
			    	  this.plateau.musique.rebond();
		          }
			      if (this.plateau.brique.get(i).collisionH(plateau.bille)){
			    	  FrameBrique.backY= true;
			    	  if(this.plateau.mOn())
			    	  this.plateau.musique.rebond();
			      }
			      if (this.plateau.brique.get(i).collisionB(plateau.bille)){
			    	  FrameBrique.backY= false;
			    	  if(this.plateau.mOn())
			    	  this.plateau.musique.rebond();
		          }
		      }
			
			   if(FrameBrique.start)
				   if (!FrameBrique.pause) {
		  
		      this.plateau.update();
		      if (x < 1)
		    	  FrameBrique.backX = false;
		      if (x > this.plateau.getWidth() - 20)
		    	  FrameBrique.backX = true;
		      if (y < 1)
		    	  FrameBrique.backY = false;
		      if (y > this.plateau.getHeight() - 25){
		    	  if(FrameBrique.VIE>0){
		    		  FrameBrique.backY=true;
		    		  if(this.plateau.mOn())
		    		  this.plateau.musique.viePerdu();
		    		  FrameBrique.VIE--;
		    	  }
		    	  else{
		    		  this.plateau.musique.stop();
		    		  if(this.plateau.mOn())
		    		  this.plateau.musique.gameOver();
		    		  try{
		    		        Thread.sleep(1200);
		    		      } catch (InterruptedException e) {
		    		        e.printStackTrace();
		    		      }
		    		  f.changerPanel();
		    		  FrameBrique.fin = true;
		    		  
		    	  }
		        
		      }
		      if (plateau.barre.collision(plateau.bille)){
		    	  FrameBrique.backY = true;
		    	  if(this.plateau.mOn())
		    	  this.plateau.musique.rebond();
		      }
		      
		      this.plateau.vitesse();
		     
		      if(this.plateau.victoire())
		      {
		    	  this.plateau.musique.stop();
		    	  if(this.plateau.mOn())
		    	  this.plateau.musique.victoire();
		    	  x=this.plateau.barre.getXBarre()+10;
		    	  y=this.plateau.barre.getYBarre()-20;
		    	  this.plateau.repaint();
		    	  try{
	    		        Thread.sleep(1200);
	    		      } catch (InterruptedException e) {
	    		        e.printStackTrace();
	    		      }
		    	  f.changerPanel();
		    	  FrameBrique.fin=true;
		      }
		      
		      if (!FrameBrique.backX)
		        this.plateau.bille.setPosX(++x);
		      else
		    	this.plateau.bille.setPosX(--x);
		      if (!FrameBrique.backY)
		    	this.plateau.bille.setPosY(++y);
		      else
		    	this.plateau.bille.setPosY(--y);
		     
		      this.plateau.repaint();
		      
		     try{
		        Thread.sleep(FrameBrique.dificulte);
		      } 
		     catch (InterruptedException e) {
		        e.printStackTrace();
		      }
		    }
		
		}
	}

}
