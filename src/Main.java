import java.util.Arrays;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        /*Personne personne = new Personne();
        personne.setPrenom("Martin");
        personne.setNom("Dupont");
        System.out.println(personne.toString());

        CompteEpargne compteEpargne = new CompteEpargne(personne, 123456789, 1000.0, 0.02);
        CompteCourant compteCourant = new CompteCourant(personne, 987654321, 1000.0, 200.0);

        Transaction transactionEpargne = new Transaction(compteEpargne);
        Transaction transactionCourant = new Transaction(compteCourant);

        compteEpargne.crediter(100.0);
        transactionEpargne.ajouterOperation("Crédit de 100.0 sur le compte épargne par M." + personne.getNom());
        compteEpargne.retirer(200.0);
        transactionEpargne.ajouterOperation("Retrait de 200.0 sur le compte épargne par M." + personne.getNom());
        compteCourant.crediter(100.0);
        transactionCourant.ajouterOperation("Crédit de 100.0 sur le compte courant par M." + personne.getNom());
        compteCourant.retirer(200.0);
        transactionCourant.ajouterOperation("Retrait de 200.0 sur le compte courant par M." + personne.getNom());


        System.out.println("Historique des opérations du compte épargne : " + Arrays.toString(transactionEpargne.getHistoriqueOperations()));
        System.out.println("Historique des opérations du compte courant : " + Arrays.toString(transactionCourant.getHistoriqueOperations()));
        */

        Scanner scanner = new Scanner(System.in);
        Personne personne = null;
        CompteEpargne compteEpargne = null;
        CompteCourant compteCourant = null;
        Transaction transactionEpargne = null;
        Transaction transactionCourant = null;

        while (true) {
            System.out.println("Menu:");
            System.out.println("1. Ajouter un client");
            System.out.println("2. Créer un compte épargne");
            System.out.println("3. Créer un compte courant");
            System.out.println("4. Effectuer un dépôt");
            System.out.println("5. Effectuer un retrait");
            System.out.println("6. Effectuer un virement");
            System.out.println("7. Afficher les comptes");
            System.out.println("8. Afficher l'historique des opérations");
            System.out.println("9. Quitter");
            System.out.print("Choisissez une option: ");
            int choix = scanner.nextInt();
            scanner.nextLine();

            switch (choix) {
                case 1:
                    System.out.print("Entrez le prénom du client: ");
                    String prenom = scanner.nextLine();
                    System.out.print("Entrez le nom du client: ");
                    String nom = scanner.nextLine();

                    personne = new Personne();
                    personne.setPrenom(prenom);
                    personne.setNom(nom);
                    System.out.println("Le client " + personne.getPrenom() + " " + personne.getNom() + " a été ajouté.");
                    break;
                
                case 2:
                    if (personne == null) {
                        System.out.println("Veuillez d'abord ajouter un client.");
                        break;
                    }
                    else{
                        System.out.print("Entrez le numéro de compte: ");
                        int numeroCompte = scanner.nextInt();
                        System.out.print("Entrez le solde initial: ");
                        double soldeInitial = scanner.nextDouble();
                        System.out.print("Entrez le taux d'intérêt: ");
                        double tauxInteret = scanner.nextDouble();

                        compteEpargne = new CompteEpargne(personne, numeroCompte, soldeInitial, tauxInteret);
                        transactionEpargne = new Transaction(compteEpargne);
                        System.out.println("Le compte épargne " + numeroCompte + " a bien été créé, pour " + personne.getPrenom() + " " + personne.getNom());
                        break;
                    }
                
                case 3:
                    if (personne == null) {
                        System.out.println("Veuillez d'abord ajouter un client.");
                        break;
                    }
                    else{
                        System.out.print("Entrez le numéro de compte: ");
                        int numeroCompte = scanner.nextInt();
                        System.out.print("Entrez le solde initial: ");
                        double soldeInitial = scanner.nextDouble();
                        System.out.print("Entrez le découvert autorisé: ");
                        double decouvertAutorise = scanner.nextDouble();

                        compteCourant = new CompteCourant(personne, numeroCompte, soldeInitial, decouvertAutorise);
                        transactionCourant = new Transaction(compteCourant);
                        System.out.println("Le compte courant " + numeroCompte + " a bien été créé, pour " + personne.getPrenom() + " " + personne.getNom());
                        break; 
                    }
                case 4: 
                    System.out.print("Entrez le type de compte (1 pour épargne, 2 pour courant): ");
                    int typeCompte = scanner.nextInt();
                    System.out.print("Entrez le montant à déposer: ");
                    double montantDepot = scanner.nextDouble();
                    if (typeCompte == 1 && compteEpargne != null) {
                        compteEpargne.crediter(montantDepot);
                        transactionEpargne.ajouterOperation("Crédit de " + montantDepot + " sur le compte épargne le solde actuel est de " + compteEpargne.getSolde());
                        System.out.println("Dépôt effectué sur le compte épargne.");
                    } else if (typeCompte == 2 && compteCourant != null) {
                        compteCourant.crediter(montantDepot);
                        transactionCourant.ajouterOperation("Crédit de " + montantDepot + " sur le compte courant le solde actuel est de " + compteCourant.getSolde());
                        System.out.println("Dépôt effectué sur le compte courant.");
                    } else {
                        System.out.println("Compte non trouvé.");
                    }
                    break;

                case 5:
                    System.out.print("Entrez le type de compte (1 pour épargne, 2 pour courant): ");
                    typeCompte = scanner.nextInt();
                    System.out.print("Entrez le montant à retirer: ");
                    double montantRetrait = scanner.nextDouble();
                    if (typeCompte == 1 && compteEpargne != null) {
                        compteEpargne.retirer(montantRetrait);
                        transactionEpargne.ajouterOperation("Retrait de " + montantRetrait + " sur le compte épargne le solde actuel est de " + compteEpargne.getSolde());
                        System.out.println("Retrait effectué sur le compte épargne.");
                    } else if (typeCompte == 2 && compteCourant != null) {
                        compteCourant.retirer(montantRetrait);
                        transactionCourant.ajouterOperation("Retrait de " + montantRetrait + " sur le compte courant le solde actuel est de " + compteCourant.getSolde());   
                        System.out.println("Retrait effectué sur le compte courant.");
                    } else {
                        System.out.println("Compte non trouvé.");
                    }
                    break;
                
                case 6:
                    System.out.print("Entrez le montant à virer: ");
                    double montantVirement = scanner.nextDouble();
                    if (compteEpargne != null && compteCourant != null) {
                        System.out.print("Entrez le compte source (1 pour épargne, 2 pour courant): ");
                        int compteSource = scanner.nextInt();
                        System.out.print("Entrez le compte destination (1 pour épargne, 2 pour courant): ");
                        int compteDestination = scanner.nextInt();
                        if (compteSource == 1 && compteDestination == 2) {
                            compteEpargne.virement(compteCourant, montantVirement);
                            transactionEpargne.ajouterOperation("Virement de " + montantVirement + " sur le compte courant le solde actuel est de " + compteEpargne.getSolde());
                            transactionCourant.ajouterOperation("Virement de " + montantVirement + " sur le compte courant le solde actuel est de " + compteCourant.getSolde());
                            System.out.println("Virement effectué de l'épargne vers le courant.");
                        } else if (compteSource == 2 && compteDestination == 1) {
                            compteCourant.virement(compteEpargne, montantVirement);
                            transactionEpargne.ajouterOperation("Virement de " + montantVirement + " sur le compte épargne le solde actuel est de " + compteEpargne.getSolde());
                            transactionCourant.ajouterOperation("Virement de " + montantVirement + " sur le compte épargne le solde actuel est de " + compteCourant.getSolde());
                            System.out.println("Virement effectué du courant vers l'épargne.");
                        } else {
                            System.out.println("Compte source ou destination invalide.");
                        }
                    } else {
                        System.out.println("vous devez créer un compte épargne et un compte courant pour effectuer un virement.");
                    }
                    break;    

                
                case 7:
                    if (compteEpargne != null) {
                        System.out.println("Compte épargne: " + compteEpargne.getSolde() + "€" + " Taux d'intérêt: " + compteEpargne.getInteret());
                    }
                    if (compteCourant != null) {
                        System.out.println("Compte courant: " + compteCourant.getSolde() + "€" + " Découvert autorisé: " + compteCourant.getDecouvert() + "€");
                    }
                    break;

                case 8:
                    if (transactionEpargne != null) {
                        System.out.println("Historique des opérations du compte épargne: " + Arrays.toString(transactionEpargne.getHistoriqueOperations()));
                    }
                    if (transactionCourant != null) {
                        System.out.println("Historique des opérations du compte courant: " + Arrays.toString(transactionCourant.getHistoriqueOperations()));
                    }
                    break;

                case 9:
                    System.out.println("Au revoir!");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Option invalide.");
                    break;
            }

            
        }
    }
}