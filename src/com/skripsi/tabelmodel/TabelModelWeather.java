/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.skripsi.tabelmodel;

import com.skripsi.entity.Weather;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author dickajava
 */
public class TabelModelWeather extends AbstractTableModel{
    
    private List<Weather> list = new ArrayList<>();
    
    public TabelModelWeather(){
        
    }

    @Override
    public int getRowCount() {
      return list.size();
    }

    @Override
    public int getColumnCount() {
        return 6;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
      switch(columnIndex){
          case 0: return list.get(rowIndex).getIdweather();
          case 1: return list.get(rowIndex).getOutlook();
          case 2: return list.get(rowIndex).getTemprature();
          case 3: return list.get(rowIndex).getHumidity();
          case 4: return list.get(rowIndex).getWindy();
          case 5: return list.get(rowIndex).getPlay();
          default:return null;
      }
    }

    @Override
    public String getColumnName(int column) {
        switch(column){
            case 0: return "No";
            case 1: return "Outlook";
            case 2: return "Temprature";
            case 3: return "Humidity";
            case 4: return "Windy";
            case 5: return "Play";
            default:return null;
        }
    }
    
    public void getListWeather(List<Weather> list){
        this.list = list;
        fireTableDataChanged();
    }
    
    public void getInsertWeather(Weather weather){
        this.list.add(weather);
        fireTableDataChanged();
    }
    
}
