import java.util.ArrayList;

public class Etoile {
    int tempCouleur;
    ArrayList<String> compoSurface;
    Type classification;


    public Etoile(int tempCouleur, ArrayList<String> compoSurface, Type classification) {
        tempCouleur = this.tempCouleur;
        compoSurface = this.compoSurface;
        classification = this.classification;
    }

    public int getTempCouleur() {
        return tempCouleur;
    }

    public Type getClassification() {
        return classification;
    }

}


