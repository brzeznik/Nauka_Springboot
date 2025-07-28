package com.projekty.projekt1;


import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;

@Entity(name = "Oceny")
@Table(name = "Oceny")
public class Oceny {
    @Id
    @SequenceGenerator(
            name = "ocena_sequence",
            sequenceName = "ocena_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "ocena_sequence"
    )
    @Column(name = "oceny_id", updatable = false)
    private Long id;
    @Column(
            name = "ocena",
            nullable = false
    )
    @Min(value = 1)
    @Max(value = 6)
    private Integer ocena;
    @ManyToOne
    @JoinColumn(name = "student_id",nullable = false)
    private Student student;
    @ManyToOne
    @JoinColumn(name = "przedmiot_id", nullable = false)
    private Przedmiot przedmiot;

    public Oceny(){

    }
    public Oceny(Integer ocena, Student student, Przedmiot przedmiot){
        this.ocena=ocena;
        this.przedmiot=przedmiot;
        this.student=student;
    }

    public @Min(value = 1) @Max(value = 6) Integer getOcena() {
        return ocena;
    }

    public void setOcena(@Min(value = 1) @Max(value = 6) Integer ocena) {
        this.ocena = ocena;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Przedmiot getPrzedmiot() {
        return przedmiot;
    }

    public void setPrzedmiot(Przedmiot przedmiot) {
        this.przedmiot = przedmiot;
    }


    public Long getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Oceny{" +
                "id=" + id +
                ", ocena=" + ocena +
                ", student=" + student +
                ", przedmiot=" + przedmiot +
                '}';
    }
}
