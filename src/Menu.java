import java.util.Scanner;

public class Menu {
    Scanner scanner = new Scanner(System.in);
    private int menu_zajecia=-1;
    Zajecia zajeciaWybrane;

    //pusty konstruktor
    public Menu() {}

    public void runMenu() {
        while (true) {
            System.out.println("Prosze wybrac numer zajec:\n");
            System.out.printf("%-30s|", "Zajecia");
            System.out.print("Cyfra, aby je wybrac:\n");
            System.out.printf("%-30s|", "Zajecia 2 - kolekcje");
            System.out.print("1\n");
            System.out.printf("%-30s|", "Zajecia 3 - GUI ze SWING");
            System.out.print("2\n");
            System.out.printf("%-30s|", "Koniec wybierania");
            System.out.print("0\n");

            //choice = Integer.parseInt(scanner.nextLine());
            menu_zajecia = scanner.nextInt();
            this.decisionMethod(menu_zajecia);
            if(menu_zajecia==1 || menu_zajecia==2) break; //przerywa petle while
        }
        zajeciaWybrane.menuTychZajec();
    }

    private void decisionMethod(int number) {
        switch (number) {
            case 0:
                System.out.println("Koniec wybierania. Koniec programu.");
                System.exit(0);
                break;
            case 1:
                zajeciaWybrane = new ZajeciaDrugie();
                break;
            case 2:
                zajeciaWybrane = new ZajeciaTrzecie();
                break;
            default:
                System.out.println("Wybrany numer nie jest ze zbioru {0, 1, 2}. \n " +
                        "Prosze sprobowac jeszcze raz.\n");
        }
    }

}
