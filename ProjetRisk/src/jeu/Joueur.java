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
	
	public ArrayList<Territoire> territoireListJoueur;
	
	/*__METHODES____________________________________________________*/
	
	//CONSTRUCTEUR
	public Joueur(Color color, int unitDebut) {
		this.couleur = color;
		this.unit = unitDebut;
	}
	
	//INIT JOUEUR
	public static ArrayList<Joueur> initJoueur (int nbrJoueur) {
		
		Color couleurList [] = {Color.BLUE, Color.RED,Color.GREEN, Color.ORANGE, Color.MAGENTA, Color.YELLOW};
		ArrayList<Joueur> joueurList = new ArrayList<>();
		
		for (int i = 0; i < nbrJoueur; i++ ) {
			Color couleur = couleurList [i];
			
			int unit = 0;
			if(nbrJoueur == 2) { unit = 40; }
			if(nbrJoueur == 3) { unit = 35; }
			if(nbrJoueur == 4) { unit = 30; }
			if(nbrJoueur == 5) { unit = 25; }
			if(nbrJoueur == 6) { unit = 20; }
			
			Joueur player = new Joueur (couleur,unit);
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
