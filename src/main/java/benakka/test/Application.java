package benakka.test;

import benakka.metier.Compte;
import benakka.metier.IMetierBanque;
import benakka.metier.MetierBanqueImpl;

import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        new Application().start();
    }

    private void start() {
        System.out.println("Démarrage de l'application");
        Scanner scanner=new Scanner(System.in);
        System.out.print("Donner le code du compte :");
        long code=scanner.nextLong();
        System.out.print("Donner le solde initiale du compte :");
        double solde=scanner.nextDouble();
        IMetierBanque metierBanque=new MetierBanqueImpl();
        metierBanque.addCompte(new Compte(code,solde));
        while (true){
            try {
                System.out.print("Type Opération:");
                String type=scanner.next();
                if (type.equals("q")) break;
                System.out.print("Montant :");
                double montant=scanner.nextDouble();
                if(type.equals("v")){
                    metierBanque.verser(code,montant);
                }
                else if (type.equals("r")){
                    metierBanque.retirer(code,montant);
                }
                Compte compte = metierBanque.consulter(code);
                System.out.println("Solde = "+compte.toString());
            }catch (Exception e){
                System.out.println(e.getMessage());
            }

        }
    }
}
