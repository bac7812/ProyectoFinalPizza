package com.martin.proyectofinal;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class orderPizzaCustomAdapter extends BaseAdapter {
    Context context;
    List <Pizza> pizzaFinal = null;
    ViewHolder pizzaList;
    LayoutInflater inflter;
    SimpleDateFormat simpleDateFormat;

    public orderPizzaCustomAdapter(Context applicationContext, List<Pizza> pizzaList) {
        this.context = context;
        this.pizzaFinal = pizzaList;
        inflter = (LayoutInflater.from(applicationContext));
    }
    public class ViewHolder {
        TextView order;
        TextView created;
    }

    @Override
    public int getCount() {
        return pizzaFinal.size();
    }

    @Override
    public Object getItem(int i) {
        return pizzaFinal.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = inflter.inflate(R.layout.activity_list_order_pizza, viewGroup, false);
            pizzaList = new ViewHolder();
            pizzaList.order = view.findViewById(R.id.orderTextView);
            pizzaList.created = view.findViewById(R.id.dateTextView);
            pizzaList.order.setText("PEDIDO " + (i+1) + ":"+ pizzaFinal.get(i).getPizza());
            simpleDateFormat =new SimpleDateFormat("dd/MM/yyyy",Locale.ENGLISH);
            pizzaList.created.setText(simpleDateFormat.format(pizzaFinal.get(i).getCreated()));
            view.setTag(pizzaList);
        } else{
            pizzaList = (ViewHolder) view.getTag();
        }
        return view;
    }
}
