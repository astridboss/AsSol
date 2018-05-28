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
import java.util.ArrayList;
import java.awt.*;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.awt.peer.SystemTrayPeer;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 * INTERFACE : plateau de jeu
 * 
 *
 */

public class IHM3carte extends JFrame {
	
	/*__ATTRIBUTS___________________________________________________*/
	private JPanel contentPane;
	private JTable table;

	/*__METHODES____________________________________________________*/
	
	//CONSTRUCTEUR
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
				//System.out.println(current_color);
				
				ArrayList<Territoire> mondeT = Territoire.getMondeT();
				System.out.println(current_color);
				System.out.println(mondeT.get(2));
				
				for (int i = 0 ; i < mondeT.size() ; i++) {
					System.out.println("Dans la boucle if");
					if (current_color == mondeT.get(i).getCouleurT()) {
						Territoire territoire = mondeT.get(i);
						System.out.println("Vous êtes sur le: " + territoire.getNomT());
						
					}}
				
				
				
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
		iconSoldat.setIcon(new ImageIcon(IHM3carte.class.getResource("/Images/IconSoldat.PNG")));
		iconSoldat.setBounds(20, 541, 46, 78);
		contentPane.add(iconSoldat);
		
		JLabel iconCavalier = new JLabel("");
		iconCavalier.setIcon(new ImageIcon(IHM3carte.class.getResource("/Images/IconCavalier.PNG")));
		iconCavalier.setBounds(98, 541, 57, 78);
		contentPane.add(iconCavalier);
		
		JLabel iconCanon = new JLabel("");
		iconCanon.setIcon(new ImageIcon(IHM3carte.class.getResource("/Images/IconCanon.PNG")));
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
}
