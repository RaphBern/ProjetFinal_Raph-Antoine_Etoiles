package Étoile;

import java.io.IOException;
import java.util.HashMap;

public interface ClassificationEtoile {

   boolean associerEtoiles(Etoile etoile);
   HashMap<Type, Double> getType() throws IOException;
}
