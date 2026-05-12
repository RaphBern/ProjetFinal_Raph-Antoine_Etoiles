package Étoile;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class RegleTemp {
    Type type;

    public RegleTemp(Type type) {
        this.type = type;
    }

    public Type getType() {
        return type;
    }

    public static ArrayList temp(Type type) throws IOException {
        ArrayList<Object> temp = new ArrayList<>();
        String line;
        BufferedReader fichier = new BufferedReader(new FileReader("src/DonneesClassification/ClassificationsTemperature.csv"));
        fichier.readLine();
        line = fichier.readLine();
        while (line != null) {
            String[] etoilez = line.split(",");
            if(type.equals(Type.valueOf(etoilez[2]))) {
                for (int i = 0; i < etoilez.length -1; i++) {
                    if(!etoilez[i].equals("null")) {
                        temp.add(etoilez[i]);
                    }
                }
            }

            line = fichier.readLine();
        }
        return temp;
    }

    public static ArrayList compo(Type type) throws IOException {
        ArrayList<Object> compo = new ArrayList<>();
        String line;
        BufferedReader fichier = new BufferedReader(new FileReader("src/DonneesClassification/ClassificationComposition.csv"));
        fichier.readLine();
        line = fichier.readLine();
        while (line != null) {
            String[] etoilez = line.split(",");
            if(type.equals(Type.valueOf(etoilez[4]))) {
                for (int i = 0; i < etoilez.length - 1; i++) {
                    if(!etoilez[i].equals("null")) {
                        compo.add(etoilez[i]);
                    }
                }
            }

            line = fichier.readLine();
        }
        return compo;
    }

    public static ArrayList couleur(Type type) throws IOException {
        ArrayList<Object> couleur = new ArrayList<>();
        String line;
        BufferedReader fichier = new BufferedReader(new FileReader("src/DonneesClassification/ClassificationCouleur.csv"));
        fichier.readLine();
        line = fichier.readLine();
        while (line != null) {
            String[] etoilez = line.split(",");
            if(type.equals(Type.valueOf(etoilez[2]))) {
                for (int i = 0; i < etoilez.length - 1; i++) {
                    if(!etoilez[i].equals("null")) {
                        couleur.add(etoilez[i]);
                    }
                }
            }

            line = fichier.readLine();
        }
        return couleur;
    }

    public static String toString(Type type) throws IOException {
        return "Température: " + temp(type) + "\nCouleur: " + couleur(type) + "\nComposition: " + compo(type);
    }

}
