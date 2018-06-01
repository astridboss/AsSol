package jeu;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
//import com.jgoodies.forms.factories.DefaultComponentFactory;
import java.awt.event.*;
import java.io.IOException;

/**
 * MENU DU JEU
 * @parameter nbrJoueur
 * @parameter nbrIA
 */

public class MenuJeu {
	
	/*__ATTRIBUTS___________________________________________________*/
	public JFrame fenetre;
	private JPanel contentPaneMenu;
	public int nbrJoueur;
	private int nbrIA;
	
	/*__METHODES____________________________________________________*/
	
	//CONSTRUCTEUR
	public MenuJeu () {
		
	}
	
	//AFFICHAGE MENU ET CHOIX JOUEUR
	public void Menu () {
		
		/**CREATION DE LA FENETRE PRINCIPALE*/
		fenetre = new JFrame ("RISK'ISEP");
		fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		fenetre.setBounds(100, 100, 634, 442);
		fenetre.setVisible(true);
		
		/**CREATION DE LA ZONE DE CONTENUE DU MENU*/
		contentPaneMenu = new JPanel();
		contentPaneMenu.setLayout(null);
		fenetre.setContentPane(contentPaneMenu);
			
		/**TITRE*/
		JLabel titrejeux = new JLabel("Bienvenue sur RISK'ISEP");
		titrejeux.setHorizontalAlignment(SwingConstants.CENTER);
		titrejeux.setFont(new Font("Goudy Old Style", Font.PLAIN, 25));
		titrejeux.setBounds(16, 11, 592, 30);
		contentPaneMenu.add(titrejeux);
		
		/**IMAGE DE L'ACCUEIL*/
		JLabel imageAcceuil = new JLabel("");
		imageAcceuil.setIcon(new ImageIcon(MenuJeu.class.getResource("/Images/Image_accueil.jpg")));
		imageAcceuil.setBounds(16, 138, 230, 151);
		contentPaneMenu.add(imageAcceuil);
		
		/**OBTENTION DU NBR DE JOUEUR ET IA*/
		JLabel lblNbrJoueur = new JLabel("Nombre de joueur :");
		lblNbrJoueur.setBounds(256, 148, 118, 14);
		contentPaneMenu.add(lblNbrJoueur);
		
		JLabel lblNbrIA = new JLabel("Nombre d'IA :");
		lblNbrIA.setBounds(256, 206, 101, 14);
		contentPaneMenu.add(lblNbrIA);
		
		JSpinner spinner_NbrJoueur = new JSpinner();
		spinner_NbrJoueur.setModel(new SpinnerNumberModel(2, 2, 6, 1));
		spinner_NbrJoueur.setBounds(372, 144, 76, 23);
		contentPaneMenu.add(spinner_NbrJoueur);
		
		JSpinner spinner_NbrIA = new JSpinner();
		spinner_NbrIA.setModel(new SpinnerNumberModel(0, 0, 1, 1));
		spinner_NbrIA.setBounds(372, 202, 76, 23);
		contentPaneMenu.add(spinner_NbrIA);
		
		/**BOUTON JOUER + ACTION APRES CLIC DE SOURIS*/
		JButton btnJouer = new JButton("JOUER");
		btnJouer.setBounds(496, 266, 89, 23);
		contentPaneMenu.add(btnJouer);		
				
		btnJouer.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				nbrJoueur = ((Integer)spinner_NbrJoueur.getValue()).intValue();
				nbrIA = ((Integer)spinner_NbrIA.getValue()).intValue();
				
				System.out.println("Nombre Joueur dans Menu : " +spinner_NbrJoueur.getValue());
				
				fenetre.remove(contentPaneMenu);
				fenetre.validate();
		        fenetre.repaint();

		        
		        /**DIRECTION LE FICHIER PRINCIPAL DU JEU : PARTIE*/
		        try {
					new Partie(nbrJoueur, fenetre);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		
		fenetre.validate();
        fenetre.repaint();
	}
	
	
	//GETTERS & SETTERS
	public int getNbrJoueur() {
		return nbrJoueur;
	}

	public void setNbrJoueur(int nbrJoueur) {
		this.nbrJoueur = nbrJoueur;
	}

	public int getNbrIA() {
		return nbrIA;
	}

	public void setNbrIA(int nbrIA) {
		this.nbrIA = nbrIA;
	}


	public JPanel getContentPaneMenu () {
		return contentPaneMenu;
	}


	public void setContentPaneMenu (JPanel contentPane) {
		this.contentPaneMenu = contentPane;
	}


	public JFrame getFenetre() {
		return fenetre;
	}


	public void setFenetre(JFrame fenetre) {
		this.fenetre = fenetre;
	}
}