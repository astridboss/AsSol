package jeu;

import java.awt.Button;
import java.awt.Choice;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
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
	public int nbSoldat;
	public int nbCavalier;
	public int nbCanon;
	public boolean attaquePossible; 
	public Territoire territoire;

	public ArrayList<Unit> armeList= new ArrayList<>();


	/*__METHODES____________________________________________________*/

	/**_____CONSTRUCTEUR___________________*/

	public Arme(Joueur joueur, int nbSoldat, int nbCavalier, int nbCanon, boolean attaquePossible,
			Territoire territoire, ArrayList<Unit> armeList) {
		super();
		this.joueur = joueur;
		this.nbSoldat = nbSoldat;
		this.nbCavalier = nbCavalier;
		this.nbCanon = nbCanon;
		this.attaquePossible = attaquePossible;
		this.territoire = territoire;
		this.armeList = armeList;
	}


	/**____FONCTION_ATTAQUE_POSSIBLE_________________*/

	public boolean attaquePossible(int nbSoldatAttaque, int nbCavalierAttaque,int nbCanonAttaque) {

		if(this.getTerritoire().getSoldatT()<nbSoldatAttaque) {
			System.out.println("Il n'y a pas assez de soldat");
			return false;
		}
		this.setNbSoldat(nbSoldatAttaque);

		if(this.getTerritoire().getCavalierT()<nbCavalierAttaque) {
			System.out.println("Il n'y a pas assez de cavalier");
			return false;
		}
		if(this.getTerritoire().getCanonT()<nbCanonAttaque) {
			System.out.println("Il n'y a pas assez de canon");
			return false;

		}
		if (this.getTerritoire().getCanonT()*7+this.getTerritoire().getCavalierT()*3+this.getTerritoire().getSoldatT()-(nbSoldatAttaque+nbCavalierAttaque*3+nbCanonAttaque*7)<1) {
			System.out.println("Il faut laisser au moins une unitée sur le territoire");
			return false;	
		}
		return true;
	}


	/**____FONCTION_CHOIX_ATTAQUE_INTERFACE_________________*/

	public boolean attaqueChoix(Joueur joueur, Partie partie,JFrame fenetre)throws IOException {
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
		Territoire choixTerrOrigineT =Territoire.stringToTerritoire(choixTerrOrigineS, partie);
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

				JLabel lblSoldat_1 = new JLabel("Soldat (1U)");
				lblSoldat_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
				lblSoldat_1.setBounds(43, 185, 74, 14);
				panelDeplacement.add(lblSoldat_1);

				JLabel lblCavalier_1 = new JLabel("Cavalier (2U)");
				lblCavalier_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
				lblCavalier_1.setBounds(131, 185, 80, 14);
				panelDeplacement.add(lblCavalier_1);

				JLabel lblCanon_1 = new JLabel("Canon (3U)");
				lblCanon_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
				lblCanon_1.setBounds(216, 185, 72, 14);
				panelDeplacement.add(lblCanon_1);

				JSpinner spinnerSoldat = new JSpinner();
				spinnerSoldat.setModel(new SpinnerNumberModel(0, 0, 60, 1));
				spinnerSoldat.setBounds(66, 209, 39, 24);
				panelDeplacement.add(spinnerSoldat);

				JSpinner spinnerCavalier = new JSpinner();
				spinnerCavalier.setModel(new SpinnerNumberModel(0, 0, 60, 1));
				spinnerCavalier.setBounds(158, 210, 39, 23);
				panelDeplacement.add(spinnerCavalier);

				JSpinner spinnerCanon = new JSpinner();
				spinnerCanon.setModel(new SpinnerNumberModel(0, 0, 60, 1));
				spinnerCanon.setBounds(236, 210, 39, 23);
				panelDeplacement.add(spinnerCanon);

				JButton btnDeplacement = new JButton("D\u00E9placement/ Attaque");
				btnDeplacement.setBounds(160, 258, 170, 23);
				panelDeplacement.add(btnDeplacement);

				fenetre.validate();
				fenetre.repaint();


			}
		}
				);
		return true;

	}
	/*__GETTERS_&_SETTERS____________________________________________________*/

	public Joueur getJoueur() {
		return joueur;
	}


	public void setJoueur(Joueur joueur) {
		this.joueur = joueur;
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


	public Territoire getTerritoire() {
		return territoire;
	}


	public void setTerritoire(Territoire territoire) {
		this.territoire = territoire;
	}


	public ArrayList<Unit> getArmeList() {
		return armeList;
	}


	public void setArmeList(ArrayList<Unit> armeList) {
		this.armeList = armeList;
	}











}



