package jeu;

import java.awt.Color;
import java.util.ArrayList;

public class Joueur {
	private Color couleur;
	private int renfortTPossedés;
	private int renfortTGagnés;
	public ArrayList<Territoire> territoireList;
	
	public Joueur() {
		
	}

	public Color getCouleur() {
		return couleur;
	}

	public void setCouleur(Color couleur) {
		this.couleur = couleur;
	}

	public int getRenfortTPossedés() {
		return renfortTPossedés;
	}

	public void setRenfortTPossedés(int renfortTPossedés) {
		this.renfortTPossedés = renfortTPossedés;
	}

	public int getRenfortTGagnés() {
		return renfortTGagnés;
	}

	public void setRenfortTGagnés(int renfortTGagnés) {
		this.renfortTGagnés = renfortTGagnés;
	}

	
}
