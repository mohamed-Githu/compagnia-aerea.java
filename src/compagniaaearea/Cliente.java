package compagniaaearea;

import java.util.ArrayList;

public class Cliente {
    private String nome;
    private static ArrayList<String> nomi = new ArrayList<>();;
    
    Cliente(String nome) {
        this.nome = nome;
        nomi.add(nome);
    }
    
    public static boolean controllaNomi(String nome) {
        return nomi.indexOf(nome) != -1 || nome.trim().equals("");
    }

    public String getNome() {
        return nome;
    }
    
    public static void rimuoviNome(String nome) {
        nomi.remove(nome);
    }
}
