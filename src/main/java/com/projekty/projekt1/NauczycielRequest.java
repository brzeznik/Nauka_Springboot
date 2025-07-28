package com.projekty.projekt1;

public class NauczycielRequest {
    private String imie;
    private String nazwisko;
    private Long przedmiotid;

    public String getImie() {
        return imie;
    }

    public void setImie(String imie) {
        this.imie = imie;
    }

    public String getNazwisko() {
        return nazwisko;
    }

    public void setNazwisko(String nazwisko) {
        this.nazwisko = nazwisko;
    }

    public Long getPrzedmiotid() {
        return przedmiotid;
    }

    public void setPrzedmiotid(Long przedmiotid) {
        this.przedmiotid = przedmiotid;
    }
}
