package jeu;

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
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
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
	//private JTable table;
	private Color current_color;
	private BufferedImage maps;


	/*__METHODES___________________________________________________*/
	public Partie (int nbrJoueur, JFrame fenetre) throws IOException {
		
		ArrayList<Territoire> territoireArrayList = new ArrayList<Territoire>();
		territoireArrayList = Territoire.initTerritoire();
				
		//INIT JOUEUR
		ArrayList<Joueur> joueurList = new ArrayList<>();
		joueurList = Joueur.initJoueur(nbrJoueur);
		
		System.out.println("Boucle créer : " + joueurList);

		//REPARTITION DES TERRITOIRES ENTRE LES JOUEURS
		
		map(fenetre, joueurList, territoireArrayList);
		
	}
	
	//MISE EN PLACE DE LA CARTE
	public void map (JFrame fenetre, ArrayList<Joueur> nbrJoueur, ArrayList<Territoire> territoireList) throws IOException {

		Dimension dimension = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
		int height = (int)dimension.getHeight();
		int width  = (int)dimension.getWidth();

		fenetre.setBounds(100, 100, width, height);
		
		contentPaneJeu = new JPanel();
		fenetre.setContentPane(contentPaneJeu);
		contentPaneJeu.setLayout(null);

		//IMAGE
		File file = new File("src/Images/carte_mondeV3.png");
		maps = ImageIO.read(file);
	
		JLabel map = new JLabel("");
		map.setIcon(new ImageIcon(maps));
		map.setBounds(10, 0, 900, 487);
		contentPaneJeu.add(map);
		
		map.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked (MouseEvent e) {
				int  xPos = (int) (e.getX());
			    int  yPos = (int) (e.getY());
			    System.out.println("Cursor: " + xPos + ", " + yPos);
			    
			    Territoire paysSelect = Territoire.territoireDetection(xPos, yPos, territoireList);
			    
			    if (paysSelect != null) {
				    //TABLEAU INFORMATION PAYS SELECTIONNE / APPROCHER
					JLabel tabInfo_NomT = new JLabel("Nom du pays");
					tabInfo_NomT.setFont(new Font("Tahoma", Font.BOLD, 13));
					tabInfo_NomT.setBounds(10, 510, 113, 23);
					contentPaneJeu.add(tabInfo_NomT);
				
					JLabel TabInfo_Proprio = new JLabel("Propri\u00E9taire");
					TabInfo_Proprio.setFont(new Font("Tahoma", Font.BOLD, 13));
					TabInfo_Proprio.setBounds(117, 514, 92, 14);
					contentPaneJeu.add(TabInfo_Proprio);
					
					JLabel TabInfo_Soldat = new JLabel("Soldat");
					TabInfo_Soldat.setFont(new Font("Tahoma", Font.BOLD, 13));
					TabInfo_Soldat.setBounds(219, 514, 46, 14);
					contentPaneJeu.add(TabInfo_Soldat);
					
					JLabel TabInfo_Cavalier = new JLabel("Cavalier");
					TabInfo_Cavalier.setFont(new Font("Tahoma", Font.BOLD, 13));
					TabInfo_Cavalier.setBounds(282, 514, 61, 14);
					contentPaneJeu.add(TabInfo_Cavalier);
					
					JLabel TabInfo_Canon = new JLabel("Canon");
					TabInfo_Canon.setFont(new Font("Tahoma", Font.BOLD, 13));
					TabInfo_Canon.setBounds(353, 514, 46, 14);
					contentPaneJeu.add(TabInfo_Canon);
					
					JLabel lblVariablenompays = new JLabel(paysSelect.getNomT());
					lblVariablenompays.setBounds(10, 539, 92, 14);
					contentPaneJeu.add(lblVariablenompays);
					
					JLabel lblProprio = new JLabel(paysSelect.getProprietaireT());
					lblProprio.setBounds(127, 539, 61, 14);
					contentPaneJeu.add(lblProprio);
					
					JLabel nbrSoldat = new JLabel(String.valueOf(paysSelect.getSoldatT()));
					nbrSoldat.setBounds(229, 539, 26, 14);
					contentPaneJeu.add(nbrSoldat);
					
					JLabel nbrCav = new JLabel(String.valueOf(paysSelect.getCavalierT()));
					nbrCav.setBounds(302, 539, 26, 14);
					contentPaneJeu.add(nbrCav);
					
					JLabel nbrCanon = new JLabel(String.valueOf(paysSelect.getCanonT()));
					nbrCanon.setBounds(363, 539, 26, 14);
					contentPaneJeu.add(nbrCanon);
			    }			
			} } );
		
		
		
		fenetre.validate();
        fenetre.repaint();
        
        
		
		/*map.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				//Recupere la couleur du pixel lors du clic de souris

				int xPos = (int) MouseInfo.getPointerInfo().getLocation().getX();
				int yPos = (int) MouseInfo.getPointerInfo().getLocation().getY();

				Robot robot = null;
				try {
					robot = new Robot ();

				} catch (Exception e2) {
					e2.printStackTrace ();
				}

				current_color = robot.getPixelColor(xPos, yPos);
				System.out.println(current_color);
				int couleurTerritoire = maps.getRGB(xPos, yPos);
				System.out.println("Couleur = " + couleurTerritoire);

				Territoire territoireActuel = Territoire.territoireClic (current_color, territoireList);

				System.out.println("Vous êtes en : " + territoireActuel.getNomT());	


			}
		});*/

		
		/**

		// Label pour indiquer le joueur dont c'est le tour
		JLabel lblJoueur = new JLabel("Joueur bleu :");
		lblJoueur.setFont(new Font("Bahnschrift", Font.PLAIN, 20));
		lblJoueur.setBounds(10, 498, 124, 32);
		contentPane.add(lblJoueur);

		//Tableau pour afficher le nombre de soldat, cavalier et canon

		JLabel iconSoldat = new JLabel("");
		iconSoldat.setIcon(new ImageIcon(map.class.getResource("/Images/IconSoldat.PNG")));
		iconSoldat.setBounds(20, 541, 46, 78);
		contentPane.add(iconSoldat);

		JLabel iconCavalier = new JLabel("");
		iconCavalier.setIcon(new ImageIcon(map.class.getResource("/Images/IconCavalier.PNG")));
		iconCavalier.setBounds(98, 541, 57, 78);
		contentPane.add(iconCavalier);

		JLabel iconCanon = new JLabel("");
		iconCanon.setIcon(new ImageIcon(map.class.getResource("/Images/IconCanon.PNG")));
		iconCanon.setBounds(165, 558, 88, 52);
		contentPane.add(iconCanon);

		table = new JTable();
		table.setToolTipText("");
		table.setModel(new DefaultTableModel(
				new Object[][] {
					{new Integer(5), new Integer(4), new Integer(4)},
				},
				new String[] {
						"Soldat", "Cavalier", "Canon"
				}
				) {
			Class[] columnTypes = new Class[] {
					Integer.class, Integer.class, Integer.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		table.setBounds(10, 618, 243, 16);
		contentPane.add(table);*/


	}
	public void distributionT(Joueur joueur,int nbrJoueur, ArrayList<Territoire> territoireList,ArrayList<Joueur>joueurList) {

		int terrDist=0;

		while (terrDist>=42){
			for(int joueurIndex=0; joueurIndex<joueurList.size();joueurIndex++ ) {
				int territoireIndex= (int) Math.floor(Math.random() * 42) + 1;
				Territoire territoire = territoireList.get(territoireIndex);
				joueur.getTerritoireList.add(0, territoire);
	            joueur.setTerritoireList(joueur.getTerritoireList());
	            territoire.setProprietaireT(joueurIndex);
			}

		}


	}
	public
	

	/*public void initArmee(ArrayList<Joueur> joueurList, ArrayList<Territoire> territoireList) {

	}*/


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



