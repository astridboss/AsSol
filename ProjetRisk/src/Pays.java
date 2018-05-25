import java.awt.Color;
import java.util.jar.Attributes.Name;

public class Pays {
	
	/*__ATTRIBUTS___________________________________________________*/
	public String nomPays;
	public Color couleur;
	public String region;
	public Pays voisin;
	
	/*__METHODES____________________________________________________*/
	
	//CONSTRUCTEUR
	public Pays (String nom, Color color, String regions, Pays pays2) {
		this.nomPays = nom;
		this.couleur = color;
		this.region = regions;
		this.voisin = pays2;
		
		
	}
	
	// GETTERS, SETTERS
	
	
	// FONCTIONS

}
