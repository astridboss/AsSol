package jeu;

import java.awt.Color;
import java.io.IOException;
import java.util.ArrayList;


/**
 * GESTION DES TERRITOIRES
 *
 *
 */

public class Territoire {

	/*__ATTRIBUTS___________________________________________________*/
	private int territoireId;
	private String nomT;
	private static Color couleurT;
	private int[] pixelT;
	private ArrayList<ZoneT> zoneTerritoires = new ArrayList<>();

	private String regionT;
	private ArrayList<Territoire> voisinT;
	private String proprietaireT;

	private int soldatT;
	private int cavalierT;
	private int canonT;


	/*__METHODES____________________________________________________*/

	//CONSTRUCTEUR

	public Territoire (Color proprietaireT ,int territoireId, String nomT, Color couleurT, int [] pixel, String region) throws IOException {
		this.territoireId= territoireId;
		this.nomT=nomT;
		this.couleurT= couleurT;
		this.pixelT = pixel;
		this.regionT = region;   
		this.proprietaireT = null;
		this.zoneTerritoires = ZoneT.zoneTerritoireCalcul(pixel);
	}


	//INIT TERRITOIRE FONCTIONS
	private static Color color(int r, int g, int b) throws IOException {
		Color color = new Color(r, g, b);
		return color;
	}

	public static ArrayList<Territoire> initTerritoire() throws IOException {

		ArrayList<Territoire> territoireArrayList = new ArrayList<Territoire>();

		int [] [] pixel = {{375, 52}, {460, 96}, {453, 113}, {460, 48}, {425, 111}, {415, 93}, {530, 80}, {414, 222}, {485, 360}, {528, 257}, {558, 344}, {474, 282}, {484, 182}, {770, 276}, {853, 366}, {784, 368}, {856, 298}, {734, 284}, {244, 308}, {220, 392}, {208, 334}, {198, 256}, {62, 48}, {115, 88}, {100, 200}, {180, 92}, {228, 88}, {157, 154}, {100, 130}, {136, 53}, {336, 21}, {605, 120}, {656, 197}, {823, 148}, {745, 115}, {763, 62}, {541, 166}, {708, 155}, {657, 72}, {596, 56}, {729, 216}, {710, 88}, {708, 52}};

		String [] territoireEurope = { "Islande", "Europe du Nord", "Europe du Sud", "Scandinavie", "Europe Occidentale", "Grande Bretagne", "Ukraine" };
		Color [] couleurEurope = {color(200, 12, 25), color(16, 124, 183), color(2, 90, 138), color(104, 168, 203), color(13, 79, 115), color(77, 135, 116), color(77, 135, 116)};

		String [] territoireAfrique = { "Afrique du Nord", "Afrique du Sud", "Afrique Orientale", "Madagascar", "Congo", "Egypte"};
		Color [] couleurAfrique = {color(184, 126, 89), color(205, 158, 128), color(227, 111, 38), color(238, 201, 177), color(240, 162, 113), color(249, 99, 3)};

		String [] territoireOceanie = {"Indon�sie", "Australie Occidentale", "Australie orientale", "Nouvelle Guin�e", "Iles Indon�sie"};
		Color [] couleurOceanie = { color(82, 14, 78), color(96, 63, 94), color(130, 94, 128), color(220, 49, 210), color(225, 191, 223)};

		String [] territoireAmeriqueSud = { "Br�sil", "Argentine", "P�rou", "Venezuela"};
		Color [] couleurAmeriqueSud = { color(200, 85, 102), color(147, 44, 59), color(220, 117, 132), color(211, 77, 96)};

		String [] territoireAmeriqueNord = {"Alaska", "Alberta",  "Am�rique Centrale", "Ontario", "Qu�bec","Etat de l'Est", "Etat de l'Ouest", "Territoire du Nord Ouest", "Groenland",};
		Color [] couleurAmeriqueNord = { color(249, 187, 17), color(247, 195, 48), color(241, 216, 145), color(218, 164, 13), color(187, 149, 43), color(245, 200, 76), color(216, 186, 102), color(220, 172, 38), color(155, 177, 12)};

		String [] territoireAsie = {"Afghanistan", "Inde", "Japon","Mongolie", "Kamchatka", "Moyen Orient","Chine","Sib�rie", "Oural","Siam","Tchita", "Yakoutie"};
		Color [] couleurAsie = { color(14, 173, 122), color(66, 241, 185), color(32, 157, 117), color(87, 171, 144), color(101, 191, 162), color(19, 218, 154), color(133, 223, 194), color(32, 157, 117), color(8, 131, 92), color(169, 229, 210), color(57, 139, 113), color(39, 129, 100)};

		for(int id = 0; id < territoireEurope.length; id++) {
			String nomT= territoireEurope[id];
			Territoire territory = new Territoire(couleurT, id, nomT, couleurEurope [id], pixel [id] ,"Europe");
			territoireArrayList.add(territory);
		}

		for(int id = 7; id < (territoireAfrique.length + 7); id++) {
			String nomT= territoireAfrique[(id-7)];
			Territoire territory = new Territoire(couleurT, id, nomT, couleurAfrique [id-7], pixel[id] ,"Afrique");
			territoireArrayList.add(territory);
		}

		for(int id = 13; id < (territoireOceanie.length + 13); id++) {
			String nomT= territoireOceanie[(id-13)];
			Territoire territory = new Territoire(couleurT, id, nomT, couleurOceanie [id-13], pixel [id] ,"Oc�anie");
			territoireArrayList.add(territory);
		}

		for(int id = 18; id < (territoireAmeriqueSud.length + 18); id++) {
			String nomT= territoireAmeriqueSud[(id-18)];
			Territoire territory = new Territoire(couleurT, id, nomT, couleurAmeriqueSud [id-18], pixel [id] ,"Am�rique du Sud");
			territoireArrayList.add(territory);
		}

		for(int id = 22; id < (territoireAmeriqueNord.length + 22); id++) {
			String nomT= territoireAmeriqueNord[(id-22)];
			Territoire territory = new Territoire(couleurT, id, nomT, couleurAmeriqueNord [id-22], pixel [id] ,"Am�rique du Nord");
			territoireArrayList.add(territory);
		}

		for(int id = 31; id < (territoireAsie.length + 31); id++) {
			String nomT= territoireAsie[(id-31)];
			Territoire territory = new Territoire(couleurT, id, nomT, couleurAsie [id-31], pixel [id] ,"Asie");
			territoireArrayList.add(territory);
		}
		return territoireArrayList;
	}


	//FONCTIONS

	public static Territoire territoireDetection (int posx, int posy, ArrayList<Territoire> list) {

		for (int i = 0 ; i < list.size() ; i++) {
			//	System.out.println(list.get(i).getNomT());
			for (int j = 0; j < list.get(i).getZoneTerritoires().size(); j++) {
				//System.out.println("x= " + list.get(i).getZoneT().get(j).getPosX() + " | y = " + list.get(i).getZoneT().get(j).getPosY());
				if ( (posx == list.get(i).getZoneTerritoires().get(j).getPosX()) && (posy == list.get(i).getZoneTerritoires().get(j).getPosY())) {
					System.out.println("Vous �tes en : " + list.get(i).getNomT());
					return list.get(i);
				}
			} 
		} 
		return null;
	}


	public static void distributionTerritoire (ArrayList<Territoire> territoireList, ArrayList<Joueur>joueurList ) {
		int terrDist = 42;
		ArrayList<Integer> indexTerritoireUtiliser = new ArrayList<>();

		while (terrDist != 0) {
			//System.out.println("terrDist = "+terrDist);

			for (int joueurIndex=0; joueurIndex < joueurList.size();joueurIndex++) {

				//System.out.println("Joueur = "+joueurIndex);
				int territoireIndex =  (int) (Math.random()*43); //(int) Math.floor(Math.random() * 42) + 1;
				for (int i = 0; i < indexTerritoireUtiliser.size(); i++) {
					if ( territoireIndex == indexTerritoireUtiliser.get(i)) {
						territoireIndex =  (int) (Math.random()*43); //(int) Math.floor(Math.random() * 42) + 1;
					}
				}
				//System.out.println("Territoire index = " + territoireIndex);

				indexTerritoireUtiliser.add(territoireIndex);
				Territoire territoire = territoireList.get(territoireIndex);
				joueurList.get(joueurIndex).getTerritoireList().add(territoire);
				territoire.setProprietaireT(joueurList.get(joueurIndex).getNomJoueur());

				//System.out.println("ProprioT = " + territoireList.get(territoireIndex).getProprietaireT());
				//System.out.println("Joueur list T = " + joueurList.get(joueurIndex).getTerritoireList());
				terrDist = terrDist - 1;
				if (joueurIndex == joueurList.size()) {
					joueurIndex = 0;
				}
			}
		}
	}
	public static Territoire stringToTerritoire(String nom, Partie partie) {
		ArrayList<Territoire> territoireArrayList = partie.territoireArrayList;
		for (int i=0; i<territoireArrayList.size(); i++) {
			Territoire territoire =territoireArrayList.get(i);
			if(territoire.getNomT().equals(nom)) {
				return territoire;
			}

		}
		return null;
	}


	//GETTERS & SETTERS 
	public int getSoldatT() {
		return soldatT;
	}

	public void setSoldatT(int soldatT) {
		this.soldatT = soldatT;
	}


	public int getCavalierT() {
		return cavalierT;
	}

	public void setCavalierT(int cavalierT) {
		this.cavalierT = cavalierT;
	}


	public int getCanonT() {
		return canonT;
	}

	public void setCanonT(int canonT) {
		this.canonT = canonT;
	}


	public String getNomT() {
		return nomT;
	}

	public void setNomT(String nomT) {
		this.nomT = nomT;
	}

	public Color getCouleurT() {
		return couleurT;
	}

	public void setCouleurT(Color couleurT) {
		this.couleurT = couleurT;
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


	public String getProprietaireT() {
		return proprietaireT;
	}


	public void setProprietaireT(String proprietaireT) {
		this.proprietaireT = proprietaireT;
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




}
