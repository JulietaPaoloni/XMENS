package com.example.Xmen.repositories;

import com.example.Xmen.entities.Dna;
import org.springframework.stereotype.Repository;

@Repository
public interface DnaRepository extends BaseRepository<Dna, Long> {
    long countBymutanteTrue();
    long countBymutanteFalse();
}
