package jeu;

import java.awt.Color;
import java.util.ArrayList;

/**
 * GESTION DES JOUEURS
 *
 */

public class Joueur {
	
	/*__ATTRIBUTS___________________________________________________*/

	private Color couleur;
	private int unit;
	private int renfortTControles;
	private int renfortTGagnes;
	
	public ArrayList<Territoire> territoireListJoueur = new ArrayList<>();
	
	/*__METHODES____________________________________________________*/
	
	//CONSTRUCTEUR
//	public Joueur(Color color, int unitDebut ,int renfortTControles,int renfortTGagnes, ArrayList<Territoire> territoireListJoueur) {
//		
//		this.couleur = color;
//		this.unit = unitDebut;
//	}
	
	public Joueur(Color blue, int unitDebut, int renfortTControles2, int renfortTGagnes2,
			ArrayList<Territoire> territoireListJoueur2) {
		// TODO Auto-generated constructor stub
	}

	public Joueur(Color couleur2, int unit2, String name) {
		// TODO Auto-generated constructor stub
	}

	//INIT JOUEUR
	public static ArrayList<Joueur> initJoueur (int nbrJoueur) {
		
		Color couleurList [] = {new Color(38, 146, 204), new Color(198, 41, 41), new Color(57, 154, 71), new Color(231, 112, 35), new Color(115, 88, 23,5), new Color(242, 227, 79)};
		ArrayList<Joueur> joueurList = new ArrayList<>();
		
		for (int i = 0; i < nbrJoueur; i++ ) {
			Color couleur = couleurList [i];
			
			int unit = 0;
			if(nbrJoueur == 2) { unit = 40; }
			if(nbrJoueur == 3) { unit = 35; }
			if(nbrJoueur == 4) { unit = 30; }
			if(nbrJoueur == 5) { unit = 25; }
			if(nbrJoueur == 6) { unit = 20; }
			
			String name = "";
			if (couleur == new Color(38, 146, 204)) { name = "Bleu"; }
			if (couleur == new Color(198, 41, 41)) { name = "Rouge"; }
			if (couleur == new Color(57, 154, 71)) { name = "Vert"; }
			if (couleur == new Color(231, 112, 35)) { name = "Orange"; }
			if (couleur == new Color(115, 88, 23,5)) { name = "Violet"; }
			if (couleur == new Color(242, 227, 79)) { name = "Jaune"; }
			
			Joueur player = new Joueur (couleur,unit, name);
			joueurList.add(player);
		}
		
		return joueurList;			
	}

	
	//GETTERS & SETTERS
	public Color getCouleur() {
		return couleur;
	}

	public void setCouleur(Color couleur) {
		this.couleur = couleur;
	}

	public ArrayList<Territoire> getTerritoireList() {
		return territoireListJoueur;
	}

	public void setTerritoireList(ArrayList<Territoire> territoireList) {
		this.territoireListJoueur = territoireList;
	}

	public int getUnit() {
		return unit;
	}

	public void setUnit(int unit) {
		this.unit = unit;
	}

	public int getRenfortTControles() {
		return renfortTControles;
	}

	public void setRenfortTControles(int renfortTControles) {
		this.renfortTControles = renfortTControles;
	}

	public int getRenfortTGagnes() {
		return renfortTGagnes;
	}

	public void setRenfortTGagnes(int renfortTGagnes) {
		this.renfortTGagnes = renfortTGagnes;
	}

	
	

	
}
