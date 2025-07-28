package com.projekty.projekt1;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Ocenauslugi {
    private final Ocenarepo repozytorium;
    private final Repozytorium studentrepo;
    private final PrzedmiotRepo przedmiotrepo;

    @Autowired
    public Ocenauslugi(Ocenarepo ocenarepo,Repozytorium studentrepo, PrzedmiotRepo przedmiotrepo){
        this.repozytorium = ocenarepo;
        this.przedmiotrepo = przedmiotrepo;
        this.studentrepo = studentrepo;
    }

    public List<Oceny> getOceny(){
        return repozytorium.findAll();
    }

    public void usun(Long id){
        if (repozytorium.existsById(id)){
            repozytorium.deleteById(id);
        }else{
            throw new IllegalStateException();
        }
    }

    public void dodaj(OcenaRequest request){
        Student student = studentrepo.findById(request.getStudent()).orElseThrow(() -> new IllegalStateException());
        Przedmiot przedmiot = przedmiotrepo.findById(request.getPrzedmiot()).orElseThrow(() -> new IllegalStateException());
        Oceny ocena = new Oceny();
        ocena.setStudent(student);
        ocena.setPrzedmiot(przedmiot);
        ocena.setOcena(request.getOcena());
        repozytorium.save(ocena);
    }

    @Transactional
    public void edytuj(Long id, Integer ocena, Long przedmiot, Long student){
        Oceny oceny = repozytorium.findById(id).orElseThrow(() -> new IllegalStateException());

        if (ocena != null && ocena>0 && ocena<7 && !oceny.getOcena().equals(ocena)){
            oceny.setOcena(ocena);
        }
        if (przedmiot != null && !oceny.getPrzedmiot().getId().equals(przedmiot)){
            Przedmiot przedmiot1 = przedmiotrepo.findById(przedmiot).orElseThrow(()->new IllegalStateException());
            oceny.setPrzedmiot(przedmiot1);
        }
        if (student != null && !oceny.getStudent().getId().equals(student)){
            Student student1 = studentrepo.findById(student).orElseThrow(()->new IllegalStateException());
            oceny.setStudent(student1);
        }
    }
}
