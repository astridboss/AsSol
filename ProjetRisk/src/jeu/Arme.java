package jeu;
import java.util.concurrent.ThreadLocalRandom;
import java.awt.Button;
import java.awt.Choice;
import java.awt.Color;
import java.awt.Font;
import java.awt.List;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
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

import edu.princeton.cs.introcs.StdDraw;

/**
 * 
 *
 *Arme par Territoire
 * Classe permettant d'itialialisé un format et des caracteristiques de l'armee

 * INITIALISER UN FORMAT ET LES CARACTERISTIQUES DE L'ARMEE
 */

public abstract class Arme {

	/*__ATTRIBUTS___________________________________________________*/
	public Joueur joueur;

	public boolean attaquePossible; 


	public ArrayList<Unit> armeList= new ArrayList<>();


	/*__METHODES____________________________________________________*/

	/**_____CONSTRUCTEUR___________________*/

	public Arme(Joueur joueur, int nbSoldat, int nbCavalier, int nbCanon, 
			Territoire territoire, ArrayList<Unit> armeList) {
		super();
		this.joueur = joueur;


		this.armeList = armeList;
	}


	/**____FONCTION_CHOIX_ATTAQUE_INTERFACE_________________*/


	public boolean attaqueChoix(Joueur joueur, ArrayList<Territoire> territoireArrayList ,JFrame fenetre)throws IOException {

		JPanel panelDeplacement = new JPanel();
		panelDeplacement.setBounds(922, 264, 359, 296);
		panelDeplacement.add(panelDeplacement);
		panelDeplacement.setLayout(null);

		JLabel titreDeplacement = new JLabel("D\u00E9placement\r\n");
		titreDeplacement.setFont(new Font("LeHavre", Font.PLAIN, 17));
		titreDeplacement.setBounds(120, 0, 134, 24);
		panelDeplacement.add(titreDeplacement);

		JLabel lblTerrOrigine = new JLabel("Choisir votre territoire d'origine :");
		lblTerrOrigine.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblTerrOrigine.setBounds(28, 35, 212, 14);
		panelDeplacement.add(lblTerrOrigine);

		Choice choixTerrOrigine = new Choice();
		choixTerrOrigine.setBounds(55, 55, 200, 20);
		panelDeplacement.add(choixTerrOrigine);
		ArrayList<Territoire> territoireListJoueur= joueur.getTerritoireList();

		for (int i=0; i<territoireListJoueur.size();i++) {
			Territoire territoireInit=territoireListJoueur.get(i);
			String nomT=territoireInit.getNomT();
			choixTerrOrigine.add(nomT);
		}

		JLabel lblTerrDest = new JLabel("Les territoires de destination possible  :");
		lblTerrDest.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblTerrDest.setBounds(28, 98, 249, 14);
		panelDeplacement.add(lblTerrDest);
		Choice choixTerrDest = new Choice();
		choixTerrDest.setBounds(55, 131, 200, 20);
		panelDeplacement.add(choixTerrDest);
		String choixTerrOrigineS=choixTerrOrigine.getSelectedItem();
		Territoire choixTerrOrigineT =Territoire.stringToTerritoire(choixTerrOrigineS, territoireArrayList);
		ArrayList<Territoire> voisinT=choixTerrOrigineT .getVoisinT();

		for (int i=0; i<voisinT.size();i++) {
			Territoire territoireVoisin=territoireListJoueur.get(i);
			String nomT=territoireVoisin.getNomT();
			choixTerrDest.add(nomT);
		}

		Button boutonNext = new Button("Next");
		boutonNext.setBounds(279, 131, 51, 22);
		panelDeplacement.add(boutonNext);
		boutonNext.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ArrayList<Unit> armeList=choixTerrOrigineT.getArmeList();
				ArrayList<Unit> soldatList= new ArrayList();
				ArrayList<Unit> cavalierList= new ArrayList();
				ArrayList<Unit> canonList= new ArrayList();
				ArrayList<Unit> choixPion = new ArrayList();
				for (int i=0; i<armeList.size();i++) {
					if(armeList.get(i).cout==1 && armeList.get(i).mouventEffectif<armeList.get(i).mouventEffectif) {
						soldatList.add(armeList.get(i));
					}
					if(armeList.get(i).cout==3 && armeList.get(i).mouventEffectif<armeList.get(i).mouventEffectif) {
						cavalierList.add(armeList.get(i));
					}
					if(armeList.get(i).cout==7 && armeList.get(i).mouventEffectif<armeList.get(i).mouventEffectif) {
						canonList.add(armeList.get(i));
					}

				}
				JLabel lblSoldat_1 = new JLabel("Soldat (1U)");
				lblSoldat_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
				lblSoldat_1.setBounds(43, 185, 74, 14);
				panelDeplacement.add(lblSoldat_1);

				JLabel lblCavalier_1 = new JLabel("Cavalier (3U)");
				lblCavalier_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
				lblCavalier_1.setBounds(131, 185, 80, 14);
				panelDeplacement.add(lblCavalier_1);

				JLabel lblCanon_1 = new JLabel("Canon (7U)");
				lblCanon_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
				lblCanon_1.setBounds(216, 185, 72, 14);
				panelDeplacement.add(lblCanon_1);

				JSpinner spinnerSoldat = new JSpinner();
				spinnerSoldat.setModel(new SpinnerNumberModel(0, 0, soldatList.size(), 1));
				spinnerSoldat.setBounds(66, 209, 39, 24);
				panelDeplacement.add(spinnerSoldat);

				JSpinner spinnerCavalier = new JSpinner();
				spinnerCavalier.setModel(new SpinnerNumberModel(0, 0, cavalierList.size(), 1));
				spinnerCavalier.setBounds(158, 210, 39, 23);
				panelDeplacement.add(spinnerCavalier);

				JSpinner spinnerCanon = new JSpinner();
				spinnerCanon.setModel(new SpinnerNumberModel(0, 0, canonList.size(), 1));
				spinnerCanon.setBounds(236, 210, 39, 23);
				panelDeplacement.add(spinnerCanon);

				JButton btnDeplacement = new JButton("D\u00E9placement/ Attaque");
				btnDeplacement.setBounds(160, 258, 170, 23);
				panelDeplacement.add(btnDeplacement);

				btnDeplacement.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {

						int nbSoldatChoix =((Integer)spinnerSoldat.getValue()).intValue();
						int nbCavalierChoix =((Integer)spinnerCavalier.getValue()).intValue();
						int nbCanonChoix =((Integer)spinnerCanon.getValue()).intValue();

						Territoire choixTerrDestT=Territoire.stringToTerritoire(choixTerrDest.getSelectedItem(), territoireArrayList);
						String condition1 = null;
						String condition2 = null ;
						String condition3 = null;
						if((nbSoldatChoix+nbCavalierChoix+nbCanonChoix)>=armeList.size()) {
							condition1="\n Vous devez laisser un pion sur le territoire ";
						}
						if(nbSoldatChoix==0 && nbCavalierChoix==0 && nbCanonChoix==0 ) {
							condition2="\n Vous n'avez selectionné aucun pion à déplacer ";
						}
						if (nbSoldatChoix+nbCanonChoix+nbCavalierChoix>3 && !joueur.territoireListJoueur.contains(choixTerrOrigine)) {
							condition3="\n Vous ne devez pas avoir plus de 3 pions attaquants";
						}
						if (condition1.isEmpty()|| condition2.isEmpty()|| condition3.isEmpty()) {
							JOptionPane.showMessageDialog(null, condition1 + condition2 + condition3 , "Erreur", JOptionPane.ERROR_MESSAGE);
						}
						if (condition1.isEmpty()&& condition2.isEmpty()&& condition3.isEmpty()) {

							if(joueur.territoireListJoueur.contains(choixTerrDestT)) {
								ArrayList<Unit> armeListMvt= new ArrayList<>();
								armeListMvt=choixTerrDestT.getArmeList();
								for (int i=0;i==nbSoldatChoix; i++) {
									armeListMvt.add(soldatList.get(i));

								}
								for (int i=0;i==nbCavalierChoix; i++) {
									armeListMvt.add(cavalierList.get(i));

								}
								for (int i=0;i==nbCanonChoix; i++) {
									armeListMvt.add(canonList.get(i));

								}
								setArmeList(armeListMvt);
								armeList.removeAll(armeListMvt);
								setArmeList(armeList);
							}
							else {
								attaque(nbSoldatChoix,nbCavalierChoix,nbCanonChoix,soldatList,cavalierList,canonList,choixTerrOrigineT,choixTerrDestT);
							}
						}

					}
				}
						);
			}
		}
				);
		return true;

	}
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
		 * */
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
			 */*
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











}



