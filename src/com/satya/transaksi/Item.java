/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.satya.transaksi;

/**
 *
 * @author satya
 */
public class Item {
    //variable menyimpan nama barang
    private String nama;
    //variable menyimpan harga barang
    private float harga;
    //variable menyimpan jumlah barang
    private int jumlah;
    
    //Konstruktor

    public Item() {
    }

    public Item(String nama, float harga, int jumlah) {
        this.nama = nama;
        this.harga = harga;
        this.jumlah = jumlah;
    }
    
    //harga setter dan getter

    public void setHarga(float harga) {
        this.harga = harga;
    }

    public float getHarga() {
        return harga;
    }
    //nama setter dan getter

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getNama() {
        return nama;
    }
    //jumlah setter dan getter

    public void setJumlah(int jumlah) {
        this.jumlah = jumlah;
    }

    public int getJumlah() {
        return jumlah;
    }
   //hasil perkalian harga dan jumlah
    public float getTotal(){
        return this.harga * this.jumlah;
    }
    //toString
    public String toString(){
        return this.nama;
    }
    
    
    
}
