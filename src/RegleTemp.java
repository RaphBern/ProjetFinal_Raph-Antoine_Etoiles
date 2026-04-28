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

    @Override
    public Type getType() {
        return null;
    }
}
