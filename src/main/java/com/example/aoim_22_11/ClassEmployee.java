package com.example.aoim_22_11;

import java.util.List;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Collections;


public class ClassEmployee {

    private String nazwa_grupy;
    private ArrayList<Employee> pracownicy = new ArrayList<Employee>();
    private static final int maksymalna_liczba_pracownikow = 10;

    private int pojemnosc;

    private int liczbaPracownikow;

    public String getNazwa_grupy() {
        return nazwa_grupy;
    }

    public void setNazwa_grupy(String nazwa_grupy) {
        this.nazwa_grupy = nazwa_grupy;
    }

    public ArrayList<Employee> getPracownicy() {
        return pracownicy;
    }

    public void setPracownicy(ArrayList<Employee> pracownicy) {
        this.pracownicy = pracownicy;
    }

    public void setPojemnosc(int pojemnosc) {
        this.pojemnosc = pojemnosc;
    }

    public void setLiczbaPracownikow(int liczbaPracownikow) {
        this.liczbaPracownikow = liczbaPracownikow;
    }

    public ClassEmployee(int pojemnosc, String nazwa_grupy) {
        this.pojemnosc = pojemnosc;
        this.liczbaPracownikow = 0; // Początkowo grupa jest pusta
        this.nazwa_grupy = nazwa_grupy;
    }

    @Override
    public String toString() {
        return nazwa_grupy;
    }

    public ClassEmployee(int pojemnosc) {
        this.pojemnosc = pojemnosc;
        this.liczbaPracownikow = 0; // Początkowo grupa jest pusta
    }

    public int getPojemnosc() {
        return pojemnosc;
    }

    public int getLiczbaPracownikow() {
        return liczbaPracownikow;
    }


    public boolean addEmployee(Employee newEmployee){
        if(pracownicy.size() == maksymalna_liczba_pracownikow)
            return false;
        pracownicy.add(newEmployee);
        return true;

    }

//    public void addSalary(Employee ee, double salar) {
//        int i = pracownicy.indexOf(ee);
//        double var = ee.getWynagrodzenie();
//        pracownicy.get(i).getWynagrodzenie(var+salar);
//    }

    public boolean removeEmployee(Employee ee){
        if(!pracownicy.contains(ee))
            return false;
        pracownicy.remove(ee);
            return true;
    }
    public void changecondition(Employee ee, EmployeeCondition condition){
        int i = pracownicy.indexOf(ee);
        pracownicy.get(i).setStan_pracownika(condition);
    }
//    public Employee search(String nazwisko) {
//        for (Employee pracownik : pracownicy) {
//            if (pracownik.getSurname().equals(nazwisko)) {
//                return pracownik;
//            }
//        }
//        return null;
//    }
    public Employee search(String nazwisko) {
        Comparator<Employee> nazwiskoComparator = Comparator.comparing(Employee::getNazwisko);

        Collections.sort(pracownicy, nazwiskoComparator);

        Employee poszukiwanyPracownik = new Employee("", nazwisko, EmployeeCondition.obecny, 0, 0);

        int index = Collections.binarySearch(pracownicy, poszukiwanyPracownik, nazwiskoComparator);

        if (index >= 0) {
            return pracownicy.get(index);
        } else {
            return null;
        }
    }

    public List<Employee> searchPartial(String fragment) {
        List<Employee> znalezioniPracownicy = new ArrayList<>();
        for (Employee pracownik : pracownicy) {
            if (pracownik.getNazwisko().contains(fragment) || pracownik.getImię().contains(fragment)) {
                znalezioniPracownicy.add(pracownik);
            }
        }
        return znalezioniPracownicy;
    }
    public int countByCondition(EmployeeCondition condition) {
        int count = 0;
        for (Employee pracownik : pracownicy) {
            if (pracownik.getStan_pracownika() == condition) {
                count++;
            }
        }
        return count;
    }
    public void summary() {
        System.out.println("====== Podsumowanie pracowników w firmie ======");
        for (Employee pracownik : pracownicy) {
            pracownik.print();
            System.out.println();
        }
    }
    public List<Employee> sortByName() {
        List<Employee> sortedEmployees = new ArrayList<>(pracownicy);
        sortedEmployees.sort(Comparator.comparing(Employee::getNazwisko));
        return sortedEmployees;
    }
    public List<Employee> sortBySalary() {
        List<Employee> sortedEmployees = new ArrayList<>(pracownicy);
        sortedEmployees.sort((e1, e2) -> Double.compare(e2.getWynagrodzenie(), e1.getWynagrodzenie()));
        return sortedEmployees;
    }
    public Employee max() {
        return Collections.max(pracownicy, Comparator.comparing(Employee::getWynagrodzenie));
    }

}
