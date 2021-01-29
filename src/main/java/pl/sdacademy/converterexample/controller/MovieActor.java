package pl.sdacademy.converterexample.controller;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

//klasa zwracana w api - mapowana do odpowiedzi w API
public class MovieActor {
    private LocalDate birthDate;
    private String name;

    private Map<String, String> skills;

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    private String surname;
    private List<String> movieList; //żeby nie komplikować - filmy w których udział brał aktor to String a nie obiekt


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
