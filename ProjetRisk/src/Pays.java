import java.awt.Color;
import java.util.jar.Attributes.Name;

/**
 * 
 *
 *
 */


public class Pays {
	
	/*__ATTRIBUTS___________________________________________________*/
	public String nomPays;
	public Color couleur;
	public String region;
	public Pays [] voisin;
	public String proprietaire;
	
	/*__METHODES____________________________________________________*/
	
	//CONSTRUCTEUR
	public Pays (String nom, Color color, String regions) {
		this.nomPays = nom;
		this.couleur = color;
		this.region = regions;
		this.voisin = null;
		this.proprietaire = null;
		
		
	}
	
	// GETTERS, SETTERS
	
	
	// FONCTIONS

}
