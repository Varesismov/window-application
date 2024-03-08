package com.example.aoim_22_11;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ClassContainer {
    private Map<String, ClassEmployee> grupyPracownicze = new HashMap<>();

    // a) Metoda dodaje nową grupę pracowniczą o podanej nazwie i pojemności do spisu grup
    public void addClass(String nazwaGrupy, int pojemnosc) {
        if (!grupyPracownicze.containsKey(nazwaGrupy)) {
            grupyPracownicze.put(nazwaGrupy, new ClassEmployee(pojemnosc));
        } else {
            System.out.println("Grupa o nazwie " + nazwaGrupy + " już istnieje.");
        }
    }

    // b) Metoda usuwa grupę o podanej nazwie
    public void removeClass(String nazwaGrupy) {
        if (grupyPracownicze.containsKey(nazwaGrupy)) {
            grupyPracownicze.remove(nazwaGrupy);
        } else {
            System.out.println("Grupa o nazwie " + nazwaGrupy + " nie istnieje.");
        }
    }

    // c) Metoda zwraca listę pustych grup
    public List<String> findEmpty() {
        List<String> pusteGrupy = new ArrayList<>();
        for (Map.Entry<String, ClassEmployee> entry : grupyPracownicze.entrySet()) {
            if (entry.getValue().getPojemnosc() == 0) {
                pusteGrupy.add(entry.getKey());
            }
        }
        return pusteGrupy;
    }

    // d) Metoda wypisuje na standardowe wyjście informacje zawierające nazwę grupy i jej procentowe zapełnienie
    public void summary() {
        for (Map.Entry<String, ClassEmployee> entry : grupyPracownicze.entrySet()) {
            String nazwaGrupy = entry.getKey();
            ClassEmployee grupa = entry.getValue();
            int pojemnosc = grupa.getPojemnosc();
            int liczbaPracownikow = grupa.getLiczbaPracownikow();
            double procentZapelnienia = (double) liczbaPracownikow / pojemnosc * 100;

            System.out.println("Grupa: " + nazwaGrupy);
            System.out.println("Procentowe zapełnienie: " + procentZapelnienia + "%");
            System.out.println();
        }
    }
}
