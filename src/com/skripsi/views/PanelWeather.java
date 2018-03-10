/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.skripsi.views;

import com.skripsi.dao.WeatherDaoImpl;
import com.skripsi.entity.Weather;
import com.skripsi.tabelmodel.Feature;
import com.skripsi.tabelmodel.TabelModelWeather;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author dickajava
 */
public class PanelWeather extends javax.swing.JPanel {

    
    private WeatherDaoImpl weatherDaoImpl;
    DefaultTableModel importfile;
    private String[][] data=null;
    private Feature splitOnFeature = null;
    private HashMap<Feature, Double> infoGains = new HashMap<Feature, Double>();
    
    private TabelModelWeather tabelModelWeather;
    public PanelWeather() {
        initComponents();
        weatherDaoImpl = new WeatherDaoImpl();
        importfile = new DefaultTableModel();
        tabelModelWeather = new TabelModelWeather();
        txtTotalKasus.setEnabled(false);
        loadData();
        tabel_weather.setModel(tabelModelWeather);
    }
    
    
    private void loadData(){
        List<Weather> weathers = weatherDaoImpl.listWeather();
        tabelModelWeather.getListWeather(weathers);
        tabel_weather.setModel(tabelModelWeather);
    }
    
    //add --> controller hitung entropy dan gains
    public JButton getButtonHitungEntropyDanGains(){
        return btn_hitung_entropy_gain;
    }
    
    //add --> controller pohon keputusan
    public JButton getButtonBuildDecisionTree(){
        return btn_build_tree;
    }
    
    //add --> controller tabel model weather
    public TabelModelWeather getTabelModelWeather(){
        return tabelModelWeather;
    }
    
    //add --> controller tabel weather
    public JTable getTabelWeather(){
        return tabel_weather;
    }
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabel_import = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        tabel_weather = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtOulook = new javax.swing.JTextField();
        txtTemprature = new javax.swing.JTextField();
        txtHumidity = new javax.swing.JTextField();
        txtWindy = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtTotalKasus = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        btn_import = new javax.swing.JButton();
        btn_hitung_entropy_gain = new javax.swing.JButton();
        btn_simpan = new javax.swing.JButton();
        btn_build_tree = new javax.swing.JButton();

        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel1.setText("Algoritma C.45");
        jPanel1.add(jLabel1);

        tabel_import.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Outlook", "Temprature", "Humidity", "Windy", "Play"
            }
        ));
        jScrollPane1.setViewportView(tabel_import);

        jScrollPane2.setViewportView(tabel_weather);

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Hasil Perhitungan Gain"));

        jLabel4.setText("Outlook:");

        jLabel5.setText("Temprature:");

        jLabel6.setText("Humidity:");

        jLabel7.setText("Windy:");

        jLabel2.setText("Total Kasus:");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel7)
                    .addComponent(jLabel6)
                    .addComponent(jLabel5)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtOulook)
                    .addComponent(txtTemprature)
                    .addComponent(txtHumidity)
                    .addComponent(txtWindy)
                    .addComponent(txtTotalKasus, javax.swing.GroupLayout.DEFAULT_SIZE, 267, Short.MAX_VALUE))
                .addGap(98, 98, 98))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtTotalKasus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 16, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txtOulook, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txtTemprature, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txtHumidity, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txtWindy, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        btn_import.setText("Import Data Training");
        btn_import.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_importActionPerformed(evt);
            }
        });
        jPanel3.add(btn_import);

        btn_hitung_entropy_gain.setText("Hitung Entropy dan Gain");
        btn_hitung_entropy_gain.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_hitung_entropy_gainActionPerformed(evt);
            }
        });
        jPanel3.add(btn_hitung_entropy_gain);

        btn_simpan.setText("Simpan Data Training");
        btn_simpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_simpanActionPerformed(evt);
            }
        });
        jPanel3.add(btn_simpan);

        btn_build_tree.setText("Tampilkan Decision Tree c.45");
        jPanel3.add(btn_build_tree);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 510, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 489, Short.MAX_VALUE))
                    .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 268, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 268, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btn_importActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_importActionPerformed
        //import data training
        JFileChooser chooser = new JFileChooser();
        int result = chooser.showOpenDialog(null);
        chooser.setDialogTitle("Pilih untuk import data training");
        if (result == JFileChooser.APPROVE_OPTION) {

            String locationPath = chooser.getSelectedFile().getAbsolutePath();
            File file = new File(locationPath);
            if (!file.getName().endsWith("xlsx") && !file.getName().endsWith("txt")) {
                JOptionPane.showMessageDialog(null, "Maaf ini bukan file yang diharapkan !");
            } else {

                try {
                    FileReader reader = new FileReader(file);
                    BufferedReader br = new BufferedReader(reader);

                    importfile = (DefaultTableModel) tabel_import.getModel();
                    Object[] lines = br.lines().toArray();

                    for (int i = 0; i < lines.length; i++) {
                        String[] row = lines[i].toString().split(",");
                        importfile.addRow(row);
                    }

                } catch (FileNotFoundException ex) {
                    Logger.getLogger(PanelProduct.class.getName()).log(Level.SEVERE, null, ex);
                }

            }

        }
    }//GEN-LAST:event_btn_importActionPerformed

    private void btn_simpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_simpanActionPerformed
        // simpan data training
       if(importfile.getRowCount() == 0){
           JOptionPane.showMessageDialog(null, "Maaf data set masih kosong !");
       }else{
           List<Weather> listweather = new ArrayList();
           for(int i=0; i < importfile.getRowCount(); i++){
               Weather weather = new Weather();
               String outlook = (String) tabel_import.getValueAt(i, 0);
               String temprature = (String) tabel_import.getValueAt(i,1);
               String humidity = (String) tabel_import.getValueAt(i, 2);
               String windy = (String) tabel_import.getValueAt(i, 3);
               String play = (String) tabel_import.getValueAt(i, 4);
               
               weather.setHumidity(humidity);
               weather.setPlay(play);
               weather.setTemprature(temprature);
               weather.setOutlook(outlook);
               weather.setWindy(windy);
               weatherDaoImpl.createWeather(weather);
               loadData();
           }
           JOptionPane.showMessageDialog(null, "data berhasil disimpan");
           if(importfile.getRowCount()>0){
               for(int i=importfile.getRowCount() -1; i>-1; i--){
                   importfile.removeRow(i);
               }
           }
       }
    }//GEN-LAST:event_btn_simpanActionPerformed

    static double rtLog(double x){
        return Math.log(x)/Math.log(2.0);
    }
    
    private void btn_hitung_entropy_gainActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_hitung_entropy_gainActionPerformed
         
        //proses mencari total kasus
        int totalKasus = tabel_weather.getRowCount();
        txtTotalKasus.setText(String.valueOf(totalKasus));
       
        int totalOutlookYes = 0;
        int totalOutlookNo = 0;
        int totalHumidityHighValueYes = 0;
        int totalHumidityHighValueNo = 0;
        int totalWindyTrueByNo = 0;
        int totalWindyTrueByYes = 0;
        int totalWindyFalseByYes = 0;
        int totalWindyFalseByNo = 0;
        int Probabilitas_totalPlayYes = 0;
        int Probabilitas_totalPlayNo = 0;
        
        //entropy informasi 
        double data_entropy = 0.0;
        //gain informasi
        double data_gain = 0.0;     
        
        
        //count total kasus play dengan yes
        Probabilitas_totalPlayYes = weatherDaoImpl.countTotalKasusYes();
        System.out.println("total kasus play dengan nilai yes--> "+Probabilitas_totalPlayYes);
        
        //count total kasus play dengan no
        Probabilitas_totalPlayNo = weatherDaoImpl.countTotalKasusNo();
        System.out.println("total kasus play dengan nilai no---> "+Probabilitas_totalPlayNo);
        
        //entropy total
        data_entropy = rtLog(Probabilitas_totalPlayYes);
        System.out.println("test entropy --> "+data_entropy);
        
        //count total kasus outlook sunny dengan nilai yes
        totalOutlookYes = weatherDaoImpl.countOutlookByYes();
        System.out.println("total outlook dengan yes --> "+ totalOutlookYes);
        
        //count total kasus outlook sunny dengan nilai no
        totalOutlookNo = weatherDaoImpl.countOutlookByNo();
        System.out.println("total outlook dengan No --->"+ totalOutlookNo);
        
        //count total kasus humidity hight dengan nilai yes
        totalHumidityHighValueYes = weatherDaoImpl.countHumidityByYes();
        System.out.println("total humidity dengan instance hight value yes --> "+totalHumidityHighValueYes);
        
        //count total kasus humidity high dengan nilai no
        totalHumidityHighValueNo = weatherDaoImpl.countHumidityByNo();
        System.out.println("total humidity dengan instance high value no --> "+totalHumidityHighValueNo);
        
        //count total kasus windy dengan instance false dengn nilai yes
        totalWindyFalseByYes = weatherDaoImpl.countWindyFalseByYes();
        System.out.println("total windy dengan instance false value yes --> "+totalWindyFalseByYes);    
        
        //count total kasus windy dengan instance false dengan nilai no
        totalWindyFalseByNo = weatherDaoImpl.countWindyFalseByNo();
        System.out.println("total windy dengan instance false value no --> "+totalWindyFalseByNo);
        
        //count total kasus windy dengan instance true dengan nilai yes
        totalWindyTrueByYes = weatherDaoImpl.countWindyTrueByYes();
        System.out.println("total windy dengan instance true value yes --> "+totalWindyTrueByYes);
        
        //count total kasus windy dengan instance true dengan nilai no
        totalWindyTrueByNo = weatherDaoImpl.countWindyFalseByNo();
        System.out.println("total windy dengan instance true value no --> "+totalWindyTrueByNo);
        
    }//GEN-LAST:event_btn_hitung_entropy_gainActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_build_tree;
    private javax.swing.JButton btn_hitung_entropy_gain;
    private javax.swing.JButton btn_import;
    private javax.swing.JButton btn_simpan;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tabel_import;
    private javax.swing.JTable tabel_weather;
    private javax.swing.JTextField txtHumidity;
    private javax.swing.JTextField txtOulook;
    private javax.swing.JTextField txtTemprature;
    private javax.swing.JTextField txtTotalKasus;
    private javax.swing.JTextField txtWindy;
    // End of variables declaration//GEN-END:variables
}
