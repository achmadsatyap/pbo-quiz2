package com.satya.transaksi;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author satya
 */
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.ArrayList;
public class Transaksi {
    //variable untuk menampilkan kode pembayaran 
    private final String kode;
    //item untuk menampilkan item apa saja yang dibeli
    private  ArrayList<Item> items = new ArrayList();
    //variable menampilkan total pembelian
    private float total;
    
    //konstruktor

    public Transaksi(String kode, ArrayList<Item> items) {
        this.kode = kode;
        this.items = items;
    }
    
    //total setter
    public void setTotal(){
        float total = 0;
        for(Item item : this.items){
            total += item.getTotal();
        }
        this.total = total;
    }
    //output transaksi
    public String Pembayaran(){
        setTotal();
        String obt = "";
        obt += "Kode\t\t : " + this.kode + "\n";
        obt += "Daftar Belanja : \n ";
        for (Item item : this.items){
            obt += "\t" + item.getNama()  + "(X" + item.getJumlah() + ") : " +item.getTotal() + "\n" ;   
        }
        obt += "Total\t\t : " + this.total;
        return obt;
    }
    
}
