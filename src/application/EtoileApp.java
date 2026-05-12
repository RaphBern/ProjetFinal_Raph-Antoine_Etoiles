package application;

import Étoile.CompoRaies;
import Étoile.Couleurs;
import Étoile.Etoile;
import Étoile.RegleTemp;
import Étoile.Type;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class EtoileApp {
    public static void main(String[] args) throws IOException {

        Scanner lecteur = new Scanner(System.in);
        Etoile etoile = new Etoile(0,null,null);
        System.out.println("Si vous vouler connaître le type d'une étoile appuiée sur R:\nSi vous vouler connaître les caractéristique d'un type entrer la lettre du type:");
        String entree = lecteur.nextLine();
            if(entree.equalsIgnoreCase("R")) {
                System.out.println("Entrer la température de l'étoile (si la donnée est inconnu écrire R):");
                String entreeTemp = lecteur.nextLine();
                while (!entreeTemp.equalsIgnoreCase("R")) {
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
                        Couleurs couleur = Couleurs.valueOf(entreeColor);
                        etoile.setCouleur(couleur);
                        break;
                    } catch (IllegalArgumentException e) {
                        System.out.println("Couleur invalide ou inutile pour la classification");
                        System.out.println("Entrez à nouveau la couleur ou R si vous n'avez pas d'autre données");

                    }
                    entreeColor = lecteur.nextLine();
                }

                System.out.println("Entrer un element de la composition du raie d'absorbtion (si inconnu ecrire R)");
                String entreeElements = lecteur.nextLine();
                ArrayList<CompoRaies> compo = new ArrayList<>();
                while (!entreeElements.equalsIgnoreCase("R")) {
                    entreeElements = entreeElements.toUpperCase();
                    try {
                        compo.add(CompoRaies.valueOf(entreeElements));
                        System.out.println("Entrée valide, entrer le prochain élément (si le reste est inconnu, entrer R)");
                    } catch (IllegalArgumentException e) {
                        System.out.println("Élément inconnu ou inutile pour la classification");
                        System.out.println("Entrez à nouveau l'élément ou R si le reste de la composition des raies est inconnue ");
                    }
                    entreeElements = lecteur.nextLine();
                }
                etoile.setCompoSurface(compo);
                System.out.println(compo);
                System.out.println(etoile.toString());
            }
            else{
                while(!entree.equalsIgnoreCase("R")) {
                try {
                    Type type = Type.valueOf(entree);
                    System.out.println(RegleTemp.toString(type));
                }catch(IllegalArgumentException e) {
                    System.out.println("Type inconnu ou il n'a pas été écrit en majuscule");
                }
                entree = lecteur.nextLine();}
            }
    }

}
