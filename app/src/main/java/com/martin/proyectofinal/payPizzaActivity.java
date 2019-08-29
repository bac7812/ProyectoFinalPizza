package com.martin.proyectofinal;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.widget.ImageView;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toolbar;

import com.backendless.Backendless;
import com.backendless.async.callback.AsyncCallback;
import com.backendless.exceptions.BackendlessFault;

public class payPizzaActivity extends Activity {

    Toolbar toolbar;
    String place;
    String address;
    String city;
    String province;
    String postalCode;
    int iconList[] = {R.drawable.barbacoa_c, R.drawable.carbonara_c, R.drawable.hawaiana_c, R.drawable.champinones_c, R.drawable.quesos_c, R.drawable.infantil_c};
    int icon;
    String pizza;
    String size;
    String dough;
    String drink;
    String quantity;
    String price;
    String pay;
    ImageView iconImageView;
    TextView pizzaTextView;
    TextView sizeTextView;
    TextView doughTextView;
    TextView drinkTextView;
    TextView quantityTextView;
    TextView priceTextView;
    RadioGroup radioGroup;
    AlertDialog.Builder builder;
    AlertDialog dialog;
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pay_pizza);

        toolbar = findViewById(R.id.toolbar);
        if(toolbar != null){
            setActionBar(toolbar);
        }

        place = getIntent().getStringExtra("place");
        address = getIntent().getStringExtra("address");
        city = getIntent().getStringExtra("city");
        province = getIntent().getStringExtra("province");
        postalCode = getIntent().getStringExtra("postalCode");
        icon = Integer.parseInt(getIntent().getStringExtra("icon"));
        pizza = getIntent().getStringExtra("pizza");
        size = getIntent().getStringExtra("size");
        dough = getIntent().getStringExtra("dough");
        drink = getIntent().getStringExtra("drink");
        quantity = getIntent().getStringExtra("quantity");
        price = getIntent().getStringExtra("price");

        iconImageView = findViewById(R.id.iconFinalImageView);
        pizzaTextView = findViewById(R.id.pizzaFinalTextView);
        sizeTextView = findViewById(R.id.sizeFinalTextView);
        doughTextView = findViewById(R.id.doughFinalTextView);
        drinkTextView = findViewById(R.id.drinkFinalTextView);
        quantityTextView = findViewById(R.id.quantityFinalTextView);
        priceTextView = findViewById(R.id.totalPriceFinalTextView);
        radioGroup = findViewById(R.id.radioGroup);

        iconImageView.setImageResource(iconList[icon]);
        pizzaTextView.setText(pizza);
        sizeTextView.setText("TAMAÑO: "+size);
        doughTextView.setText("MASA: "+dough);
        drinkTextView.setText("BEBIDA: "+drink);
        quantityTextView.setText("CANTIDAD: "+quantity);
        priceTextView.setText("TOTAL: "+price);

        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                switch (i) {
                    case R.id.cashRadioButton:
                        pay = "0";
                        break;

                    case R.id.cardRadioButton:
                        pay = "1";
                        break;
                }
            }
        });
    }

    public void payButton(View view) {
        if(radioGroup.getCheckedRadioButtonId() == -1){
            builder = new AlertDialog.Builder(this);
            builder.setTitle("Aviso");
            builder.setMessage("No se puedan estar vacíos");

            builder.setNegativeButton("Aceptar", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int id) {
                }
            });

            dialog = builder.create();

            dialog.show();

        } else{

            Pizza p = new Pizza();
            p.setPlace(place);
            p.setAddress(address);
            p.setCity(city);
            p.setProvince(province);
            p.setPostalCode(postalCode);
            p.setIcon(String.valueOf(icon));
            p.setPizza(pizza);
            p.setSize(size);
            p.setDough(dough);
            p.setDrink(drink);
            p.setQuantity(quantity);
            p.setPrice(price);
            p.setPay(pay);
            Backendless.Data.of(Pizza.class).save(p, new AsyncCallback<Pizza>() {
                @Override
                public void handleResponse(Pizza response) {

                }

                @Override
                public void handleFault(BackendlessFault fault) {

                }
            });
            intent = new Intent(this, confirmPizzaActivity.class);
            startActivity(intent);
        }
    }
}
