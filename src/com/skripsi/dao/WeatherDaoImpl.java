/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.skripsi.dao;

import com.skripsi.connection.DBConnection;
import com.skripsi.entity.Weather;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author dickajava
 */
public class WeatherDaoImpl implements WeatherDao{
    
    private Connection connection;
    public WeatherDaoImpl(){
        connection = DBConnection.getConnection();
    }

    @Override
    public List<Weather> listWeather() {
        PreparedStatement statement=null;
        List list = new ArrayList<>();
        ResultSet rs = null;
        String sql="select * from weather";
        try {
            statement=connection.prepareStatement(sql);
            rs=statement.executeQuery();
            while(rs.next()){
                Weather w = new Weather();
                w.setIdweather(rs.getInt("idweather"));
                w.setOutlook(rs.getString("outlook"));
                w.setTemprature(rs.getString("temprature"));
                w.setHumidity(rs.getString("humidity"));
                w.setWindy(rs.getString("windy"));
                w.setPlay(rs.getString("play"));
                list.add(w);
            }
            return list;
        } catch (SQLException ex) {
            Logger.getLogger(WeatherDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }finally{
            if(statement!=null){
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(WeatherDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if(rs!=null){
                try {
                    rs.close();
                } catch (SQLException ex) {
                    Logger.getLogger(WeatherDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

    @Override
    public Weather createWeather(Weather weather) {
        PreparedStatement statement = null;
        String sql = "insert into weather(outlook, temprature, humidity, windy, play) "
                + "values(?,?,?,?,?)";
        try {
            statement=connection.prepareStatement(sql);
            statement.setString(1, weather.getOutlook());
            statement.setString(2, weather.getTemprature());
            statement.setString(3, weather.getHumidity());
            statement.setString(4, weather.getWindy());
            statement.setString(5, weather.getPlay());
            statement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(WeatherDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            if(statement!=null){
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(WeatherDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return weather;
    }

    //total kasus outlook dengan nilai sunny dengan nilai yes
    @Override
    public int countOutlookByYes() {
      PreparedStatement statement=null;
      String sql="select count(*) as counter from weather where outlook='sunny' and play='yes'";
      ResultSet rs = null;
      Weather weather =null;
      int rows = 0;
        try {
            statement=connection.prepareStatement(sql);
            rs=statement.executeQuery();
            while(rs.next()){
                weather = new Weather();
                rows = rs.getInt("counter");
            }
        } catch (SQLException ex) {
            Logger.getLogger(WeatherDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            if(statement!=null){
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(WeatherDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if(rs!=null){
                try {
                    rs.close();
                } catch (SQLException ex) {
                    Logger.getLogger(WeatherDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return rows;
    }

    //menghitung total kasus yes
    @Override
    public int countTotalKasusYes() {
       PreparedStatement statement=null;
       ResultSet rs = null;
       int countKasusYes = 0;
       String sql = "select count(*) as Y from weather where play='yes'";
        try {
            statement=connection.prepareStatement(sql);
            rs=statement.executeQuery();
            while(rs.next()){
                countKasusYes = rs.getInt("Y");
            }
        } catch (SQLException ex) {
            Logger.getLogger(WeatherDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            if(statement!=null){
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(WeatherDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }if(rs!=null){
                try {
                    rs.close();
                } catch (SQLException ex) {
                    Logger.getLogger(WeatherDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            return countKasusYes;
        }
    }

    //menghitung total kasus NO
    @Override
    public int countTotalKasusNo() {
        PreparedStatement statement=null;
        String sql="select count(*) as N from weather where play='no'";
        ResultSet rs = null;
        Weather weather = null;
        int countTotalKasusNo = 0;
        try {
            statement=connection.prepareStatement(sql);
            rs=statement.executeQuery();
            while(rs.next()){
                weather = new Weather();
                countTotalKasusNo = rs.getInt("N"); //-----> parameter N 
            }
        } catch (SQLException ex) {
            Logger.getLogger(WeatherDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            if(statement!=null){
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(WeatherDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if(rs!=null){
                try {
                    rs.close();
                } catch (SQLException ex) {
                    Logger.getLogger(WeatherDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            return countTotalKasusNo;
        }
    }

    //total kasus outlook dengan nilai sunny dengan nilai no
    @Override
    public int countOutlookByNo() {
       PreparedStatement statement = null;
       ResultSet rs = null;
       Weather weather = null;
       int countOutlookByNO=0;
       String sql = "select count(*) as outlook_no from weather where outlook='sunny' and play='no'";
        try {
            statement=connection.prepareStatement(sql);
            rs=statement.executeQuery();
            while(rs.next()){
                weather = new Weather();
                countOutlookByNO = rs.getInt("outlook_no");
            }
        } catch (SQLException ex) {
            Logger.getLogger(WeatherDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            if(statement!=null){
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(WeatherDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if(rs!=null){
                try {
                    rs.close();
                } catch (SQLException ex) {
                    Logger.getLogger(WeatherDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            return countOutlookByNO;
        }
    }

    
    //humidity dengan instance high dengan value yes
    @Override
    public int countHumidityByYes() {
      PreparedStatement statement=null;
      ResultSet rs=null;
      String sql = "select count(*) as humidity_high_yes from weather where humidity='high' and play='yes'";
      int count_humidity_yes = 0;
        try {
            statement=connection.prepareStatement(sql);
            rs=statement.executeQuery();
            while(rs.next()){
                count_humidity_yes = rs.getInt("humidity_high_yes");
            }
        } catch (SQLException ex) {
            Logger.getLogger(WeatherDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            if(statement!=null){
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(WeatherDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if(rs!=null){
                try {
                    rs.close();
                } catch (SQLException ex) {
                    Logger.getLogger(WeatherDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            return count_humidity_yes;
        }
    }

    //humidity dengan instance high dengan value no
    @Override
    public int countHumidityByNo() {
      PreparedStatement statement=null;
      ResultSet rs=null;
      String sql = "select count(*) as humidity_high_no from weather where humidity='high' and play='no'";
      int count_humidity_no = 0;
        try {
            statement=connection.prepareStatement(sql);
            rs=statement.executeQuery();
            while(rs.next()){
                count_humidity_no = rs.getInt("humidity_high_no");
            }
        } catch (SQLException ex) {
            Logger.getLogger(WeatherDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            if(statement!=null){
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(WeatherDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if(rs!=null){
                try {
                    rs.close();
                } catch (SQLException ex) {
                    Logger.getLogger(WeatherDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            return count_humidity_no;
        }
    }

    //count instance atribut windy instance false dengan value yes
    @Override
    public int countWindyFalseByYes() {
        PreparedStatement statement=null;
        ResultSet rs = null;
        String sql = "select count(*) as windy_false_yes from weather where windy='FALSE' and play='yes'";
        int countWindyFalseYes = 0;
        try {
            statement=connection.prepareStatement(sql);
            rs=statement.executeQuery();
            while(rs.next()){
                countWindyFalseYes = rs.getInt("windy_false_yes");
            }
        } catch (SQLException ex) {
            Logger.getLogger(WeatherDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            if(statement!=null){
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(WeatherDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if(rs!=null){
                try {
                    rs.close();
                } catch (SQLException ex) {
                    Logger.getLogger(WeatherDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            return countWindyFalseYes;
        }
    }
        
    //count atribut windy dengan instance false value no
     @Override
    public int countWindyFalseByNo() {
        PreparedStatement statement=null;
        ResultSet rs = null;
        String sql = "select count(*) as windy_false_no from weather where windy='FALSE' and play='no'";
        int countWindyFalseNo = 0;
        try {
            statement=connection.prepareStatement(sql);
            rs=statement.executeQuery();
            while(rs.next()){
                countWindyFalseNo = rs.getInt("windy_false_no");
            }
        } catch (SQLException ex) {
            Logger.getLogger(WeatherDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            if(statement!=null){
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(WeatherDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if(rs!=null){
                try {
                    rs.close();
                } catch (SQLException ex) {
                    Logger.getLogger(WeatherDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            return countWindyFalseNo;
        }
    }
    
    @Override
    public int countWindyTrueByYes() {
        PreparedStatement statement=null;
        ResultSet rs = null;
        String sql = "select count(*) as windy_true_yes from weather where windy='TRUE' and play='yes'";
        int countWindyTrueYes = 0;
        try {
            statement=connection.prepareStatement(sql);
            rs=statement.executeQuery();
            while(rs.next()){
                countWindyTrueYes = rs.getInt("windy_true_yes");
            }
        } catch (SQLException ex) {
            Logger.getLogger(WeatherDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            if(statement!=null){
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(WeatherDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if(rs!=null){
                try {
                    rs.close();
                } catch (SQLException ex) {
                    Logger.getLogger(WeatherDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            return countWindyTrueYes;
        }
    }

    @Override
    public int countWindyTrueByNo() {
        PreparedStatement statement=null;
        ResultSet rs = null;
        String sql = "select count(*) as windy_true_no from weather where windy='TRUE' and play='no'";
        int countWindyTrueNo = 0;
        try {
            statement=connection.prepareStatement(sql);
            rs=statement.executeQuery();
            while(rs.next()){
                countWindyTrueNo = rs.getInt("windy_true_no");
            }
        } catch (SQLException ex) {
            Logger.getLogger(WeatherDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            if(statement!=null){
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(WeatherDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if(rs!=null){
                try {
                    rs.close();
                } catch (SQLException ex) {
                    Logger.getLogger(WeatherDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            return countWindyTrueNo;
        }
    }

    @Override
    public int countOutlookRainyByYes() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int countOutlookRainyByNo() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int countOutlookOvercastByNo() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int countOutlookOvercastByYes() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int countHumidityNormalByYes() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int countHumidityNormalByNo() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

   


   
}
