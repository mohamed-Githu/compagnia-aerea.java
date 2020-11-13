package compagniaaearea;

import java.util.ArrayList;

public class Volo {
    private ArrayList<Cliente> attesa;
    private Cliente[] posti;
    private int sentinella;
    
    public Volo(int max) {
        posti = new Cliente[max];
        attesa = new ArrayList<>();
        sentinella = 0;
    }
    
    public void prenotaVolo(Cliente cliente) {
        if (sentinella < posti.length) {
            posti[sentinella] = cliente;
            sentinella++;
        } else {
            attesa.add(cliente);
        }
    }
    
    public void disdiciPrenotazione(String nome) {
        if (!controllaPosti(nome))
            controllaAttesa(nome);
    }
    
    private void shiftArray(int index) {
        for (int x = index; x < sentinella - 1; x++)
            posti[x] = posti[x + 1];
    }

    public void stampaDati() {
        System.out.print("Attesa: ");
        for (int x = 0; x < attesa.size(); x++)
            System.out.print(attesa.get(x).getNome() + ", ");
        System.out.print("\nPosti: ");
        for (int x = 0; x < sentinella; x++)
            System.out.print(posti[x].getNome() + ", ");
    }
    
    private boolean controllaPosti(String nome) {
        int index = -1;
        for (int x = 0; x < sentinella; x++) {
            if (posti[x].getNome().equals(nome)) {
                index = x;
                break;
            }
        }    
        
        if (index == -1) {
            System.out.println("NON SI TROVA IN POSTI!");
            return false;
        }
        
        if (attesa.size() > 0) {
            posti[index] = attesa.get(0);
            attesa.remove(0);
        } else {
            shiftArray(index);
            posti[sentinella -1] = null;
            sentinella--;
        }
        
        Cliente.rimuoviNome(nome);
        System.out.println("CLIENTE CANCELLATO DAI POSTI!");
        return true;
    }
    
    private void controllaAttesa(String nome) {
        int index = -1;
        for (int x = 0; x < attesa.size(); x++) {
            if (attesa.get(x).getNome().equals(nome)) {
                index = x;
                break;
            }
        }    
        
        if (index == -1) {
            System.out.println("NON SI TROVA NEANCHE IN ATTESA!");
            return;
        }
        attesa.remove(index);
        Cliente.rimuoviNome(nome);
        
        System.out.println("CLIENTE CANCELLATO DALL'ATTESA!");
    }
}
