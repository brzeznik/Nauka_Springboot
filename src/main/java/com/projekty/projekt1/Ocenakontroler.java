package com.projekty.projekt1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/oceny")
public class Ocenakontroler {
    private final Ocenauslugi ocenauslugi;

    @Autowired
    public Ocenakontroler(Ocenauslugi ocenauslugi){
        this.ocenauslugi = ocenauslugi;
    }

    @GetMapping
    public List<Oceny> getOceny(){
        return ocenauslugi.getOceny();
    }
    @PostMapping
    public void dodaj(@RequestBody OcenaRequest request){
        ocenauslugi.dodaj(request);
    }
    @DeleteMapping(path = "{oceny_id}")
    public void usun(@PathVariable("oceny_id")Long id){
        ocenauslugi.usun(id);
    }
    @PutMapping(path = "{oceny_id}")
    public void update(@PathVariable("oceny_id") Long id, @RequestBody OcenaRequest request){
        ocenauslugi.edytuj(id, request.getOcena(), request.getPrzedmiot(), request.getStudent());
    }
}
