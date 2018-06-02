package jeu;

import java.awt.Color;


/**
 * Initialisation composant unité Canon
 
 *
 */
public class Canon extends Unit {
	


	public Canon(Color couleur) {
		this.couleur= couleur;
		this.cout=7;
		this.desMin=4;
		this.desMax=9;
		this.prioAttaque=3;
		this.prioDefense=2;
		this.mouvement=1;
		
	}
	
}

