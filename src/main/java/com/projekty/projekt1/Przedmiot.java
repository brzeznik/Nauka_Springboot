package com.projekty.projekt1;

import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;

import java.util.ArrayList;
import java.util.List;

@Entity(name = "Przedmiot")
@Table(name = "Przedmiot")
public class Przedmiot {
@Id
    @SequenceGenerator(
            name = "przedmiot_sequence",
            sequenceName = "przedmiot_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "przedmiot_sequence"
    )
    @Column(
            name = "przedmiot_id",
            updatable = false
    )
    private Long id;
    @Column(
            name = "nazwa",
            nullable = false,
            columnDefinition = "TEXT"
    )
    private String nazwa;
    @Column(
            name = "itn",
            nullable = false
    )
    @Min(value = 0)
    @Max(value = 6)
    private Integer itn;
    @OneToMany(mappedBy = "przedmiot")
    private List<Oceny> oceny = new ArrayList<>();

    public Przedmiot(){

    }
    public Przedmiot(String nazwa, Integer itn){
        this.nazwa = nazwa;
        this.itn = itn;
    }

    public Integer getITN() {
        return itn;
    }

    public String getNazwa() {
        return nazwa;
    }

    public Long getId() {
        return id;
    }

    public void setNazwa(String nazwa) {
        this.nazwa = nazwa;
    }

    public void setITN(Integer ITN) {
        this.itn = ITN;
    }

    @Override
    public String toString() {
        return "Przedmiot{" +
                "id=" + id +
                ", nazwa='" + nazwa + '\'' +
                ", ITN=" + itn +
                '}';
    }
}
