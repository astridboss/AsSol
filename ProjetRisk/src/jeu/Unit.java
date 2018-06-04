package jeu;

/**
 * CREATION D'UNE UNITE (SOLDAT, CAVALIER, CANON)
 *
 */

public class Unit {

	/*__ATTRIBUTS___________________________________________________*/
	
	public int cout;
	public int prioAttaque;
	public int prioDefense;
	public int mouvement;
	public int score;
	public int mouventEffectif;
	public String nom;

	
	
	/*__METHODES____________________________________________________*/
	
	
	public Unit() {

	}
	
	public Unit(int mouventEffectif, int cout, int prioAttaque, int prioDefense, int mouvement, int score, String nom) {
		super();
		
		this.cout = cout;
		this.prioAttaque = prioAttaque;
		this.prioDefense = prioDefense;
		this.mouvement = mouvement;
		this.score = score;
		this.mouventEffectif = mouventEffectif;
		this.nom = nom;
	}

	
	/*__GETTERS_&_SETTERS____________________________________________________*/

	public int getCout() {
		return cout;
	}

	public void setCout(int cout) {
		this.cout = cout;
	}

	public int getPrioAttaque() {
		return prioAttaque;
	}

	public void setPrioAttaque(int prioAttaque) {
		this.prioAttaque = prioAttaque;
	}

	public int getPrioDefense() {
		return prioDefense;
	}

	public void setPrioDefense(int prioDefense) {
		this.prioDefense = prioDefense;
	}

	public int getMouvement() {
		return mouvement;
	}

	public void setMouvement(int mouvement) {
		this.mouvement = mouvement;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}
	
	public int getMouventEffectif() {
		return mouventEffectif;
	}
	
	public void setMouventEffectif(int mouventEffectif) {
		this.mouventEffectif = mouventEffectif;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}
}