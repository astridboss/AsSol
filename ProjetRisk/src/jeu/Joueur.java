package jeu;

import java.awt.Color;
import java.util.ArrayList;

public class Joueur {
	private Color couleur;
	private int renfortTPossed�s;
	private int renfortTGagn�s;
	public ArrayList<Territoire> territoireList;
	
	public Joueur() {
		
	}

	public Color getCouleur() {
		return couleur;
	}

	public void setCouleur(Color couleur) {
		this.couleur = couleur;
	}

	public int getRenfortTPossed�s() {
		return renfortTPossed�s;
	}

	public void setRenfortTPossed�s(int renfortTPossed�s) {
		this.renfortTPossed�s = renfortTPossed�s;
	}

	public int getRenfortTGagn�s() {
		return renfortTGagn�s;
	}

	public void setRenfortTGagn�s(int renfortTGagn�s) {
		this.renfortTGagn�s = renfortTGagn�s;
	}

	
}
