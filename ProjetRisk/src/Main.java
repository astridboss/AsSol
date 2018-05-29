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
			Thread.sleep(5 * 1000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		while (menu.isVisible() == true) {
			//System.out.println("avantIF");
			if (menu.getFenetreFerme() == true) {	
				//System.out.println("IF");
					try {
						Partie partie = new Partie (menu.getNbrJoueur(), territoireArrayList);
						partie.setVisible(true);
					
					} catch (IOException e) {
						e.printStackTrace();
					}
				}else {/*System.out.println("ELSE");*/}
		
		}

	}

}
