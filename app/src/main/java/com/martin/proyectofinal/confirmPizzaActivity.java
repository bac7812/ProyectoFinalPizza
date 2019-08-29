package com.martin.proyectofinal;

import android.content.Intent;
import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.widget.Toolbar;

public class confirmPizzaActivity extends Activity {

    Toolbar toolbar;
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirm_pizza);

        toolbar = findViewById(R.id.toolbar);
        if(toolbar != null){
            setActionBar(toolbar);
        }
    }

    public void returnHomeButton(View view){
        intent = new Intent(this, principalPizzaActivity.class);
        startActivity(intent);
    }
}
