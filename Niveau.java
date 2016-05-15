//Auteur: Simon Quentin
//Cadre: Vaccance 
//Fichier: Niveau.java

import java.util.ArrayList;

public class Niveau{

	private ArrayList<Brique> listeBrique;
	private int sizeX,sizeY;

	public Niveau(int niveau){
		this.listeBrique = new ArrayList<Brique>();
		switch(niveau){
			case(1): this.carre(50,50,5,10,"vert");
					 this.sizeX=500;
					 this.sizeY=500;
					 break;	 
					 
			case(2): this.kura();
					 this.sizeX=600;
					 this.sizeY=500;
					 break;	 
					 
			case(3): this.didine();
					 this.sizeX=900;
					 this.sizeY=600;
					 break;	
					 
			case(4): this.iut();
					 this.sizeX=500;
					 this.sizeY=500;
			 		 break;	
			 		 
			case(5): this.tms();
					 this.sizeX=550;
					 this.sizeY=500;
	 		 		 break;	
	 		 		 
			case(6): this.coeur();
					 this.sizeX=560;
					 this.sizeY=500;
					 break;
					 
			case(7): this.dango("vert");
				 	 this.sizeX=540;
				 	 this.sizeY=500;
				 	 break;
				 	 
			case(8): this.dango("jaune");
					 this.sizeX=540;
					 this.sizeY=500;
					 break;
					 
			case(9): this.pandaRoux();
					 this.sizeX=500;
					 this.sizeY=550;
					 break;
					 
			case(10): this.pingouin();
					  this.sizeX=500;
					  this.sizeY=550;
					  break;
		}
	}
	
	private void brique(int xdebut, int ydebut, String couleur)
	{
		listeBrique.add(new Brique(xdebut,ydebut,40,20,couleur));
	}
	
	private void carre(int xDebut, int yDebut,int ligne,int colonne,String couleur)
	{
		for(int i=0;i<ligne;i++)
			for(int j=0;j<colonne;j++)
				listeBrique.add(new Brique((j*40)+xDebut,(i*20)+yDebut,40,20,couleur));
	}
	
	private void ligneH(int xDeb, int yDeb, int taille,String couleur)
	{
		for(int i=0;i<taille;i++)
			listeBrique.add(new Brique(xDeb+(i*40),yDeb,40,20,couleur));
	}
	
	private void ligneV(int xDeb, int yDeb, int taille,String couleur)
	{
		for(int i=0;i<taille;i++)
			listeBrique.add(new Brique(xDeb,yDeb+(i*20),40,20,couleur));
	}
	
	private void pingouin()
	{
		ligneH(180,50,4,"noir");
		ligneV(180,70,4,"noir");
		ligneV(300,70,4,"noir");
		carre(220,70,2,2,"blanc");
		carre(220,110,2,2,"orange");
		ligneV(140,130,6,"noir");
		ligneV(340,130,6,"noir");
		ligneV(100,150,4,"noir");
		ligneV(380,150,4,"noir");
		carre(180,150,5,4,"blanc");
		carre(140,250,2,2,"jaune");
		carre(300,250,2,2,"jaune");
		ligneH(220,250,2,"blanc");
		ligneH(220,270,2,"noir");
	}
	
	private void dango(String couleur)
	{
		ligneV(410,130,2,"rose");
		ligneV(90,130,2,"rose");
		ligneV(170,110,4,"noir");
		ligneV(330,110,4,"noir");
		ligneH(110,50,8,couleur);
		ligneH(90,70,9,couleur);
		ligneH(70,90,10,couleur);
		ligneH(50,110,3,couleur);
		ligneH(210,110,3,couleur);
		ligneH(370,110,3,couleur);
		ligneH(50,130,3,couleur);
		ligneH(210,130,3,couleur);
		ligneH(370,130,3,couleur);
		ligneH(50,150,3,couleur);
		ligneH(210,150,3,couleur);
		ligneH(370,150,3,couleur);
		ligneH(50,170,3,couleur);
		ligneH(210,170,3,couleur);
		ligneH(370,170,3,couleur);
		ligneH(110,230,8,couleur);
		ligneH(90,210,9,couleur);
		ligneH(70,190,10,couleur);
	}
	
	private void coeur()
	{
		listeBrique.add(new Brique(260,270,40,20,"rouge"));
		ligneH(240,250,2,"rouge");
		ligneH(220,230,3,"rouge");
		ligneH(200,210,4,"rouge");
		ligneH(180,190,5,"rouge");
		ligneH(160,170,6,"rouge");
		ligneH(140,150,7,"rouge");
		ligneH(120,130,8,"rouge");
		ligneH(120,110,8,"rouge");
		ligneH(120,90,8,"rouge");
		ligneH(140,70,3,"rouge");
		ligneH(300,70,3,"rouge");
		ligneH(160,50,2,"rouge");
		ligneH(320,50,2,"rouge");
	}
	
	private void tms()
	{
		//T
		listeBrique.add(new Brique(50,50,40,20));
		listeBrique.add(new Brique(90,50,40,20));
		listeBrique.add(new Brique(90,70,40,20));
		listeBrique.add(new Brique(90,90,40,20));
		listeBrique.add(new Brique(90,110,40,20));
		listeBrique.add(new Brique(90,130,40,20));
		listeBrique.add(new Brique(90,150,40,20));
		listeBrique.add(new Brique(130,50,40,20));
		
		//M
		listeBrique.add(new Brique(180,50,40,20));
		listeBrique.add(new Brique(180,70,40,20));
		listeBrique.add(new Brique(180,90,40,20));
		listeBrique.add(new Brique(180,110,40,20));
		listeBrique.add(new Brique(180,130,40,20));
		listeBrique.add(new Brique(180,150,40,20));
		listeBrique.add(new Brique(220,70,40,20));
		listeBrique.add(new Brique(240,90,40,20));
		listeBrique.add(new Brique(260,70,40,20));
		listeBrique.add(new Brique(300,50,40,20));
		listeBrique.add(new Brique(300,70,40,20));
		listeBrique.add(new Brique(300,90,40,20));
		listeBrique.add(new Brique(300,110,40,20));
		listeBrique.add(new Brique(300,130,40,20));
		listeBrique.add(new Brique(300,150,40,20));
		
		//S
		listeBrique.add(new Brique(350,70,40,20));
		listeBrique.add(new Brique(350,50,40,20));
		listeBrique.add(new Brique(350,90,40,20));
		listeBrique.add(new Brique(350,110,40,20));
		listeBrique.add(new Brique(350,150,40,20));
		listeBrique.add(new Brique(390,150,40,20));
		listeBrique.add(new Brique(390,50,40,20));
		listeBrique.add(new Brique(390,110,40,20));
		listeBrique.add(new Brique(430,50,40,20));
		listeBrique.add(new Brique(430,70,40,20));
		listeBrique.add(new Brique(430,130,40,20));
		listeBrique.add(new Brique(430,150,40,20));
		listeBrique.add(new Brique(430,110,40,20));
		
	}
	
	private void iut()
	{
		//I
		listeBrique.add(new Brique(50,50,40,20));
		listeBrique.add(new Brique(50,150,40,20));
		listeBrique.add(new Brique(90,50,40,20));
		listeBrique.add(new Brique(90,70,40,20));
		listeBrique.add(new Brique(90,90,40,20));
		listeBrique.add(new Brique(90,110,40,20));
		listeBrique.add(new Brique(90,130,40,20));
		listeBrique.add(new Brique(90,150,40,20));
		listeBrique.add(new Brique(130,50,40,20));
		listeBrique.add(new Brique(130,150,40,20));
		
		//U
		listeBrique.add(new Brique(180,50,40,20));
		listeBrique.add(new Brique(180,70,40,20));
		listeBrique.add(new Brique(180,90,40,20));
		listeBrique.add(new Brique(180,110,40,20));
		listeBrique.add(new Brique(180,130,40,20));
		listeBrique.add(new Brique(180,150,40,20));
		listeBrique.add(new Brique(220,150,40,20));
		listeBrique.add(new Brique(260,150,40,20));
		listeBrique.add(new Brique(260,130,40,20));
		listeBrique.add(new Brique(260,110,40,20));
		listeBrique.add(new Brique(260,90,40,20));
		listeBrique.add(new Brique(260,70,40,20));
		listeBrique.add(new Brique(260,50,40,20));
		
		//T
		listeBrique.add(new Brique(310,50,40,20));
		ligneV(350,50,6,"vert");
		listeBrique.add(new Brique(390,50,40,20));
	}
	
	private void didine()
	{
		//D
		listeBrique.add(new Brique(50,50,40,20));
		listeBrique.add(new Brique(50,70,40,20));
		listeBrique.add(new Brique(50,90,40,20));
		listeBrique.add(new Brique(50,110,40,20));
		listeBrique.add(new Brique(50,130,40,20));
		listeBrique.add(new Brique(50,150,40,20));
		listeBrique.add(new Brique(90,50,40,20));
		listeBrique.add(new Brique(90,70,40,20));
		listeBrique.add(new Brique(90,130,40,20));
		listeBrique.add(new Brique(90,150,40,20));
		listeBrique.add(new Brique(130,70,40,20));
		listeBrique.add(new Brique(130,90,40,20));
		listeBrique.add(new Brique(130,110,40,20));
		listeBrique.add(new Brique(130,130,40,20));
		
		//I
		listeBrique.add(new Brique(180,50,40,20));
		listeBrique.add(new Brique(180,150,40,20));
		listeBrique.add(new Brique(220,50,40,20));
		listeBrique.add(new Brique(220,70,40,20));
		listeBrique.add(new Brique(220,90,40,20));
		listeBrique.add(new Brique(220,110,40,20));
		listeBrique.add(new Brique(220,130,40,20));
		listeBrique.add(new Brique(220,150,40,20));
		listeBrique.add(new Brique(260,150,40,20));
		listeBrique.add(new Brique(260,50,40,20));
		
		//D
		listeBrique.add(new Brique(310,50,40,20));
		listeBrique.add(new Brique(310,70,40,20));
		listeBrique.add(new Brique(310,90,40,20));
		listeBrique.add(new Brique(310,110,40,20));
		listeBrique.add(new Brique(310,130,40,20));
		listeBrique.add(new Brique(310,150,40,20));
		listeBrique.add(new Brique(350,50,40,20));
		listeBrique.add(new Brique(350,70,40,20));
		listeBrique.add(new Brique(350,130,40,20));
		listeBrique.add(new Brique(350,150,40,20));
		listeBrique.add(new Brique(390,70,40,20));
		listeBrique.add(new Brique(390,90,40,20));
		listeBrique.add(new Brique(390,110,40,20));
		listeBrique.add(new Brique(390,130,40,20));
		
		//I
		listeBrique.add(new Brique(440,50,40,20));
		listeBrique.add(new Brique(440,150,40,20));
		listeBrique.add(new Brique(480,50,40,20));
		listeBrique.add(new Brique(480,70,40,20));
		listeBrique.add(new Brique(480,90,40,20));
		listeBrique.add(new Brique(480,110,40,20));
		listeBrique.add(new Brique(480,130,40,20));
		listeBrique.add(new Brique(480,150,40,20));
		listeBrique.add(new Brique(520,150,40,20));
		listeBrique.add(new Brique(520,50,40,20));
		
		//N
		listeBrique.add(new Brique(570,50,40,20));
		listeBrique.add(new Brique(570,70,40,20));
		listeBrique.add(new Brique(570,90,40,20));
		listeBrique.add(new Brique(570,110,40,20));
		listeBrique.add(new Brique(570,130,40,20));
		listeBrique.add(new Brique(570,150,40,20));
		listeBrique.add(new Brique(610,70,40,20));
		listeBrique.add(new Brique(610,90,40,20));
		listeBrique.add(new Brique(650,110,40,20));
		listeBrique.add(new Brique(650,130,40,20));
		listeBrique.add(new Brique(690,50,40,20));
		listeBrique.add(new Brique(690,70,40,20));
		listeBrique.add(new Brique(690,90,40,20));
		listeBrique.add(new Brique(690,110,40,20));
		listeBrique.add(new Brique(690,130,40,20));
		listeBrique.add(new Brique(690,150,40,20));
		
		//E
		listeBrique.add(new Brique(740,50,40,20));
		listeBrique.add(new Brique(740,70,40,20));
		listeBrique.add(new Brique(740,90,40,20));
		listeBrique.add(new Brique(740,110,40,20));
		listeBrique.add(new Brique(740,130,40,20));
		listeBrique.add(new Brique(740,150,40,20));
		listeBrique.add(new Brique(780,50,40,20));
		listeBrique.add(new Brique(820,50,40,20));
		listeBrique.add(new Brique(780,150,40,20));
		listeBrique.add(new Brique(820,150,40,20));
		listeBrique.add(new Brique(780,90,40,20));
	}
	
	
	private void kura()
	{
		//K
		listeBrique.add(new Brique(50,50,40,20));
		listeBrique.add(new Brique(50,70,40,20));
		listeBrique.add(new Brique(50,90,40,20));
		listeBrique.add(new Brique(50,110,40,20));
		listeBrique.add(new Brique(50,130,40,20));
		listeBrique.add(new Brique(50,150,40,20));
		listeBrique.add(new Brique(90,110,40,20));
		listeBrique.add(new Brique(90,90,40,20));
		listeBrique.add(new Brique(130,130,40,20));
		listeBrique.add(new Brique(130,150,40,20));
		listeBrique.add(new Brique(130,50,40,20));
		listeBrique.add(new Brique(130,70,40,20));
		
		//U
		listeBrique.add(new Brique(180,50,40,20));
		listeBrique.add(new Brique(180,70,40,20));
		listeBrique.add(new Brique(180,90,40,20));
		listeBrique.add(new Brique(180,110,40,20));
		listeBrique.add(new Brique(180,130,40,20));
		listeBrique.add(new Brique(180,150,40,20));
		listeBrique.add(new Brique(220,150,40,20));
		listeBrique.add(new Brique(260,150,40,20));
		listeBrique.add(new Brique(260,130,40,20));
		listeBrique.add(new Brique(260,110,40,20));
		listeBrique.add(new Brique(260,90,40,20));
		listeBrique.add(new Brique(260,70,40,20));
		listeBrique.add(new Brique(260,50,40,20));
		
		//R
		listeBrique.add(new Brique(310,50,40,20));
		listeBrique.add(new Brique(310,70,40,20));
		listeBrique.add(new Brique(310,90,40,20));
		listeBrique.add(new Brique(310,110,40,20));
		listeBrique.add(new Brique(310,130,40,20));
		listeBrique.add(new Brique(310,150,40,20));
		listeBrique.add(new Brique(350,50,40,20));
		listeBrique.add(new Brique(390,50,40,20));
		listeBrique.add(new Brique(390,70,40,20));
		listeBrique.add(new Brique(350,90,40,20));
		listeBrique.add(new Brique(390,110,40,20));
		listeBrique.add(new Brique(390,130,40,20));
		listeBrique.add(new Brique(390,150,40,20));
		
		//A
		listeBrique.add(new Brique(480,50,40,20));
		listeBrique.add(new Brique(480,110,40,20));
		listeBrique.add(new Brique(440,70,40,20));
		listeBrique.add(new Brique(440,90,40,20));
		listeBrique.add(new Brique(440,110,40,20));
		listeBrique.add(new Brique(440,130,40,20));
		listeBrique.add(new Brique(440,150,40,20));
		listeBrique.add(new Brique(520,150,40,20));
		listeBrique.add(new Brique(520,130,40,20));
		listeBrique.add(new Brique(520,110,40,20));
		listeBrique.add(new Brique(520,90,40,20));
		listeBrique.add(new Brique(520,70,40,20));
	}
	
	private void pandaRoux()
	{
		ligneV(70,50,4,"blanc");
		listeBrique.add(new Brique(110,70,40,20,"blanc"));
		listeBrique.add(new Brique(110,90,40,20,"gris"));
		listeBrique.add(new Brique(110,110,40,20,"gris"));
		ligneV(150,90,2,"blanc");
		ligneV(390,50,4,"blanc");
		listeBrique.add(new Brique(350,70,40,20,"blanc"));
		ligneV(310,90,2,"blanc");
		ligneV(350,90,2,"gris");
		ligneH(110,150,3,"blanc");
		ligneH(270,150,3,"blanc");
		listeBrique.add(new Brique(150,170,40,20,"noir"));
		listeBrique.add(new Brique(310,170,40,20,"noir"));
		listeBrique.add(new Brique(150,190,40,20,"blanc"));
		listeBrique.add(new Brique(310,190,40,20,"blanc"));
		ligneV(70,190,2,"blanc");
		ligneV(110,210,2,"blanc");
		ligneV(390,190,2,"blanc");
		ligneV(350,210,2,"blanc");
		brique(230,250,"noir");
		carre(190,210,4,3,"blanc");
		carre(70,130,7,9,"orange");
		ligneH(110,270,7,"orange");
		ligneH(150,290,5,"orange");
	}
	
	public ArrayList<Brique> getListeBrique() {
		return listeBrique;
	}

	public int getSizeX() {
		return sizeX;
	}

	public int getSizeY() {
		return sizeY;
	}
}
