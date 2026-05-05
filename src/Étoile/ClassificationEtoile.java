package Étoile;

import java.io.IOException;

public interface ClassificationEtoile {

   boolean associerEtoiles(Etoile etoile);
   Type getType() throws IOException;
}
