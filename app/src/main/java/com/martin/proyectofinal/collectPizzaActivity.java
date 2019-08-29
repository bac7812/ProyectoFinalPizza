package com.martin.proyectofinal;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toolbar;

public class collectPizzaActivity extends Activity {

    Toolbar toolbar;
    String[] place = {"Avenida Ribeira Sacra, 50, OURENSE","Ervedelo esquina Dalí, 2 OURENSE","Celso Emilio Ferreiro, 2 OURENSE"};
    Spinner placeSpinner;
    String placeFinal;
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_collect_pizza);

        toolbar = findViewById(R.id.toolbar);
        if(toolbar != null){
            setActionBar(toolbar);
        }

        placeSpinner = findViewById(R.id.storeSpinner);
        placeSpinner.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, place));
        placeSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                placeFinal = place[i];
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }

    public void fullowingStoreButton(View view) {
        intent = new Intent(this, typesPizzaActivity.class);
        intent.putExtra("place", placeFinal);
        startActivity(intent);
    }
}
