package com.example.Xmen.services;

import com.example.Xmen.entities.Base;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.io.Serializable;
import java.util.List;

public interface BaseService <E extends Base, ID extends Serializable> {
    public List<E> findAll()throws Exception; // trae lista de personas de la base de datos
    public Page<E> findAll(Pageable pagebale) throws Exception;
    public E findById(ID id) throws Exception; //trae una persona/entidad segun ID
    public E save(E entity) throws Exception; //crea una nueva entidad
    public E update(ID id, E entity)throws Exception; //actualiza
    public boolean delete(ID id)throws Exception; //elimina registros de la base de datos

}