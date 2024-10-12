//package controllers;
//
//import dto.DnaRequest;
//import entities.Dna;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//import services.DnaServiceImpl;
//
//@RestController
//@CrossOrigin(origins = "*")
//@RequestMapping(path = "/api/v1/dna")
//
//public class DnaController extends BaseControllerImpl<Dna, DnaServiceImpl> {
//
//    private final DnaServiceImpl dnaService;
//
//    @Autowired
//    public DnaController(DnaServiceImpl dnaService) {
//        this.dnaService = dnaService;
//    }
//
//    // Endpoint que recibe el ADN y determina si es mutante
////    @PostMapping("/mutant")
////    public ResponseEntity<String> isMutant(@RequestBody DnaRequest dnaRequest) {
////        try {
////            // Verificamos si la secuencia de ADN es válida
////            if (dna == null || dna.length == 0) {
////                return new ResponseEntity<>("Secuencia de ADN inválida", HttpStatus.BAD_REQUEST); // HTTP 400
////            }
////
////            // Si es mutante, respondemos con HTTP 200
////            if (dnaService.isMutant(dna)) {
////                return new ResponseEntity<>("Es un mutante", HttpStatus.OK); // HTTP 200
////            } else {
////                // Si no es mutante, respondemos con HTTP 403
////                return new ResponseEntity<>("No es mutante", HttpStatus.FORBIDDEN); // HTTP 403
////            }
////        } catch (Exception e) {
////            // Si ocurre un error, respondemos con HTTP 400
////            return new ResponseEntity<>("Error en la secuencia de ADN: " + e.getMessage(), HttpStatus.BAD_REQUEST); // HTTP 400
////        }
////    }
//    @PostMapping("/mutant")
//    public ResponseEntity<String> isMutant(@RequestBody DnaRequest dnaRequest) {
//        try {
//            // Obtener la secuencia de ADN del objeto DnaRequest
//            String[] dna = dnaRequest.getDna(); // Aquí estás accediendo a la secuencia de ADN
//
//            // Verificamos si la secuencia de ADN es válida
//            if (dna == null || dna.length == 0) {
//                return new ResponseEntity<>("Secuencia de ADN inválida", HttpStatus.BAD_REQUEST); // HTTP 400
//            }
//
//            // Si es mutante, respondemos con HTTP 200
//            if (dnaService.isMutant(dna)) {
//                return new ResponseEntity<>("Es un mutante", HttpStatus.OK); // HTTP 200
//            } else {
//                // Si no es mutante, respondemos con HTTP 403
//                return new ResponseEntity<>("No es mutante", HttpStatus.FORBIDDEN); // HTTP 403
//            }
//        } catch (Exception e) {
//            // Si ocurre un error, respondemos con HTTP 400
//            return new ResponseEntity<>("Error en la secuencia de ADN: " + e.getMessage(), HttpStatus.BAD_REQUEST); // HTTP 400
//        }
//    }
//}
package com.example.Xmen.controllers;

import com.example.Xmen.dto.DnaRequest; // Asegúrate de que esta clase esté correctamente definida
import com.example.Xmen.entities.Dna;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.Xmen.services.DnaServiceImpl;

import java.util.Map;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "/api/v1/dna")
public class DnaController extends BaseControllerImpl<Dna, DnaServiceImpl> {

    private final DnaServiceImpl dnaService;

    @Autowired
    public DnaController(DnaServiceImpl dnaService) {
        this.dnaService = dnaService;
    }

    // Endpoint que recibe el ADN y determina si es mutante
    @PostMapping("/mutant")
    public ResponseEntity<String> isMutant(@RequestBody DnaRequest dnaRequest) {
        try {
            String[] dna = dnaRequest.getDna(); // Obtener la secuencia de ADN del objeto DnaRequest

            // Verificamos si la secuencia de ADN es válida
            if (dna == null || dna.length == 0) {
                return new ResponseEntity<>("Secuencia de ADN inválida", HttpStatus.BAD_REQUEST); // HTTP 400
            }

            // Si es mutante, respondemos con HTTP 200
            if (dnaService.isMutant(dna)) {
                return new ResponseEntity<>("Es un mutante", HttpStatus.OK); // HTTP 200
            } else {
                // Si no es mutante, respondemos con HTTP 403
                return new ResponseEntity<>("No es mutante", HttpStatus.FORBIDDEN); // HTTP 403
            }
        } catch (Exception e) {
            // Si ocurre un error, respondemos con HTTP 400
            return new ResponseEntity<>("Error en la secuencia de ADN: " + e.getMessage(), HttpStatus.BAD_REQUEST); // HTTP 400
        }


    }
    @PostMapping("/mutantSave")
    public ResponseEntity<?> saveDNA(@RequestBody DnaRequest dnaRequest) {
        try {
            //Recupero el dna que viene del post
            String[] dna = dnaRequest.getDna();
            //Chequeo si es mutante
            boolean esMutante = dnaService.isMutant(dna);
            //Creo un dna y le asigno, isMutant y el dna recuperado
            Dna entity = new Dna();
            entity.setMutante(esMutante);
            entity.setDna(dna);
            //Guardo el dna
            Dna entidad = servicio.save(entity);
            if (entidad.isMutante()) {
                return ResponseEntity.status(HttpStatus.OK).body("Es mutante! Corran!");
            }
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body("No es mutante");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body("{\"error\":\"Error, por favor intente más tarde\"}");
        }
    }
    @GetMapping("/stats")
    public ResponseEntity<Map<String, Object>> getStats() {
        Map<String, Object> stats = dnaService.getStats();
        return ResponseEntity.status(HttpStatus.OK).body(stats);
    }

}

