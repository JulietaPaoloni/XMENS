package com.example.Xmen.entities;

import jakarta.persistence.*;
import lombok.*;
import jakarta.persistence.Entity;
import jakarta.persistence.Column;
import jakarta.persistence.Table;
//import org.hibernate.envers.Audited;

@Entity
@Getter
@Setter
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "persona")
//@Audited
public class Persona extends Base {
    @Column(name = "nombre")
    private String nombre;
    @Column(name = "apellido")
    private String apellido;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "dna_id")
    private Dna dna;

}
