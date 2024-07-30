public class Personne {
    public String nom;
    public String prenom;
    public enum etatCivil {CELIBATAIRE, MARIE, DIVORCE, VEUF};

    public Personne(String nom, String prenom) {
        this.nom = nom;
        this.prenom = prenom;
    }

    public Personne() {
        this.nom = "";
        this.prenom = "";
    }

    public String getNom() {
        return nom;
    }
    public void setNom(String nom) {
        this.nom = nom;
    }
    public String getPrenom() {
        return prenom;
    }
    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }
    public String toString() {
        return "Personne [nom=" + nom + ", prenom=" + prenom + "]";
    }
}