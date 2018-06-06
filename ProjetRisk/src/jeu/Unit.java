package jeu;

import java.awt.Button;
import java.awt.Choice;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.SwingConstants;

/**
 * CREATION D'UNE UNITE (SOLDAT, CAVALIER, CANON)
 *
 */

public class Unit {

	/*__ATTRIBUTS___________________________________________________*/
	
	protected int idUnit;
	protected int cout;
	protected int prioAttaque;
	protected int prioDefense;
	protected int mouvement;
	protected int score;
	protected int mouventEffectif;
	protected String nom;
	protected int desMin;
	protected int desMax;

	private JPanel panelPlacerUnit;
	private JPanel panelDeplacement;
	
	/*__METHODES____________________________________________________*/
	
	
	public Unit() {

	}
	
	public Unit(int idUnit, int mouventEffectif, int cout, int prioAttaque, int prioDefense, int mouvement, int score, String nom, JPanel panelPlacerUnit,int desMin, int desMax) {
		super();
		
		this.idUnit = idUnit;
		this.cout = cout;
		this.prioAttaque = prioAttaque;
		this.prioDefense = prioDefense;
		this.mouvement = mouvement;
		this.score = score;
		this.mouventEffectif = mouventEffectif;
		this.nom = nom;
		this.desMin = desMin;
		this.desMax = desMax;
		
		this.panelPlacerUnit = panelPlacerUnit;
	}

	
	/*_____FONCTION_PLACER_LES_UNITES______________________________________*/
	
	public void placerUnit (ArrayList<Joueur> joueurList, int idJoueur,JFrame fenetre, JPanel contentPaneJeu, JLabel nbrUnite) {
		
		/**CREATION D'UN JPANEL DEDIE AU PLACEMENT DES UNITES - INTERFACE GRAPHIQUE*/
		panelPlacerUnit = new JPanel();
		panelPlacerUnit.setBounds(922, 264, 359, 296);
		contentPaneJeu.add(panelPlacerUnit);
		panelPlacerUnit.setLayout(null);
		
		JLabel titrePlacerUnit = new JLabel("Placement des unit\u00E9s");
		titrePlacerUnit.setHorizontalAlignment(SwingConstants.CENTER);
		titrePlacerUnit.setFont(new Font("LeHavre", Font.PLAIN, 17));
		titrePlacerUnit.setBounds(10, 0, 339, 24);
		panelPlacerUnit.add(titrePlacerUnit);
		
		JLabel lblTerritoire = new JLabel("1. Choisir un de vos territoires:");
		lblTerritoire.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblTerritoire.setBounds(28, 35, 212, 14);
		panelPlacerUnit.add(lblTerritoire);
		
		JLabel lblArmee = new JLabel("2. Choisir l'arm\u00E9e que vous souhaitez placer :");
		lblArmee.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblArmee.setBounds(28, 98, 272, 14);
		panelPlacerUnit.add(lblArmee);
		
		
		Choice choixTerr = new Choice();
		choixTerr.setBounds(55, 55, 200, 20);
		panelPlacerUnit.add(choixTerr);
		for ( int i = 0; i < joueurList.get(idJoueur).getTerritoireList().size(); i++) {
			choixTerr.add (joueurList.get(idJoueur).getTerritoireList().get(i).getNomT());
		}
		
		/*JLabel choixTerr = new JLabel(" ");
		choixTerr.setBounds(55, 55, 200, 20);
		panelPlacerUnit.add(choixTerr);
		for ( int i = 0; i < joueurList.get(idJoueur).getTerritoireList().size(); i++) {
			choixTerr.add (joueurList.get(idJoueur).getTerritoireList().get(i).getNomT());
		}*/
		
		
		JLabel lblSoldat_1 = new JLabel("Soldat (1U)");
		lblSoldat_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblSoldat_1.setBounds(38, 123, 74, 14);
		panelPlacerUnit.add(lblSoldat_1);
		
		JLabel lblCavalier_1 = new JLabel("Cavalier (3U)");
		lblCavalier_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblCavalier_1.setBounds(126, 123, 80, 14);
		panelPlacerUnit.add(lblCavalier_1);
		
		JLabel lblCanon_1 = new JLabel("Canon (7U)");
		lblCanon_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblCanon_1.setBounds(211, 123, 72, 14);
		panelPlacerUnit.add(lblCanon_1);
		
		JSpinner spinnerSoldat = new JSpinner();
		spinnerSoldat.setModel(new SpinnerNumberModel(0, 0, 60, 1));
		spinnerSoldat.setBounds(61, 147, 39, 24);
		panelPlacerUnit.add(spinnerSoldat);
		
		JSpinner spinnerCavalier = new JSpinner();
		spinnerCavalier.setModel(new SpinnerNumberModel(0, 0, 60, 1));
		spinnerCavalier.setBounds(153, 148, 39, 23);
		panelPlacerUnit.add(spinnerCavalier);
		
		JSpinner spinnerCanon = new JSpinner();
		spinnerCanon.setModel(new SpinnerNumberModel(0, 0, 60, 1));
		spinnerCanon.setBounds(231, 148, 39, 23);
		panelPlacerUnit.add(spinnerCanon);
		
		
		JButton btnPlacerUnites = new JButton("Placer");
		btnPlacerUnites.setBounds(126, 196, 80, 23);
		panelPlacerUnit.add(btnPlacerUnites);
		btnPlacerUnites.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				int nbrSoldat = ((Integer)spinnerSoldat.getValue()).intValue();
				int nbrCavalier = ((Integer)spinnerCavalier.getValue()).intValue();
				int nbrCanon = ((Integer)spinnerCanon.getValue()).intValue();
				
				int unitUtiliser = nbrSoldat + 3* nbrCavalier + 7*nbrCanon;
				
				if (unitUtiliser <= joueurList.get(idJoueur).getUnit()) {
					
					for ( int i = 0; i < joueurList.get(idJoueur).getTerritoireList().size(); i++) {
						if (choixTerr.getSelectedItem() == joueurList.get(idJoueur).getTerritoireList().get(i).getNomT()) {
							
							ArrayList<Unit> armeeL = joueurList.get(idJoueur).getTerritoireList().get(i).getArmeList();
									
							for (int s = 0; s < nbrSoldat; s++) {
								int idUnit =  joueurList.get(idJoueur).getIdUnit();
								Unit unitS = new Soldat(idUnit);
								idUnit = idUnit + 1;
								joueurList.get(idJoueur).setIdUnit(idUnit);
								armeeL.add(unitS);
							}
							for (int c = 0; c < nbrCavalier; c++) {
								int idSoldat =  joueurList.get(idJoueur).getIdUnit();
								Unit unitC = new Cavalier(idSoldat);
								idSoldat = idSoldat + 1;
								joueurList.get(idJoueur).setIdUnit(idSoldat);
								armeeL.add(unitC);
							}
							for (int ca = 0; ca < nbrCanon; ca++) {
								int idUnit =  joueurList.get(idJoueur).getIdUnit();
								Unit unitCa = new Canon(idUnit);
								idUnit = idUnit + 1;
								joueurList.get(idJoueur).setIdUnit(idUnit);
								armeeL.add(unitCa);
							}

							joueurList.get(idJoueur).getTerritoireList().get(i).setArmeList(armeeL);
						}
					}
							
				joueurList.get(idJoueur).setUnit(joueurList.get(idJoueur).getUnit() - unitUtiliser);
				nbrUnite.setText (String.valueOf(joueurList.get(idJoueur).getUnit()));
				
				}else {
					JOptionPane.showMessageDialog(null, "Hum ... On dirait que vous n'avez plus assez d'unité ... Pas d'unité, pas d'armée ! Veuillez recommencer.", "Erreur", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		
		fenetre.validate();
		fenetre.repaint();			
	}
	
	
	
	/**____FONCTION_DEPLACEMENT_INTERFACE________________________*/

	public void attaqueChoix(Joueur joueur, Territoire territoireOrigine, ArrayList<Territoire> territoireArrayList ,JFrame fenetre, JPanel contentPaneJeu) throws IOException {
		
		//JPANEL SPECIFIQUE AU DEPLACEMENT
		panelDeplacement = new JPanel();
		panelDeplacement.setBounds(929, 264, 359, 296);
		contentPaneJeu.add(panelDeplacement);
		panelDeplacement.setLayout(null);
		
		//TITRE
		JLabel titreDeplacement = new JLabel("D\u00E9placement\r\n");
		titreDeplacement.setFont(new Font("LeHavre", Font.PLAIN, 17));
		titreDeplacement.setBounds(120, 0, 134, 24);
		panelDeplacement.add(titreDeplacement);
		
		//CHOIX PAYS ORIGINE
		JLabel lblTerrOrigine = new JLabel("Pays d'origine choisi :" + territoireOrigine.getNomT());
		lblTerrOrigine.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblTerrOrigine.setBounds(28, 49, 302, 14);
		panelDeplacement.add(lblTerrOrigine);

		
		//CHOIX DU PAYS DE DESTINATION EN FONCTION DES TERRITOIRES VOISINS
		JLabel lblTerrDest = new JLabel("2. Les territoires de destination possible  :");
		lblTerrDest.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblTerrDest.setBounds(28, 98, 249, 14);
		panelDeplacement.add(lblTerrDest);
		
		Choice choixTerrDest = new Choice();
		choixTerrDest.setBounds(55, 131, 200, 20);
		panelDeplacement.add(choixTerrDest);
		
		ArrayList<Territoire> voisinT = territoireOrigine.getVoisinT();
		for (int i = 0; i < voisinT.size(); i++) {
			Territoire territoireVoisin = voisinT.get(i);
			String nomT = territoireVoisin.getNomT();
			choixTerrDest.add(nomT);
		}
		
		//BOUTON NEXT -> CHOISIR LES ARMEES A DEPLACER
		Button boutonNext = new Button("Next");
		boutonNext.setBounds(279, 131, 51, 22);
		panelDeplacement.add(boutonNext);
		
		boutonNext.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				ArrayList<Unit> armeList = territoireOrigine.getArmeList();
				ArrayList<Unit> soldatList= new ArrayList<>();
				ArrayList<Unit> cavalierList= new ArrayList<>();
				ArrayList<Unit> canonList= new ArrayList<>();
				//ArrayList<Unit> choixPion = new ArrayList<>();
				
				for (int i=0; i<armeList.size();i++) {
					
					if(armeList.get(i).cout==1 && armeList.get(i).mouventEffectif < armeList.get(i).mouvement) {
						soldatList.add(armeList.get(i));
					}
					
					if(armeList.get(i).cout==3 && armeList.get(i).mouventEffectif < armeList.get(i).mouvement) {
						cavalierList.add(armeList.get(i));
					}
					
					if(armeList.get(i).cout==7 && armeList.get(i).mouventEffectif < armeList.get(i).mouvement) {
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

						Territoire choixTerrDestT = Territoire.stringToTerritoire(choixTerrDest.getSelectedItem(), territoireArrayList);
						
						String condition1 = null;
						String condition2 = null;
						String condition3 = null;
						
						if((nbSoldatChoix + nbCavalierChoix + nbCanonChoix) >= armeList.size()) {
							condition1="\n Vous devez laisser un pion sur le territoire ";
						}
						if(nbSoldatChoix == 0 && nbCavalierChoix == 0 && nbCanonChoix == 0 ) {
							condition2="\n Vous n'avez selectionne aucun pion a deplacer ";
						}
						if (nbSoldatChoix + nbCanonChoix + nbCavalierChoix >3 && !joueur.getTerritoireList().contains(choixTerrDestT)) {
							condition3="\n Vous ne devez pas avoir plus de 3 pions attaquants";
						}
						if ( !condition1.isEmpty()|| !condition2.isEmpty() || !condition3.isEmpty()) {
							JOptionPane.showMessageDialog(null, condition1 + condition2 + condition3 , "Erreur", JOptionPane.ERROR_MESSAGE);
						}
						if (condition1.isEmpty() && condition2.isEmpty() && condition3.isEmpty()) {
							
							ArrayList<Unit> armeDeplacerList = new ArrayList<>();
							

							if(joueur.getTerritoireList().contains(choixTerrDestT)) {
								
								ArrayList<Unit> armeListMvt= new ArrayList<>();
								armeListMvt = choixTerrDestT.getArmeList();
								for (int i=0; i==nbSoldatChoix; i++) {
									armeListMvt.add(soldatList.get(i));
								}
								
								for (int i=0;i==nbCavalierChoix; i++) {
									armeListMvt.add(cavalierList.get(i));
								}
								
								for (int i=0;i==nbCanonChoix; i++) {
									armeListMvt.add(canonList.get(i));
								}
								
								choixTerrDestT.setArmeList(armeListMvt);
								armeList.removeAll(armeListMvt);
								territoireOrigine.setArmeList(armeList);
							}
							else {
								
								//attaque(armeDeplacerList,territoireOrigine,choixTerrDestT);
							}
						}

					}
				}
						);
			}
		}
		);
		
		fenetre.validate();
	    fenetre.repaint();

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

	public JPanel getPanelPlacerUnit() {
		return panelPlacerUnit;
	}

	public void setPanelPlacerUnit(JPanel panelPlacerUnit) {
		this.panelPlacerUnit = panelPlacerUnit;
	}

	public int getIdUnit() {
		return idUnit;
	}

	public void setIdUnit(int idUnit) {
		this.idUnit = idUnit;
	}
	
	
	
}