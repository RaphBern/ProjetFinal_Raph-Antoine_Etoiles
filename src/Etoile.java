import java.util.ArrayList;
import java.util.Comparator;

public class Etoile {
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



}


