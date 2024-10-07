package com.salma.pizzaapplication;

import android.os.Bundle;
import android.widget.ListView;
import androidx.appcompat.app.AppCompatActivity;

import com.salma.pizzaapplication.adapter.PizzaAdapter;
import com.salma.pizzaapplication.classes.Produit;
import com.salma.pizzaapplication.service.ProduitService;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ListView listView;
    private ProduitService produitService;
    private PizzaAdapter pizzaAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_pizza);

        // Initialiser la ListView
        listView = findViewById(R.id.liste);

        // Créer une instance du service qui gère les produits (pizzas)
        produitService = new ProduitService();

        // Ajouter les pizzas dans le service avec des images placées dans drawable
        produitService.create(new Produit("BARBECUED CHICKEN PIZZA", 3, R.drawable.pizza1, "35 min",
                "- 2 boneless skinless chicken breast halves (6 ounces each)\n- 1/4 teaspoon pepper\n- 1 cup barbecue sauce, divided...",
                "So fast and so easy with refrigerated pizza crust...",
                "STEP 1: Sprinkle chicken with pepper; place on an oiled grill rack. Grill covered until cooked through..."));

        produitService.create(new Produit("BRUSCHETTA PIZZA", 5, R.drawable.pizza2, "35 min",
                "- 1/2 pound reduced-fat bulk pork sausage\n- 1 prebaked 12-inch pizza crust\n- 1 package (6 ounces) sliced turkey pepperoni\n- 2 cups shredded part-skim mozzarella cheese...",
                "You might need a knife and fork for this hearty pizza! Loaded with Italian flavor and plenty of fresh tomatoes...",
                "STEP 1: In a small skillet, cook sausage over medium heat until no longer pink; drain. Place crust on an ungreased baking sheet..."));

        produitService.create(new Produit("SPINACH PIZZA", 2, R.drawable.pizza3, "25 min",
                "- 1 package (6-1/2 ounces) pizza crust mix\n- 1/2 cup Alfredo sauce\n- 2 medium tomatoes\n- 4 cups chopped fresh spinach...",
                "This tasty pizza is so easy to prepare. My family, including my young daughter, loves it.",
                "STEP 1: Prepare pizza dough according to package directions. Spread Alfredo sauce over dough. Top with spinach and cheese..."));

        // Continuez d'ajouter les autres pizzas avec les images placées dans drawable...

        // Récupérer la liste des produits (pizzas)
        List<Produit> produits = produitService.findAll();

        // Initialiser l'adaptateur pour la ListView
        pizzaAdapter = new PizzaAdapter(this, produits);

        // Lier l'adaptateur à la ListView
        listView.setAdapter(pizzaAdapter);
    }
}
