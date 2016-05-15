//Auteur: Simon Quentin
//Cadre: Vaccance 
//Fichier: MonCasseBrique.java

import java.awt.EventQueue;

public class MonCasseBrique {
	
	public static void main(String[] args) {
		
		 EventQueue.invokeLater(new Runnable() { 
			public void run() {
				new InterfaceCasseBrique();
			}
		 });
		
	}
}