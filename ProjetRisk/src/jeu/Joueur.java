package jeu;

import java.awt.Color;
import java.util.ArrayList;

public class Joueur {
	private Color couleur;
	private int renfortTControles;
	private int renfortTGagnes;
	public ArrayList<Territoire> territoireListJoueur;
	private int unit;
	
	public Joueur() {
		
	}

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
		this.territoireListJoueur = territoireListJoueur;
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
