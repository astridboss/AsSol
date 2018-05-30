package jeu;

import java.awt.Color;
import java.awt.Dimension;
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
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;


// (default package)


/**
 * FICHIER PRINCIPALE DU JEU
 */

public class maps extends JFrame {


	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/*__ATTRIBUTS___________________________________________________*/
	private JPanel contentPane;
	private Color current_color;
	private BufferedImage maps;


	/*__METHODES___________________________________________________*/
	public maps (int nbrJoueur, ArrayList<Territoire> territoireList) throws IOException {

		//recuperer la taille de l'ecran
		Dimension dimension = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
		int height = (int)dimension.getHeight();
		int width  = (int)dimension.getWidth();

		// creer une fenetre au dimension de l'ecran
		/*setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, width, height);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);*/

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

				/*Robot robot = null;
				try {
					robot = new Robot ();

				} catch (Exception e2) {
					e2.printStackTrace ();
				}*/

				//current_color = robot.getPixelColor(xPos, yPos);
				//System.out.println(current_color);
				
				int couleurTerritoire = maps.getRGB(yPos, xPos);
				System.out.println("Couleur = " + couleurTerritoire);

				//Territoire territoireActuel = Territoire.territoireClic (current_color, territoireList);

				//System.out.println("Vous êtes en : " + territoireActuel.getNomT());	


			}
		});

		map.setVerticalAlignment(SwingConstants.TOP);
		map.setIcon(new ImageIcon(maps));
		map.setBounds(10, 0, 900, 487);
		contentPane.add(map);

	}

}
