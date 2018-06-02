package jeu;

import java.awt.Color;


/**
 * Initialisation composant unité Cavalier
 
 *
 */
public class Cavalier extends Unit {
	


	public Cavalier(Color couleur) {
		this.couleur= couleur;
		this.cout=3;
		this.desMin=2;
		this.desMax=7;
		this.prioAttaque=1;
		this.prioDefense=3;
		this.mouvement=3;
		
	}
	
}

