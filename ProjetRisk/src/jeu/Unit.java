package jeu;


import java.awt.Choice;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.TreeMap;
import java.util.concurrent.ThreadLocalRandom;

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
					JOptionPane.showMessageDialog(null, "Hum ... On dirait que vous n'avez plus assez d'unite ... Pas d'unite, pas d'armee ! Veuillez recommencer.", "Erreur", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		
		fenetre.validate();
		fenetre.repaint();			
	}
	
	
	
	
	/**____FONCTION_ATTAQUE_________________________________*/
	
	
	public void attaque(ArrayList<Unit> mvtAttaque, Territoire choixTerrOrigineT, Territoire choixTerrDestT ) {
		TreeMap<Integer,Unit> resultAttaque =new TreeMap<>();
		/*Creer l arme liste defense
		 * */
		TreeMap<Integer, Unit> resultDefense= new TreeMap<>();
		if(choixTerrDestT.getArmeList().size()<2) {
			int des=ThreadLocalRandom.current().nextInt(1, 6 + 1);
			resultDefense.put(des, choixTerrDestT.getArmeList().get(0));
		}
		else{
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

			}

		}
		for(int i=0; i<mvtAttaque.size();i++) {
			int des=ThreadLocalRandom.current().nextInt(mvtAttaque.get(i).desMin,mvtAttaque.get(i).desMax + 1);
			mvtAttaque.get(i).setScore(des);
			resultAttaque.put((des*10+mvtAttaque.get(i).prioAttaque),mvtAttaque.get(i));
		}
		int attaqueTour=0;
		while(attaqueTour<2) {
			if(resultAttaque.get(resultAttaque.lastKey()).getScore()>resultDefense.get(resultDefense.lastKey()).getScore()) {
				//TODO Récupérer ID last element resultDefense et supprimer dans la liste ArmeList
				resultDefense.remove(resultAttaque.lastKey());
				resultAttaque.remove(resultAttaque.lastKey());
				attaqueTour=attaqueTour+1;
				if(resultDefense.isEmpty()) {
					//TODO Récuper tous les pions attaque et les déplacer
					//TODO territoire posséder!
					break;
				}
			}
			if(resultAttaque.get(resultAttaque.lastKey()).getScore()<=resultDefense.get(resultDefense.lastKey()).getScore()) {
				//TODO Récupérer ID last element resultAttaque et supprimer dans la liste ArmeList
				resultDefense.remove(resultAttaque.lastKey());
				resultAttaque.remove(resultAttaque.lastKey());
				attaqueTour=attaqueTour+1;
			}
			
		}
		
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
