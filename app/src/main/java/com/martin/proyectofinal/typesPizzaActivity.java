package com.martin.proyectofinal;

import android.content.Intent;
import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toolbar;

public class typesPizzaActivity extends Activity {

    Toolbar toolbar;
    String place;
    String address;
    String city;
    String province;
    String postalCode;
    ListView listView;
    int iconList[] = {R.drawable.barbacoa_c, R.drawable.carbonara_c, R.drawable.hawaiana_c, R.drawable.champinones_c, R.drawable.quesos_c, R.drawable.infantil_c};
    String pizzaList[] = {"BARBACOA", "CARBONARA", "HAWAIANA", "CHAMPIÑONES", "4 QUESOS", "INFANTIL"};
    Double priceList[] = {12.95, 12.95, 12.95, 12.95, 12.95, 2.50};
    typesPizzaCustomAdapter customAdapter;
    String icon;
    String pizza;
    String price;
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_types_pizza);

        toolbar = findViewById(R.id.toolbar);
        if(toolbar != null){
            setActionBar(toolbar);
        }

        place = getIntent().getStringExtra("place");
        address = getIntent().getStringExtra("address");
        city = getIntent().getStringExtra("city");
        province = getIntent().getStringExtra("province");
        postalCode = getIntent().getStringExtra("postalCode");


        listView = findViewById(R.id.pizzaListView);
        customAdapter = new typesPizzaCustomAdapter(getApplicationContext(), iconList, pizzaList, priceList);
        listView.setAdapter(customAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                icon = String.valueOf(i);
                pizza = pizzaList[i];
                price = priceList[i].toString();
                intent = new Intent(typesPizzaActivity.this, optionsTastePizzaActivity.class);
                intent.putExtra("place", place);
                intent.putExtra("address", address);
                intent.putExtra("city", city);
                intent.putExtra("province", province);
                intent.putExtra("postalCode", postalCode);
                intent.putExtra("icon", icon);
                intent.putExtra("pizza", pizza);
                intent.putExtra("price", price);
                startActivity(intent);
            }
        });
    }
}
