import java.util.Scanner;
import java.util.ArrayList;
import java.util.TreeMap;
import java.util.Comparator;

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
            System.out.printf("%-30s|", "Zadanie 5. - Mapy");
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
                System.out.println("Zadanie 5.");
                ArrayList<Person> people = new ArrayList<>();

                //dodanie osob:

                people.add(new Person("Hanna", 19));
                people.add(new Person("Anna", 20));
                people.add(new Person("Adrien", 15));
                people.add(new Person("Kennit", 34));

                System.out.println("Lista przed sortowaniem wg wieku:");
                System.out.println(people);

                //sortowanie
                people.sort(Comparator.comparingInt(person -> person.age));
                //inny zapis:
                /*people.sort((person1, person2) -> {
                    if(person1.age < person2.age) return -1;
                    if(person1.age > person2.age) return 1;
                    return 0;
                });*/
                System.out.println("Lista po sortowaniu wg wieku:");
                System.out.println(people);

                System.out.println("Koniec zadania 5.\n");
                pause.nextLine(); //pseudo pauza
                break;
            case 3:
                System.out.println("Zadanie 6.");

                TreeMap<String, Integer> cities = new TreeMap<>();



                System.out.println("Koniec zadania 6.\n");
                pause.nextLine(); //pseudo pauza
                break;
            default:
                System.out.println("Wybrany numer nie jest ze zbioru {0, 1, 2, 3}. \n " +
                        "Prosze sprobowac jeszcze raz.\n\n");
        }
    }
}
