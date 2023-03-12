package com.example.moneyconverter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.AdapterView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.moneyconverter.Model.Currency;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {
    private Spinner spinner1,spinner2;
    private EditText input1,input2;
    private Button btnConverter;
    private TextView displayData;
    private ArrayList<Currency> currencies;
    String selectedFromCurrency;
    String selectedToCurrency;
    SpinnerAdapter adapter;
    private float result;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        selectedFromCurrency = "MAD";
        selectedToCurrency = "USD";
        spinner1 = findViewById(R.id.spinner4);
        spinner2 = findViewById(R.id.spinner5);
        result = 0f;
        input1 = findViewById(R.id.value1);
        input2 = findViewById(R.id.value2);
        btnConverter = findViewById(R.id.cvter);
        displayData = findViewById(R.id.resultView);
        CurrenciesData();
        initSpinnerAdapter();

    }
    public void Calculate(View v){
        if(input1.getText().toString().isEmpty()){
            input1.setError("Please enter the amount");
        }
        else if(selectedFromCurrency.equals(selectedToCurrency)){
            Toast.makeText(this, "Please selected different currency ",Toast.LENGTH_LONG).show();
        }
        else{
            // from mad to usd and eur
            if(selectedFromCurrency.equals("MAD") && selectedToCurrency.equals("EUR")){
                result = Float.parseFloat(input1.getText().toString()) / 11;
            }
            else if(selectedFromCurrency.equals("MAD") && selectedToCurrency.equals("USD")){
                result = Float.parseFloat(input1.getText().toString()) / 10;
            }
            else if(selectedFromCurrency.equals("EUR") && selectedToCurrency.equals("MAD")){
                result = Float.parseFloat(input1.getText().toString()) * 10;
            }
            else if(selectedFromCurrency.equals("EUR") && selectedToCurrency.equals("USD")){
                result = Float.parseFloat(input1.getText().toString()) * 1.07f;
            }
            else if(selectedFromCurrency.equals("USD") && selectedToCurrency.equals("MAD")){
                result = Float.parseFloat(input1.getText().toString()) * 10;
            }
            else if(selectedFromCurrency.equals("USD") && selectedToCurrency.equals("EUR")){
                result = Float.parseFloat(input1.getText().toString()) / 1.07f;
            }
            displayData.setText(result+ " " );
        }
    }
    private void initSpinnerAdapter(){
        ArrayAdapter<Currency> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item,currencies);
        this.adapter = new SpinnerAdapter(this, currencies);
        spinner1.setAdapter(this.adapter);
        spinner2.setAdapter(this.adapter);

        spinner1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                selectedFromCurrency = adapterView.getItemAtPosition(i).toString();

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        spinner2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                selectedToCurrency = adapterView.getItemAtPosition(i).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });


    }
    public void CurrenciesData(){
        currencies = new ArrayList<>();
        currencies.add(new Currency("MAD"));
        currencies.add(new Currency("EUR"));
        currencies.add(new Currency("USD"));
    }
}