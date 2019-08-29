package com.martin.proyectofinal;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.text.DecimalFormat;

public class typesPizzaCustomAdapter extends BaseAdapter {
    Context context;
    int iconList[];
    String pizzaList[];
    Double priceList[];
    LayoutInflater inflter;
    ImageView icon;
    TextView pizza;
    TextView price;
    DecimalFormat decimalFormat;

    public typesPizzaCustomAdapter(Context applicationContext, int[] iconList, String[] pizzaList, Double[] priceList) {
        this.context = context;
        this.iconList = iconList;
        this.pizzaList = pizzaList;
        this.priceList = priceList;
        inflter = (LayoutInflater.from(applicationContext));
    }

    @Override
    public int getCount() {
        return pizzaList.length;
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        view = inflter.inflate(R.layout.activity_list_pizza, null);
        icon =  view.findViewById(R.id.iconFinalImageView);
        pizza = view.findViewById(R.id.pizzaFinalTextView);
        price = view.findViewById(R.id.sizeFinalTextView);
        icon.setImageResource(iconList[i]);
        pizza.setText(pizzaList[i]);
        decimalFormat = new DecimalFormat(".00");
        price.setText(String.valueOf(decimalFormat.format(priceList[i]))+"€");
        return view;
    }
}
