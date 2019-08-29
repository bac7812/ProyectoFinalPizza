package com.martin.proyectofinal;

import android.content.Intent;
import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.Toolbar;

import com.backendless.Backendless;
import com.backendless.async.callback.AsyncCallback;
import com.backendless.exceptions.BackendlessFault;

import java.util.List;

public class orderDetailPizzaActivity extends Activity {

    Toolbar toolbar;
    List<Pizza> pizzaList;
    int iconList[] = {R.drawable.barbacoa_c, R.drawable.carbonara_c, R.drawable.hawaiana_c, R.drawable.champinones_c, R.drawable.quesos_c, R.drawable.infantil_c};
    int id;
    String objectId;
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
    RadioButton cashRadioButton;
    RadioButton cardRadioButton;
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_detail_pizza);

        toolbar = findViewById(R.id.toolbar);
        if(toolbar != null){
            setActionBar(toolbar);
        }

        id = Integer.parseInt(getIntent().getStringExtra("id"));

        Backendless.Persistence.of(Pizza.class).find(new AsyncCallback<List<Pizza>>() {
            @Override
            public void handleResponse(List<Pizza> response) {
                    objectId = response.get(id).getObjectId();
                    icon = Integer.parseInt(response.get(id).getIcon());
                    pizza = response.get(id).getPizza();
                    size = response.get(id).getSize();
                    dough = response.get(id).getDough();
                    drink = response.get(id).getDrink();
                    quantity = response.get(id).getQuantity();
                    price = response.get(id).getPrice();
                    pay = response.get(id).getPay();

                    iconImageView = findViewById(R.id.iconFinalImageView);
                    pizzaTextView = findViewById(R.id.pizzaFinalTextView);
                    sizeTextView = findViewById(R.id.sizeFinalTextView);
                    doughTextView = findViewById(R.id.doughFinalTextView);
                    drinkTextView = findViewById(R.id.drinkFinalTextView);
                    quantityTextView = findViewById(R.id.quantityFinalTextView);
                    priceTextView = findViewById(R.id.totalPriceFinalTextView);
                    radioGroup = findViewById(R.id.radioGroup);
                    cashRadioButton = findViewById(R.id.cashRadioButton);
                    cardRadioButton = findViewById(R.id.cardRadioButton);

                    iconImageView.setImageResource(iconList[icon]);
                    pizzaTextView.setText(pizza);
                    sizeTextView.setText("TAMAÑO: "+size);
                    doughTextView.setText("MASA: "+dough);
                    drinkTextView.setText("BEBIDA: "+drink);
                    quantityTextView.setText("CANTIDAD: "+quantity);
                    priceTextView.setText("TOTAL: "+price);
                    if(Integer.parseInt(pay) == 0){
                        cashRadioButton.setChecked(true);
                    }else{
                        if (Integer.parseInt(pay) == 1){
                            cardRadioButton.setChecked(true);
                        }
                    }

                    pizzaList = response;
            }

            @Override
            public void handleFault(BackendlessFault fault) {

            }
        });
    }

    public void deleteButton(View view) {

        Backendless.Persistence.of(Pizza.class).remove(pizzaList.get(id), new AsyncCallback<Long>() {
            @Override
            public void handleResponse(Long response) {
                Toast.makeText(orderDetailPizzaActivity.this, "Pedido eliminado", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void handleFault(BackendlessFault fault) {

            }
        });

        intent = new Intent(orderDetailPizzaActivity.this, principalPizzaActivity.class);
        startActivity(intent);
    }
}
