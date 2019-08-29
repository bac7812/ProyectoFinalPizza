package com.martin.proyectofinal;

import android.content.Intent;
import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toolbar;

import java.text.DecimalFormat;

public class optionsTastePizzaActivity extends Activity {

    Toolbar toolbar;
    String place;
    String address;
    String city;
    String province;
    String postalCode;
    int iconList[] = {R.drawable.barbacoa_c, R.drawable.carbonara_c, R.drawable.hawaiana_c, R.drawable.champinones_c, R.drawable.quesos_c, R.drawable.infantil_c};
    int icon;
    String pizza;
    Double price;
    ImageView iconImageView;
    TextView pizzaTextView;
    TextView priceTextView;
    Spinner sizeSpinner;
    Spinner doughSpinner;
    Spinner drinkSpinner;
    Spinner quantitySpinner;
    String[] size = {"Pequeña","Mediana","Grande","Familiar"};
    String[] dough = {"Fina","Normal","Integral","Roller"};
    String[] drink = {"Coca Cola", "Coca Cola Light", "Coca Cola Zero", "Fanta Limón","Fanta Naranja","Nestea","Agua"};
    String[] quantity = {"1","2","3","4","5","6","7","8","9","10"};
    int number;
    double total;
    DecimalFormat decimalFormat;
    Intent intent;
    String iconFinal;
    String pizzaFinal;
    String priceFinal;
    String sizeFinal;
    String doughFinal;
    String drinkFinal;
    String quantityFinal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_options_taste_pizza);

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
        price = Double.parseDouble(getIntent().getStringExtra("price"));

        iconImageView = findViewById(R.id.iconFinalImageView);
        pizzaTextView = findViewById(R.id.pizzaFinalTextView);
        priceTextView = findViewById(R.id.sizeFinalTextView);

        iconImageView.setImageResource(iconList[icon]);
        pizzaTextView.setText(pizza);
        priceTextView.setText(price.toString()+"€");

        sizeSpinner = findViewById(R.id.sizeSpinner);
        sizeSpinner.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, size));

        sizeSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                sizeFinal = String.valueOf(size[i]);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        doughSpinner = findViewById(R.id.doughSpinner);
        doughSpinner.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, dough));

        doughSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                doughFinal = String.valueOf(dough[i]);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        drinkSpinner = findViewById(R.id.drinkSpinner);
        drinkSpinner.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, drink));

        drinkSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                drinkFinal = String.valueOf(drink[i]);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        quantitySpinner = findViewById(R.id.quantitySpinner);
        quantitySpinner.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, quantity));

        quantitySpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                number = Integer.parseInt(quantity[i]);
                total = price * number;
                decimalFormat = new DecimalFormat(".00");
                priceTextView.setText(String.valueOf(decimalFormat.format(total))+"€");
                quantityFinal = quantity[i];
                priceFinal = String.valueOf(decimalFormat.format(total))+"€";
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }


    public void follwingOptionsTasteButton(View view) {

        intent = new Intent(this, payPizzaActivity.class);
        iconFinal = String.valueOf(icon);
        pizzaFinal = pizza;
        intent.putExtra("place",place);
        intent.putExtra("address", address);
        intent.putExtra("city", city);
        intent.putExtra("province", province);
        intent.putExtra("postalCode", postalCode);
        intent.putExtra("icon", iconFinal);
        intent.putExtra("pizza", pizzaFinal);
        intent.putExtra("size", sizeFinal);
        intent.putExtra("dough", doughFinal);
        intent.putExtra("drink", drinkFinal);
        intent.putExtra("quantity", quantityFinal);
        intent.putExtra("price", priceFinal);
        startActivity(intent);
    }
}
