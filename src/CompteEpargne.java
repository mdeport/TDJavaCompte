
public class CompteEpargne extends Compte {
    private double interet;
    
    public CompteEpargne(Personne proprietaire, long numero, double solde, double interet) {
        super(proprietaire, solde);
        this.interet = interet;
    }

    public CompteEpargne() {
        super( new Personne(), 0);
        this.interet = 0;
    }


    public double getInteret() {
        return interet;
    }

    public void setInteret(double interet) {
        this.interet = interet;
    }
}
