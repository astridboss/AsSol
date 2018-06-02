package jeu;

import java.awt.Button;
import java.awt.Canvas;
import java.awt.Choice;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.MouseInfo;
import java.awt.Panel;
import java.awt.Robot;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.nio.Buffer;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.security.auth.x500.X500Principal;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.SpinnerNumberModel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;


/**
 * FICHIER PRINCIPALE DU JEU
 */

public class Partie {


	/*__ATTRIBUTS___________________________________________________*/
	public ArrayList<Territoire> territoireArrayList;
	public ArrayList<Joueur> joueurList;
	
	public JPanel contentPaneJeu;
	private JPanel panelInfoT;
	
	private JLabel map;
	private JLabel lblProprio;
	private JLabel lblVariablenompays;
	private JLabel nbrSoldat;
	private JLabel nbrCav;
	private JLabel nbrCanon;
	
	
	private Color current_color;
	private BufferedImage maps;


	/*__METHODES___________________________________________________*/
	public Partie (int nbrJoueur, JFrame fenetre) throws IOException {
		
		//INIT TERRITOIRE
		territoireArrayList = new ArrayList<Territoire>();
		territoireArrayList = Territoire.initTerritoire();
				
		//INIT JOUEUR
		ArrayList<Joueur> joueurList = new ArrayList<>();
		joueurList = Joueur.initJoueur(nbrJoueur);
		

		//REPARTITION DES TERRITOIRES ENTRE LES JOUEURS
		Territoire.distributionTerritoire (territoireArrayList, joueurList);
		
		//AFFICHER LA CARTE
		map(fenetre, joueurList, territoireArrayList);
		
	}
	
	//MISE EN PLACE DE LA CARTE
	public void map (JFrame fenetre, ArrayList<Joueur> joueurList, ArrayList<Territoire> territoireList) throws IOException {
		
		/**DIMENTIONNEMENT DE LA FENETRE*/
		Dimension dimension = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
		int height = (int)dimension.getHeight();
		int width  = (int)dimension.getWidth();

		fenetre.setBounds(100, 100, width, height);
		
		/**CREATION DU CONTENEUR PRINCIPAL*/
		contentPaneJeu = new JPanel();
		fenetre.setContentPane(contentPaneJeu);
		contentPaneJeu.setLayout(null);
		
		/**INFORMATION BONUS CONQUETE ET NBR JOUEUR*/
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
		
		/**INFORMATION TERRITOIRE : LABEL */
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
		lblProprio.setBounds(136, 27, 34, 14);
		panelInfoT.add(lblProprio);
		
		nbrSoldat = new JLabel(" ");
		nbrSoldat.setBounds(235, 27, 12, 14);
		panelInfoT.add(nbrSoldat);
		
		nbrCav = new JLabel(" ");
		nbrCav.setBounds(290, 27, 12, 14);
		panelInfoT.add(nbrCav);
		
		nbrCanon = new JLabel(" ");
		nbrCanon.setBounds(366, 27, 12, 14);
		panelInfoT.add(nbrCanon);
		

		/**IMAGE : INSERTION ET AFFICHAGE*/
		File file = new File("src/Images/carte_mondeV3.png");
		maps = ImageIO.read(file);
		
		/**IMAGE : CHANGEMENT DE COULEUR*/
		chgmCouleurT (territoireArrayList, joueurList, maps);
	
		map = new JLabel("");
		map.setIcon(new ImageIcon(maps));
		map.setBounds(10, 0, 900, 487);
		contentPaneJeu.add(map);
		
		
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
		choixTerrOrigine.add("Territoire 1");
		choixTerrOrigine.add("Territoire 2");
		choixTerrOrigine.add("Territoire 3");
		
		
		Choice choixTerrDest = new Choice();
		choixTerrDest.setBounds(55, 131, 200, 20);
		panelDeplacement.add(choixTerrDest);
		choixTerrDest.add("Territoire 1");
		choixTerrDest.add("Territoire 2");
		choixTerrDest.add("Territoire 3");
		
		
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
		map.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked (MouseEvent e) {
				/**INFORMATION TERRITOIRE : AU CLIC DE SOURIS*/
				int  xPos = (int) (e.getX());
			    int  yPos = (int) (e.getY());
			    System.out.println("Cursor: " + xPos + ", " + yPos);
			    
			    Territoire paysSelect = Territoire.territoireDetection (xPos, yPos, territoireList);
			    //System.out.println("ICI : " + paysSelect.getNomT());
			    
			    if (paysSelect != null) {
			    	lblVariablenompays.setText(paysSelect.getNomT());
			    	lblProprio.setText(paysSelect.getProprietaireT());
			    	nbrSoldat.setText(String.valueOf(paysSelect.getSoldatT()));
			    	nbrCav.setText(String.valueOf(paysSelect.getCavalierT()));
			    	nbrCanon.setText(String.valueOf(paysSelect.getCanonT()));
					
					fenetre.revalidate();
					fenetre.repaint();	
					
			    }		
			} 
		});
		
		/**INFORMATION UNITES : DETAIL DU NOMBRE UNITE*/
		JLabel lblUnits = new JLabel("Unit\u00E9s");
		lblUnits.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblUnits.setBounds(1056, 73, 46, 14);
		contentPaneJeu.add(lblUnits);
		
		JLabel nbrUnite = new JLabel("35");
		nbrUnite.setFont(new Font("Stencil", Font.PLAIN, 21));
		nbrUnite.setBounds(1067, 93, 34, 23);
		contentPaneJeu.add(nbrUnite);
		
		fenetre.validate();
        fenetre.repaint();
	}
	
	/*__FONCTION_CHANGEMENT_COULEUR_____________________-___________________*/
		
	public void chgmCouleurT (ArrayList<Territoire> territoireArrayList, ArrayList<Joueur> joueurList, BufferedImage map) {
		for (int iT = 0; iT < territoireArrayList.size(); iT++) {
			for (int iJ = 0; iJ < joueurList.size(); iJ++) {
				if (territoireArrayList.get(iT).getProprietaireT() == joueurList.get(iJ).getNomJoueur()) {
					//Color pixel = joueurList.get(iJ).getCouleur();
					
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

	public BufferedImage getMaps() {
		return maps;
	}

	public void setMaps(BufferedImage maps) {
		this.maps = maps;
	}

	public Color getCurrent_color() {
		return current_color;
	}

	public void setCurrent_color(Color current_color) {
		this.current_color = current_color;
	}



}



