package com.example.moneyconverter.Model;

public class Currency {
    private String nameCurrency;

    public Currency(String name){
        this.nameCurrency = name;
    }
    public String getName(){ return this.nameCurrency; }
}
