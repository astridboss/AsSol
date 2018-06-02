package jeu;

import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * MAIN : POINT DE DEPART
 */
public class Main{

	public static void main(String[] args) throws IOException {
		
	//AFFICHAGE MENU
//	MenuJeu menu = new MenuJeu();
//	menu.Menu ();
    PanelArme armeee =new PanelArme();
	armeee.deplacementUnit();
	}
}