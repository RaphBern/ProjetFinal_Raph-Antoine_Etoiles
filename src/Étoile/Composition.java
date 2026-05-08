package Étoile;

import java.util.ArrayList;

public class Composition {
    ArrayList<CompoRaies> elements = new ArrayList<>();


    public Composition(ArrayList<CompoRaies> elements) {
        this.elements = elements;
    }

    public ArrayList<CompoRaies> getElements() {
        return elements;
    }
}
