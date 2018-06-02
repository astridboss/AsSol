package jeu;
/**
 * 
 * @author Astrid
 * Classe permettant d'itialialisé un format et des caracteristiques de l'armee
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
	
	
	
	public int nbSoldat;
	public int nbCavalier;
	public int nbCanon;
	public boolean attaquePossible; 
	public Territoire territoire;
	

	

	public Arme(String couleur, int cout, int puissanceMin, int puissanceMax, int prioriteAtt, int prioriteDef, int mouvement,int nbSoldat,int nbCavalier, int nbCanon,boolean attaquePossible,  Territoire territoire) {
		this.couleur = couleur;
		this.cout = cout;
		this.desMin = puissanceMin;
		this.desMax = puissanceMax;
		this.prioAttaque = prioriteAtt;
		this.prioDefense = prioriteDef;
		this.mouvement = mouvement;
		this.score = 0;
		
		
		this.nbSoldat= nbSoldat;
		this.nbCavalier= nbCavalier;
		this.nbCanon= nbCanon;
		this.attaquePossible= attaquePossible;
		this.territoire= territoire;
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

public Territoire getTerritoire() {
	return territoire;
}



public void setTerritoire(Territoire territoire) {
	this.territoire = territoire;
}

public int getNbSoldat() {
	return nbSoldat;
}



public void setNbSoldat(int nbSoldat) {
	this.nbSoldat = nbSoldat;
}



public int getNbCavalier() {
	return nbCavalier;
}



public void setNbCavalier(int nbCavalier) {
	this.nbCavalier = nbCavalier;
}



public int getNbCanon() {
	return nbCanon;
}



public void setNbCanon(int nbCanon) {
	this.nbCanon = nbCanon;
}



public boolean isAttaquePossible() {
	return attaquePossible;
}



public void setAttaquePossible(boolean attaquePossible) {
	this.attaquePossible = attaquePossible;
}


public boolean attaquePossible() {
	//Récuperer du bouton soldat attaque le nbSoldat
	int nbSoldatAttaque = 0;
	if(this.getTerritoire().getSoldatT()<nbSoldat) {
		System.out.println("Il n'y a pas assez de soldat");
        return false;
	}
	this.setNbSoldat(nbSoldatAttaque);
	//Récuperer du bouton Cavalier attaque le nbCavalierAttaque
	int nbCavalierAttaque=0;
	
	if(this.getTerritoire().get)
}



}
