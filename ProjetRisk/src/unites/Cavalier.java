package unites;

import jeu.Arme;

/**
 * Armée de type cavalier. Doit être créée par UnitFactory.
 * @see UnitFactory
 */

class Cavalier extends Arme {

	Cavalier(){
		super("Cavalier", 3, 2, 7, 1, 3, 3);
	}

	@Override
	public int getMouvementMax(){
		return 3;
	}
}
