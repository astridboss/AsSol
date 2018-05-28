package jeu;

import java.util.ArrayList;

import com.projectIsep.risk.Territory;

import Territoire;

public class Partie {

	/**
	 * 
	 * @param joueurList
	 * @param territoireList
	 * Permet d'initialiser l
	 */
	public void initArmee(ArrayList<Joueur> joueurList, ArrayList<Territoire> territoireList) {

	}

	public ArrayList<Territoire> initTerritoire(){
		ArrayList<Territoire> territoireArrayList = new ArrayList<>();
		String [] territoireList = {
				"Afghanistan", "Inde", "Afrique du Nord", "Indonésie", "Afrique du Sud", "Islande", "Afrique Orientale", "Japon","Alaska", "Kamchatka", "Alberta", "Madagascar", "Amérique Centrale", "Mongolie", "Argentine", "Moyen Orient", "Australie Occidentale", "Nouvelle Guinée", "Australie orientale", "Ontario", "Brésil", "Oural", "Chine", "Pérou" ,"Congo", "Québec" , "Egypte", "Scandinavie","Etat de l'Est", "Siam" , "Etat de l'Ouest" , "Sibérie", "Europe du Nord", "Tchita" , "Europe du Sud", "Territoire du Nord Ouest" ,"Europe Occidentale" ,"Ukraine" , "Grande Bretagne" ,"Venezuela" , "Groenland" , "Yakoutie"};
		for(int it=0; it<territoireList.length;it++){
			String nomTerritoire= territoireList[it];
			Territoire territory = new Territoire(it,0, nomTerritoire);
			territoireArrayList.add(territory);
		}
		return territoireArrayList;

	}

}
