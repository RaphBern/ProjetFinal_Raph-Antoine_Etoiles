package Étoile;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.lang.annotation.ElementType;
import java.util.ArrayList;

public class Etoile implements ClassificationEtoile {
    int tempCouleur;
    Couleurs couleur;
  ArrayList<CompoRaies> compoSurface;



    public Etoile(int tempCouleur, ArrayList<CompoRaies> compoSurface, Couleurs couleurs) {
        this.tempCouleur = tempCouleur;
        this.compoSurface = compoSurface;
        this.couleur = couleurs;

    }

    public int getTempCouleur() {
        return tempCouleur;
    }

    public Couleurs getCouleur() {
        return couleur;
    }

    public int compareTo(Etoile autreEtoile){
        return autreEtoile.getTempCouleur() - this.tempCouleur;
    }

    public void setTempCouleur(int tempCouleur) {
      if (tempCouleur >= 2000 && tempCouleur <= 200000) {
          this.tempCouleur = tempCouleur;
      } else throw new IllegalArgumentException();
    }

    public void setCompoSurface(ArrayList<CompoRaies> compoSurface) {
        this.compoSurface = compoSurface;
    }

    public void setCouleur(Couleurs couleur) {
    boolean vrai = false;
      for (Couleurs couleurs : Couleurs.values()){
          if (couleurs.equals(couleur)) {
              this.couleur = couleur;
              vrai = true;
              break;
          }
      }
       if (!vrai) {
           throw new IllegalArgumentException();
       }
    }

    public ArrayList<CompoRaies> getCompoSurface() {
        return compoSurface;
    }

    @Override
    public String toString(){
        return "Température de couleur: " + getTempCouleur() + "\n Couleur: " + getCouleur() + "\n Composition des raies: " + getCompoSurface();
    }

    @Override
    public boolean associerEtoiles(Etoile etoile) {
        return false;
    }

    public Type getType() throws IOException {
        int tempMin;
        int tempMax;
        String Couleur;
        String Couleur2;
        Type typeTemp = null;
        Type[] typeCouleur = null;

        String line;
        BufferedReader fichier = new BufferedReader(new FileReader("src/DonneesClassification/ClassificationsTemperature.csv"));
        fichier.readLine();
        line = fichier.readLine();
        while (line != null) {
            String[] etoilez = line.split(",");
            tempMin = Integer.parseInt(etoilez[0]);
            tempMax = Integer.parseInt(etoilez[1]);
            if (getTempCouleur() > tempMin && getTempCouleur() < tempMax){
                typeTemp = Type.valueOf(etoilez[2]);
            }
            line = fichier.readLine();
        }
        String line1;
        BufferedReader fichier1 = new BufferedReader(new FileReader("src/DonneesClassification/CLassificationCouleur.csv"));
        fichier1.readLine();
        line1 = fichier1.readLine();
        int i = 0;
        while (line1 != null) {
            String[] etoilex = line1.split(",");
            Couleur = etoilex[0];
            Couleur2 = etoilex[1];

            if(getCouleur().toString().equals(Couleur) || getCouleur().toString().equals(Couleur2)){
               typeCouleur[i] = Type.valueOf(etoilex[2]);
               i++;
            }
            line1 = fichier1.readLine();
        }
        String line2;
        BufferedReader fichier2 = new BufferedReader(new FileReader("src/DonneesClassification/ClassificationsComposition.csv"));
        fichier2.readLine();
        line2 = fichier2.readLine();
        while (line != null) {
            String[] etoilez = line2.split(",");
            tempMin = Integer.parseInt(etoilez[0]);
            tempMax = Integer.parseInt(etoilez[1]);
            if (getTempCouleur() > tempMin && getTempCouleur() < tempMax){
                typeTemp = Type.valueOf(etoilez[2]);
            }
            line2 = fichier.readLine();
        }
        fichier1.close();
        fichier.close();
        return typeTemp;
    }
}


