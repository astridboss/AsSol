package jeu;
// (default package)

import java.io.IOException;
import java.util.ArrayList;

public class Main {

	public static void main(String[] args) {
		
		//INIT TERRITOIRE
		ArrayList<Territoire> territoireArrayList = new ArrayList<Territoire>();
		territoireArrayList = Territoire.initTerritoire();
				
		//Boucle test de la liste de territoire :
		/*for (int i = 0; i <territoireArrayList.size() ; i++ ) {
			System.out.println(" ");
			System.out.print(territoireArrayList.get(i).getTerritoireId());
			System.out.print("| " + territoireArrayList.get(i).getNomT());
			System.out.print("| " + territoireArrayList.get(i).getCouleurT());
			System.out.print("| " + territoireArrayList.get(i).getRegionT());
		}*/
				

		//AFFICHAGE MENU
		MenuJeu menu = new MenuJeu ();
		menu.setVisible(true);
		
		try {
			Partie partie1 = new Partie (menu.getNbrJoueur(), territoireArrayList);
			partie1.setVisible(true);
			
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		
	}

}
