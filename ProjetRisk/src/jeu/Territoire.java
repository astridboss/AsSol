package jeu;

import java.io.IOException;
import java.util.ArrayList;


/**
 * GESTION DES TERRITOIRES
 *
 */

public class Territoire {

	/*__ATTRIBUTS___________________________________________________*/
	private int territoireId;
	private String nomT;
	private int[] pixelT;
	
	private Joueur joueur;
	private String regionT;
	private ArrayList<Territoire> voisinT;

	private ArrayList<Unit> armeList= new ArrayList<>();
	private ArrayList<ZoneT> zoneTerritoires = new ArrayList<>();

	/*__METHODES____________________________________________________*/

	/**_____CONSTRUCTEUR___________________*/
    
	public Territoire (int territoireId, String nomT, int [] pixel, String region, Joueur joueur) throws IOException {
    	this.territoireId= territoireId;
    	this.nomT=nomT;
    	this.pixelT = pixel;
    
    	this.joueur = joueur;
    	this.regionT = region;   
   
    	this.zoneTerritoires = ZoneT.zoneTerritoireCalcul(pixel);
    	this.armeList = initArmeList(); 
    }
	
	
	/**_____FONCTION_INITIALISATION_DES_TERRITOIRES___________________*/
	

	public static ArrayList<Territoire> initTerritoire() throws IOException {

		ArrayList<Territoire> territoireArrayList = new ArrayList<Territoire>();

		int [] [] pixel = {{375, 52}, {460, 96}, {453, 113}, {460, 48}, {425, 111}, {415, 93}, {530, 80}, {414, 222}, {485, 360}, {528, 257}, {558, 344}, {474, 282}, {484, 182}, {770, 276}, {853, 366}, {784, 368}, {856, 298}, {734, 284}, {244, 308}, {220, 392}, {208, 334}, {198, 256}, {62, 48}, {115, 88}, {100, 200}, {180, 92}, {228, 88}, {157, 154}, {100, 130}, {136, 53}, {336, 21}, {605, 120}, {656, 197}, {823, 148}, {745, 115}, {763, 62}, {541, 166}, {708, 155}, {657, 72}, {596, 56}, {729, 216}, {710, 88}, {708, 52}};

		String [] territoireEurope = { "Islande", "Europe du Nord", "Europe du Sud", "Scandinavie", "Europe Occidentale", "Grande Bretagne", "Ukraine" };
		String [] territoireAfrique = { "Afrique du Nord", "Afrique du Sud", "Afrique Orientale", "Madagascar", "Congo", "Egypte"};	
		String [] territoireOceanie = {"Indonesie", "Australie Occidentale", "Australie orientale", "Nouvelle Guinee", "Iles Indonesie"};		
		String [] territoireAmeriqueSud = { "Bresil", "Argentine", "Perou", "Venezuela"};
		String [] territoireAmeriqueNord = {"Alaska", "Alberta",  "Amerique Centrale", "Ontario", "Quebec","Etat de l'Est", "Etat de l'Ouest", "Territoire du Nord Ouest", "Groenland",};
		String [] territoireAsie = {"Afghanistan", "Inde", "Japon","Mongolie", "Kamchatka", "Moyen Orient","Chine","Siberie", "Oural","Siam","Tchita", "Yakoutie"};

		for(int id = 0; id < territoireEurope.length; id++) {
			String nomT= territoireEurope[id];
			Territoire territory = new Territoire(id, nomT, pixel [id] ,"Europe", null);
			territoireArrayList.add(territory);
		}

		for(int id = 7; id < (territoireAfrique.length + 7); id++) {
			String nomT= territoireAfrique[(id-7)];
			Territoire territory = new Territoire(id, nomT, pixel[id] ,"Afrique", null);
			territoireArrayList.add(territory);
		}

		for(int id = 13; id < (territoireOceanie.length + 13); id++) {
			String nomT= territoireOceanie[(id-13)];
			Territoire territory = new Territoire(id, nomT, pixel [id] ,"Océanie", null);
			territoireArrayList.add(territory);
		}

		for(int id = 18; id < (territoireAmeriqueSud.length + 18); id++) {
			String nomT= territoireAmeriqueSud[(id-18)];
			Territoire territory = new Territoire(id, nomT, pixel [id] ,"Amérique du Sud", null);
			territoireArrayList.add(territory);
		}

		for(int id = 22; id < (territoireAmeriqueNord.length + 22); id++) {
			String nomT= territoireAmeriqueNord[(id-22)];
			Territoire territory = new Territoire(id, nomT, pixel [id] ,"Amérique du Nord", null);
			territoireArrayList.add(territory);
		}

		for(int id = 31; id < (territoireAsie.length + 31); id++) {
			String nomT= territoireAsie[(id-31)];
			Territoire territory = new Territoire(id, nomT, pixel [id] ,"Asie", null);
			territoireArrayList.add(territory);
		}
		return territoireArrayList;
	}

	/**_____INITIALISATION_ARMEE_LISTE___________________*/
	
	public ArrayList<Unit> initArmeList() {
		Unit unitS = new Soldat();
		armeList.add(unitS);
		return armeList;
	}
	
	/**_____FONCTION_DE_DETECTION_DE_TERRITOIRES___________________*/
	
	public static Territoire territoireDetection (int posx, int posy, ArrayList<Territoire> list) {

		for (int i = 0 ; i < list.size() ; i++) {
			//	System.out.println(list.get(i).getNomT());
			for (int j = 0; j < list.get(i).getZoneTerritoires().size(); j++) {
				//System.out.println("x= " + list.get(i).getZoneT().get(j).getPosX() + " | y = " + list.get(i).getZoneT().get(j).getPosY());
				if ( (posx == list.get(i).getZoneTerritoires().get(j).getPosX()) && (posy == list.get(i).getZoneTerritoires().get(j).getPosY())) {
					System.out.println("Vous Ãªtes en : " + list.get(i).getNomT());
					return list.get(i);
				}
			} 
		} 
		return null;
	}
	
	
	/**_____FONCTION_DE_DISTRIBUTION_DES_TERRITOIRES___________________*/
	
	public static void distributionTerritoire (ArrayList<Territoire> territoireList, ArrayList<Joueur>joueurList ) {
		int terrDist = 43;
		
		ArrayList<Integer> indexTerritoire = new ArrayList<>();
		for (int j = 0; j < 43; j++) 	{ indexTerritoire.add(j); }
		
		while (terrDist > 0) {
		for (int joueurIndex=0; joueurIndex < joueurList.size();joueurIndex++) {			
			
				System.out.println("****************************************");
				System.out.println("terrDist = "+ terrDist);
				System.out.println("Joueur = "+joueurIndex);
				
				int index =  (int) (Math.random()*(terrDist));
				int territoireIndex = indexTerritoire.get(index);
				
				System.out.println("Index = " + index);
				System.out.println("Territoire index = " + territoireIndex);
			
				Territoire territoire = territoireList.get(territoireIndex);
				joueurList.get(joueurIndex).getTerritoireList().add(territoire);
				territoire.joueur = joueurList.get(joueurIndex);
				
				System.out.println("ProprioT = " + territoireList.get(territoireIndex).getJoueur().getNomJoueur());
				System.out.println("Joueur list T = " + joueurList.get(joueurIndex).getTerritoireList());
				
				indexTerritoire.remove(indexTerritoire.get(index));
				terrDist = terrDist - 1;
				if (terrDist == 0) {
					break;
					}
				if (joueurIndex == joueurList.size()) {
					joueurIndex = 0;
				}
			}
			
		}
	}
	
	
	/**_____FONCTION_POUR_RETOURNER_UN_TERRITOIRE_SELECTIONNE_PAR_UN_NOM____________*/
	
	public static Territoire stringToTerritoire(String nom,ArrayList<Territoire> territoireArrayList) {

		for (int i=0; i<territoireArrayList.size(); i++) {
			Territoire territoire = territoireArrayList.get(i);
			if(territoire.getNomT().equals(nom)) {
				return territoire;
			}
		}
		return null;
	}

	
	/*__GETTERS_&_SETTERS____________________________________________________*/
	
	public String getNomT() {
		return nomT;
	}

	public void setNomT(String nomT) {
		this.nomT = nomT;
	}

	public int getTerritoireId() {
		return territoireId;
	}

	public void setTerritoireId(int territoireId) {
		this.territoireId = territoireId;
	}

	public String getRegionT() {
		return regionT;
	}


	public void setRegionT(String regionT) {
		this.regionT = regionT;
	}


	public ArrayList<Territoire> getVoisinT() {
		return voisinT;
	}


	public void setVoisinT(ArrayList<Territoire> voisinT) {
		this.voisinT = voisinT;
	}


	public int[] getPixelT() {
		return pixelT;
	}


	public void setPixelT(int[] pixelT) {
		this.pixelT = pixelT;
	}

	public ArrayList<ZoneT> getZoneTerritoires() {
		return zoneTerritoires;
	}


	public void setZoneTerritoires(ArrayList<ZoneT> zoneT) {
		this.zoneTerritoires = zoneT;
	}


	public Joueur getJoueur() {
		return joueur;
	}


	public void setJoueur(Joueur joueur) {
		this.joueur = joueur;
	}

	public ArrayList<Unit> getArmeList() {
		return armeList;
	}


	public void setArmeList(ArrayList<Unit> armeList) {
		this.armeList = armeList;
	}
}
