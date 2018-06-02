package jeu;

import java.awt.Color;


/**
 * Initialisation composant unité Soldat
 
 *
 */
public class Soldat extends Unit {
	


	public Soldat(Color couleur) {
		this.couleur= couleur;
		this.cout=1;
		this.desMin=1;
		this.desMax=6;
		this.prioAttaque=2;
		this.prioDefense=1;
		this.mouvement=2;
		
	}
	
}

