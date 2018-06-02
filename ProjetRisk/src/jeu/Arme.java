package jeu;

import java.awt.Button;
import java.awt.Choice;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;

import edu.princeton.cs.introcs.StdDraw;

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




	public boolean attaqueChoix(Joueur joueur, Partie partie) {
		JPanel panelDeplacement = new JPanel();
		panelDeplacement.setBounds(922, 264, 359, 296);
		contentPane.add(panelDeplacement);
		panelDeplacement.setLayout(null);

		JLabel titreDeplacement = new JLabel("D\u00E9placement\r\n");
		titreDeplacement.setFont(new Font("LeHavre", Font.PLAIN, 17));
		titreDeplacement.setBounds(120, 0, 134, 24);
		panelDeplacement.add(titreDeplacement);

		JLabel lblTerrOrigine = new JLabel("Choisir votre territoire d'origine :");
		lblTerrOrigine.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblTerrOrigine.setBounds(28, 35, 212, 14);
		panelDeplacement.add(lblTerrOrigine);

		JLabel lblTerrDest = new JLabel("Choisir votre territoire de destination :");
		lblTerrDest.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblTerrDest.setBounds(28, 98, 249, 14);
		panelDeplacement.add(lblTerrDest);

		Choice choixTerrOrigine = new Choice();
		choixTerrOrigine.setBounds(55, 55, 200, 20);
		panelDeplacement.add(choixTerrOrigine);
		ArrayList<Territoire> territoireListJoueur= joueur.getTerritoireList();
		for (int i=0; i<territoireListJoueur.size();i++) {
			Territoire territoireInit=territoireListJoueur.get(i);
			String nomT=territoireInit.getNomT();
			choixTerrOrigine.add(nomT);
		}



		Choice choixTerrDest = new Choice();
		choixTerrDest.setBounds(55, 131, 200, 20);
		panelDeplacement.add(choixTerrDest);
		ArrayList<Territoire> territoireArrayList=partie.territoireArrayList;
		for (int i=0; i<territoireArrayList.size();i++) {
			Territoire territoireMvt=territoireListJoueur.get(i);
			String nomT=territoireMvt.getNomT();
			choixTerrOrigine.add(nomT);
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
				boolean unite = false;
				while (!unite){
					int [] nbSoldatAttaque = new int[this.getTerritoire().getSoldatT()+1];
					StdDraw.disableDoubleBuffering();
					StdDraw.clear();
					StdDraw.text(50,60,"How many soldiers do you want to attack ?");
					StdDraw.text(40,55,"Number of soldiers : ");
					for(int it=0;it<=this.getTerritory().getNbSoldier();it++){
						StdDraw.text((45+it*2)+2,55, String.valueOf(it));
						xTextSoldier[it] = (45+it*2)+2;
					}
					StdDraw.show();
					boolean numberOfSoldiersChosen = false;
					int nbSoldierAttacker = 0;
					while (!numberOfSoldiersChosen){
						if (StdDraw.isMousePressed()){
							double xSoldier = StdDraw.mouseX();
							double ySoldier = StdDraw.mouseY();
							if((ySoldier>=53.7 && ySoldier<=56.3)){
								for (int k=0; k<=this.getTerritory().getNbSoldier();k++){
									if((xSoldier>=xTextSoldier[k]-1.1) && (xSoldier<=xTextSoldier[k]+1.1)){
										nbSoldierAttacker = k;
										numberOfSoldiersChosen = true;
									}
								}
							}
							StdDraw.pause(90);
						}
					}

					if (this.getTerritory().getNbSoldier()<nbSoldierAttacker){
						StdDraw.disableDoubleBuffering();
						StdDraw.clear();
						StdDraw.text(50,50,"Not enough soldiers");
						StdDraw.show();
						StdDraw.pause(1500);
					}
					this.setNbSoldier(nbSoldierAttacker);



					int [] xTextCavalier = new int[this.getTerritory().getNbCavalery()+1];
					StdDraw.disableDoubleBuffering();
					StdDraw.clear();
					StdDraw.text(50,60,"How many cavaliers do you want to attack ?");
					StdDraw.text(40,55,"Number of cavaliers : ");
					for(int it=0;it<=this.getTerritory().getNbCavalery();it++){
						StdDraw.text((45+it*2)+2,55, String.valueOf(it));
						xTextCavalier[it] = (45+it*2)+2;
					}
					StdDraw.show();
					boolean numberOfCavaliersChosen = false;
					int nbCavaleryAttacker = 0;
					while (!numberOfCavaliersChosen){
						if (StdDraw.isMousePressed()){
							double xCavalery = StdDraw.mouseX();
							double yCavalery = StdDraw.mouseY();
							if(yCavalery>=53.7 && yCavalery<=56.3){
								for (int k=0; k<=this.getTerritory().getNbCavalery();k++){
									if(xCavalery>=xTextCavalier[k]-0.1 && xCavalery<=xTextCavalier[k]+0.1){
										nbCavaleryAttacker = k;
										numberOfCavaliersChosen = true;
									}
								}
							}
							StdDraw.pause(200);
						}
					}

					if (this.getTerritory().getNbCavalery()<nbCavaleryAttacker){
						StdDraw.disableDoubleBuffering();
						StdDraw.clear();
						StdDraw.text(50,50,"Not enough cavaliers");
						StdDraw.show();
						StdDraw.pause(1500);
					}
					this.setNbCavalery(nbCavaleryAttacker);



					int [] xTextCanon = new int[this.getTerritory().getNbCanon()+1];
					StdDraw.disableDoubleBuffering();
					StdDraw.clear();
					StdDraw.text(50,60,"How many canons do you want to attack ?");
					StdDraw.text(40,55,"Number of canons : ");
					for(int it=0;it<=this.getTerritory().getNbCanon();it++){
						StdDraw.text((45+it*2)+2,55, String.valueOf(it));
						xTextCanon[it] = (45+it*2)+2;
					}
					StdDraw.show();
					boolean numberOfCanonChosen = false;
					int nbCanonAttacker = 0;
					while (!numberOfCanonChosen){
						if (StdDraw.isMousePressed()){
							double xCanon = StdDraw.mouseX();
							double yCanon = StdDraw.mouseY();
							if(yCanon>=53.7 && yCanon<=56.3){
								for (int k=0; k<=this.getTerritory().getNbCanon();k++){
									if(xCanon>=xTextCanon[k]-1.1 && xCanon<=xTextCanon[k]+1.1){
										nbCanonAttacker = k;
										numberOfCanonChosen = true;
									}
								}
							}
							StdDraw.pause(200);
						}
					}

					if (this.getTerritory().getNbCanon()<nbCanonAttacker){
						StdDraw.disableDoubleBuffering();
						StdDraw.clear();
						StdDraw.text(50,50,"Not enough canons");
						StdDraw.show();
						StdDraw.pause(1500);
					}
					this.setNbCanon(nbCanonAttacker);


					if ((this.getNbSoldier() + this.getNbCavalery() + this.getNbCanon()) ==0){
						StdDraw.disableDoubleBuffering();
						StdDraw.clear();
						StdDraw.text(50,50,"You need to at least chose one unit ");
						StdDraw.show();
						StdDraw.pause(1500);
					}

					else if ((this.getNbSoldier() + this.getNbCavalery() + this.getNbCanon()) > 3){
						StdDraw.disableDoubleBuffering();
						StdDraw.clear();
						StdDraw.text(50,50,"You cannot choose more than three units ");
						StdDraw.show();
						StdDraw.pause(1500);
					}

					else if ((this.getNbSoldier() + this.getNbCavalery() + this.getNbCanon()) >= (this.getTerritory().getNbCanon()+this.getTerritory().getNbSoldier()+this.getTerritory().getNbCavalery() )){
						StdDraw.disableDoubleBuffering();
						StdDraw.clear();
						StdDraw.text(50,50,"At least one unit needs to stay in the territory ");
						StdDraw.show();
						StdDraw.pause(1500);
						return false;
					}
					else{
						unitsChosen = true;
						this.territory.setNbSoldier(this.territory.getNbSoldier()-nbSoldierAttacker); // on retire les troupes qui partent au combat de leur territoire de base
						this.territory.setNbCavalery(this.territory.getNbCavalery()-nbCavaleryAttacker);
						this.territory.setNbCanon(this.territory.getNbCanon()-nbCanonAttacker);
					}

				}

				return unitsChosen;


			}





		}
