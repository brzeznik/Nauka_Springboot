package com.projekty.projekt1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/v1/nauczyciel")
public class NauczycielKontroler {
    private final NauczycielUslugi nauczycielUslugi;

    @Autowired
    public NauczycielKontroler(NauczycielUslugi nauczycielUslugi){
        this.nauczycielUslugi = nauczycielUslugi;
    }

    @GetMapping
    public List<Nauczyciel> getNauczyciele(){
        return nauczycielUslugi.getNauczyciele();
    }

    @PostMapping
    public void dodaj(@RequestBody NauczycielRequest nauczyciel){
        nauczycielUslugi.dodaj(nauczyciel);
    }

    @DeleteMapping(path = "{id}")
    public void usun(@PathVariable("id") Long id){
        nauczycielUslugi.usun(id);
    }

    @PutMapping(path = "{id}")
    public void edytuj(@PathVariable("id")Long id, @RequestBody NauczycielRequest request){
        nauczycielUslugi.edytuj(id,request.getImie(), request.getNazwisko(), request.getPrzedmiotid());
    }
}
