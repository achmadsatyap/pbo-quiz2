/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.satya.transaksi;

import javax.swing.table.DefaultTableModel;

/**
 *
 * @author satya
 */
public class TableTransaksi extends DefaultTableModel{
    //berfungsi untuk menyimpan nama kolom
    private String[] kolom;
    
    //konstruktor

    public TableTransaksi() {
        this.kolom = new String[]{
          "Nama" , "Harga"  , "Jumlah"
        };
    }
    //kolomNama getter
    public String[] getKolomNama(){
        return this.kolom;
    }
}
