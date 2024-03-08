package com.example.aoim_22_11;

import java.util.concurrent.locks.Condition;

public class Employee implements Comparable<Employee>{
    private String imię;
    private String nazwisko;
    private EmployeeCondition stan_pracownika;
    private int rok_urodzenia;
    private double wynagrodzenie;

    public String getImię() {
        return imię;
    }

    public void setImię(String imię) {
        this.imię = imię;
    }

    public String getNazwisko() {
        return nazwisko;
    }

    public void setNazwisko(String nazwisko) {
        this.nazwisko = nazwisko;
    }

    public EmployeeCondition getStan_pracownika() {
        return stan_pracownika;
    }

    public int getRok_urodzenia() {
        return rok_urodzenia;
    }

    public void setRok_urodzenia(int rok_urodzenia) {
        this.rok_urodzenia = rok_urodzenia;
    }

    public double getWynagrodzenie() {
        return wynagrodzenie;
    }

    public void setWynagrodzenie(double wynagrodzenie) {
        this.wynagrodzenie = wynagrodzenie;
    }

    public void setStan_pracownika(EmployeeCondition condition){
       stan_pracownika = condition;
    }
    public Employee(String name, String surname, EmployeeCondition stan, int rok, double salary){
        imię = name;
        nazwisko = surname;
        stan_pracownika = stan;
        rok_urodzenia = rok;
        wynagrodzenie = salary;
    }
    public Employee(String name, String surname, int rok, double salary){
        imię = name;
        nazwisko = surname;
        stan_pracownika = EmployeeCondition.obecny;
        rok_urodzenia = rok;
        wynagrodzenie = salary;
    }


    public void print(){
        System.out.println("Imie: " + imię);
        System.out.println("Nazwisko: " + nazwisko);
        System.out.println("Stan pracownika: " + stan_pracownika);
        System.out.println("Rok urodzenia: " + rok_urodzenia);
        System.out.println("Wynagrodzenie: " + wynagrodzenie);
    }

    public int compareTo(Employee toCompare) {
        if(nazwisko == toCompare.nazwisko)
            return 0;
        else
            return 1;
    }
}
