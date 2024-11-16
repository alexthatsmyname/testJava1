package problema_test;

import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class MainApp {

    public static void afisarePublicatii(List<Publicatie> publicatii) {
       for(Publicatie publicatie : publicatii) {
           System.out.println(publicatie);
       }
    }

    public static void filtrareDupaAn(List<Publicatie> publicatii, int an) {
        publicatii.stream().filter(publicatie -> publicatie.getAnPublicare() == an).forEach(System.out::println);
    }

    public static void afisareDoarCarti(List<Publicatie> publicatii) {
        publicatii.stream().filter(publicatie -> publicatie instanceof Carte).forEach(System.out::println);
    }

    public static void revistaCuCeleMaiMulteExemplare(List<Publicatie> publicatii) {
        publicatii.stream().filter(publicatie -> publicatie instanceof Revista).
                map(publicatie -> (Revista) publicatie).max((r1, r2) -> Integer.compare(r1.getAnPublicare(), r2.getAnPublicare())).ifPresent(System.out::println);
    }

    public static void adaugarePublicatie(List<Publicatie> publicatii, Scanner scanner) {
        System.out.println("Introduceti tipul: (Revista/Carte)");
        String tip = scanner.nextLine();

        System.out.println("Introduceti titlul: ");
        String titlu = scanner.nextLine();

        System.out.println("Introduceti autorul: ");
        String autor = scanner.nextLine();

        System.out.println("Introduceti anul publicarii: ");
        int anPublicare = scanner.nextInt();
        scanner.nextLine();

        if(tip.equalsIgnoreCase("Carte")) {
            System.out.println("Introduceti numarul de pagini: ");
            int pagini = scanner.nextInt();
            scanner.nextLine();
            publicatii.add(new Carte(titlu, autor, anPublicare, pagini));
        } else if(tip.equalsIgnoreCase("Revista")) {
            System.out.println("Introduceti numarul de exemplare: ");
            int exemplare = scanner.nextInt();
            scanner.nextLine();
            publicatii.add(new Revista(titlu, autor, anPublicare, exemplare));
        } else {
            System.out.println("Tip invalid");
        }
    }

    public static void main(String[] args) {
        List<Publicatie> publicatii = CSVUtils.citestePublicatiiDinCSV("publicatie.txt");
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Meniu:");
            System.out.println("1. Afișare toate publicațiile");
            System.out.println("2. Filtrare după an");
            System.out.println("3. Afișare doar cărți");
            System.out.println("4. Afișare revista cu cele mai multe exemplare");
            System.out.println("5. Adăugare publicație");
            System.out.println("0. Ieșire");
            int option = scanner.nextInt();
            scanner.nextLine();

            switch (option) {
                case 1:
                    afisarePublicatii(publicatii);
                    break;
                case 2:
                    System.out.println("Introduceti anul pe care il cautati: ");
                    int anCautat = scanner.nextInt();
                    scanner.nextLine();
                    filtrareDupaAn(publicatii, anCautat);
                    break;
                case 3:
                    System.out.println("Afisare carti: ");
                    afisareDoarCarti(publicatii);
                    break;
                case 4:
                    System.out.println("Revista cu cele multe exemplare: ");
                    revistaCuCeleMaiMulteExemplare(publicatii);
                    break;
                case 5:
                    adaugarePublicatie(publicatii, scanner);
                    break;
                case 0:
                    System.out.println("Iesire din aplicatie...");
                    return;
            }
        }
    }
}
