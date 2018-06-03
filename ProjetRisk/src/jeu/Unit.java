package jeu;

import java.awt.Color;

public class Unit {
	

	
	public int unitId;
	public int cout;
	public int desMin;
	public int desMax;
	public int prioAttaque;
	public int prioDefense;
	public int mouvement;
	public int score;
	public int mouventEffectif;

	public Unit() {

	}
	public Unit(Joueur joueur,Territoire territoire,int mouventEffectif,int unitId,Color couleur, int cout, int desMin, int desMax, int prioAttaque, int prioDefense, int mouvement,
			int score) {
		super();
		
		
		this.unitId=unitId;
		this.cout = cout;
		this.desMin = desMin;
		this.desMax = desMax;
		this.prioAttaque = prioAttaque;
		this.prioDefense = prioDefense;
		this.mouvement = mouvement;
		this.score = score;
		this.mouventEffectif=mouventEffectif;
	}

	

	public int getCout() {
		return cout;
	}

	public void setCout(int cout) {
		this.cout = cout;
	}

	public int getDesMin() {
		return desMin;
	}

	public void setDesMin(int desMin) {
		this.desMin = desMin;
	}

	public int getDesMax() {
		return desMax;
	}

	public void setDesMax(int desMax) {
		this.desMax = desMax;
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
	

	public int getUnitId() {
		return unitId;
	}
	public void setUnitId(int unitId) {
		this.unitId = unitId;
	}
	public int getMouventEffectif() {
		return mouventEffectif;
	}
	public void setMouventEffectif(int mouventEffectif) {
		this.mouventEffectif = mouventEffectif;
	}
	
}
