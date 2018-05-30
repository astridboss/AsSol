package jeu;

import java.io.IOException;
import java.util.ArrayList;


public class Main {

	public static void main(String[] args) throws IOException {
		
		//INIT TERRITOIRE
		ArrayList<Territoire> territoireArrayList = new ArrayList<Territoire>();
		int [] testpixel = {235, 85};
		territoireArrayList = Territoire.initTerritoire();
		
		//ZoneT.zone (territoireArrayList);
		
		
				
		//Boucle test de la liste de territoire :
		for (int i = 0; i <territoireArrayList.size() ; i++ ) {
			System.out.println(" ");
			System.out.println(territoireArrayList.get(i).getTerritoireId());
			System.out.println(territoireArrayList.get(i).getNomT());
			System.out.println(territoireArrayList.get(i).getCouleurT());
			System.out.println(territoireArrayList.get(i).getPixelT() [0] + " " +territoireArrayList.get(i).getPixelT() [1] );
			System.out.println(territoireArrayList.get(i).getRegionT());
			//System.out.println(territoireArrayList.get(i).getZoneT());
			System.out.println("******************************************************");
		}
		
		
		ArrayList<ZoneT> zoneTest = new ArrayList<>();
		zoneTest = ZoneT.zoneTerritoireCalcul(testpixel);
		System.out.println(zoneTest);
				

		//AFFICHAGE MENU
		MenuJeu menu = new MenuJeu ();
		menu.setVisible(true);
		
		//maps carte = new maps(3, territoireArrayList);
		//carte.setVisible(true);
		
		
		/*while (menu.isVisible() == true) {
			//System.out.println("avantIF");
			if (menu.getFenetreFerme() == true) {	
				//System.out.println("IF");
					try {
						Partie partie = new Partie (menu.getNbrJoueur(), territoireArrayList);
						partie.setVisible(true);
					
					} catch (IOException e) {
						e.printStackTrace();
					}
				}else {/*System.out.println("ELSE");}
		
		}*/

	}

}
