package jeu;

public class BROUILLON {

}
/**
	
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
}*/
//FONCTION PLACER DANS TERRITOIRE ET REECRITRE : FONCTIONNE MAIS CERTAIN TERRITOIRE SONT DOUBLE :/
/**public void distributionT (Joueur joueur,int nbrJoueur, ArrayList<Territoire> territoireList, ArrayList<Joueur>joueurList) {

System.out.println("List : " + territoireList);

int terrDist=0;

while (terrDist>=42){
	for(int joueurIndex=0; joueurIndex < joueurList.size();joueurIndex++ ) {
		int territoireIndex= (int) Math.floor(Math.random() * 42) + 1;
		Territoire territoire = territoireList.get(territoireIndex);
		joueur.getTerritoireList().add(0, territoire);
        joueur.setTerritoireList(joueur.getTerritoireList());
        territoire.setProprietaireT(joueurList.get(joueurIndex).getNomJoueur());
	}
}
}*/


/*public void initArmee(ArrayList<Joueur> joueurList, ArrayList<Territoire> territoireList) {

}*/

/**

import java.awt.Color; 
import java.awt.Container; 
import java.awt.Dimension; 
import java.awt.Graphics; 
import java.awt.event.MouseAdapter; 
import java.awt.event.MouseEvent; 
import java.awt.image.BufferedImage; 
import javax.swing.JFrame; import javax.swing.JPanel; 
/** * Created on 07-avr.-07 * * @author: HackTrack */ 

/**public class PixelDemo extends JFrame { 
	private Container c; 
	
	public PixelDemo() { 
		super("Pixel demo"); 
		this.initialize(); 
		} 
	
	private void initialize() { 
		setDefaultCloseOperation(EXIT_ON_CLOSE); 
		c = getContentPane(); 
		JPanel panel = new DemoPanel(); 
		panel.setPreferredSize(new Dimension(320, 200)); 
		c.add(panel); } 
	
	
	class DemoPanel extends JPanel { 
		private BufferedImage img; 
		public DemoPanel() { 
			super(); 
			this.initialize(); } 
		
		private void initialize() { 
			img = new BufferedImage(320, 200, BufferedImage.TYPE_INT_ARGB); 
			addMouseListener(new MouseAdapter() { 
				public void mouseClicked(MouseEvent e) { 
					int x = e.getX(); 
					int y = e.getY(); 
					img.setRGB(x, y,Color.red.getRGB()); 
					repaint(); }}); 
			} 
		
		public void paint(Graphics g) {
			g.drawImage(img, 0, 0, null); 
			} } 
	
	
	public static void main(String[] args) { 
		PixelDemo demo = new PixelDemo(); 
		demo.pack(); 
		demo.setVisible(true); 
		} 
	}*/









































