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
         while (!entreeTemp.equals("R")){
            try {
                int temp = Integer.parseInt(entreeTemp);
                etoile.setTempCouleur(temp);
                break;
            } catch (IllegalArgumentException e) {
                System.out.println("Température impossible ou ");
                entreeTemp = lecteur.nextLine();
            }

        }

        System.out.println("Entrer la couleur de l'étoile (si la couleur est inconnue écrire R):");
        String entreeColor = lecteur.nextLine();
        entreeColor = entreeColor.toUpperCase();
      while (!entreeColor.equals("R")) {
          try {
              etoile.setCouleur(entreeColor);

          } catch (IllegalArgumentException e) {
              System.out.println("Couleur invalide ou inutile pour la classification");
              System.out.println("Entrez à nouveau la couleur ou R si vous n'avez pas d'autre données");

          }
          entreeColor = lecteur.nextLine();
      }

        System.out.println("Entrer un element de la composition du raie d'absorbtion (si inconnu ecrire R)");
        String entreeElements = lecteur.nextLine();
        entreeElements = entreeElements.toUpperCase();
         ArrayList<CompoRaies> compo = new ArrayList<>();
         while (!entreeElements.equals("R")) {
              try {
                  compo.add(CompoRaies.valueOf(entreeElements));
                  System.out.println("Entrée valide, entrer le prochain élément (si le reste est inconnu, entrer R)");
              }catch (IllegalArgumentException e) {
                  System.out.println("Élément inconnu ou inutile pour la classification");
                  System.out.println("Entrez à nouveau l'élément ou R si le reste de la composition des raies est inconnue ");
              }
             entreeElements = lecteur.nextLine();
         }
        System.out.println(compo);
    }
}
