import java.util.Scanner;
import java.io.IOException;

public class ZajeciaDrugie implements Zajecia{
    Scanner scanner = new Scanner(System.in);
    Scanner pause = new Scanner(System.in); //dla pauz w kompilatorze
    private int menu=-1;

    @Override
    public void menuTychZajec() {
        while (menu != 0) {
            System.out.println("Zajecia 2.\n Prosze wybrac numer zadania:\n");
            System.out.printf("%-30s|", "Zadanie.");
            System.out.print("Cyfra, aby je wybrac:\n");
            System.out.printf("%-30s|", "Zadanie 4. - HashSet.");
            System.out.print("1\n");
            System.out.printf("%-30s|", "Zadanie x. - Mapy");
            System.out.print("2\n");
            System.out.printf("%-30s|", "Zadanie y. - HashList");
            System.out.print("3\n");
            System.out.printf("%-30s|", "Koniec wybierania");
            System.out.print("0\n");

            //choice = Integer.parseInt(scanner.nextLine());
            menu = scanner.nextInt();
            this.decisionMethod(menu);
        }
    }

    public void decisionMethod(int number) {
        switch (number) {
            case 0:
                System.out.println("Koniec wybierania. Koniec.");
                break;
            case 1:
                System.out.println("Zadanie 4.");

                System.out.println("Dodadnie produktow:");
                Products products = new Products();
                products.addProductsLoop();
                System.out.println("Produkty w sklepie: " + products.PerfumeShopProducts);

                System.out.println("Koniec zadania 4.\n");
                pause.nextLine(); //pseudo pauza
                break;
            case 2:
                System.out.println("Zadanie x.");
                System.out.println("Koniec zadania x.\n");
                break;
            case 3:
                System.out.println("Zadanie y.");
                System.out.println("Koniec zadania y.\n");
                break;
            default:
                System.out.println("Wybrany numer nie jest ze zbioru {0, 1, 2, 3}. \n " +
                        "Prosze sprobowac jeszcze raz.\n\n");
        }
    }
}
