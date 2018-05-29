package jeu;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
//import com.jgoodies.forms.factories.DefaultComponentFactory;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;

/**
 * MENU DU JEU
 * @parameter nbrJoueur
 * @parameter nbrIA
 */

public class MenuJeu extends JFrame {
	
	/*__ATTRIBUTS___________________________________________________*/
	private JPanel contentPane;
	private int nbrJoueur;
	private int nbrIA;
	private boolean fenetreFerme = false;
	private static final long serialVersionUID = 1L;
	
	/*__METHODES____________________________________________________*/
	
	//CONSTRUCTEUR
	public MenuJeu() {
		setTitle("RISK'ISEP");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 634, 442);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lbl_titrejeux = new JLabel("Bienvenue sur RISK'ISEP");
		lbl_titrejeux.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_titrejeux.setFont(new Font("Goudy Old Style", Font.PLAIN, 25));
		lbl_titrejeux.setBackground(Color.WHITE);
		lbl_titrejeux.setBounds(16, 11, 592, 30);
		contentPane.add(lbl_titrejeux);
		
		JLabel image_acceuil = new JLabel("");
		image_acceuil.setIcon(new ImageIcon(MenuJeu.class.getResource("/Images/Image_accueil.jpg")));
		image_acceuil.setBounds(16, 138, 230, 151);
		contentPane.add(image_acceuil);
		
		JLabel lblNbrJoueur = new JLabel("Nombre de joueur :");
		lblNbrJoueur.setBounds(256, 148, 118, 14);
		contentPane.add(lblNbrJoueur);
		
		JLabel lblNbrIA = new JLabel("Nombre d'IA :");
		lblNbrIA.setBounds(256, 206, 101, 14);
		contentPane.add(lblNbrIA);
		
		JSpinner spinner_NbrJoueur = new JSpinner();
		spinner_NbrJoueur.setModel(new SpinnerNumberModel(2, 2, 6, 1));
		spinner_NbrJoueur.setBounds(372, 144, 76, 23);
		contentPane.add(spinner_NbrJoueur);
		
		JSpinner spinner_NbrIA = new JSpinner();
		spinner_NbrIA.setModel(new SpinnerNumberModel(0, 0, 1, 1));
		spinner_NbrIA.setBounds(372, 202, 76, 23);
		contentPane.add(spinner_NbrIA);
		
		JButton btnJouer = new JButton("JOUER");
		btnJouer.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				fenetreFerme = true;
				//System.out.println(fenetreFerme);
				//System.out.println(spinner_NbrJoueur.getValue());
				//System.out.println(spinner_NbrIA.getValue());
				nbrJoueur = ((Integer)spinner_NbrJoueur.getValue()).intValue();
				nbrIA = ((Integer)spinner_NbrIA.getValue()).intValue();
				dispose();
			}
		});
		btnJouer.setForeground(Color.BLACK);
		btnJouer.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnJouer.setBackground(Color.LIGHT_GRAY);
		btnJouer.setBounds(496, 266, 89, 23);
		contentPane.add(btnJouer);
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
	
	public boolean getFenetreFerme() {
		return fenetreFerme;
	}

	public void setFenetreFerme(Boolean fenetreFerme) {
		this.fenetreFerme = fenetreFerme;
	}
}