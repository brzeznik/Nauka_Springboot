package com.projekty.projekt1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/przedmiot")
public class PrzedmiotKontroler {
    private final Przedmiotuslugi przedmiotuslugi;

    @Autowired
    public PrzedmiotKontroler(Przedmiotuslugi przedmiotuslugi){
        this.przedmiotuslugi = przedmiotuslugi;
    }

    @GetMapping
    public List<Przedmiot> getPrzedmioty(){
        return przedmiotuslugi.getPrzedmioty();
    }

    @PostMapping
    public void dodaj(@RequestBody PrzedmiotRequest request){
        przedmiotuslugi.dodaj(request);
    }

    @DeleteMapping(path = "{przedmiot_id}")
    public void usun(@PathVariable("przedmiot_id") Long id){
        przedmiotuslugi.usun(id);
    }

    @PutMapping(path = "{przedmiot_id}")
    public void update(@PathVariable("przedmiot_id")Long id, @RequestBody PrzedmiotRequest request){
        przedmiotuslugi.edytuj(id,request.getNazwa(), request.getItn());
    }
}
