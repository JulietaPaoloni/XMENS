package com.example.Xmen.services;

import com.example.Xmen.entities.Dna;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.Xmen.repositories.BaseRepository;
import com.example.Xmen.repositories.DnaRepository;

import java.util.HashMap;
import java.util.Map;

@Service
public class DnaServiceImpl extends BaseServiceImpl<Dna, Long> implements DnaService {

    @Autowired
    private DnaRepository dnaRepository;

    public DnaServiceImpl(BaseRepository<Dna, Long> baseRepository) {
        super(baseRepository);
    }

    private static final int SEQUENCE_LENGTH = 4;

    @Override
    public boolean isMutant(String[] dnaSequence) {
        // Paso 1: Verificar que la matriz sea cuadrada
        int n = dnaSequence.length;
        if (!esMatrizCuadrada(dnaSequence, n)) {
            throw new IllegalArgumentException("La matriz de ADN debe ser cuadrada.");
        }

        // Paso 2: Verificar que las letras sean válidas
        validarLetrasADN(dnaSequence, n);

        // Paso 3: Contar secuencias encontradas
        int sequencesFound = 0;

        // Buscar secuencias horizontales, verticales y oblicuas
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (checkHorizontal(dnaSequence, i, j) || checkVertical(dnaSequence, i, j) ||
                        checkDiagonal(dnaSequence, i, j) || checkAntiDiagonal(dnaSequence, i, j)) {
                    sequencesFound++;
                }
                if (sequencesFound > 1) {
                    return true; // Es mutante si encuentra más de una secuencia
                }
            }
        }
        return false; // Si no encuentra más de una secuencia, es humano
    }

    // Verifica si la matriz es cuadrada
    private boolean esMatrizCuadrada(String[] dna, int n) {
        for (String row : dna) {
            if (row.length() != n) {
                return false;
            }
        }
        return true;
    }

    // Valida que las letras del ADN sean A, T, C o G
    private void validarLetrasADN(String[] dna, int n) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                char base = dna[i].charAt(j);
                if (base != 'A' && base != 'T' && base != 'C' && base != 'G') {
                    throw new IllegalArgumentException("El ADN contiene letras inválidas. Solo se permiten A, T, C, G.");
                }
            }
        }
    }

    // Métodos para las diferentes verificaciones
    private boolean checkHorizontal(String[] dna, int row, int col) {
        if (col + SEQUENCE_LENGTH - 1 >= dna.length) return false;
        char base = dna[row].charAt(col);
        for (int i = 1; i < SEQUENCE_LENGTH; i++) {
            if (base != dna[row].charAt(col + i)) return false;
        }
        return true;
    }

    private boolean checkVertical(String[] dna, int row, int col) {
        if (row + SEQUENCE_LENGTH - 1 >= dna.length) return false;
        char base = dna[row].charAt(col);
        for (int i = 1; i < SEQUENCE_LENGTH; i++) {
            if (base != dna[row + i].charAt(col)) return false;
        }
        return true;
    }

    private boolean checkDiagonal(String[] dna, int row, int col) {
        if (row + SEQUENCE_LENGTH - 1 >= dna.length || col + SEQUENCE_LENGTH - 1 >= dna.length) return false;
        char base = dna[row].charAt(col);
        for (int i = 1; i < SEQUENCE_LENGTH; i++) {
            if (base != dna[row + i].charAt(col + i)) return false;
        }
        return true;
    }

    private boolean checkAntiDiagonal(String[] dna, int row, int col) {
        if (row + SEQUENCE_LENGTH - 1 >= dna.length || col - SEQUENCE_LENGTH + 1 < 0) return false;
        char base = dna[row].charAt(col);
        for (int i = 1; i < SEQUENCE_LENGTH; i++) {
            if (base != dna[row + i].charAt(col - i)) return false;
        }
        return true;
    }
    @Override
    @Transactional
    public Map<String, Object> getStats() { //En este metodo uso Map porque es similar a un JSON

        float countMutantDna = dnaRepository.countBymutanteTrue();
        float countHumanDna = dnaRepository.countBymutanteFalse();


        Map<String, Object> stats = new HashMap<>();
        stats.put("count_mutant_dna", countMutantDna);
        stats.put("count_human_dna", countHumanDna);
        stats.put("ratio", countHumanDna == 0 ? 0 : countMutantDna / countHumanDna);

        return stats;
    }
}
