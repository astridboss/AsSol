package jeu;

/**
 * DESCRIPTION CANON (UNIT)
 */

public class Canon extends Unit {
	
	public Canon(int index) {
		
		this.idUnit = index;
		this.cout = 7;
		this.prioAttaque = 3;
		this.prioDefense = 2;
		this.mouvement = 1;
		this.nom = "Canon";
		this.mouventEffectif = 0;
		this.desMin = 4;
		this.desMax = 9;
		
	}
	
}


