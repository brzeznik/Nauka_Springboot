package com.projekty.projekt1;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;

import java.util.List;
import java.util.Optional;

@Service
public class NauczycielUslugi {
    private final NauczycielRepo repozytorium;
    private final PrzedmiotRepo przedmiotRepo;

    @Autowired
    public NauczycielUslugi(NauczycielRepo nauczycielRepo, PrzedmiotRepo przedmiotRepo){
        this.repozytorium = nauczycielRepo;
        this.przedmiotRepo = przedmiotRepo;
    }


    public List<Nauczyciel> getNauczyciele(){
        return repozytorium.findAll();
    }


    public void dodaj(NauczycielRequest request){
        Przedmiot przedmiot = przedmiotRepo.findById(request.getPrzedmiotid()).orElseThrow(()->new IllegalStateException());
        Nauczyciel nauczyciel = new Nauczyciel();
        nauczyciel.setPrzedmiot(przedmiot);
        nauczyciel.setImie(request.getImie());
        nauczyciel.setNazwisko(request.getNazwisko());
        repozytorium.save(nauczyciel);
    }

    public void usun(Long id){
        if (!repozytorium.existsById(id)){
            throw new IllegalStateException();
        }
        repozytorium.deleteById(id);
    }

    @Transactional
    public void edytuj(Long id, String imie, String nazwisko, Long przedmiotid){
        Nauczyciel nauczyciel = repozytorium.findNauczycielById(id).orElseThrow(()->new IllegalStateException());

        if (imie != null && imie.length() > 0 && !nauczyciel.getImie().equals(imie)){
            nauczyciel.setImie(imie);
        }
        if (nazwisko != null && nazwisko.length() > 0 && !nauczyciel.getNazwisko().equals(nazwisko)){
            nauczyciel.setNazwisko(nazwisko);
        }
        if (przedmiotid != null && !nauczyciel.getPrzedmiot().getId().equals(przedmiotid)){
            Przedmiot przedmiot = przedmiotRepo.findById(przedmiotid).orElseThrow(() -> new IllegalStateException());
            nauczyciel.setPrzedmiot(przedmiot);
        }
    }
}
