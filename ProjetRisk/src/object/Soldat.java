package object;

import jeu.Arme;


/**
 * Initialisation composant unité Soldat
 * @author Astrid
 *
 */
class Soldat extends Arme {

	Soldat(){
		super("Soldat", 1, 1, 6, 2, 1, 2);
	}

	@Override
	public int getMouvementMax() {
		return 1;
	}
}

