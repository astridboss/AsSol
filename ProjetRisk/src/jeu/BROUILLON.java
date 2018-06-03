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




/*Merdouille Astrid;

boolean unite = false;
						while (!unite){
							int [] nbSoldatAttaque = new int[this.getTerritoire().getSoldatT()+1];
							StdDraw.disableDoubleBuffering();
							StdDraw.clear();
							StdDraw.text(50,60,"How many soldiers do you want to attack ?");
							StdDraw.text(40,55,"Number of soldiers : ");
							for(int it=0;it<=this.getTerritory().getNbSoldier();it++){
								StdDraw.text((45+it*2)+2,55, String.valueOf(it));
								xTextSoldier[it] = (45+it*2)+2;
							}
							StdDraw.show();
							boolean numberOfSoldiersChosen = false;
							int nbSoldierAttacker = 0;
							while (!numberOfSoldiersChosen){
								if (StdDraw.isMousePressed()){
									double xSoldier = StdDraw.mouseX();
									double ySoldier = StdDraw.mouseY();
									if((ySoldier>=53.7 && ySoldier<=56.3)){
										for (int k=0; k<=this.getTerritory().getNbSoldier();k++){
											if((xSoldier>=xTextSoldier[k]-1.1) && (xSoldier<=xTextSoldier[k]+1.1)){
												nbSoldierAttacker = k;
												numberOfSoldiersChosen = true;
											}
										}
									}
									StdDraw.pause(90);
								}
							}

							if (this.getTerritory().getNbSoldier()<nbSoldierAttacker){
								StdDraw.disableDoubleBuffering();
								StdDraw.clear();
								StdDraw.text(50,50,"Not enough soldiers");
								StdDraw.show();
								StdDraw.pause(1500);
							}
							this.setNbSoldier(nbSoldierAttacker);



							int [] xTextCavalier = new int[this.getTerritory().getNbCavalery()+1];
							StdDraw.disableDoubleBuffering();
							StdDraw.clear();
							StdDraw.text(50,60,"How many cavaliers do you want to attack ?");
							StdDraw.text(40,55,"Number of cavaliers : ");
							for(int it=0;it<=this.getTerritory().getNbCavalery();it++){
								StdDraw.text((45+it*2)+2,55, String.valueOf(it));
								xTextCavalier[it] = (45+it*2)+2;
							}
							StdDraw.show();
							boolean numberOfCavaliersChosen = false;
							int nbCavaleryAttacker = 0;
							while (!numberOfCavaliersChosen){
								if (StdDraw.isMousePressed()){
									double xCavalery = StdDraw.mouseX();
									double yCavalery = StdDraw.mouseY();
									if(yCavalery>=53.7 && yCavalery<=56.3){
										for (int k=0; k<=this.getTerritory().getNbCavalery();k++){
											if(xCavalery>=xTextCavalier[k]-0.1 && xCavalery<=xTextCavalier[k]+0.1){
												nbCavaleryAttacker = k;
												numberOfCavaliersChosen = true;
											}
										}
									}
									StdDraw.pause(200);
								}
							}

							if (this.getTerritory().getNbCavalery()<nbCavaleryAttacker){
								StdDraw.disableDoubleBuffering();
								StdDraw.clear();
								StdDraw.text(50,50,"Not enough cavaliers");
								StdDraw.show();
								StdDraw.pause(1500);
							}
							this.setNbCavalery(nbCavaleryAttacker);



							int [] xTextCanon = new int[this.getTerritory().getNbCanon()+1];
							StdDraw.disableDoubleBuffering();
							StdDraw.clear();
							StdDraw.text(50,60,"How many canons do you want to attack ?");
							StdDraw.text(40,55,"Number of canons : ");
							for(int it=0;it<=this.getTerritory().getNbCanon();it++){
								StdDraw.text((45+it*2)+2,55, String.valueOf(it));
								xTextCanon[it] = (45+it*2)+2;
							}
							StdDraw.show();
							boolean numberOfCanonChosen = false;
							int nbCanonAttacker = 0;
							while (!numberOfCanonChosen){
								if (StdDraw.isMousePressed()){
									double xCanon = StdDraw.mouseX();
									double yCanon = StdDraw.mouseY();
									if(yCanon>=53.7 && yCanon<=56.3){
										for (int k=0; k<=this.getTerritory().getNbCanon();k++){
											if(xCanon>=xTextCanon[k]-1.1 && xCanon<=xTextCanon[k]+1.1){
												nbCanonAttacker = k;
												numberOfCanonChosen = true;
											}
										}
									}
									StdDraw.pause(200);
								}
							}

							if (this.getTerritory().getNbCanon()<nbCanonAttacker){
								StdDraw.disableDoubleBuffering();
								StdDraw.clear();
								StdDraw.text(50,50,"Not enough canons");
								StdDraw.show();
								StdDraw.pause(1500);
							}
							this.setNbCanon(nbCanonAttacker);


							if ((this.getNbSoldier() + this.getNbCavalery() + this.getNbCanon()) ==0){
								StdDraw.disableDoubleBuffering();
								StdDraw.clear();
								StdDraw.text(50,50,"You need to at least chose one unit ");
								StdDraw.show();
								StdDraw.pause(1500);
							}

							else if ((this.getNbSoldier() + this.getNbCavalery() + this.getNbCanon()) > 3){
								StdDraw.disableDoubleBuffering();
								StdDraw.clear();
								StdDraw.text(50,50,"You cannot choose more than three units ");
								StdDraw.show();
								StdDraw.pause(1500);
							}

							else if ((this.getNbSoldier() + this.getNbCavalery() + this.getNbCanon()) >= (this.getTerritory().getNbCanon()+this.getTerritory().getNbSoldier()+this.getTerritory().getNbCavalery() )){
								StdDraw.disableDoubleBuffering();
								StdDraw.clear();
								StdDraw.text(50,50,"At least one unit needs to stay in the territory ");
								StdDraw.show();
								StdDraw.pause(1500);
								return false;
							}
							else{
								unitsChosen = true;
								this.territory.setNbSoldier(this.territory.getNbSoldier()-nbSoldierAttacker); // on retire les troupes qui partent au combat de leur territoire de base
								this.territory.setNbCavalery(this.territory.getNbCavalery()-nbCavaleryAttacker);
								this.territory.setNbCanon(this.territory.getNbCanon()-nbCanonAttacker);
							}

						}

						return unitsChosen;

			}

			if (this.getTerritory().getNbCanon()<nbCanonAttacker){
				StdDraw.disableDoubleBuffering();
				StdDraw.clear();
				StdDraw.text(50,50,"Not enough canons");
				StdDraw.show();
				StdDraw.pause(1500);
			}
			this.setNbCanon(nbCanonAttacker);


			if ((this.getNbSoldier() + this.getNbCavalery() + this.getNbCanon()) ==0){
				StdDraw.disableDoubleBuffering();
				StdDraw.clear();
				StdDraw.text(50,50,"You need to at least chose one unit ");
				StdDraw.show();
				StdDraw.pause(1500);
			}

			else if ((this.getNbSoldier() + this.getNbCavalery() + this.getNbCanon()) > 3){
				StdDraw.disableDoubleBuffering();
				StdDraw.clear();
				StdDraw.text(50,50,"You cannot choose more than three units ");
				StdDraw.show();
				StdDraw.pause(1500);
			}

			else if ((this.getNbSoldier() + this.getNbCavalery() + this.getNbCanon()) >= (this.getTerritory().getNbCanon()+this.getTerritory().getNbSoldier()+this.getTerritory().getNbCavalery() )){
				StdDraw.disableDoubleBuffering();
				StdDraw.clear();
				StdDraw.text(50,50,"At least one unit needs to stay in the territory ");
				StdDraw.show();
				StdDraw.pause(1500);
				return false;
			}
			else{
				unitsChosen = true;
				this.territory.setNbSoldier(this.territory.getNbSoldier()-nbSoldierAttacker); // on retire les troupes qui partent au combat de leur territoire de base
				this.territory.setNbCavalery(this.territory.getNbCavalery()-nbCavaleryAttacker);
				this.territory.setNbCanon(this.territory.getNbCanon()-nbCanonAttacker);
			}

		}

		return unitsChosen;
		*/


































