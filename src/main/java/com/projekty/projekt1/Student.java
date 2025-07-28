package com.projekty.projekt1;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity(name = "Student")
@Table(
        name = "Student",
        uniqueConstraints = {
                @UniqueConstraint(name = "student_unique_email",columnNames = "email")
        }
)
public class Student {
    @Id
    @SequenceGenerator(
            name = "student_sequence",
            sequenceName = "student_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "student_sequence"
    )
    @Column(
            name = "student_id",
            updatable = false
    )
    private Long id;
    @Column(
            name = "imie",
            nullable = false,
            columnDefinition = "TEXT"
    )
    private String imie;
    @Column(
            name = "nazwisko",
            nullable = false,
            columnDefinition = "TEXT"
    )    private String nazwisko;
    @Column(
            name = "email",
            nullable = false,
            columnDefinition = "TEXT"
    )    private String email;
    @Column(
            name = "wiek",
            nullable = false
    )    private Integer wiek;
    @OneToMany(mappedBy = "student")
    private List<Oceny> oceny = new ArrayList<>();
    public Student(String imie, String nazwisko, String email, Integer wiek) {
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.email = email;
        this.wiek = wiek;
    }

    public Student() {
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getWiek() {
        return wiek;
    }

    public void setWiek(Integer wiek) {
        this.wiek = wiek;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", imie='" + imie + '\'' +
                ", nazwisko='" + nazwisko + '\'' +
                ", email='" + email + '\'' +
                ", wiek=" + wiek +
                '}';
    }
}
