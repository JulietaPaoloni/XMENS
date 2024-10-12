package com.example.Xmen.entities;

import jakarta.persistence.*;
import lombok.*;
//import org.hibernate.envers.Audited;

@Entity
@Getter
@Setter
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "dna")
//@Audited
public class Dna extends Base{
    @Column(name = "mutante")
    private boolean mutante;  //Si es True = mutante, False= no

    @Column(unique = true)
    private String[] dna;

    @OneToOne(mappedBy = "dna", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Persona persona;


}
