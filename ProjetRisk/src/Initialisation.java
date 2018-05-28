import java.awt.Color;
import java.util.ArrayList;
import java.util.Collection;

import java.awt.*;



public class Initialisation {

	public static void main(String[] args) {
		
		/*__CREATION_DES_PAYS_____________________________________________*/
			
		//Pays europe = [];
		
		Collection<Pays> listeEurope;
		listeEurope = new ArrayList<Pays>();
		
		Color c1 = new Color(200, 12, 25);
		Pays islande = new Pays (0, "islande", c1 ,"Europe");
		listeEurope.add(islande);

		Color c2 = new Color(16, 124, 183);
		Pays eurNord = new Pays (1, "Europe du Nord", c2 ,"Europe");
		listeEurope.add(eurNord);
		
		Color c3 = new Color(2, 90, 138);
		Pays eurSud = new Pays (2, "Europe du Sud", c3 ,"Europe");
		listeEurope.add(eurSud);
		
		Color c4 = new Color(104, 168, 203);
		Pays scandinavie = new Pays (3, "Scandinavie", c4 ,"Europe");
		listeEurope.add(scandinavie);
		
		Color c5 = new Color(13, 79, 115);
		Pays eurOcc = new Pays (4, "Europe Occidentale", c5 ,"Europe");
		listeEurope.add(eurOcc);
		
		Color c6 = new Color(77, 135, 116);
		Pays angleterre = new Pays (5, "Grande Bretagne", c6 ,"Europe");
		listeEurope.add(angleterre);
		
		Color c7 = new Color(52, 179, 249);
		Pays ukraine = new Pays (6, "Ukraine", c7 ,"Europe");
		listeEurope.add(ukraine);
		
		
		
		
		Color co1 = new Color(184, 126, 89);
		Pays afriqueNord = new Pays (1, "Afrique du Nord", co1 ,"Afrique");
		
		Color co2 = new Color(205, 158, 128);
		Pays afriqueSud = new Pays (2, "Afrique du Sud", co2 ,"Afrique");
		
		Color co3 = new Color(227, 111, 38);
		Pays afriqueOrient = new Pays (3, "Afrique Orientale", co3 ,"Afrique");
		
		Color co4 = new Color(238, 201, 177);
		Pays madagascar = new Pays (4, "Madagascar", co4 ,"Afrique");
		
		Color co5 = new Color(240, 162, 113);
		Pays congo = new Pays (5, "Congo", co5 ,"Afrique");
		
		Color co6 = new Color(249, 99, 3);
		Pays egypte = new Pays (6, "Egypte", co6 ,"Afrique");
		
		
		Color cou1 = new Color(82, 14, 78);
		Pays indonesie = new Pays (1, "Indonésie", cou1 ,"Océanie");
		
		Color cou2 = new Color(96, 63, 94);
		Pays ausOcc = new Pays (2, "Australie Occidentale", cou2 ,"Océanie");
		
		Color cou3 = new Color(130, 94, 128);
		Pays ausOrient = new Pays (3, "Australie Orientale", cou3 ,"Océanie");
		
		Color cou4 = new Color(220, 49, 210);
		Pays nvlleGuinee = new Pays (4, "Nouvelle Guinée", cou4 ,"Océanie");
		
		Color cou5 = new Color(225, 191, 223);
		Pays indonesieIle = new Pays (5, "Iles d'Indonésie", cou5 ,"Océanie");
		
		
		
		
		
		/*__LANCER_LE_JEU_____________________________________________*/
		
		IHM1 fenetre = new IHM1 ();
		fenetre.setVisible(true);

	}
	

}
