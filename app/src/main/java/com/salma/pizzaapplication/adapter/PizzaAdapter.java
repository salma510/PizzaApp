package com.salma.pizzaapplication.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.salma.pizzaapplication.R;
import com.salma.pizzaapplication.classes.Produit;

import java.util.List;

public class PizzaAdapter extends ArrayAdapter<Produit> {

    public PizzaAdapter(Context context, List<Produit> produits) {
        super(context, 0, produits);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Vérifier si la vue existante peut être réutilisée, sinon, gonfler la vue
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.item_pizza, parent, false);
        }

        // Obtenir l'élément produit à cette position
        Produit produit = getItem(position);

        // Récupérer les vues de l'item_pizza.xml
        ImageView imageView = convertView.findViewById(R.id.imagePizza);
        TextView nomTextView = convertView.findViewById(R.id.nomPizza);
        TextView tempsTextView = convertView.findViewById(R.id.tempsPreparation);

        // Remplir les données du produit
        if (produit != null) {
            imageView.setImageResource(produit.getPhoto());
            nomTextView.setText(produit.getNom());
            tempsTextView.setText(produit.getDuree());
        }

        // Retourner la vue remplie pour afficher la ligne dans la ListView
        return convertView;
    }
}
