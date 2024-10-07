package com.salma.pizzaapplication.dao;
import java.util.List;
public interface IDao<T> {
    boolean create(T obj);
    List<T> findAll();
    T findById(int id);    // Trouver un objet par ID
    boolean update(T obj);    // Mettre à jour un objet existant
    boolean delete(T id);   // Supprimer un objet par ID
}


