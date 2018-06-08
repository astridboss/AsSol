package jeu;

/**
 * DESCRIPTION SOLDAT (UNIT)
 */

public class Soldat extends Unit {

	public Soldat(int index) {
		
		this.idUnit = index;
		this.cout = 1;
		this.prioAttaque = 2; 
		this.prioDefense = 1;
		this.mouvement = 2;
		this.nom = "Soldat";
		this.mouventEffectif = 0;
		this.desMin = 1;
		this.desMax = 6;
	
	}
	
}

