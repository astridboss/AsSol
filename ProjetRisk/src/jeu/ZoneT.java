package jeu;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;

/**
 * CREATION DES ZONES DES TERRITOIRES A PARTIR DES COULEURS
 * @parameter pixel
 * @parameter zoneT (posX + posY)
 */

public class ZoneT {

	/*__ATTRIBUTS___________________________________________________*/
	private int posX;
	private int posY;


	/*__METHODES____________________________________________________*/
	
	/**_____CONSTRUCTEUR___________________*/
	
	public ZoneT (int x, int y) {
		this.posX = x;
		this.posY = y;
	}	
	


	/**
	 * CALCUL LA ZONE DU TERRITOIRE CORRESPONDANT AU PIXEL
	 * @param pixelT
	 * @return
	 * @throws IOException
	 */
	public static ArrayList<ZoneT> zoneTerritoireCalcul (int [] pixelT) throws IOException {
	
		//INSERT IMAGE
		File file = new File("src/Images/carte_mondeV3.png");
		BufferedImage maps = ImageIO.read(file);
			
		//TAILLE IMAGE
		int w = maps.getWidth();
		int h = maps.getHeight();
		
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
