/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.satya.transaksi;

import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author satya
 */
public class ComboModel {
    //hashMap
    private HashMap<String, Float> items = new HashMap<>();
    
    //konstruktor

    public ComboModel() {
        this.items.put("Gula", new Float(20000));
        this.items.put("Kopi", new Float(5000));
        this.items.put("Susu", new Float(15000));
    }
    
    //ArrayList JenisNama Getter
    public ArrayList<String> getJenisNama(){
        ArrayList<String> str = new ArrayList<>();
        for(String item : this.items.keySet()){
            str.add(item);
        }
        return str;
    }
    //ArrayList HargaBarang getter
    public ArrayList<Float> getHargaBarang(){
        ArrayList<Float> flt = new ArrayList<>();
        for(float item : this.items.values()){
            flt.add(item);
        }
        return flt;
    }
    //nambah item 
    public void addItem(String nama, float harga){
        this.items.put(nama, harga);
    }
    
}
