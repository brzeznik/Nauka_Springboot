package com.projekty.projekt1;

public class OcenaRequest {
    private Integer ocena;
    private Long przedmiot;
    private Long student;

    public Integer getOcena(){
        return ocena;
    }

    public Long getPrzedmiot(){
        return przedmiot;
    }

    public Long getStudent(){
        return student;
    }

    public void setOcena(Integer ocena) {
        this.ocena = ocena;
    }

    public void setPrzedmiot(Long przedmiot) {
        this.przedmiot = przedmiot;
    }

    public void setStudent(Long student) {
        this.student = student;
    }
}
