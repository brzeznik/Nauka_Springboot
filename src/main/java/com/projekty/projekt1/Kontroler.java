package com.projekty.projekt1;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/student")
public class Kontroler{
    private final Studentuslugi studentuslugi;

    @Autowired
    public Kontroler(Studentuslugi studentuslugi){
        this.studentuslugi = studentuslugi;
    }

    @GetMapping
    public List<Student> getStudents(){
        return studentuslugi.getStudents();
    }

    @PostMapping
    public void dodajstudenta(@RequestBody StudentRequest request){
        studentuslugi.dodaj(request);
    }

    @DeleteMapping(path = "{id}")
    public void usunstudenta(@PathVariable("id") Long id){
        studentuslugi.usun(id);
    }

    @PutMapping(path = "{id}")
    public void update(@PathVariable("id")Long id,@RequestBody StudentRequest request)
    {
        studentuslugi.edytuj(id,request.getImie(),request.getNazwisko(),request.getEmail(),request.getWiek());
    }

}
