package com.martin.proyectofinal;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toolbar;

import com.backendless.Backendless;

public class principalPizzaActivity extends Activity {

    public static final String serverUrl = "https://api.backendless.com";
    public static final String applicationId = "8AD7318A-D897-B55F-FF88-332FBE475700";
    public static final String apiKey = "5EA5EE36-354D-5BAE-FF40-286172DBCC00";

    Toolbar toolbar;
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal_pizza);

        toolbar = findViewById(R.id.toolbar);
        if(toolbar != null){
            setActionBar(toolbar);
        }

        Backendless.setUrl(serverUrl);
        Backendless.initApp(this, applicationId, apiKey);
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.tooblar_principal, menu);
        return true;
    }

    public void orderPizza(MenuItem item) {
        intent = new Intent(this, orderPizzaActivity.class);
        startActivity(intent);
    }


    public void repartoButton(View view) {
        intent = new Intent(this, distributionPizzaActivity.class);
        startActivity(intent);
    }

    public void recogerButton(View view) {
        intent = new Intent(this, collectPizzaActivity.class);
        startActivity(intent);
    }
}