package com.projekty.projekt1;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class Studentuslugi {
    private final Repozytorium repozytorium;

    @Autowired
    public Studentuslugi(Repozytorium repozytorium){
        this.repozytorium = repozytorium;
    }
    public List<Student> getStudents(){
        return repozytorium.findAll();
    }

    public void usun(Long id){
        if (!repozytorium.existsById(id)){
            throw new IllegalStateException();
        }
        repozytorium.deleteById(id);
    }


    public void dodaj(StudentRequest request){
        Student student = new Student();
        student.setImie(request.getImie());
        student.setNazwisko(request.getNazwisko());
        student.setEmail(request.getEmail());
        student.setWiek(request.getWiek());
        repozytorium.save(student);
    }

    @Transactional
    public void edytuj(Long id,String imie,String nazwisko,String email, Integer wiek) {
        Student student = repozytorium.findById(id).orElseThrow(()-> new IllegalStateException());
        if (imie != null && imie.length()>0 && !student.getImie().equals(imie)){
            student.setImie(imie);
        }
        if (nazwisko != null && nazwisko.length()>0 && !student.getNazwisko().equals(nazwisko)){
            student.setNazwisko(nazwisko);
        }
        if (email != null && email.length()>0 && !student.getEmail().equals(email)){
            if (repozytorium.findStudentByEmail(email).isPresent()){
                throw new IllegalStateException();
            }
            student.setEmail(email);
        }
        if (wiek != null && !student.getWiek().equals(wiek)){
            student.setWiek(wiek);
        }
    }
}
