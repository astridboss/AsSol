package object;

import jeu.Arme;


/**
 * Initialisation composant unité Canon
 * @author Astrid
 *
 */
class Canon extends Arme {

	Canon(){
		super("Canon", 7, 4, 9, 3, 2, 1);
	}

	@Override
	public int getMouvementMax() {
		return 1;
	}
}

