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

public class IHM2 extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
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
	}

	/**
	 * Create the frame.
	 */
	public IHM2() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 645, 429);
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
		
		JLabel lblNewLabel = new JLabel("Veuillez vous r\u00E9partir les couleurs :");
		lblNewLabel.setBounds(207, 71, 217, 31);
		contentPane.add(lblNewLabel);
		
		JLabel lblBleu = new JLabel("");
		lblBleu.setIcon(new ImageIcon(IHM2.class.getResource("/Images/bleu.jpg")));
		lblBleu.setBounds(97, 118, 61, 47);
		contentPane.add(lblBleu);
		
		JLabel lblRouge = new JLabel("");
		lblRouge.setIcon(new ImageIcon(IHM2.class.getResource("/Images/rouge.jpg")));
		lblRouge.setBounds(176, 118, 61, 47);
		contentPane.add(lblRouge);
		
		JLabel lblViolet = new JLabel("");
		lblViolet.setIcon(new ImageIcon(IHM2.class.getResource("/Images/violet.JPG")));
		lblViolet.setBounds(256, 118, 61, 47);
		contentPane.add(lblViolet);
		
		JLabel lblJaune = new JLabel("");
		lblJaune.setIcon(new ImageIcon(IHM2.class.getResource("/Images/jaune.jpg")));
		lblJaune.setBounds(335, 118, 61, 47);
		contentPane.add(lblJaune);
		
		JLabel lblOrange = new JLabel("");
		lblOrange.setIcon(new ImageIcon(IHM2.class.getResource("/Images/orange.jpg")));
		lblOrange.setBounds(419, 118, 61, 47);
		contentPane.add(lblOrange);
		
		JLabel lblVert = new JLabel("");
		lblVert.setIcon(new ImageIcon(IHM2.class.getResource("/Images/vert.jpg")));
		lblVert.setBounds(500, 118, 61, 47);
		contentPane.add(lblVert);
	}
}
