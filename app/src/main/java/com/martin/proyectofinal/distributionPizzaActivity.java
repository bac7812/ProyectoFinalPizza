package com.martin.proyectofinal;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
import android.widget.Toolbar;

public class distributionPizzaActivity extends Activity {

    Toolbar toolbar;
    String address;
    String city;
    String province;
    String postalCode;
    AlertDialog.Builder builder;
    AlertDialog dialog;
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_distribution_pizza);

        toolbar = findViewById(R.id.toolbar);
        if(toolbar != null){
            setActionBar(toolbar);
        }
    }

    public void followingAddressButton(View view) {
        address = ((EditText)findViewById(R.id.addressEditText)).getText().toString();
        city = ((EditText)findViewById(R.id.cityEditText)).getText().toString();
        province = ((EditText)findViewById(R.id.provinceEditText)).getText().toString();
        postalCode = ((EditText)findViewById(R.id.postalCodeEditText)).getText().toString();

        if(address.isEmpty() || city.isEmpty() || province.isEmpty() || postalCode.isEmpty()){
            builder = new AlertDialog.Builder(this);
            builder.setTitle("Aviso");
            builder.setMessage("No se puedan estar vacíos");

            builder.setNegativeButton("Aceptar", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int id) {
                }
            });

            dialog = builder.create();

            dialog.show();
        }
        else{
            intent = new Intent(this, typesPizzaActivity.class);
            intent.putExtra("address", address);
            intent.putExtra("city", city);
            intent.putExtra("province", province);
            intent.putExtra("postalCode", postalCode);
            startActivity(intent);
        }
    }
}
