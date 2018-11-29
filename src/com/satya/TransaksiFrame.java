package com.satya;

import com.satya.transaksi.Item;
import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;
import javax.swing.table.DefaultTableModel;
import com.satya.transaksi.*;
import java.text.SimpleDateFormat;
import java.util.*;
import javax.swing.JOptionPane;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author satya
 */
public class TransaksiFrame extends javax.swing.JFrame {

    //variable ID kode transaksi
    private int id = 0;
    //variable untuk kode transaksi
    private String code;
    //table model
    private DefaultTableModel tbModel;
    //combobox model
    private  DefaultComboBoxModel cbModel;
    //variable pembelanjaan transaksi item
    private ArrayList<Item> belanja = new ArrayList<>();
    
    //konstruktor
    public TransaksiFrame() {
        ComboModel comboModel = new ComboModel();
        this.cbModel = new DefaultComboBoxModel<>(comboModel.getJenisNama().toArray());
        
        TableTransaksi tabelModel = new TableTransaksi();
        this.tbModel = new DefaultTableModel(tabelModel.getKolomNama(), 0); // tabel kolom nama
        initComponents();
    }

    
    //penambahan id
    private  void incId(){
        this.id += 1;
    }
    //pengurangan id
    private  void decId(){
        this.id -= 1;
    }
 //addItem Object
    private  Object[] addItem(String nama, int jumlah){
        float harga = 0;
        ComboModel items = new ComboModel();
        for(int i = 0 ; i < items.getHargaBarang().size(); i++){
            if(nama.equalsIgnoreCase(items.getJenisNama().get(i))){
            harga = items.getHargaBarang().get(i);
            }
        }
        Object[] obj = {
            nama,
            harga,
            jumlah
        };
        return obj;
    }
    
    //set fungsi code
    private String setCode(){
        this.incId();
        // tanggal
        String sk = new SimpleDateFormat("yyMMdd").format(new Date());
        this.code = String.format(sk + "%02d", this.id);
        return code;
    }
    
    // update fungsi jumlah
    private  void updateJumlah(String nama, int add){
        ArrayList<String> item = new ArrayList<>();
        for(int i = 0; i < tbModel.getRowCount(); i++){
            item.add(tbModel.getValueAt(i, 0).toString());
        }
        for(int i = 0; i < item.size(); i++){
            if(item.get(i).equals(nama)){
                int jumlah = new Integer (tbModel.getValueAt(i, 2).toString());
                tbModel.setValueAt(jumlah + add, i, 2);
            }
        }
    }
    // ngecek item double yang terpilih pada item sebelumnya
    private  boolean Duplicate(String nama){
        boolean result = false;
        ArrayList<String> item = new ArrayList<>();
        for(int i = 0; i < tbModel.getRowCount(); i++){
            item.add(tbModel.getValueAt(i, 0).toString());
        }
        for(String i : item){
            if(i.equals(nama)){
                result = true;
            }
        }
        return result;
    }
    //disable tombol remove dan save jiak isi table kosong
    private void belanja(){
        if(isEmpty()){
            this.saveButton.setEnabled(false);
            this.removeButton.setEnabled(false);
        }else{
            this.saveButton.setEnabled(true);
            this.removeButton.setEnabled(true);
        }
    }
    
    // ngecek jika isi tabel kosong
    private boolean isEmpty(){
        return this.transaksiTable.getModel().getRowCount() <= 0;
    }
    // melakukan transaksi baru jika sudah transaksi sebelumnya
    private  void newTransaksi(){
        this.itemsText.setText("");
        this.codeText.setText("");
        this.newButton.setEnabled(true);
        this.saveButton.setEnabled(false);
        this.cancelButton.setEnabled(false);
        this.addButton.setEnabled(false);
        this.removeButton.setEnabled(false);
        this.removeButton.setEnabled(false);
        this.itemsText.setEnabled(false);
        this.itemCombo.setEnabled(false);
        this.tbModel.setRowCount(0);
        this.belanja.clear();
    }
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jFrame1 = new javax.swing.JFrame();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        codeText = new javax.swing.JTextField();
        itemCombo = new javax.swing.JComboBox<>();
        itemsText = new javax.swing.JTextField();
        newButton = new javax.swing.JButton();
        addButton = new javax.swing.JButton();
        removeButton = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        transaksiTable = new javax.swing.JTable();
        saveButton = new javax.swing.JButton();
        cancelButton = new javax.swing.JButton();

        javax.swing.GroupLayout jFrame1Layout = new javax.swing.GroupLayout(jFrame1.getContentPane());
        jFrame1.getContentPane().setLayout(jFrame1Layout);
        jFrame1Layout.setHorizontalGroup(
            jFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        jFrame1Layout.setVerticalGroup(
            jFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Code");

        jLabel2.setText("Items");

        codeText.setDragEnabled(true);
        codeText.setEnabled(false);

        itemCombo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Susu", "Gula", "Kopi" }));
        itemCombo.setSelectedIndex(-1);
        itemCombo.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        itemCombo.setEnabled(false);

        itemsText.setEnabled(false);
        itemsText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemsTextActionPerformed(evt);
            }
        });

        newButton.setText("New");
        newButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                newButtonActionPerformed(evt);
            }
        });

        addButton.setText("Add");
        addButton.setEnabled(false);
        addButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addButtonActionPerformed(evt);
            }
        });

        removeButton.setText("Remove");
        removeButton.setEnabled(false);
        removeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removeButtonActionPerformed(evt);
            }
        });

        transaksiTable.setModel(this.tbModel);
        jScrollPane1.setViewportView(transaksiTable);

        saveButton.setText("Save");
        saveButton.setEnabled(false);
        saveButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveButtonActionPerformed(evt);
            }
        });

        cancelButton.setText("Cancel");
        cancelButton.setEnabled(false);
        cancelButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1)
                                    .addComponent(jLabel2))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(itemCombo, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(itemsText, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(codeText)))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 308, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(45, 45, 45)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(removeButton, javax.swing.GroupLayout.DEFAULT_SIZE, 60, Short.MAX_VALUE)
                            .addComponent(addButton, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(newButton, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(36, 36, 36))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(saveButton, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(33, 33, 33)
                        .addComponent(cancelButton, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(codeText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(newButton))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(itemCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(itemsText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(addButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(removeButton)
                        .addGap(175, 175, 175))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cancelButton)
                    .addComponent(saveButton))
                .addContainerGap(134, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void saveButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveButtonActionPerformed
        try{
            // loop setiap tabel
            for(int i = 0; i < tbModel.getRowCount(); i++){
                //menyimpan nama dan jumlah menjadi variable
                String nama = tbModel.getValueAt(i, 0).toString();
                float harga = new Float(tbModel.getValueAt(i, 1).toString());
                int jumlah = new Integer(tbModel.getValueAt(i, 2).toString());
                this.belanja.add(new Item(nama, harga, jumlah));
            }
            //Transaksi dengan kode dan comitted belanja
            Transaksi transaksi = new Transaksi(this.code, this.belanja);
            //menangani output transaksi
            StringBuilder sbr = new StringBuilder();
            //menambahkan hasil transaksi
            sbr.append(transaksi.Pembayaran());
            // memanggil dialog
            JOptionPane.showMessageDialog(this, sbr, "Transaksi" , JOptionPane.INFORMATION_MESSAGE);
            // melakukan transaksi baru
            newTransaksi();
            
            
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }//GEN-LAST:event_saveButtonActionPerformed

    private void itemsTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemsTextActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_itemsTextActionPerformed

    private void newButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newButtonActionPerformed
        this.itemsText.setText("1");
        this.newButton.setEnabled(false);
        this.cancelButton.setEnabled(true);
        this.addButton.setEnabled(true);
        this.itemsText.setEnabled(true);
        this.itemCombo.setEnabled(true);
        this.codeText.setText(this.setCode());
    }//GEN-LAST:event_newButtonActionPerformed

    private void addButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addButtonActionPerformed
        String nama = this.itemCombo.getSelectedItem().toString();
        int jumlah = new Integer(this.itemsText.getText());
        if(Duplicate(nama)){
            updateJumlah(nama, jumlah);
        }else{
            tbModel.addRow(addItem(nama, jumlah));
        }
        this.belanja();
    }//GEN-LAST:event_addButtonActionPerformed

    private void cancelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelButtonActionPerformed
        newTransaksi();
        this.decId();
    }//GEN-LAST:event_cancelButtonActionPerformed

    private void removeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removeButtonActionPerformed
        // ngecek apakah ada baris yang dipilih
        if(transaksiTable.getSelectedRow() <0){
            String sbr = "Pilih item mau dihapus";
            JOptionPane.showMessageDialog(this, sbr,"Information",JOptionPane.INFORMATION_MESSAGE);
        }else{
            // ada baris yang dipilih, baris itu akan dihapus
            int count = transaksiTable.getSelectedRows().length;
            for(int i = 0; i < count; i++){
                tbModel.removeRow(transaksiTable.getSelectedRow());
            }
        }
            this.belanja();
        
    }//GEN-LAST:event_removeButtonActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(TransaksiFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TransaksiFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TransaksiFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TransaksiFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
            try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(TransaksiFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TransaksiFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TransaksiFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TransaksiFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
            java.awt.EventQueue.invokeLater(new Runnable(){
                public void run(){
                    new TransaksiFrame().setVisible(true);
                }
    });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addButton;
    private javax.swing.JButton cancelButton;
    private javax.swing.JTextField codeText;
    private javax.swing.JComboBox<String> itemCombo;
    private javax.swing.JTextField itemsText;
    private javax.swing.JFrame jFrame1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton newButton;
    private javax.swing.JButton removeButton;
    private javax.swing.JButton saveButton;
    private javax.swing.JTable transaksiTable;
    // End of variables declaration//GEN-END:variables

  

   
}
