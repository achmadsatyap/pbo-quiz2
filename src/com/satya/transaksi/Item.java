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
    
}
