package Étoile;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Etoile implements ClassificationEtoile {
    int tempCouleur;
    String couleur;
  Composition compoSurface;



    public Etoile(int tempCouleur, Composition compoSurface, String couleur) {
        this.tempCouleur = tempCouleur;
        this.compoSurface = compoSurface;
        this.couleur = couleur;

    }

    public int getTempCouleur() {
        return tempCouleur;
    }

    public String getCouleur() {
        return couleur;
    }

    public int compareTo(Etoile autreEtoile){
        return autreEtoile.getTempCouleur() - this.tempCouleur;
    }

    public void setTempCouleur(int tempCouleur) {
        this.tempCouleur = tempCouleur;
    }

    public void setCompoSurface(Composition compoSurface) {
        this.compoSurface = compoSurface;
    }

    public void setCouleur(String couleur) {
        this.couleur = couleur;
    }

    @Override
    public boolean associerEtoiles(Etoile etoile) {
        return false;
    }

    public Type getType() throws IOException {
        int tempMin;
        int tempMax;
        Type type = null;
        String line;
        BufferedReader fichier = new BufferedReader(new FileReader("src/DonneesClassification/ClassificationsTemperature.csv"));
        fichier.readLine();
        line = fichier.readLine();
        while (line != null) {
            String[] etoilez = line.split(",");
            tempMin = Integer.parseInt(etoilez[0]);
            tempMax = Integer.parseInt(etoilez[1]);
            if (getTempCouleur() > tempMin && getTempCouleur() < tempMax){
                type = Type.valueOf(etoilez[2]);
            }
            line = fichier.readLine();
        }
        fichier.close();
        return type;
    }
}


