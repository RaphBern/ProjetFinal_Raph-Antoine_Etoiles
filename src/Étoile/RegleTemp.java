package Étoile;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class RegleTemp implements ClassificationEtoile {
    @Override
    public boolean associerEtoiles(Etoile etoile) {
        return false;
    }
@Override
    public Type getType() throws IOException {
//        int tempMin;
//        int tempMax;
//        Type type = null;
//        String line;
//        BufferedReader fichier = new BufferedReader(new FileReader("src/Classifications.csv"));
//        fichier.readLine();
//        line = fichier.readLine();
//        while (line != null) {
//            String[] etoilez = line.split(",");
//            tempMin = Integer.parseInt(etoilez[0]);
//            tempMax = Integer.parseInt(etoilez[1]);
//            if (getTempCouleur() > tempMin && getTempCouleur() < tempMax){
//                type = Type.valueOf(etoilez[2]);
//            }
//            line = fichier.readLine();
//        }
// fichier.close();
        return null;
    }
}
