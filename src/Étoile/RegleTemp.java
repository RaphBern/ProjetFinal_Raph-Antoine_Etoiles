package Étoile;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class RegleTemp implements ClassificationEtoile {
int tempCouleurMin;
int tempCouleurMax;
Type typeEtoile;

public RegleTemp(int tempCouleurMin, int tempCouleurMax, Type typeEtoile){
    tempCouleurMin = this.tempCouleurMin;
    tempCouleurMax = this.tempCouleurMax;
    typeEtoile = this.typeEtoile;
}
    @Override
    public boolean associerEtoiles(Etoile etoile) {
        return false;
    }

    public Type getType(Etoile etoile) throws IOException {
        int tempMin;
        int tempMax;
        Type type = null;
        String line;
        BufferedReader fichier = new BufferedReader(new FileReader("src/Classifications.csv"));
        line = fichier.readLine();
        while (line != null) {
            String[] etoilez = line.split(",");
            tempMin = Integer.parseInt(etoilez[0]);
            tempMax = Integer.parseInt(etoilez[1]);
            if (etoile.getTempCouleur() > tempMin || etoile.getTempCouleur() < tempMax){
                type = Type.valueOf(etoilez[2]);
            }
            line = fichier.readLine();
        }
 fichier.close();
        return type;
    }
}
