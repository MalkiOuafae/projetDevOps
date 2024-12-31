package org.tva.mytva;
import java.util.Scanner;
/**
 * Hello world!
 *
 */
public class App {
    public static void main(String[] args) {
        System.out.println("Hello World!");

        Scanner scanner = new Scanner(System.in);
        CalculateurTva calculateurTva = new CalculateurTva();

        System.out.println("Bienvenue dans l'application Calculateur de TVA !");
        System.out.print("Entrez le montant : ");
        double montant = scanner.nextDouble();

        System.out.print("Entrez le pays (Maroc, France, Espagne) : ");
        String pays = scanner.next();

        try {
            double tva = calculateurTva.calculerTva(montant, pays);
            System.out.println("La TVA pour un montant de " + montant + " dans " + pays + " est : " + tva);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        scanner.close();
    }

}
