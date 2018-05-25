//Librairie utilisees
import java.awt.BorderLayout;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JEditorPane;
import javax.swing.JSpinner;
import javax.swing.JList;
import javax.swing.JScrollBar;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Toolkit;
import java.awt.Dimension;
import javax.swing.JPopupMenu;
import java.awt.Component;

import java.io.*;
import java.awt.*;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.awt.peer.SystemTrayPeer;

// Interface 3 : plateau du jeu
public class IHM3carte extends JFrame {

	private JPanel contentPane;
	/**
	 * Create the frame.
	 */
	public IHM3carte (int nbrJoueur) throws IOException {
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
		BufferedImage maps = ImageIO.read(file);
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
				
				Color current_color = robot.getPixelColor(xPos, yPos);
				System.out.println(current_color);
				
				Pays pays = new Pays();
				pays = triePays(current_color);
				System.out.println("Vous avez cliqu� sur" + pays.nomPays);
				
			}
		});
		map.setVerticalAlignment(SwingConstants.TOP);
		map.setIcon(new ImageIcon(maps));
		map.setBounds(10, 0, 900, 487);
		contentPane.add(map);
		
		
		
	}
	

	
	
	public Pays triePays (Color colorPixelClick) {
		Pays pays = new Pays();
		
		return pays;
		
		
	}
	
}
