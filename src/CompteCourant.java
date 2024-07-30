public class CompteCourant extends Compte {

private double decouvert;

public CompteCourant(Personne proprietaire, long numero, double solde, double decouvert) {
    super(proprietaire, solde);
    this.decouvert = decouvert;
}

public CompteCourant() {
    super( new Personne(), 0);
    this.decouvert = 0;
}

public double getDecouvert() {
    return decouvert;
}

public void setDecouvert(double decouvert) {
    this.decouvert = decouvert;
}

@Override void retirer(double montant)
{
    if (this.getSolde() - montant >= decouvert)
    {
        this.setSolde(this.getSolde() - montant);
        System.out.println("Retrait de " + montant + " effectué." + " Solde actuelle : " + this.getSolde());
    }
    else
    {
        System.out.println("Retrait impossible, solde insuffisant.");
    }
}

}