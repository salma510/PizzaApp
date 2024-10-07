package com.salma.pizzaapplication.service;
import com.salma.pizzaapplication.dao.IDao;

import java.util.ArrayList;
import android.util.Log;
import com.salma.pizzaapplication.classes.Produit;

import java.util.List;

public class ProduitService implements IDao<Produit> {

    private List<Produit> produits;
    public ProduitService(List<Produit> produits) {
        this.produits = produits;
    }

    public ProduitService() {
        this.produits = new ArrayList<>();
    }


    public boolean create(Produit d) {
        Log.d("Create : ", d.toString());
        return produits.add(d);
    }
    public Produit findById(int id) {
        Log.d("FindById : ", id+"");
        for(Produit p : produits)
            if(p.getId() == id)
                return p;
        return null;
    }

    public List<Produit> findAll() {
        Log.d("findAll : ", produits.size()+"");
        return produits;
    }


    public boolean delete(Produit p) {
        Log.d("Delete : ", p.toString());
        return produits.remove(p);
    }

    public boolean update(Produit o) {
        Produit p = findById(o.getId());
        p.setNom(o.getNom());
        p.setDuree(o.getDuree());
        p.setPhoto(o.getPhoto());
        p.setDescription(o.getDescription());
        p.setPreparation(o.getPreparation());
        p.setDuree(o.getDuree());
        p.setNbrIngredients(o.getNbrIngredients());

        return false;
    }
}
