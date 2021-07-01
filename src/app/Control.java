package app;

import file.Algorytm;
import file.KontenerList;
import model.Kontener;
import java.io.IOException;
import java.util.Scanner;

public class Control {
    private static final String FILENAME = "file.txt";
    private static final String FILENAME2 = "file2.txt";
    private Scanner sc = new Scanner(System.in);
    private int number;
    private int tmp;
    private int helpToRead = tmp;

    public void getOptions(){
        System.out.println("\n");
        System.out.println("1 - Generowanie listy x kontenerów i zapis do pliku: ");
        System.out.println("2 - Wczyta z pliku liste z kontenerami: ");
        System.out.println("3 - Posortuj wczytaną z pliku listę według wagi malejaco: ");
        System.out.println("4 - Posortuj według bezpiecznego rozkładu masy na statku: ");
        System.out.println("5 - Zapisz do pliku bezpiecznie rozłożone kontenery ze statku: ");
        System.out.println("6 - Exit");
    }

    public void menu() throws Exception {
        System.out.println("Statek moze przyjac 15000 kontenerow, aby prawidlowo wyswietlic projekt prosze o wykonanie ponizszych komend:");
        do {
            getOptions();
            int number = sc.nextInt();

            switch (number) {
                case 1:
                    getFirst();
                break;

                case 2:
                    getSecond();
                break;

                case 3:
                    getThird();
                break;

                case 4:
                    getFourth();
                break;

                case 5:
                    getFifth();
                break;

                case 6:
                    System.exit(0);
                break;

                default:
                    System.out.println("Nie poprawna komenda, spróbuj ponownie:");
            }
        } while (number == 0) ;
            System.out.println("Wyjście");
    }

    private void getFirst() throws IOException {
        System.out.println("Ile kontenerów chcesz wygenerować: (Aktualnie ustawione na 15 000)");
        tmp = sc.nextInt();
        KontenerList kl = new KontenerList(tmp);
        kl.saveToFile(FILENAME);
        System.out.println("Kontenery z losowymi wartościami zostały zapisane do pliku!");
    }

    private void getSecond() throws IOException {
        KontenerList kl = new KontenerList(tmp);
        Kontener kontenerTab[] = kl.readFromFile(FILENAME);
        System.out.println("Plik " + FILENAME + " zostanie wypisany z nieposortowanymi wagami:");

        for (Kontener k: kontenerTab) {
            System.out.println(k);
        }
    }

    private void getThird(){
        KontenerList kl = new KontenerList(tmp);
        Kontener kontenerTab[] = kl.readFromFile(FILENAME);
        Algorytm alg = new Algorytm();
        Kontener sorted[] = alg.sort(kontenerTab);

        for (Kontener k: sorted) {
            System.out.println(k);
        }
    }

    private void getFourth(){
        KontenerList kl = new KontenerList(tmp);
        Kontener kontenerTab[] = kl.readFromFile(FILENAME);
        Algorytm alg = new Algorytm();
        Kontener ko[][][] = alg.putToArray3D(kontenerTab);
        alg.getInfo();
    }

    private void getFifth() throws IOException {

        KontenerList kl = new KontenerList(tmp);
        Kontener kontenerTab[] = kl.readFromFile(FILENAME);
        Algorytm al = new Algorytm();
        Kontener ko[][][] = al.putToArray3D(kontenerTab);
        kl.saveToFile2(FILENAME2);
    }
}
