package com.ntt.bootcamp.functionalflux.controller;

import com.ntt.bootcamp.functionalflux.model.Persona;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class PController {

    private ArrayList<Persona> listaPersona = new ArrayList<Persona>();

    public void PerController() {
        listaPersona.add(new Persona("Angel","aaridom", "1234abcd"));
        listaPersona.add(new Persona("Diego", "degava", "abcd1234"));
    }

    @GetMapping(path = "/login")
    private String login(@RequestParam(value = "username") String username, @RequestParam(value = "password") String password) {

        var result = listaPersona.stream().filter(p -> p.getUsername().equals(username)
                && p.getPassword().equals(password)).collect(Collectors.toList()).get(0);

        return "Hola " + result.getName();
    }
}
