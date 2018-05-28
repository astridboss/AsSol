package jeu;

import java.awt.Color;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.jar.Attributes.Name;

/**
 * 
 *
 *
 */

public class Territoire {

	/*__ATTRIBUTS___________________________________________________*/
    private int territoireId;
    private String nomT;
    private Color couleurT;
    //private Zone zoneT;
    
    private String regionT;
    private ArrayList<Territoire> voisinT;
    private String proprietaireT;
        
    private int soldatT;
	private int cavalierT;
	private int canonT;

	/*__METHODES____________________________________________________*/

	//CONSTRUCTEUR
    
	public Territoire (int territoireId, String nomT, Color couleurT, String region) {
    	this.territoireId= territoireId;
    	this.nomT=nomT;
    	this.couleurT= couleurT;
    	this.regionT = region;
    }
	
	
	
	//FONCTIONS
	
	public Territoire territoireClic (Color couleurSelectionne) {
		for (Terrritoire territoire) {
			if (couleurSelectionne == pays.couleur) {
				return territoire;
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
    
}
