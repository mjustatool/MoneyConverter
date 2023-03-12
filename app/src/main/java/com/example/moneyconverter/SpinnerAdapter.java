package com.example.moneyconverter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.moneyconverter.Model.Currency;

import java.util.ArrayList;

public class SpinnerAdapter extends BaseAdapter {


    ArrayList<Currency> currencies;
    Context context;

    public SpinnerAdapter(Context context,ArrayList<Currency> currencies) {
        this.currencies = currencies;
        this.context = context;
    }


    @Override
    public int getCount() {
        return currencies.size();
    }

    @Override
    public Object getItem(int i) {
        return currencies.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        if(view == null){
            view= LayoutInflater.from(context).inflate(R.layout.spinner_row, viewGroup, false);
        }
        TextView currencyName = view.findViewById(R.id.currencyTv);
        currencyName.setText(currencies.get(i).getName());

        return view;
    }
}
