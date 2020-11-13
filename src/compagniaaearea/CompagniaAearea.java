package compagniaaearea;
import java.util.ArrayList;
import java.util.Scanner;

public class CompagniaAearea {

    public static void main(String[] args) {
        ArrayList<Volo> voli = new ArrayList<>();
        boolean attivo = true;
        int scelta;
        Scanner in = new Scanner(System.in);
        
        while (attivo) {
            stampaScelte();
            scelta = in.nextInt();
            
            switch(scelta) {
                case 1:
                    System.out.print("Massimo numero di passeggeri: ");
                    int max = in.nextInt();
                    voli.add(new Volo(max));
                    break;
                case 2:
                    if (voli.size() == 0) {
                        System.out.println("Non esistono voli!!!");
                        break;
                    }
                    
                    String nome = "";
                    do {
                        System.out.print("Nome di cliente: ");
                        nome = in.nextLine();
                    } while (Cliente.controllaNomi(nome));
                    
                    int num;
                    do {
                        System.out.print("Numero di volo: ");
                        num = in.nextInt();
                    } while (num >= voli.size() || num < 0);
                    
                    voli.get(num).prenotaVolo(new Cliente(nome));
                    break;
                case 3:
                    if (voli.size() == 0) {
                        System.out.println("Non esistono voli!!!");
                        break;
                    }
                    
                    int num2;
                    do {
                        System.out.print("Numero di volo: ");
                        num2 = in.nextInt();
                    } while (num2 >= voli.size() || num2 < 0);
                    
                    String nome2 = "";
                    for (int x = 0; x < 2; x++) {
                        if (x == 0)
                            System.out.print("");
                        else
                            System.out.print("Nome di cliente: ");
                        nome2 = in.nextLine();
                    }
                    voli.get(num2).disdiciPrenotazione(nome2);
                    
                    break;
                case 4:
                    for (int x = 0; x < voli.size(); x++) {
                        System.out.println("\nVolo: " + x);
                        voli.get(x).stampaDati();
                    }
                    System.out.println("");
                    break;
                case 5:
                    if (voli.size() == 0) {
                        System.out.println("Non esistono voli!!!");
                        break;
                    }
                    
                    int num3;
                    do {
                        System.out.print("Numero di volo: ");
                        num3 = in.nextInt();
                    } while (num3 >= voli.size() || num3 < 0);
                    
                    voli.remove(num3);
                    break;
                default:
                    attivo = false;
            }
        }
    }
    
    public static void stampaScelte() {
        System.out.println("\nCrea Volo (1)");
        System.out.println("Prenota Volo (2)");
        System.out.println("Desdici Volo (3)");
        System.out.println("Stampa Dati (4)");
        System.out.println("Annulla Volo (5)");
        System.out.println("Chiudi Programma (*)\n");
        System.out.print("Scelta: ");
    }
    
}
