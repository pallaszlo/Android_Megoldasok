package com.example.pizzaselector;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<Pizza> pizzaList = new ArrayList<>();
    Pizza selectedPizza;
    Spinner spinner;
    CheckBox cheese;
    CheckBox tomato;
    TextView price;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        spinner = findViewById(R.id.spinner);
        cheese = findViewById(R.id.cheese);
        tomato = findViewById(R.id.tomato);
        price = findViewById(R.id.price);

        Pizza margarita = new Pizza("Margarita", 22);
        pizzaList.add(margarita);

        Pizza vega = new Pizza("Vegetarian", 25);
        pizzaList.add(vega);

        Pizza napoli = new Pizza("Napoli", 29);
        pizzaList.add(napoli);

        ArrayAdapter<Pizza> pizzaAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, pizzaList);
        spinner.setAdapter(pizzaAdapter);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                selectedPizza = (Pizza) spinner.getSelectedItem();
                String pizzaPrice = Double.toString(selectedPizza.getTotalPrice()) + " RON";
                price.setText(pizzaPrice);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

    public void onClick(View view) {
        if (cheese.isChecked()) {
            selectedPizza.addTopping(cheese.getText().toString(), 3);
        } else {
            selectedPizza.removeTopping(cheese.getText().toString());
        }

        if (tomato.isChecked()) {
            selectedPizza.addTopping(tomato.getText().toString(), 2);
        } else {
            selectedPizza.removeTopping(tomato.getText().toString());
        }

        price.setText(Double.toString(selectedPizza.getTotalPrice()) + " RON");
    }
}