package jeu;

import java.awt.Font;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeMap;
import java.util.concurrent.ThreadLocalRandom;


import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
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
	

	
	
	
	
	/**____FONCTION_ATTAQUE_________________________________*/
	
	
	public void attaque(ArrayList<Unit> mvtAttaque, Territoire choixTerrOrigineT, Territoire choixTerrDestT, JFrame fenetre, JPanel contentPaneJeu) {
		// creation de la Jpanel
				JPanel panelAttack = new JPanel();
				panelAttack.setBounds(463, 510, 397, 181);
				contentPaneJeu.add(panelAttack);
				panelAttack.setLayout(null);
				
				// TITRE
				JLabel lblTitreAttaque = new JLabel("Attaque\r\n");
				lblTitreAttaque.setBounds(108, 0, 162, 24);
				panelAttack.add(lblTitreAttaque);
				lblTitreAttaque.setHorizontalAlignment(SwingConstants.CENTER);
				lblTitreAttaque.setFont(new Font("LeHavre", Font.PLAIN, 17));
				
				//Label cotÃ© Attaquant
				JLabel lblAttaquant = new JLabel("Attaquant");
				lblAttaquant.setHorizontalAlignment(SwingConstants.CENTER);
				lblAttaquant.setBounds(86, 35, 86, 14);
				panelAttack.add(lblAttaquant);
				
				//LABEL VS
				JLabel lblVs = new JLabel("VS\r\n");
				lblVs.setHorizontalAlignment(SwingConstants.CENTER);
				lblVs.setFont(new Font("LeHavre", Font.PLAIN, 17));
				lblVs.setBounds(172, 78, 41, 24);
				panelAttack.add(lblVs);
				
				
				//Physique cotÃ© defenseur
				JLabel lblDefenseur = new JLabel("Defenseur");
				lblDefenseur.setHorizontalAlignment(SwingConstants.CENTER);
				lblDefenseur.setBounds(210, 35, 86, 14);
				panelAttack.add(lblDefenseur);
				
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
		

		
		
		
		ArrayList<Unit> attaqueUnitTrie= new ArrayList<>();
		Set<Integer> set=resultAttaque.keySet();
		Iterator<Integer> iterator =set.iterator();
		while(iterator.hasNext()) {
			int cles =((int) iterator.next());
			attaqueUnitTrie.add(resultAttaque.get(cles));
		}
		
		
		ArrayList<Unit> defenseUnitTrie= new ArrayList<>();
		Set<Integer> setbis=resultAttaque.keySet();
		Iterator<Integer> iteratorbis =setbis.iterator();
		while(iteratorbis.hasNext()) {
			int cles =((int) iteratorbis.next());
			defenseUnitTrie.add(resultAttaque.get(cles));
		}
		
		JLabel lblAtt1 = new JLabel(attaqueUnitTrie.get(attaqueUnitTrie.size()-1).getNom());
		lblAtt1.setBounds(59, 60, 46, 14);
		panelAttack.add(lblAtt1);
		
		JLabel Att1 = new JLabel(String.valueOf(attaqueUnitTrie.get(attaqueUnitTrie.size()-1).getScore()));
		Att1.setHorizontalAlignment(SwingConstants.CENTER);
		Att1.setBounds(96, 60, 76, 14);
		panelAttack.add(Att1);
		
		JLabel lblDef1 = new JLabel(defenseUnitTrie.get(defenseUnitTrie.size()-1).getNom());
		lblDef1.setBounds(299, 60, 46, 14);
		panelAttack.add(lblDef1);
		
		JLabel Def1 = new JLabel(String.valueOf(attaqueUnitTrie.get(defenseUnitTrie.size()-1)));
		Def1.setHorizontalAlignment(SwingConstants.CENTER);
		Def1.setBounds(220, 60, 73, 14);
		panelAttack.add(Def1);
		
		if(attaqueUnitTrie.size()==2) {
			JLabel lblAtt2 = new JLabel(attaqueUnitTrie.get(0).getNom());
			lblAtt2.setBounds(59, 85, 46, 14);
			panelAttack.add(lblAtt2);
			
			JLabel Att2 = new JLabel(String.valueOf(attaqueUnitTrie.get(0).getScore()));
			Att2.setHorizontalAlignment(SwingConstants.CENTER);
			Att2.setBounds(99, 85, 73, 14);
			panelAttack.add(Att2);
		}
		
		if(attaqueUnitTrie.size()==3) {
			JLabel lblAtt2 = new JLabel(attaqueUnitTrie.get(1).getNom());
			lblAtt2.setBounds(59, 85, 46, 14);
			panelAttack.add(lblAtt2);
			
			JLabel Att2 = new JLabel(String.valueOf(attaqueUnitTrie.get(1).getScore()));
			Att2.setHorizontalAlignment(SwingConstants.CENTER);
			Att2.setBounds(99, 85, 73, 14);
			panelAttack.add(Att2);
			
			JLabel lblAtt3 = new JLabel(attaqueUnitTrie.get(0).getNom());
			lblAtt3.setBounds(59, 110, 46, 14);
			panelAttack.add(lblAtt3);
			
			JLabel Att3 = new JLabel(String.valueOf(attaqueUnitTrie.get(0).getScore()));
			Att3.setHorizontalAlignment(SwingConstants.CENTER);
			Att3.setBounds(99, 112, 73, 14);
			panelAttack.add(Att3);
			
		}
		if(defenseUnitTrie.size()==2) {
			JLabel lblDef2 = new JLabel(defenseUnitTrie.get(0).getNom());
			lblDef2.setBounds(299, 85, 46, 14);
			panelAttack.add(lblDef2);
			
			JLabel Def2 = new JLabel(String.valueOf(defenseUnitTrie.get(0).getScore()));
			Def2.setHorizontalAlignment(SwingConstants.CENTER);
			Def2.setBounds(223, 85, 73, 14);
			panelAttack.add(Def2);
		}
		int attaqueTour=0;
		while(attaqueTour<2) {
			if(resultAttaque.get(resultAttaque.lastKey()).getScore()>resultDefense.get(resultDefense.lastKey()).getScore()) {
				
			
				int unitIDDefenseSupp =resultDefense.get(resultDefense.lastKey()).getIdUnit();
				for (int i=0; i< choixTerrDestT.getArmeList().size();i++) {
					if(choixTerrDestT.getArmeList().get(i).getIdUnit()== unitIDDefenseSupp) {
						choixTerrDestT.getArmeList().remove(i);
						break;
					}
				}

				resultDefense.remove(resultAttaque.lastKey());

				if(resultDefense.isEmpty()) {
					/*Terrioire possede par attaquant */
					while(!resultAttaque.isEmpty()) {
						int unitIDAttaqueMoove=resultAttaque.get(resultAttaque.lastKey()).getIdUnit();
						for (int j=0; j< choixTerrDestT.getArmeList().size();j++) {
							if(choixTerrOrigineT.getArmeList().get(j).getIdUnit()== unitIDAttaqueMoove) {
								choixTerrDestT.getArmeList().add(choixTerrOrigineT.getArmeList().get(j));
								choixTerrOrigineT.getArmeList().remove(j);

								break;
							}
						}
						resultAttaque.remove(resultAttaque.lastKey());
					}
					break;
				}
				resultAttaque.remove(resultAttaque.lastKey());
				attaqueTour=attaqueTour+1;
			}
			if(resultAttaque.get(resultAttaque.lastKey()).getScore()<=resultDefense.get(resultDefense.lastKey()).getScore()) {
				int unitIDAttaqueSupp =resultDefense.get(resultAttaque.lastKey()).getIdUnit();

				for (int i=0; i< choixTerrDestT.getArmeList().size();i++) {
					if(choixTerrOrigineT.getArmeList().get(i).getIdUnit()== unitIDAttaqueSupp) {
						choixTerrOrigineT.getArmeList().remove(i);
						break;
					}
				}
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
