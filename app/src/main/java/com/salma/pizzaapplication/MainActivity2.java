package com.salma.pizzaapplication;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity2 extends AppCompatActivity {

    private ImageView imagePizza;
    private TextView nomPizza, descriptionPizza, detailsIngredPizza;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        // Lier les vues
        imagePizza = findViewById(R.id.imagePizza);
        nomPizza = findViewById(R.id.nomPizza);
        descriptionPizza = findViewById(R.id.description);
        detailsIngredPizza = findViewById(R.id.detaisIngred);

        // Récupérer les données envoyées depuis ListPizzaActivity
        Intent intent = getIntent();
        String nom = intent.getStringExtra("nom");
        int imageResId = intent.getIntExtra("photo", -1);
        String description = intent.getStringExtra("description");
        String detailsIngred = intent.getStringExtra("detailsIngred");

        // Assigner les valeurs récupérées aux vues
        nomPizza.setText(nom);
        if (imageResId != -1) {  // Vérifier que l'image a bien été envoyée
            imagePizza.setImageResource(imageResId);
        }
        descriptionPizza.setText(description);
        detailsIngredPizza.setText(detailsIngred);
    }
}
