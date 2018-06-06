package jeu;


import java.util.concurrent.ThreadLocalRandom;
import java.awt.Button;
import java.awt.Choice;
import java.awt.Font;
import java.awt.List;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.util.ArrayList;
import java.util.TreeMap;
import javax.print.attribute.Size2DSyntax;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.Painter;
import javax.swing.SpinnerNumberModel;

/**
 * CLASSE ARME
 * UNE ARMEE PAR TERRITOIRE
 * INITIALISER UN FORMAT ET LES CARACTERISTIQUES DE L'ARMEE
 */


public class Arme {

	/*__ATTRIBUTS___________________________________________________*/
	public Joueur joueur;
	public boolean attaquePossible; 

	public ArrayList<Unit> armeList= new ArrayList<>();
	
	JPanel panelDeplacement;


	/*__METHODES____________________________________________________*/

	/**_____CONSTRUCTEUR___________________*/

	public Arme () {
		
	}

	
	
	
	/**____FONCTION_ATTAQUE__________________________*/
	
	/*
	
	public void attaque (int nbSoldatChoix, int nbCavalierChoix, int nbCanonChoix, ArrayList<Unit> soldatList, ArrayList<Unit> cavalierList, ArrayList<Unit> canonList, Territoire choixTerrOrigineT, Territoire choixTerrDestT) {
		
		TreeMap<HashMap<Integer,Integer>, Unit> resultAttaque= new TreeMap<>();
		for (int i=0;i==nbSoldatChoix; i++) {
			int des=ThreadLocalRandom.current().nextInt(1, 6 + 1);
			HashMap<Integer, Integer> key =new HashMap<>();
			key.put(des, 2);
			resultAttaque.put(key, soldatList.get(i));
		}
		for (int i=0;i==nbCavalierChoix; i++) {
			int des=ThreadLocalRandom.current().nextInt(2, 7 + 1);
			HashMap<Integer, Integer> key =new HashMap<>();
			key.put(des, 1);
			resultAttaque.put(key, cavalierList.get(i));

		}
		for (int i=0;i==nbCanonChoix; i++) {
			int des=ThreadLocalRandom.current().nextInt(4, 9 + 1);
			HashMap<Integer, Integer> key =new HashMap<>();
			key.put(des, 3);
			resultAttaque.put(key, canonList.get(i));

		}

		/*Creer l arme liste defense
		 * *//*
		TreeMap<Integer, Unit> resultDefense= new TreeMap<>();
		while(resultDefense.size()<2) {
			for( int i=0 ; i<choixTerrDestT.getArmeList().size();i++) {
				if(choixTerrDestT.getArmeList().get(i).cout==1) {
					int des=ThreadLocalRandom.current().nextInt(1, 6 + 1);
					resultDefense.put(des, choixTerrDestT.getArmeList().get(i));

				}
			}
			for( int i=0 ; i<choixTerrDestT.getArmeList().size();i++) {
				if(choixTerrDestT.getArmeList().get(i).cout==7) {
					int des=ThreadLocalRandom.current().nextInt(4, 9 + 1);
					resultDefense.put(des, choixTerrDestT.getArmeList().get(i));

				}
			}
			for( int i=0 ; i<choixTerrDestT.getArmeList().size();i++) {
				if(choixTerrDestT.getArmeList().get(i).cout==3) {
					int des=ThreadLocalRandom.current().nextInt(2, 7 + 1);
					resultDefense.put(des, choixTerrDestT.getArmeList().get(i));

				}
			}
			
			/*Calcul gagnant
			 * 
			 *//*
			 
			resultAttaque.lastKey()=key HashMap<K, V>;
			while(resultDefense.size()>0) {
				if(resultAttaque.get(resultAttaque.lastKey())>resultDefense.get(resultAttaque.lastKey()) {
					Unit pionSupp =resultDefense.get(resultDefense.lastKey());
					choixTerrDestT.getArmeList().remove(pionSupp);
				}
				if(resultAttaque.lastKey()<=resultDefense.lastKey()) {
					Unit pionSupp =resultDefense.get(resultDefense.lastKey());
					choixTerrOrigineT.getArmeList().remove(pionSupp);
				}
			}
			
		}

	}
	*/
	
	
	/*__GETTERS_&_SETTERS____________________________________________________*/

	public Joueur getJoueur() {
		return joueur;
	}


	public void setJoueur(Joueur joueur) {
		this.joueur = joueur;
	}



	public boolean isAttaquePossible() {
		return attaquePossible;
	}


	public void setAttaquePossible(boolean attaquePossible) {
		this.attaquePossible = attaquePossible;
	}



	public ArrayList<Unit> getArmeList() {
		return armeList;
	}


	public void setArmeList(ArrayList<Unit> armeList) {
		this.armeList = armeList;
	}

	public JPanel getPanelDeplacement() {
		return panelDeplacement;
	}

	public void setPanelDeplacement(JPanel panelDeplacement) {
		this.panelDeplacement = panelDeplacement;
	}


	








}



