package jeu;

import java.awt.Color;
import java.util.ArrayList;

/**
 * GESTION DES JOUEURS
 *
 */

public class Joueur {
	
	/*__ATTRIBUTS___________________________________________________*/
	
	private String nomJoueur;
	private Color couleur;
	private int unit;
	private int renfortTControles;
	private int renfortTGagnes;
	
	private int idUnit;
	
	private ArrayList<Territoire> territoireListJoueur = new ArrayList<>();
	
	
	/*__METHODES____________________________________________________*/
	

	/**_____CONSTRUCTEUR___________________*/
	
	public Joueur(Color color, int unitDebut, String nom) {
		this.nomJoueur = nom;
		this.couleur = color;
		this.unit = unitDebut;
		
		this.idUnit = 0;
	}
	
	
	/**____INITIALISATION_DES_JOUEURS_________________*/
	

	public static ArrayList<Joueur> initJoueur (int nbrJoueur) {
		
		Color couleurList [] = {Color.BLUE, Color.RED, Color.GREEN, Color.ORANGE, Color.MAGENTA, Color.YELLOW};
		
		ArrayList<Joueur> joueurList = new ArrayList<>();
		
		for (int i = 0; i < nbrJoueur; i++ ) {
			Color couleur = couleurList [i];
			
			int unit = 0;
			if(nbrJoueur == 2) { unit = 40; }
			if(nbrJoueur == 3) { unit = 35; }
			if(nbrJoueur == 4) { unit = 30; }
			if(nbrJoueur == 5) { unit = 25; }
			if(nbrJoueur == 6) { unit = 20; }
			
			String name = "";
			if (couleur == Color.BLUE) { name = "Bleu"; }
			if (couleur == Color.RED) { name = "Rouge"; }
			if (couleur == Color.GREEN) { name = "Vert"; }
			if (couleur == Color.ORANGE) { name = "Orange"; }
			if (couleur == Color.MAGENTA) { name = "Violet"; }
			if (couleur == Color.YELLOW) { name = "Jaune"; }
			
			Joueur player = new Joueur (couleur,unit, name);
			joueurList.add(player);
		}
		return joueurList;			
	}

	
	/**____FONCTION_DE_CALCUL_DES_RENFORTS_________________*/
	public static void calculRenfort (Joueur joueur) {
		
		//RENFORT DES TERRITOIRES POSSEDES
		int renfortTerritoire = 0;
		renfortTerritoire = (int) Math.floor((joueur.getTerritoireList().size() / 3));
		
		//RENFORT SI UNE REGION EST POSSEDEE
		int renfortRegion = 0;
		
		int renfortEurope = 0, renfortAfrique = 0, renfortOceanie = 0, renfortAmSud = 0, renfortAmNord = 0, renfortAsie = 0;
		int europeT = 0, afriqueT = 0, oceanieT = 0, amSudT = 0, amNordT = 0, asieT = 0;
		
		
		for (int i = 0; i< joueur.getTerritoireList().size(); i++) {
			if (joueur.getTerritoireList().get(i).getRegionT() == "Europe") { europeT = europeT + 1 ; }
			if (joueur.getTerritoireList().get(i).getRegionT() == "Afrique") { afriqueT = afriqueT + 1 ; }
			if (joueur.getTerritoireList().get(i).getRegionT() == "Océanie") { oceanieT = oceanieT + 1 ; }
			if (joueur.getTerritoireList().get(i).getRegionT() == "Amérique du Sud") { amSudT = amSudT + 1 ; }
			if (joueur.getTerritoireList().get(i).getRegionT() == "Amérique du Nord") { amNordT = amNordT + 1 ; }
			if (joueur.getTerritoireList().get(i).getRegionT() == "Asie") { asieT = asieT + 1 ; }
		}
		
		if (europeT == 7) { renfortEurope = (int) Math.floor(( europeT / 2));  };
		if (afriqueT == 6) { renfortAfrique = (int) Math.floor(( afriqueT / 2));  };
		if (oceanieT == 5) { renfortOceanie = (int) Math.floor(( oceanieT / 2));  };
		if (amSudT == 4) { renfortAmSud = (int) Math.floor(( amSudT / 2));  };
		if (amNordT == 9) { renfortAmNord = (int) Math.floor(( amNordT / 2));  };
		if (asieT == 12) { renfortAsie = (int) Math.floor(( asieT / 2));  };
		
		renfortRegion = renfortEurope + renfortAfrique + renfortOceanie + renfortAmSud + renfortAmNord + renfortAsie;
		
		//RENFORT DES TERRITOIRES ACQUIS AU TOURS PRECEDENT
		int renfortTConquis = 0;
		renfortTConquis = (int) Math.floor(joueur.getRenfortTGagnes() * 0.5);		
		
		//CALCUL RENFORT TOTAL = NOUVELLE VALEUR DE UNIT
		int unitRenfort = renfortTerritoire + renfortRegion + renfortTConquis;
	
		if (unitRenfort < 2) {
			joueur.setUnit(2);
		} else {
			joueur.setUnit(unitRenfort);
		}
		
		
	}
	
	
	
	/*__GETTERS_&_SETTERS____________________________________________________*/
	
	public Color getCouleur() {
		return couleur;
	}

	public void setCouleur(Color couleur) {
		this.couleur = couleur;
	}

	public ArrayList<Territoire> getTerritoireList() {
		return territoireListJoueur;
	}

	public void setTerritoireList(ArrayList<Territoire> territoireList) {
		this.territoireListJoueur = territoireList;
	}

	public int getUnit() {
		return unit;
	}

	public void setUnit(int unit) {
		this.unit = unit;
	}

	public int getRenfortTControles() {
		return renfortTControles;
	}

	public void setRenfortTControles(int renfortTControles) {
		this.renfortTControles = renfortTControles;
	}

	public int getRenfortTGagnes() {
		return renfortTGagnes;
	}

	public void setRenfortTGagnes(int renfortTGagnes) {
		this.renfortTGagnes = renfortTGagnes;
	}


	public String getNomJoueur() {
		return nomJoueur;
	}


	public void setNomJoueur(String nomJoueur) {
		this.nomJoueur = nomJoueur;
	}


	public int getIdUnit() {
		return idUnit;
	}


	public void setIdUnit(int idUnit) {
		this.idUnit = idUnit;
	}

}
