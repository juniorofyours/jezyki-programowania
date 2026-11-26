package LaboratoriumTrzecie;

import Wspolne.Zajecia;

import java.util.Scanner;

public class ZajeciaTrzecie implements Zajecia {
    Scanner scanner = new Scanner(System.in);
    Scanner pause = new Scanner(System.in); //dla pauz w kompilatorze
    private int menu=-1;

    @Override
    public void menuTychZajec() {
        //brak menu
        System.out.println("Jedno jedyne zadanie (popdpunkty 1, 2, 3, 5).");
        System.out.println("Prosze narazie wlaczac aplikacje okiekowa przez MainWindow (z powodu braku czasu nie zrobilem menu).");
    }

    public void decisionMethod() {
        //nie mam jeszcze tu nic
    }
}