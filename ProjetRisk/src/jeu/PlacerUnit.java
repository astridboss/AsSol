package jeu;

import java.awt.Choice;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.SwingConstants;
import javax.swing.JOptionPane;

public class PlacerUnit {
	
	
	public void placerUnite (ArrayList<Joueur> joueurList, int idJoueur,JFrame fenetre, JPanel contentPaneJeu, JLabel nbrUnite) {
		
		/**CREATION D'UN JPANEL DEDIE AU PLACEMENT DES UNITES - INTERFACE GRAPHIQUE*/
		JPanel panelPlacerUnit = new JPanel();
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

		JLabel lblSoldat_1 = new JLabel("Soldat (1U)");
		lblSoldat_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblSoldat_1.setBounds(38, 123, 74, 14);
		panelPlacerUnit.add(lblSoldat_1);
		
		JLabel lblCavalier_1 = new JLabel("Cavalier (2U)");
		lblCavalier_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblCavalier_1.setBounds(126, 123, 80, 14);
		panelPlacerUnit.add(lblCavalier_1);
		
		JLabel lblCanon_1 = new JLabel("Canon (3U)");
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
				
				int unitUtiliser = nbrSoldat + 2* nbrCavalier + 3*nbrCanon;
				
				if (unitUtiliser <= joueurList.get(idJoueur).getUnit()) {
					
					for ( int i = 0; i < joueurList.get(idJoueur).getTerritoireList().size(); i++) {
						if (choixTerr.getSelectedItem() == joueurList.get(idJoueur).getTerritoireList().get(i).getNomT())
							
							joueurList.get(idJoueur).getTerritoireList().get(i).setSoldatT(joueurList.get(idJoueur).getTerritoireList().get(i).getSoldatT() + nbrSoldat);
							joueurList.get(idJoueur).getTerritoireList().get(i).setCavalierT(joueurList.get(idJoueur).getTerritoireList().get(i).getCavalierT() + nbrCavalier);
							joueurList.get(idJoueur).getTerritoireList().get(i).setCanonT(joueurList.get(idJoueur).getTerritoireList().get(i).getCanonT() + nbrCanon);
							}
					
					joueurList.get(idJoueur).setUnit(joueurList.get(idJoueur).getUnit() - unitUtiliser);
					nbrUnite.setText (String.valueOf(joueurList.get(0).getUnit()));
				} else {
					//JOptionPane popupErreur = new JOptionPane();
					JOptionPane.showMessageDialog(null, "Hum ... On dirait que vous n'avez plus assez d'unité ... Pas d'unité, pas d'armée ! Veuillez recommencer.", "Erreur", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		
		fenetre.validate();
		fenetre.repaint();			
	}
}
	