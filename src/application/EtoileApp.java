package application;

import Étoile.CompoRaies;
import Étoile.Composition;
import Étoile.Etoile;
import Étoile.RegleTemp;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class EtoileApp {
    public static void main(String[] args) throws IOException {

        Scanner lecteur = new Scanner(System.in);
        Etoile etoile = new Etoile(0,null,null);
        System.out.println("Entrer la température de l'étoile (si la donnée est inconnu écrire R):");
        String entreeTemp = lecteur.nextLine();
        if (entreeTemp.equals("R")){
            entreeTemp = null;
        }

        System.out.println("Entrer la couleur de l'étoile (si la couleur est inconnu écrire R):");
        String entreeColor = lecteur.nextLine();
        entreeColor = entreeColor.toUpperCase();
        if (entreeColor.equals("R")){

        }

        System.out.println("Entrer un element de la composition du raie d'absorbtion (si inconnu ecrire R)");
        String entreeElements = lecteur.nextLine();
        entreeElements = entreeElements.toUpperCase();
         ArrayList<CompoRaies> compo = new ArrayList<>();
         while (!entreeElements.equals("R")) {

             compo.add(CompoRaies.valueOf(entreeElements));
             System.out.println("Entrée valide, entrer le prochain élément (si le reste est inconnu, entrer R)");
             entreeElements = lecteur.nextLine();
         }
    }
}
