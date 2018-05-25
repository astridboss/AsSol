package jeu;
/**
 * 
 * @author Astrid
 *Classe permettant d'itialialisé un format et des caracteristiques de l'armee
 */
public abstract class Arme {

	private String couleur;
	private int cout;
	private int desMin;
	private int desMax;
	private int prioAttaque;
	private int prioDefense;
	private int mouvement;
	private int score;

	

	public Arme(String couleur, int cout, int puissanceMin, int puissanceMax, int prioriteAtt, int prioriteDef, int mouvement) {
		this.couleur = couleur;
		this.cout = cout;
		this.desMin = puissanceMin;
		this.desMax = puissanceMax;
		this.prioAttaque = prioriteAtt;
		this.prioDefense = prioriteDef;
		this.mouvement = mouvement;
		this.score = 0;
	}



	public String getNom() {
		return couleur;
	}

	public int getCout() {
		return cout;
	}

	public int getPuissanceMin() {
		return desMin;
	}

	public int getPuissanceMax() {
		return desMax;
	}

	public int getPrioriteAtt() {
		return prioAttaque;
	}

	public int getPrioriteDef() {
		return prioDefense;
	}

	public int getMouvement() {
		return mouvement;
	}

	public void setNom(String nom) {
		this.couleur = nom;
	}

	public void setCout(int cout) {
		this.cout = cout;
	}

	public void setPuissanceMin(int puissanceMin) {
		this.desMin = puissanceMin;
	}

	public void setPuissanceMax(int puissanceMax) {
		this.desMax = puissanceMax;
	}

	public void setPrioriteAtt(int prioriteAtt) {
		this.prioAttaque = prioriteAtt;
	}

	public void setPrioriteDef(int prioriteDef) {
		this.prioDefense = prioriteDef;
	}

	public void setMouvement(int mouvement) {
		this.mouvement = mouvement;
	}

	public int getMouvementMax(){
		return -1;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public void initializeScore() {
		this.score = 0;
	}




}
