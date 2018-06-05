package jeu;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.SwingConstants;
import jeu.Territoire;
import jeu.Unit;

/**
 * FICHIER PRINCIPALE DU JEU
 */

public class Partie  {

	/*______________________________________________________________*/
	/*__ATTRIBUTS___________________________________________________*/
	
	//GENERAL
	private ArrayList<Territoire> territoireArrayList;
	private ArrayList<Joueur> joueurList;
	private JPanel contentPaneJeu;
	
	//MENU
	public JFrame fenetre;
	private JPanel contentPaneMenu;
	public int nbrJoueur;
	//private int nbrIA;
	
	
	//INFO PAYS
	private JPanel panelInfoT;
	private JLabel lblProprio;
	private JLabel lblVariablenompays;
	private JLabel nbrSoldat;
	private JLabel nbrCav;
	private JLabel nbrCanon;
	
	//IMAGE
	private JLabel map;
	private BufferedImage maps;
	
	
	//INITIALISATION
	private int indexJoueurInit;
	private Territoire territoireSelect;
	private JLabel nbrUnite;
	private JLabel lblJoueurAct;
	
	//JEU
	int indexJoueurJeu;
	JLabel LabelTerritoireOrigine;

	
	/*_____________________________________________________________*/
	/*__METHODES___________________________________________________*/
	
	/**INITIALISATION DE LA PARTIE */
	 
	public Partie () {
		
		//DIMENTIONNEMENT DE LA FENETRE PRINCIPAL
		Dimension dimension = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
		int height = (int)dimension.getHeight();
		int width  = (int)dimension.getWidth();
		
		//CREATION DE LA FENETRE PRINCIPAL
		fenetre = new JFrame ("RISK'ISEP");
		fenetre.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		fenetre.setBounds(100, 100, width, height);
		fenetre.setVisible(true);
		
		//MENU PRINCIPALE 
		Menu();
	}

	
	/** MENU PRINCIPAL */
	
	public void Menu () {
		
		//CREATION DE LA ZONE DE CONTENUE DU MENU
		contentPaneMenu = new JPanel();
		contentPaneMenu.setLayout(null);
		fenetre.setContentPane(contentPaneMenu);
		
		//TITRE
		JLabel titrejeux = new JLabel("Bienvenue sur RISK'ISEP");
		titrejeux.setHorizontalAlignment(SwingConstants.CENTER);
		titrejeux.setFont(new Font("Goudy Old Style", Font.PLAIN, 25));
		titrejeux.setBounds(16, 11, 592, 30);
		contentPaneMenu.add(titrejeux);
		
		//IMAGE DE L'ACCUEIL
		JLabel imageAcceuil = new JLabel("");
		imageAcceuil.setIcon(new ImageIcon(MenuJeu.class.getResource("/Images/Image_accueil.jpg")));
		imageAcceuil.setBounds(16, 138, 230, 151);
		contentPaneMenu.add(imageAcceuil);
		
		//OBTENTION DU NBR DE JOUEUR ET IA
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
		
		//BOUTON JOUER + ACTION APRES CLIC DE SOURIS
		JButton btnJouer = new JButton("JOUER");
		btnJouer.setBounds(496, 266, 89, 23);
		contentPaneMenu.add(btnJouer);		
				
		btnJouer.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				nbrJoueur = ((Integer)spinner_NbrJoueur.getValue()).intValue();
				//nbrIA = ((Integer)spinner_NbrIA.getValue()).intValue();
								
				fenetre.remove(contentPaneMenu);
				fenetre.validate();
		        fenetre.repaint();
		        
		      //INITALISATION DU JEU
				initialisation();
			}
		});
		fenetre.validate();
        fenetre.repaint();
	}
	


	/** INITIALISATION DU JEU : AFFICHAGE DU JEU + PLACER LES ARMEES */
	
	public void initialisation () {
		
		//INITIALISATION DES TERRITOIRES
		territoireArrayList = new ArrayList<Territoire>();
		
		try {
			territoireArrayList = Territoire.initTerritoire();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		Territoire.determinerVoisin (territoireArrayList);
				
		//INITIALISATION DES JOUEURS
		joueurList = new ArrayList<>();
		joueurList = Joueur.initJoueur(nbrJoueur);
		
		//REPARTITION DES TERRITOIRES ENTRE LES JOUEURS
		Territoire.distributionTerritoire (territoireArrayList, joueurList);
		territoireSelect = territoireArrayList.get(0);
		
		//CHANGEMENT DE LA VALEUR DE UNIT DANS JOUEUR
		for (int i = 0; i < joueurList.size(); i++) {
			int unite = joueurList.get(i).getUnit();
			unite = unite - joueurList.get(i).getTerritoireList().size();
			System.out.println("Joueur" + i + " - unite : " + unite);
			joueurList.get(i).setUnit(unite);
		}
		
		/*__________________________________________________________________*/
		
		//CREATION DU CONTENEUR PRINCIPAL
		contentPaneJeu = new JPanel();
		fenetre.setContentPane(contentPaneJeu);
		contentPaneJeu.setLayout(null);

		//INFORMATION BONUS CONQUETE ET NBR JOUEUR
		JLabel lblBonusConqute = new JLabel("Bonus conqu\u00EAte");
		lblBonusConqute.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblBonusConqute.setBounds(925, 5, 104, 14);
		contentPaneJeu.add(lblBonusConqute);
		
		Canvas bleuJ = new Canvas();
		bleuJ.setBackground(Color.BLUE);
		bleuJ.setBounds(925, 25, 26, 28);
		contentPaneJeu.add(bleuJ);
		
		JLabel bonusB = new JLabel("0");
		bonusB.setBounds(957, 42, 26, 14);
		contentPaneJeu.add(bonusB);
		
		Canvas rougeJ = new Canvas();
		rougeJ.setBackground(Color.RED);
		rougeJ.setBounds(925, 59, 26, 28);
		contentPaneJeu.add(rougeJ);
		
		JLabel bonusR = new JLabel("0");
		bonusR.setBounds(957, 73, 26, 14);
		contentPaneJeu.add(bonusR);
		
		if (joueurList.size() >= 3) {
			Canvas vertJ = new Canvas();
			vertJ.setBackground(Color.GREEN);
			vertJ.setBounds(925, 93, 26, 28);
			contentPaneJeu.add(vertJ);
			
			JLabel bonusV = new JLabel("0");
			bonusV.setBounds(957, 107, 26, 14);
			contentPaneJeu.add(bonusV);
		}
		
		if (joueurList.size() >= 4) {
			Canvas orangeJ = new Canvas();
			orangeJ.setBackground(Color.ORANGE);
			orangeJ.setBounds(925, 127, 26, 28);
			contentPaneJeu.add(orangeJ);
			
			JLabel bonusO = new JLabel("0");
			bonusO.setBounds(957, 141, 26, 14);
			contentPaneJeu.add(bonusO);
		}
		
		if (joueurList.size() >= 5) {
			Canvas magentaJ = new Canvas();
			magentaJ.setBackground(Color.MAGENTA);
			magentaJ.setBounds(925, 161, 26, 28);
			contentPaneJeu.add(magentaJ);
			
			JLabel bonusM = new JLabel("0");
			bonusM.setBounds(957, 175, 26, 14);
			contentPaneJeu.add(bonusM);
		}
		
		if (joueurList.size() >= 6) {
			Canvas jauneJ = new Canvas();
			jauneJ.setBackground(Color.YELLOW);
			jauneJ.setBounds(925, 195, 26, 28);
			contentPaneJeu.add(jauneJ);
			
			JLabel bonusJ = new JLabel("0");
			bonusJ.setBounds(957, 209, 26, 14);
			contentPaneJeu.add(bonusJ);
		}
		
		//INFORMATION TERRITOIRE : LABEL
		panelInfoT = new JPanel();
    	panelInfoT.setBounds(10, 510, 406, 50);
		contentPaneJeu.add(panelInfoT);
		panelInfoT.setLayout(null);
		
		JLabel tabInfo_NomT = new JLabel("Nom du pays");
		tabInfo_NomT.setFont(new Font("Tahoma", Font.BOLD, 13));
		tabInfo_NomT.setBounds(10, 5, 82, 16);
		panelInfoT.add(tabInfo_NomT);
	
		JLabel TabInfo_Proprio = new JLabel("Propri\u00E9taire");
		TabInfo_Proprio.setFont(new Font("Tahoma", Font.BOLD, 13));
		TabInfo_Proprio.setBounds(111, 5, 78, 16);
		panelInfoT.add(TabInfo_Proprio);
		
		JLabel TabInfo_Soldat = new JLabel("Soldat");
		TabInfo_Soldat.setFont(new Font("Tahoma", Font.BOLD, 13));
		TabInfo_Soldat.setBounds(225, 5, 41, 16);
		panelInfoT.add(TabInfo_Soldat);
		
		JLabel TabInfo_Cavalier = new JLabel("Cavalier");
		TabInfo_Cavalier.setFont(new Font("Tahoma", Font.BOLD, 13));
		TabInfo_Cavalier.setBounds(280, 5, 52, 16);
		panelInfoT.add(TabInfo_Cavalier);
		
		JLabel TabInfo_Canon = new JLabel("Canon");
		TabInfo_Canon.setFont(new Font("Tahoma", Font.BOLD, 13));
		TabInfo_Canon.setBounds(356, 5, 40, 16);
		panelInfoT.add(TabInfo_Canon);
		
		lblVariablenompays = new JLabel(" ");
		lblVariablenompays.setBounds(10, 27, 116, 14);
		panelInfoT.add(lblVariablenompays);
		
		lblProprio = new JLabel(" ");
		lblProprio.setBounds(131, 27, 82, 14);
		panelInfoT.add(lblProprio);
		
		nbrSoldat = new JLabel(" ");
		nbrSoldat.setHorizontalAlignment(SwingConstants.CENTER);
		nbrSoldat.setBounds(225, 27, 41, 14);
		panelInfoT.add(nbrSoldat);
		
		nbrCav = new JLabel(" ");
		nbrCav.setHorizontalAlignment(SwingConstants.CENTER);
		nbrCav.setBounds(280, 27, 52, 14);
		panelInfoT.add(nbrCav);
		
		nbrCanon = new JLabel(" ");
		nbrCanon.setHorizontalAlignment(SwingConstants.CENTER);
		nbrCanon.setBounds(356, 27, 40, 14);
		panelInfoT.add(nbrCanon);
		
		//INFORMATION UNITES : DETAIL DU NOMBRE UNITE
		
		JLabel lblUnits = new JLabel("Unit\u00E9s");
		lblUnits.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblUnits.setBounds(1056, 73, 46, 14);
		contentPaneJeu.add(lblUnits);
		
		nbrUnite = new JLabel(String.valueOf(joueurList.get(0).getUnit()));
		nbrUnite.setFont(new Font("Stencil", Font.PLAIN, 21));
		nbrUnite.setBounds(1067, 93, 34, 23);
		contentPaneJeu.add(nbrUnite);

		//IMAGE : INSERTION ET AFFICHAGE
		File file = new File("src/Images/carte_mondeV3.png");
		try {
			maps = ImageIO.read(file);
		} catch (IOException e1) {
			e1.printStackTrace();
		}

		//IMAGE : CHANGEMENT DE COULEUR
		chgmCouleurT (territoireArrayList, joueurList, maps);
	
		map = new JLabel("");
		map.setIcon(new ImageIcon(maps));
		map.setBounds(10, 0, 900, 487);
		contentPaneJeu.add(map);
		
		map.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked (MouseEvent e) {
				
				/**INFORMATION TERRITOIRE : AU CLIC DE SOURIS*/
				int  xPos = (int) (e.getX());
			    int  yPos = (int) (e.getY());
			    
			    territoireSelect = Territoire.territoireDetection (xPos, yPos, territoireArrayList);
			    
			    if (territoireSelect != null) {
			    	
			    	//LABEL CHOIXPAYS.SETTEXT LE NOM DU PAYS SELECT dans le bouton 
			    	// à chaque fois qu'on clique sur le bouton on remove le panel placer unit et on le recréer
			    	//placer l'init avant le bouton.
			    	
			    	int soldatNombre = 0;
			    	int cavalierNombre = 0;
			    	int canonNombre = 0;
			    	
			    	for (int i = 0; i < territoireSelect.getArmeList().size(); i++) {
			    		if (territoireSelect.getArmeList().get(i).getNom() == "Soldat") {
			    			soldatNombre = soldatNombre + 1; }
			    		
			    		if (territoireSelect.getArmeList().get(i).getNom() == "Cavalier") {
			    			cavalierNombre = cavalierNombre + 1; }
			    		
			    		if (territoireSelect.getArmeList().get(i).getNom() == "Canon") {
			    			canonNombre = canonNombre + 1; }
			    	}
			    	
			    	lblVariablenompays.setText(territoireSelect.getNomT());
			    	lblProprio.setText(territoireSelect.getJoueur().getNomJoueur());
			    	nbrSoldat.setText (Integer.toString(soldatNombre));
			    	nbrCav.setText(Integer.toString(cavalierNombre));
			    	nbrCanon.setText(Integer.toString(canonNombre));
			    	
			    	LabelTerritoireOrigine.setText(territoireSelect.getNomT());

					fenetre.revalidate();
					fenetre.repaint();
			    }		
			} 
		});
		
		
		/**INITIALISATION : PLACER LES UNITES*/
		
		indexJoueurInit = 0;
		
		lblJoueurAct = new JLabel("");
		lblJoueurAct.setHorizontalAlignment(SwingConstants.CENTER);
		lblJoueurAct.setFont(new Font("LeHavre", Font.PLAIN, 15));
		lblJoueurAct.setBounds(993, 158, 264, 28);
		contentPaneJeu.add(lblJoueurAct);
		
		fenetre.validate();
        fenetre.repaint();
        
			
		Unit placeU = new Unit();
		placeU.placerUnit (joueurList, indexJoueurInit, fenetre, contentPaneJeu, nbrUnite);
		
		lblJoueurAct.setText("Joueur " + joueurList.get(indexJoueurInit).getNomJoueur() +", c'est a vous !");
		
		JButton btnJoueurSuivant = new JButton("Joueur suivant !");
		btnJoueurSuivant.setBounds(1138, 654, 143, 37);
		contentPaneJeu.add(btnJoueurSuivant);
		btnJoueurSuivant.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				if (joueurList.get(indexJoueurInit).getUnit() == 0) {
					
					fenetre.remove(placeU.getPanelPlacerUnit());
					fenetre.validate();
				    fenetre.repaint();
					
				    indexJoueurInit = indexJoueurInit +1;
					
					if (indexJoueurInit < joueurList.size()) {
						
						lblJoueurAct.setText("Joueur " + joueurList.get(indexJoueurInit).getNomJoueur() +", c'est a vous !");
						placeU.placerUnit (joueurList, indexJoueurInit, fenetre, contentPaneJeu, nbrUnite);
						nbrUnite.setText(String.valueOf(joueurList.get(indexJoueurInit).getUnit()));
						
					} else {
						fenetre.remove(btnJoueurSuivant);
						fenetre.validate();
					    fenetre.repaint();
					    
					    indexJoueurInit = 0;
						
					    jeu ();
					}
				} else {
					JOptionPane.showMessageDialog(null, "Il vous reste des unités à placer avant de finir votre tours !", "Erreur", JOptionPane.ERROR_MESSAGE);
				}

			}
		});
	
	fenetre.validate();
    fenetre.repaint();
	
	}

	/*__FONCTION_JEU________________________________________*/
	
	public void jeu () {
		
		boolean victoire = true; //Determine if there is a victory
		indexJoueurJeu = 0;
		
		/**______ETAPE_1:_RENFORT____________________________________________________*/
		
		//AFFICHAGE DU NOM DU JOUEUR
		lblJoueurAct.setText("Joueur " + joueurList.get(indexJoueurJeu).getNomJoueur() +", c'est a vous !");
		
		//AFFICHAGE DU NOMBRE D'UNITE
		nbrUnite.setText(String.valueOf(joueurList.get(0).getUnit()));
		
		
		/**______ETAPE_2:_DEPLACEMENT____________________________________________________*/
		
		JPanel panelChoixOrigine = new JPanel();
		panelChoixOrigine.setBounds(968, 275, 293, 175);
		contentPaneJeu.add(panelChoixOrigine);
		panelChoixOrigine.setLayout(null);
		
		JLabel lblTitre = new JLabel("D\u00E9placement");
		lblTitre.setBounds(79, 11, 134, 24);
		panelChoixOrigine.add(lblTitre);
		lblTitre.setFont(new Font("LeHavre", Font.PLAIN, 17));
		
		JLabel lblEtape1 = new JLabel("1. Cliquez sur votre territoire d'origine :");
		lblEtape1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblEtape1.setBounds(10, 46, 257, 20);
		panelChoixOrigine.add(lblEtape1);
		
		LabelTerritoireOrigine = new JLabel("");
		LabelTerritoireOrigine.setHorizontalAlignment(SwingConstants.CENTER);
		LabelTerritoireOrigine.setFont(new Font("Tahoma", Font.PLAIN, 11));
		LabelTerritoireOrigine.setBounds(46, 77, 207, 28);
		panelChoixOrigine.add(LabelTerritoireOrigine);
		
		JButton btnNextVersEtape2 = new JButton("Next");
		btnNextVersEtape2.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnNextVersEtape2.setBounds(114, 129, 69, 23);
		panelChoixOrigine.add(btnNextVersEtape2);
		btnNextVersEtape2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				if (territoireSelect.getJoueur() == joueurList.get(indexJoueurJeu)) {	
					fenetre.remove(panelChoixOrigine);
					fenetre.validate();
				    fenetre.repaint();
				    
					Arme jeu = new Arme ();
					System.out.println(territoireSelect.getNomT());
					try {
						jeu.attaqueChoix( joueurList.get(indexJoueurJeu), territoireSelect, territoireArrayList, fenetre, contentPaneJeu);
					} catch (IOException e1) {
						e1.printStackTrace();
					}	
				} else {
					JOptionPane.showMessageDialog(null, "Veuillez choisir l'un de vos pays !!" , "Erreur", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		
		
		JButton btnFinTour = new JButton("Fin du tour !");
		btnFinTour.setBounds(1138, 654, 143, 37);
		contentPaneJeu.add(btnFinTour);
		btnFinTour.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				if (victoire == true) {
					JOptionPane.showMessageDialog(null, "La victoire reviens au joueur Bleu !! Félicitation !!" , "VICTOIRE", JOptionPane.INFORMATION_MESSAGE);
					fenetre.dispose();
					
				} else if (indexJoueurJeu < joueurList.size()) {
					indexJoueurJeu = indexJoueurJeu + 1;
					jeu ();
				}
			}
		});
	}
	
	/*__FONCTION_CHANGEMENT_COULEUR________________________________________*/
		
	public void chgmCouleurT (ArrayList<Territoire> territoireArrayList, ArrayList<Joueur> joueurList, BufferedImage map) {
		
		for (int iT = 0; iT < territoireArrayList.size(); iT++) {
			for (int iJ = 0; iJ < joueurList.size(); iJ++) {
				if (territoireArrayList.get(iT).getJoueur() == joueurList.get(iJ)) {
					
					for (int indice = 0; indice < territoireArrayList.get(iT).getZoneTerritoires().size(); indice ++) {			

						ArrayList<ZoneT> zoneTerritoire = territoireArrayList.get(iT).getZoneTerritoires();
						int x = zoneTerritoire.get(indice).getPosX();
						int y = zoneTerritoire.get(indice).getPosY();
						Color joueurCouleur = joueurList.get(iJ).getCouleur();
						int newColor = joueurCouleur.getRGB();
						map.setRGB(x, y, newColor);
					}
				}
			}
		}		
	}
	
	
	
	/*__GETTERS_&_SETTERS___________________________________________________*/


	public JLabel getMap() {
		return map;
	}

	public void setMap(JLabel map) {
		this.map = map;
	}

	public JLabel getNbrUnite() {
		return nbrUnite;
	}

	public void setNbrUnite(JLabel nbrUnite) {
		this.nbrUnite = nbrUnite;
	}
	
}
