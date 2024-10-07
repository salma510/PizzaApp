package com.salma.pizzaapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.salma.pizzaapplication.adapter.PizzaAdapter;
import com.salma.pizzaapplication.classes.Produit;
import com.salma.pizzaapplication.service.ProduitService;

import java.io.Serializable;
import java.util.List;

public class ListPizzaActivity extends AppCompatActivity {

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

        produitService.create(new Produit("DEEP-DISH SAUSAGE PIZZA", 8, R.drawable.pizza4, "45 min",
                "- 1 package (1/4 ounce) active dry yeast\n- 2/3 cup warm water (110° to 115°)\n- 1-3/4 to 2 cups all-purpose flour\n- 1/4 cup vegetable oil...",
                "My Grandma made the tastiest snacks for us when we stayed the night at her farm...",
                "STEP 1: In a mixing bowl, dissolve yeast in water..."));

        produitService.create(new Produit("LOADED MEXICAN PIZZA", 3, R.drawable.pizza7, "30 min",
                "- 1 can (15 ounces) black beans, rinsed and drained\n- 1 medium red onion, chopped...",
                "My husband is a picky eater, but this healthy pizza has lots of flavor...",
                "STEP 1: In a small bowl, mash black beans..."));

        produitService.create(new Produit("BACON CHEESEBURGER PIZZA", 2, R.drawable.pizza8, "20 min",
                "- 1/2 pound ground beef\n- 1 small onion, chopped\n- 1 prebaked Italian bread shell crust...",
                "Kids of all ages love pizza and cheeseburgers...",
                "STEP 1: In a skillet, cook beef and onion over medium heat..."));

        produitService.create(new Produit("PIZZA MARGHERITA", 1, R.drawable.pizza9, "30 min",
                "- 3 teaspoons active dry yeast\n- 1 cup warm water (110° to 115°)\n- 2 tablespoons olive oil...",
                "A classic Pizza Margherita, named for Queen Margherita of Italy...",
                "STEP 1: In a large mixing bowl, dissolve yeast in warm water..."));

        produitService.create(new Produit("PEPPERONI-SAUSAGE STUFFED PIZZA", 5, R.drawable.pizza10, "45 min",
                "- 1 package (1/4 ounce) active dry yeast\n- 1-1/4 cups warm water (110° to 115°)...",
                "For 30 years, friends have been telling me to open a pizzeria using this recipe...",
                "STEP 1: In a small bowl, dissolve yeast in warm water..."));

        produitService.create(new Produit("HOMEMADE PIZZA", 4, R.drawable.pizza5, "50 min",
                "- 1 package (1/4 ounce) active dry yeast\n- 1 teaspoon sugar\n- 1-1/4 cups warm water...",
                "This recipe is a hearty, zesty main dish with a crisp, golden crust...",
                "STEP 1: In large bowl, dissolve yeast and sugar in water..."));

        produitService.create(new Produit("PESTO CHICKEN PIZZA", 3, R.drawable.pizza6, "50 min",
                "- 2 teaspoons active dry yeast\n- 1 cup warm water (110° to 115°)\n- 2-3/4 cups bread flour...",
                "This is the only pizza I make now. We love it! Keeping the spices simple helps...",
                "STEP 1: In a large bowl, dissolve yeast in warm water..."));
        listView= findViewById(R.id.liste);
        //adapter ma liste suivant fruitadapter qui prend en parametre l'activité sur laquelle on travaille et la liste des fruits
        listView.setAdapter(new PizzaAdapter(this, produitService.findAll()));
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Produit selectedProduit = produitService.findAll().get(position);
                Intent intent=new Intent(ListPizzaActivity.this, MainActivity2.class);
                intent.putExtra("nom", selectedProduit.getNom());
                intent.putExtra("photo", selectedProduit.getPhoto());
                intent.putExtra("description", selectedProduit.getDescription());
                intent.putExtra("detailsIngred",selectedProduit.getDetaisIngred());
                startActivity(intent);

            }
        });
    }
}
