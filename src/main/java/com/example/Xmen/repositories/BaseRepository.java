package com.example.Xmen.repositories;

import com.example.Xmen.entities.Base;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

import java.io.Serializable;

@NoRepositoryBean // para q no cree instancias
public interface BaseRepository <E extends Base, ID extends Serializable> extends JpaRepository<E,ID> {
}