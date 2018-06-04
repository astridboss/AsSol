package jeu;

import java.awt.Color;
import java.util.ArrayList;

/**
 * GESTION DES JOUEURS
 *
 */


public class Joueur {
	
	/*__ATTRIBUTS___________________________________________________*/
	
	private String nomJoueur;
	private Color couleur;
	private int unit;
	private int renfortTControles;
	private int renfortTGagnes;
	
	public ArrayList<Territoire> territoireListJoueur = new ArrayList<>();
	
	
	/*__METHODES____________________________________________________*/
	

	/**_____CONSTRUCTEUR___________________*/
	
	public Joueur(Color color, int unitDebut, String nom) {
		this.nomJoueur = nom;
		this.couleur = color;
		this.unit = unitDebut;
	}
	
	
	/**____INITIALISATION_DES_JOUEURS_________________*/
	

	public static ArrayList<Joueur> initJoueur (int nbrJoueur) {
		
		//Color couleurList [] = {new Color(38, 146, 204), new Color(198, 41, 41), new Color(57, 154, 71), new Color(231, 112, 35), new Color(115, 88, 23,5), new Color(242, 227, 79)};
		Color couleurList [] = {Color.BLUE, Color.RED, Color.GREEN, Color.ORANGE, Color.MAGENTA, Color.YELLOW};
		
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
			if (couleur == Color.BLUE) { name = "Bleu"; }
			if (couleur == Color.RED) { name = "Rouge"; }
			if (couleur == Color.GREEN) { name = "Vert"; }
			if (couleur == Color.ORANGE) { name = "Orange"; }
			if (couleur == Color.MAGENTA) { name = "Violet"; }
			if (couleur == Color.YELLOW) { name = "Jaune"; }
			
			Joueur player = new Joueur (couleur,unit, name);
			joueurList.add(player);
		}
		
		return joueurList;			
	}

	
	/*__GETTERS_&_SETTERS____________________________________________________*/
	
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


	public String getNomJoueur() {
		return nomJoueur;
	}


	public void setNomJoueur(String nomJoueur) {
		this.nomJoueur = nomJoueur;
	}

	
	

	
}
