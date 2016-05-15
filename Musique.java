//Auteur: Simon Quentin
//Cadre: Vaccance 
//Fichier: Musique.java

import java.applet.Applet;
import java.applet.AudioClip;
import java.net.URL;


public class Musique {
	private URL uMusique,uRebond,uVie,uGameOver,uVictoire;
	private AudioClip musique,rebond,vie,gameOver,victoire;
	
	public Musique(){
		chargement();
	}
	
	public void chargement(){
		try{
		uMusique = Musique.class.getResource("son/musique4.wav");
		musique = Applet.newAudioClip(uMusique);
		
		uRebond = Musique.class.getResource("son/boing.wav");
		rebond = Applet.newAudioClip(uRebond);
		
		uVie = Musique.class.getResource("son/vieperdu.wav");
		vie = Applet.newAudioClip(uVie);
		
		uVictoire = Musique.class.getResource("son/victoire.wav");
		victoire = Applet.newAudioClip(uVictoire);
		
		uGameOver = Musique.class.getResource("son/gameover.wav");
		gameOver = Applet.newAudioClip(uGameOver);
		}
		catch(Exception e1){
			e1.printStackTrace();
		}
	}
	
	
	public void musiqueOn()
	{
		musique.loop();
	}
	
	public void rebond()
	{
		rebond.play();
	}
	public void stop()
	{
		musique.stop();
	}
	
	public void viePerdu()
	{
		vie.play();
	}
	
	public void gameOver()
	{
		gameOver.play();
	}
	
	public void victoire()
	{
		victoire.play();
	}
	
}