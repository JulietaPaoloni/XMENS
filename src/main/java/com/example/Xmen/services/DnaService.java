package com.example.Xmen.services;

import java.util.Map;

public interface DnaService {
    // Declaración del metodo para determinar si una persona es mutante basándose en su ADN
    boolean isMutant(String[] dnaSequence);
    public Map<String, Object> getStats();
}
