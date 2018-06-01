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
