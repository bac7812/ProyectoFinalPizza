package com.martin.proyectofinal;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toolbar;

import com.backendless.Backendless;
import com.backendless.async.callback.AsyncCallback;
import com.backendless.exceptions.BackendlessFault;

import java.util.ArrayList;
import java.util.List;

public class orderPizzaActivity extends Activity {

    Toolbar toolbar;
    List<Pizza> pizza = new ArrayList<>();
    Pizza pizzaList;
    ListView listView;
    orderPizzaCustomAdapter customAdapter;
    Intent intent;
    int id;
    String pizzaFinal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_pizza);

        toolbar = findViewById(R.id.toolbar);
        if (toolbar != null) {
            setActionBar(toolbar);
        }

        listView = findViewById(R.id.orderListView);

        Backendless.Persistence.of(Pizza.class).find(new AsyncCallback<List<Pizza>>() {
            @Override
            public void handleResponse(List<Pizza> response) {
                for (int i = 0; i < response.size(); i++) {
                    pizzaList = new Pizza();
                    pizzaList.setPizza(response.get(i).getPizza());
                    pizzaList.setCreated(response.get(i).getCreated());

                    pizza.add(pizzaList);

                    customAdapter = new orderPizzaCustomAdapter(getApplicationContext(), pizza);
                    listView.setAdapter(customAdapter);
                }
            }

            @Override
            public void handleFault(BackendlessFault fault) {

            }
        });
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                pizzaFinal = String.valueOf(i);
                intent = new Intent(orderPizzaActivity.this, orderDetailPizzaActivity.class);
                intent.putExtra("id", pizzaFinal);
                startActivity(intent);
            }
        });
    }
}
