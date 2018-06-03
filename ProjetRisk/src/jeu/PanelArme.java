package jeu;

import java.awt.Button;
import java.awt.Choice;
import java.awt.Dimension;
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
import javax.swing.SwingConstants;

public class PanelArme {
	public JFrame fenetre;
	private JPanel contentPane;
	
	public PanelArme() {
		
	}
	

	public void deplacementUnit (Joueur joueur, Partie partie)throws IOException {
		/**CREATION DE LA FENETRE PRINCIPALE*/
		fenetre = new JFrame ("RISK'ISEP");
		fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		fenetre.setBounds(100, 100, 634, 442);
		fenetre.setVisible(true);

		
		/**CREATION DE LA ZONE DE CONTENUE DU MENU*/
		contentPane = new JPanel();
		contentPane.setLayout(null);
		fenetre.setContentPane(contentPane);
		
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

		Choice choixTerrOrigine = new Choice();
		choixTerrOrigine.setBounds(55, 55, 200, 20);
		panelDeplacement.add(choixTerrOrigine);
		ArrayList<Territoire> territoireListJoueur= joueur.getTerritoireList();

		for (int i=0; i<territoireListJoueur.size();i++) {
			//Territoire territoireInit=territoireListJoueur.get(i);
			//String nomT=territoireInit.getNomT();
			choixTerrOrigine.add(territoireListJoueur.get(i).getNomT());
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
			});
	}
	
	public void panelAttack (JPanel contentPane, JFrame fenetre) {
		// création de la Jpanel
		JPanel panelAttack = new JPanel();
		panelAttack.setBounds(463, 510, 397, 181);
		contentPane.add(panelAttack);
		panelAttack.setLayout(null);
		
		// TITRE
		JLabel lblTitreAttaque = new JLabel("Attaque\r\n");
		lblTitreAttaque.setBounds(108, 0, 162, 24);
		panelAttack.add(lblTitreAttaque);
		lblTitreAttaque.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitreAttaque.setFont(new Font("LeHavre", Font.PLAIN, 17));
		
		//Label coté Attaquant
		JLabel lblAttaquant = new JLabel("Attaquant");
		lblAttaquant.setHorizontalAlignment(SwingConstants.CENTER);
		lblAttaquant.setBounds(86, 35, 86, 14);
		panelAttack.add(lblAttaquant);
		
		JLabel lblAtt1 = new JLabel("Canon");
		lblAtt1.setBounds(59, 60, 46, 14);
		panelAttack.add(lblAtt1);
		
		JLabel lblAtt2 = new JLabel("Cavalier");
		lblAtt2.setBounds(59, 85, 46, 14);
		panelAttack.add(lblAtt2);
		
		JLabel lblAtt3 = new JLabel("Soldat");
		lblAtt3.setBounds(59, 112, 46, 14);
		panelAttack.add(lblAtt3);
		
		JLabel Att1 = new JLabel("5");
		Att1.setHorizontalAlignment(SwingConstants.CENTER);
		Att1.setBounds(96, 60, 76, 14);
		panelAttack.add(Att1);
		
		JLabel Att2 = new JLabel("5");
		Att2.setHorizontalAlignment(SwingConstants.CENTER);
		Att2.setBounds(99, 85, 73, 14);
		panelAttack.add(Att2);
		
		JLabel Att3 = new JLabel("5");
		Att3.setHorizontalAlignment(SwingConstants.CENTER);
		Att3.setBounds(99, 112, 73, 14);
		panelAttack.add(Att3);
		

		//LABEL VS
		JLabel lblVs = new JLabel("VS\r\n");
		lblVs.setHorizontalAlignment(SwingConstants.CENTER);
		lblVs.setFont(new Font("LeHavre", Font.PLAIN, 17));
		lblVs.setBounds(172, 78, 41, 24);
		panelAttack.add(lblVs);
		
		
		//Physique coté defenseur
		JLabel lblDefenseur = new JLabel("Defenseur");
		lblDefenseur.setHorizontalAlignment(SwingConstants.CENTER);
		lblDefenseur.setBounds(210, 35, 86, 14);
		panelAttack.add(lblDefenseur);
		
		JLabel lblDef1 = new JLabel("Canon");
		lblDef1.setBounds(299, 60, 46, 14);
		panelAttack.add(lblDef1);
		
		JLabel lblDef2 = new JLabel("Cavalier");
		lblDef2.setBounds(299, 85, 46, 14);
		panelAttack.add(lblDef2);
		
		JLabel Def1 = new JLabel("5");
		Def1.setHorizontalAlignment(SwingConstants.CENTER);
		Def1.setBounds(220, 60, 73, 14);
		panelAttack.add(Def1);
		
		JLabel Def2 = new JLabel("5");
		Def2.setHorizontalAlignment(SwingConstants.CENTER);
		Def2.setBounds(223, 85, 73, 14);
		panelAttack.add(Def2);
		
		//Ecrire qui est le gagnant
		JLabel lblGagnant = new JLabel("Gagnant :");
		lblGagnant.setHorizontalAlignment(SwingConstants.CENTER);
		lblGagnant.setFont(new Font("LeHavre", Font.PLAIN, 17));
		lblGagnant.setBounds(76, 157, 137, 24);
		panelAttack.add(lblGagnant);
		
		JLabel lblJoueurGagnant = new JLabel("Joueur bleu");
		lblJoueurGagnant.setHorizontalAlignment(SwingConstants.CENTER);
		lblJoueurGagnant.setFont(new Font("LeHavre", Font.PLAIN, 17));
		lblJoueurGagnant.setBounds(189, 157, 198, 24);
		panelAttack.add(lblJoueurGagnant);
		
		//Mise à jour de la fenêtre
		fenetre.validate();
		fenetre.repaint();
		
		
	}
	


	public JFrame getFenetre() {
		return fenetre;
	}


	public void setFenetre(JFrame fenetre) {
		this.fenetre = fenetre;
	}


	public JPanel getContentPane() {
		return contentPane;
	}


	public void setContentPane(JPanel contentPane) {
		this.contentPane = contentPane;
	}
	
	
	
	

}

