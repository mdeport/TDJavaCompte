public abstract class Compte {
    private Personne proprietaire;
    private long numero;
    private double solde;
    static long compteur;

    void virement(Compte destination, double montant)
    {
        if (this.solde - montant >= 0)
        {
            this.solde -= montant;
            destination.solde += montant;
            System.out.println("Virement de " + montant + " effectué." + " Solde actuelle : " + this.solde);
        }
        else
        {
            System.out.println("Virement impossible, solde insuffisant.");
        }
    }

    public Compte(Personne proprietaire, double solde) {
        compteur++;
        this.proprietaire = proprietaire;
        this.numero = compteur;
        this.solde = solde;
    }

    public Personne getProprietaire() {
        return proprietaire;
    }

    public void setProprietaire(Personne proprietaire) {
        this.proprietaire = proprietaire;
    }

    public long getNumero() {
        return numero;
    }

    public double getSolde() {
        return solde;
    }

    public void setSolde(double solde) {
        this.solde = solde;
    }

    void retirer(double montant)
    {
        if (solde - montant >= 0)
        {
            solde -= montant;
            System.out.println("Retrait de " + montant + " effectué." + " Solde actuelle : " + solde);
        }
        else
        {
            System.out.println("Retrait impossible, solde insuffisant.");
        }
    }

    void crediter(double montant)
    {
        solde += montant;
        System.out.println("Crédit de " + montant + " effectué." + " Solde actuelle : " + solde);
    }
}
