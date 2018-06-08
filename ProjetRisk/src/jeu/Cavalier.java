package jeu;

/**
 * DESCRIPTION CAVALIER (UNIT)
 *
 */

public class Cavalier extends Unit {

	public Cavalier(int index) {
		
		this.idUnit = index;
		this.cout = 3;
		this.prioAttaque = 3; //BESOIN TRI TRIMAP CLE MAX
		this.prioDefense = 3;
		this.mouvement = 3;
		this.nom = "Cavalier";
		this.mouventEffectif = 0;
		this.desMin = 2;
		this.desMax = 7;
		
	}
	
}


