public class Transaction {
    private Compte compte;
    private String[] historiqueOperations;
    private int Index;

    public Transaction(Compte compte) {
        this.compte = compte;
        this.historiqueOperations = new String[100];
        this.Index = 0;
    }

    public void ajouterOperation(String operation) {
        if (Index < historiqueOperations.length) {
            historiqueOperations[Index] = operation;
            Index++;
        } else {
            System.out.println("Historique des opérations est plein.");
        }
    }

    public String[] getHistoriqueOperations() {
        String[] result = new String[Index];
        System.arraycopy(historiqueOperations, 0, result, 0, Index);
        return result;
    }
}
