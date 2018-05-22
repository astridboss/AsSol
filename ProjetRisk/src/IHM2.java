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

public class IHM2 extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					IHM2 frame = new IHM2();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}*/

	/**
	 * Create the frame.
	 */
	public IHM2(int nbreJoueur, int nbrIA) {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 663, 489);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label = new JLabel("Bienvenue sur RISK'ISEP");
		label.setBounds(5, 5, 619, 31);
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setFont(new Font("Goudy Old Style", Font.PLAIN, 25));
		label.setBackground(Color.WHITE);
		contentPane.add(label);
		
		JLabel lblNewLabel = new JLabel("Veuillez choisir une couleur :");
		lblNewLabel.setBounds(31, 71, 198, 31);
		contentPane.add(lblNewLabel);
		
		JLabel lblBleu = new JLabel("");
		lblBleu.setIcon(new ImageIcon(IHM2.class.getResource("/Images/bleu.jpg")));
		lblBleu.setBounds(262, 71, 61, 47);
		contentPane.add(lblBleu);
		
		if (nbreJoueur >= 2) {
		JLabel lblRouge = new JLabel("");
		lblRouge.setIcon(new ImageIcon(IHM2.class.getResource("/Images/rouge.jpg")));
		lblRouge.setBounds(262, 129, 61, 47);
		contentPane.add(lblRouge);
		}
		if (nbreJoueur >= 3) {
		JLabel lblViolet = new JLabel("");
		lblViolet.setIcon(new ImageIcon(IHM2.class.getResource("/Images/violet.JPG")));
		lblViolet.setBounds(262, 187, 61, 47);
		contentPane.add(lblViolet);
		}
		if (nbreJoueur >= 4) {
		JLabel lblJaune = new JLabel("");
		lblJaune.setIcon(new ImageIcon(IHM2.class.getResource("/Images/jaune.jpg")));
		lblJaune.setBounds(262, 245, 61, 47);
		contentPane.add(lblJaune);
		}
		if (nbreJoueur >= 5) {
		JLabel lblOrange = new JLabel("");
		lblOrange.setIcon(new ImageIcon(IHM2.class.getResource("/Images/orange.jpg")));
		lblOrange.setBounds(262, 303, 61, 47);
		contentPane.add(lblOrange);
		}
		if (nbreJoueur >= 6) {
		JLabel lblVert = new JLabel("");
		lblVert.setIcon(new ImageIcon(IHM2.class.getResource("/Images/vert.jpg")));
		lblVert.setBounds(262, 361, 61, 47);
		contentPane.add(lblVert);
		}
		
		JButton btnLancerLeJeu = new JButton("Lancer le jeu !");
		btnLancerLeJeu.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				IHM3carte map = new IHM3carte (nbreJoueur);
				map.setVisible(true);
				dispose ();
			}
		});
		btnLancerLeJeu.setBounds(461, 206, 125, 47);
		contentPane.add(btnLancerLeJeu);
	}
}
