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
import javax.swing.SwingConstants;


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
	private JLabel nbrUnite;
	
	
	private Color current_color;
	private BufferedImage maps;
	
	private int indexJoueur; /** pour l'initialisation, le placement des unités */
	Territoire territoireSelect; /**Représente le pays selectionner par le joueur sur la carte*/


	/*__METHODES___________________________________________________*/
	
	//
	public Partie (int nbrJoueur, JFrame fenetre) throws IOException {
		
		//INIT TERRITOIRE
		territoireArrayList = new ArrayList<Territoire>();
		territoireArrayList = Territoire.initTerritoire();
		
		Territoire.determinerVoisin (territoireArrayList);
				
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
		
		/**INFORMATION UNITES : DETAIL DU NOMBRE UNITE*/
		
		JLabel lblUnits = new JLabel("Unit\u00E9s");
		lblUnits.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblUnits.setBounds(1056, 73, 46, 14);
		contentPaneJeu.add(lblUnits);
		
		nbrUnite = new JLabel(String.valueOf(joueurList.get(0).getUnit()));
		nbrUnite.setFont(new Font("Stencil", Font.PLAIN, 21));
		nbrUnite.setBounds(1067, 93, 34, 23);
		contentPaneJeu.add(nbrUnite);

		/**IMAGE : INSERTION ET AFFICHAGE*/
		File file = new File("src/Images/carte_mondeV3.png");
		maps = ImageIO.read(file);
		
		/**IMAGE : CHANGEMENT DE COULEUR*/
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
			    
			    territoireSelect = Territoire.territoireDetection (xPos, yPos, territoireList);
			    
			    if (territoireSelect != null) {
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

					fenetre.revalidate();
					fenetre.repaint();
			    }		
			} 
		});
		
		
		/**INITIALISATION : PLACER LES UNITES*/
		
		indexJoueur = 0;
		
		JLabel lblJoueurAct = new JLabel("");
		lblJoueurAct.setHorizontalAlignment(SwingConstants.CENTER);
		lblJoueurAct.setFont(new Font("LeHavre", Font.PLAIN, 15));
		lblJoueurAct.setBounds(993, 158, 264, 28);
		contentPaneJeu.add(lblJoueurAct);
		
		fenetre.validate();
        fenetre.repaint();
        
			
		PlacerUnit placement = new PlacerUnit();
		placement.placerUnite (joueurList, indexJoueur, fenetre, contentPaneJeu, nbrUnite);
		
		lblJoueurAct.setText("Joueur " + joueurList.get(indexJoueur).getNomJoueur() +", c'est a vous !");
		
		JButton btnJoueurSuivant = new JButton("Joueur suivant !");
		btnJoueurSuivant.setBounds(1138, 654, 143, 37);
		contentPaneJeu.add(btnJoueurSuivant);
		btnJoueurSuivant.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				if (joueurList.get(indexJoueur).getUnit() == 0) {
					
					fenetre.remove(placement.getPanelPlacerUnit());
					fenetre.validate();
				    fenetre.repaint();
					
				    indexJoueur = indexJoueur +1;
					
					if (indexJoueur < joueurList.size()) {
						
						lblJoueurAct.setText("Joueur " + joueurList.get(indexJoueur).getNomJoueur() +", c'est a vous !");
						placement.placerUnite (joueurList, indexJoueur, fenetre, contentPaneJeu, nbrUnite);
						nbrUnite.setText(String.valueOf(joueurList.get(indexJoueur).getUnit()));
						
					} else {
						Arme jeu = new Arme ();
						try {
							jeu.attaqueChoix( joueurList.get(1), territoireArrayList, fenetre,contentPaneJeu);
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						
						
					}
				} else {
					JOptionPane.showMessageDialog(null, "Il vous reste des unités à placer avant de finir votre tours !", "Erreur", JOptionPane.ERROR_MESSAGE);
				}

			}
		});
	
	fenetre.validate();
    fenetre.repaint();

	}
	
	
	
	/*__FONCTION_CHANGEMENT_COULEUR_____________________-___________________*/
		
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

	public JLabel getNbrUnite() {
		return nbrUnite;
	}

	public void setNbrUnite(JLabel nbrUnite) {
		this.nbrUnite = nbrUnite;
	}

}



