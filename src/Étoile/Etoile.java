package Étoile;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.lang.annotation.ElementType;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.function.DoubleToIntFunction;

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

    public double getProbabilite(HashMap<Type, Integer> resultat){
        int total = 0;
        int plusGrandQue = 0;
        for (Map.Entry<Type, Integer> entry : resultat.entrySet()){
            if (entry.getValue() > plusGrandQue){
                plusGrandQue = entry.getValue();
                total += entry.getValue();
            }
        }
        return ((double) plusGrandQue /total) * 100;
    }

    public Type getResultat(HashMap<Type, Integer> resultat) {
       Type meilleurType = null;
       int plusGrandQue = 0;
        for (Map.Entry<Type, Integer> entry : resultat.entrySet()){
            if (entry.getValue() > plusGrandQue){
                plusGrandQue = entry.getValue();
                meilleurType = entry.getKey();
            }
        }
        return meilleurType;
    }

    @Override
    public boolean associerEtoiles(Etoile etoile) {
        return false;
    }

    public HashMap<Type, Double> getType() throws IOException {
        int tempMin;
        int tempMax;
        String Couleur;
        String Couleur2;
        Type typeTemp = null;
        Type[] typeCouleur = null;
        HashMap<Type, Integer> probabilites = new HashMap<Type, Integer>();
        int y = 0;
        probabilites.put(Type.O, y);
        probabilites.put(Type.B, y);
        probabilites.put(Type.A, y);
        probabilites.put(Type.F, y);
        probabilites.put(Type.G, y);
        probabilites.put(Type.K, y);
        probabilites.put(Type.M, y);

        String line;
        BufferedReader fichier = new BufferedReader(new FileReader("src/DonneesClassification/ClassificationsTemperature.csv"));
        fichier.readLine();
        line = fichier.readLine();
        while (line != null) {
            String[] etoilez = line.split(",");
            tempMin = Integer.parseInt(etoilez[0]);
            tempMax = Integer.parseInt(etoilez[1]);
            if (getTempCouleur() > tempMin && getTempCouleur() < tempMax){
                probabilites.replace(Type.valueOf(etoilez[2]), +1);
            }
            line = fichier.readLine();
        }
        String line1;
        BufferedReader fichier1 = new BufferedReader(new FileReader("src/DonneesClassification/ClassificationCouleur.csv"));
        fichier1.readLine();
        line1 = fichier1.readLine();
        while (line1 != null) {
            String[] etoilex = line1.split(",");
            Couleur = etoilex[0];
            Couleur2 = etoilex[1];

         try {
             if (getCouleur().toString().equals(Couleur) || getCouleur().toString().equals(Couleur2)) {
                 probabilites.replace(Type.valueOf(etoilex[2]), +1);
             }
             line1 = fichier1.readLine();
         }catch (NullPointerException e) {
            break;
         }
        }
        String line2;
        BufferedReader fichier2 = new BufferedReader(new FileReader("src/DonneesClassification/ClassificationComposition.csv"));
        fichier2.readLine();
        line2 = fichier2.readLine();
        while (line != null) {
            String[] etoilez = line2.split(",");
          for (int o = 1; o < getCompoSurface().size();o++){
              if (getCompoSurface().get(o).equals(CompoRaies.valueOf(etoilez[o]))) {
                  probabilites.replace(Type.valueOf(etoilez[o]),+1);
              }
          }
        }
        fichier2.close();
        fichier1.close();
        fichier.close();
        HashMap<Type, Double> type = new HashMap<>();
        type.put(getResultat(probabilites), getProbabilite(probabilites));
        return type;
    }
}


