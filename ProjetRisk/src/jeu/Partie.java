package jeu;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.MouseInfo;
import java.awt.Robot;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
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

// (default package)


/**
 * FICHIER PRINCIPALE DU JEU
 */

public class map extends JFrame {


	/*__ATTRIBUTS___________________________________________________*/
	private JPanel contentPane;
	private JTable table;
	private Color current_color;
	private BufferedImage maps;


	/*__METHODES___________________________________________________*/
	public void partie(int nbrJoueur) {

		
        
        ArrayList<Joueur> joueurList = new ArrayList<>();
		for (int i = 0; i < nbrJoueur; i++) { // initialisation des joueurs
			Joueur joueur = new Joueur();
			
		}

	}

	public map (int nbrJoueur, ArrayList<Territoire> territoireList) throws IOException {

		//recuperer la taille de l'ecran
		Dimension dimension = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
		int height = (int)dimension.getHeight();
		int width  = (int)dimension.getWidth();

		// creer une fenetre au dimension de l'ecran
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, width, height);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		//Creation de l'image
		File file = new File("src/Images/carte_mondeV3.png");
		maps = ImageIO.read(file);
		/**System.out.println(file.getAbsolutePath());*/


		//Afficher l'image 	
		JLabel map = new JLabel("");
		map.addMouseListener(new MouseAdapter() {
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
		});

		map.setVerticalAlignment(SwingConstants.TOP);
		map.setIcon(new ImageIcon(maps));
		map.setBounds(10, 0, 900, 487);
		contentPane.add(map);

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
		contentPane.add(table);


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
	/**
	 * 40 armées par joueur à 2 
	 * 35 armées par joueur à 3
	 * 30 armées par joueur à 4 
	 * 25 armées par joueur à 5 
	 * 20 armées par joueur à 6
	 * @param joueurList
	 */
	public void distributionUnit(ArrayList<Joueur>joueurList) {
		int unit=0;
		if(joueurList.size()==2) {
			unit=40;
			
		}
		if(joueurList.size()==3) {
			unit=35;
			
		}
		if(joueurList.size()==4) {
			unit=30;
			
		}
		if(joueurList.size()==5) {
			unit=25;
			
		}
		if(joueurList.size()==6) {
			unit=20;
			
		}
		for(int joueurIndex=0; joueurIndex<joueurList.size();joueurIndex++ ) {
			Joueur joueur = joueurList.get(joueurIndex);
			joueur.setUnit(unit);
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



