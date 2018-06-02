package jeu;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;

public class ZoneT {

	/*__ATTRIBUTS___________________________________________________*/
	private int posX;
	private int posY;

	public ZoneT (int x, int y) {
		this.posX = x;
		this.posY = y;
	}
	
	

	/*__METHODES____________________________________________________*/
	
	
	public static void zone (int [] pixelT) throws IOException {
		
		//for (int id = 0; id < territoireArrayList.size(); id++) {
			ArrayList<ZoneT> zoneT = new ArrayList<>();
			
			//System.out.println("ID = " + territoireArrayList.get(1).getTerritoireId());
			//System.out.println("Pays = " + territoireArrayList.get(1).getNomT());
			//System.out.println("Couleur = " + territoireArrayList.get(1).getCouleurT());
						
			zoneT = zoneTerritoireCalcul(pixelT);
			
			System.out.println("Zone = " + zoneT);
			System.out.println("Taille de Zone = " + zoneT.size());
			System.out.println("****************************");
			
		}
		
	//}
	
	
	
	
	public static ArrayList<ZoneT> zoneTerritoireCalcul (int [] pixelT) throws IOException {
	
		//INSERT IMAGE
		File file = new File("src/Images/carte_mondeV3.png");
		BufferedImage maps = ImageIO.read(file);
			
		//TAILLE IMAGE
		int w = maps.getWidth();
		int h = maps.getHeight();
		//System.out.println("h : " + h + "w: " + w);
		
		//ARRAYLIST ZONE
		ArrayList<ZoneT> zoneT = new ArrayList<>();
		
		//RECUP COULEUR
		int color = maps.getRGB( pixelT[0], pixelT[1]);
			
		// PARCOURT IMAGE
		for (int i = 0; i<w; i++) {
			for (int j = 0; j<h; j++) {
				if (color == maps.getRGB(i, j)) {
					ZoneT pixel = new ZoneT(i, j);
					zoneT.add(pixel);
				}
			}
		}
		return zoneT;
	}
	
	
	
	
	/*__GETTERS_&_SETTERS____________________________________________________*/
	
	public int getPosX() {
		return posX;
	}

	public void setPosX(int posX) {
		this.posX = posX;
	}

	public int getPosY() {
		return posY;
	}

	public void setPosY(int posY) {
		this.posY = posY;
	}
}
