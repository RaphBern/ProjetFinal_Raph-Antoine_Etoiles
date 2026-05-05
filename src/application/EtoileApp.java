package application;

import Étoile.Composition;
import Étoile.Etoile;
import Étoile.RegleTemp;

import java.io.IOException;

public class EtoileApp {
    public static void main(String[] args) throws IOException {
        Etoile etoile = new Etoile(30000,new Composition());
        Etoile etoile1 = new Etoile(1000,new Composition());
        RegleTemp regleTemp = new RegleTemp();
        System.out.println(regleTemp.getType(etoile));
    }
}
