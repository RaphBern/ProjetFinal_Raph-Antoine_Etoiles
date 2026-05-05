package application;

import Étoile.Composition;
import Étoile.Etoile;
import Étoile.RegleTemp;

import java.io.IOException;
import java.util.Scanner;

public class EtoileApp {
    public static void main(String[] args) throws IOException {
        Etoile etoile = new Etoile(30000,new Composition(), "Bleue");
        Etoile etoile1 = new Etoile(10001,new Composition(), "Bleue");
        RegleTemp regleTemp = new RegleTemp();
        System.out.println(etoile1.getType());


        Scanner lecteur = new Scanner(System.in);
        System.out.println("Entrer la température de l'étoile (si la donnée est inconnu écrire R):");
        String entreeTemp = lecteur.nextLine();
        Integer.parseInt(entreeTemp);

        System.out.println("Entrer la couleur de l'étoile (si la couleur est inconnu écrire A):");
        String entreeColor = lecteur.nextLine();

        System.out.println("Entrer un element de la composition du raie d'absorbtion ()");
        String entreeElements = lecteur.nextLine();

    }
}
