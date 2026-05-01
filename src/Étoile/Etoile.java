package Étoile;

public class Etoile implements ClassificationEtoile {
    int tempCouleur;
  Composition compoSurface;



    public Etoile(int tempCouleur, Composition compoSurface) {
        tempCouleur = this.tempCouleur;
        compoSurface = this.compoSurface;

    }

    public int getTempCouleur() {
        return tempCouleur;
    }


    public int compareTo(Etoile autreEtoile){
        return autreEtoile.getTempCouleur() - this.tempCouleur;
    }


    @Override
    public boolean associerEtoiles(Etoile etoile) {
        return false;
    }

    @Override
    public Type getType() {
        return null;
    }
}


