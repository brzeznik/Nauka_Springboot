package com.projekty.projekt1;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class Przedmiotuslugi {
    private final PrzedmiotRepo repozytorium;

    @Autowired
    public Przedmiotuslugi(PrzedmiotRepo repozytorium){
        this.repozytorium = repozytorium;
    }

    public List<Przedmiot> getPrzedmioty(){
        return repozytorium.findAll();
    }

    public void usun(Long id){
        if (!repozytorium.existsById(id)){
            throw new IllegalStateException();
        }
        repozytorium.deleteById(id);
    }

    public void dodaj(PrzedmiotRequest request){
        Przedmiot przedmiot = new Przedmiot();
        przedmiot.setNazwa(request.getNazwa());
        przedmiot.setITN(request.getItn());
        repozytorium.save(przedmiot);
    }

    @Transactional
    public void edytuj(Long id,String nazwa,Integer itn){
        Przedmiot przedmiot = repozytorium.findById(id).orElseThrow(()-> new IllegalStateException());
        if (nazwa != null && nazwa.length()>0 && !przedmiot.getNazwa().equals(nazwa)){
            przedmiot.setNazwa(nazwa);
        }
        if (itn != null && itn>0 && itn<7){
            przedmiot.setITN(itn);
        }

    }

}
