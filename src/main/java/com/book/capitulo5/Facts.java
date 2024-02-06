package com.book.capitulo5;

import java.util.HashMap;
import java.util.Map;

public class Facts {

    //mapa facts que armazena pares chave-valor
    private final Map<String, String> facts = new HashMap<>();

    public String getFact(final String name) {
        return this.facts.get(name);
    }

    public void addFact(final String name, final String value) {
        this.facts.put(name, value);
    }
}
