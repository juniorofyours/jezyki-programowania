import java.util.HashSet;
import java.util.Scanner;

public class Products {
    Scanner scanner = new Scanner(System.in);
    private int choice = -1;
    HashSet<Product> PerfumeShopProducts = new HashSet<>();

    Product perfumeNr1 = new Product(71882, 4950, "Perfume Nr1");
    Product perfumeNr2 = new Product(72889, 7899, "Perfume Nr2");
    Product aromatizedCandles = new Product(349811, 3549, "Aromatized Candles");

    public Products() {
    }

    /*Metoda uzywajaca switcha dla wyboru dokladnego produktu.*/
    private void addProductToList(int number) {
        switch (number) {
            case 0:
                System.out.println("Koniec wybierania.");
                break;
            case 1:
                PerfumeShopProducts.add(perfumeNr1);
                perfumeNr1.addToProductCount();
                break;
            case 2:
                PerfumeShopProducts.add(perfumeNr2);
                perfumeNr2.addToProductCount();
                break;
            case 3:
                PerfumeShopProducts.add(aromatizedCandles);
                aromatizedCandles.addToProductCount();
                break;
            default:
                System.out.println("Wybrany numer produktu nie jest ze zbioru {0, 1, 2, 3}. \n " +
                        "Prosze sprobowac jeszcze raz.\n\n");
        }
    }

    /*Metoda robiaca petle, az uzytkownik ja nie przerwie*/
    public void addProductsLoop() {
        while (choice != 0) {
            System.out.printf("%-40s|", "Prosze dodac do koszyka produkt. Spis produktow.\n");
            System.out.printf("%-20s|", "Spis produktow");
            System.out.print("Numer produktu\n");
            System.out.printf("%-20s|", "Perfumy Nr1");
            System.out.print("1\n");
            System.out.printf("%-20s|", "Perfumy Nr2");
            System.out.print("2\n");
            System.out.printf("%-20s|", "Aromatized Candles");
            System.out.print("3\n");
            System.out.printf("%-20s|", "Koniec wybierania");
            System.out.print("0\n");

            //choice = Integer.parseInt(scanner.nextLine());
            choice = scanner.nextInt();
            this.addProductToList(choice);
        }
    }

}
