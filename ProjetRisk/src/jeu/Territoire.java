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
	private ArrayList<Territoire> voisinT = new ArrayList<>();

	private ArrayList<Unit> armeList = new ArrayList<>();
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
    }
	
	
	/**
	 * FONCTION INITIALISATION DES TERRITOIRES
	 * @return
	 * @throws IOException
	 */
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
			Territoire territory = new Territoire(id, nomT, pixel [id] ,"Oc�anie", null);
			territoireArrayList.add(territory);
		}

		for(int id = 18; id < (territoireAmeriqueSud.length + 18); id++) {
			String nomT= territoireAmeriqueSud[(id-18)];
			Territoire territory = new Territoire(id, nomT, pixel [id] ,"Am�rique du Sud", null);
			territoireArrayList.add(territory);
		}

		for(int id = 22; id < (territoireAmeriqueNord.length + 22); id++) {
			String nomT= territoireAmeriqueNord[(id-22)];
			Territoire territory = new Territoire(id, nomT, pixel [id] ,"Am�rique du Nord", null);
			territoireArrayList.add(territory);
		}

		for(int id = 31; id < (territoireAsie.length + 31); id++) {
			String nomT= territoireAsie[(id-31)];
			Territoire territory = new Territoire(id, nomT, pixel [id] ,"Asie", null);
			territoireArrayList.add(territory);
		}
		return territoireArrayList;
	}

	/**
	 * INITIALISATION ARMEE LISTE
	 * @param territoireList
	 */
	public static void determinerVoisin (ArrayList<Territoire> territoireList) {
		
		int [] [] voisin = {{30, 5, 3}, {3, 5, 4, 2, 6}, {1, 4, 6, 7, 12, 36}, {0, 1, 5, 6}, {5, 1, 2}, {0, 1, 3, 4}, {3, 1, 2, 39, 31, 36}, 
				{12, 9,11,2,18}, {11,9,10}, {7, 8,10,11,12,2,36}, {9, 8}, {7,8,9,12}, {7,9,36,2}, 
				{17, 40, 16, 15}, {16, 15 }, {13, 17, 16, 14 }, {13, 14, 15, 17, 40 }, {13, 15},
				{7, 19, 20, 21}, {20, 18}, {18, 19, 21}, {20, 18, 24},
				{35, 29, 23}, {29, 22, 25, 28}, {21, 27, 28}, {30, 23, 29, 27, 28, 26}, {25, 27, 30},{26, 25, 28, 24},{27, 24, 25, 23},{30, 22, 23, 25},{29, 25, 26, 0},
				{6, 39, 36, 32, 37}, {31, 36, 40, 37 }, {34, 35}, {37, 38, 41, 35, 33}, {22, 42, 41, 34, 33},{31, 32, 2, 6, 9},{34, 38, 39, 31, 32, 40},{39, 37, 34, 41, 42},{6, 31, 37, 38},{37, 32, 13, 17},{34, 38, 42, 35 }, {38, 41, 35} };
		
		
		
		for (int idT = 0; idT < territoireList.size(); idT++) {
			//voisinList.removeAll(voisinList);
			ArrayList<Territoire> voisinList = new ArrayList<>();
			for (int i = 0; i < voisin[idT].length ; i++) { 
				voisinList.add(territoireList.get(voisin[idT][i]));
				}
			territoireList.get(idT).setVoisinT(voisinList);
		}
	}
	
	
	/**
	 * INITIALISATION ARMEE LISTE
	 * @param joueur
	 * @return
	 */
	public static ArrayList<Unit> initArmeList(Joueur joueur) {
		
		int id =  joueur.getIdUnit();
		Unit unitS = new Soldat (id);
		ArrayList<Unit> armeL = new ArrayList<>();
		armeL.add(unitS);
		id = id +1;
		joueur.setIdUnit(id);
		
		return armeL;
	}
	
	
	
	/**
	 * FONCTION DE DETECTION DE TERRITOIRES
	 * @param posx
	 * @param posy
	 * @param list
	 * @return Territoire
	 */
	public static Territoire territoireDetection (int posx, int posy, ArrayList<Territoire> list) {

		for (int i = 0 ; i < list.size() ; i++) {
			for (int j = 0; j < list.get(i).getZoneTerritoires().size(); j++) {
				if ( (posx == list.get(i).getZoneTerritoires().get(j).getPosX()) && (posy == list.get(i).getZoneTerritoires().get(j).getPosY())) {
					return list.get(i);
				}
			} 
		} 
		return null;
	}

	
	/**
	 * FONCTION DE DISTRIBUTION DES TERRITOIRES
	 * @param territoireList
	 * @param joueurList
	 */
	public static void distributionTerritoire (ArrayList<Territoire> territoireList, ArrayList<Joueur>joueurList ) {
		int terrDist = 43;
		
		ArrayList<Integer> indexTerritoire = new ArrayList<>();
		for (int j = 0; j < 43; j++) 	{ indexTerritoire.add(j); }
		
		while (terrDist > 0) {
		for (int joueurIndex=0; joueurIndex < joueurList.size();joueurIndex++) {			
			
				int index =  (int) (Math.random()*(terrDist));
				int territoireIndex = indexTerritoire.get(index);
				
				Territoire territoire = territoireList.get(territoireIndex);
				joueurList.get(joueurIndex).getTerritoireList().add(territoire);
				territoire.joueur = joueurList.get(joueurIndex);
				
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
	
	
	/**
	 * FONCTION POUR RETOURNER UN TERRITOIRE SELECTIONNE PAR UN NOM
	 * @param nom
	 * @param territoireArrayList
	 * @return territoire
	 */

	
	public static Territoire stringToTerritoire(String nom, ArrayList<Territoire> territoireArrayList) {

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
