// (default package)

import java.awt.Color;
import java.util.ArrayList;

import javax.naming.InitialContext;

import jeu.Joueur;

public class Main {
	/**
	 * @param joueurList
	 * @param territoireList
	 * 
	 * FICHIER PRINCIPALE : MAIN
	 */
	
	/*__FONCTION_PRINCIPALE___________________________________________________*/
	
	public static void main(String[] args) {
		//INIT TERRITOIRE
		ArrayList<Territoire> territoireArrayList = new ArrayList<Territoire>();
		territoireArrayList = initTerritoire ();
		
		/*ArrayList<Territoire> mondeT = new ArrayList<Territoire>();
		
		Color c1 = new Color(200, 12, 25);
		Territoire islande = new Territoire (0, "islande", c1 ,"Europe");
		mondeT.add(islande);

		Color c2 = new Color(16, 124, 183);
		Territoire eurNord = new Territoire (1, "Europe du Nord", c2 ,"Europe");
		mondeT.add(eurNord);
		
		Color c3 = new Color(2, 90, 138);
		Territoire eurSud = new Territoire (2, "Europe du Sud", c3 ,"Europe");
		mondeT.add(eurSud);
		
		Color c4 = new Color(104, 168, 203);
		Territoire scandinavie = new Territoire (3, "Scandinavie", c4 ,"Europe");
		mondeT.add(scandinavie);
		
		Color c5 = new Color(13, 79, 115);
		Territoire eurOcc = new Territoire (4, "Europe Occidentale", c5 ,"Europe");
		mondeT.add(eurOcc);
		
		Color c6 = new Color(77, 135, 116);
		Territoire angleterre = new Territoire (5, "Grande Bretagne", c6 ,"Europe");
		mondeT.add(angleterre);
		
		Color c7 = new Color(77, 135, 116);
		Territoire ukraine = new Territoire (6, "Ukraine", c7 ,"Europe");
		mondeT.add(ukraine);*/
		
		//AFFICHAGE MENU
		
		
	}
	
	
	/*__METHODES___________________________________________________*/
	
	//INIT TERRITOIRE FONCTIONS
	private static Color color(int r, int g, int b) {
		Color color = new Color(r, g, b);
		return color;
	}
	
	public static ArrayList<Territoire> initTerritoire() {
		
		ArrayList<Territoire> territoireArrayList = new ArrayList<Territoire>();
		
		String [] territoireEurope = { "Islande", "Europe du Nord", "Europe du Sud", "Scandinavie", "Europe Occidentale", "Grande Bretagne", "Ukraine" };
		Color [] couleurEurope = {color(200, 12, 25), color(16, 124, 183), color(2, 90, 138), color(104, 168, 203), color(13, 79, 115), color(77, 135, 116), color(77, 135, 116)};

		String [] territoireAfrique = { "Afrique du Nord", "Afrique du Sud", "Afrique Orientale", "Madagascar", "Congo", "Egypte"};
		String [] territoireOceanie = {"Indonésie", "Australie Occidentale", "Nouvelle Guinée", "Australie orientale", "Iles Indonésie"};
		String [] territoireAmeriqueSud = { "Brésil", "Argentine", "Pérou", "Venezuela"};
		String [] territoireAmeriqueNord = {"Alaska", "Alberta",  "Amérique Centrale", "Ontario", "Québec","Etat de l'Est", "Etat de l'Ouest", "Territoire du Nord Ouest", "Groenland",};
		String [] territoireAsie = {"Afghanistan", "Inde", "Japon","Mongolie", "Kamchatka", "Moyen Orient","Chine","Sibérie", "Oural","Siam","Tchita", "Yakoutie"};
		
		for(int id = 0; id < territoireEurope.length; id++) {
			String nomT= territoireEurope[id];
			Territoire territory = new Territoire(id, nomT, couleurEurope [id] ,"Europe");
			territoireArrayList.add(territory);
		}
		System.out.print(territoireArrayList);
		return territoireArrayList;

	}

	
	/*public void initArmee(ArrayList<Joueur> joueurList, ArrayList<Territoire> territoireList) {

	}*/
}



