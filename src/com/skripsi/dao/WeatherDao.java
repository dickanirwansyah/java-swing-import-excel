/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.skripsi.dao;

import com.skripsi.entity.Weather;
import java.util.List;

/**
 *
 * @author dickajava
 */
public interface WeatherDao {
    
    List<Weather> listWeather();
    
    Weather createWeather(Weather weather);
    
    //count himpunan kasus
    int countHimpunanKasus();
    
    //count total kasus yes
    int countTotalKasusYes();
    
    //count total kasus no
    int countTotalKasusNo();
    
    //count total kasus outlook sunny  dengan value yes
    int countOutlookByYes();
    
    //count total kasus outlook sunny dengan value no
    int countOutlookByNo();
    
    //count total kasus outlook rainy dengan value yes
    int countOutlookRainyByYes();
    
    //count total kasus outlook rainy dengan value no
    int countOutlookRainyByNo();
    
    //count total kasus outlook overcast dengan value yes
    int countOutlookOvercastByNo();
    
    //count total kasus outlook overcast dengan value no
    int countOutlookOvercastByYes();
    
    //count total kasus humidity high dengan value yes
    int countHumidityByYes();
    
    //count total kasus humidity high dengan value no
    int countHumidityByNo();
    
    //count total kasus humidity normal dengan value yes
    int countHumidityNormalByYes();
    
    //count total kasus humidity normal dengan value no
    int countHumidityNormalByNo();
    
    //count total kasus windy dengan FALSE value yes
    int countWindyFalseByYes();
    
    //count total kasus windy dengan FALSE value No
    int countWindyFalseByNo();
    
    //count total kasus windy dengan TRUE value yes
    int countWindyTrueByYes();
    
    //count total kasus dengan windy dengan TRUE value no
    int countWindyTrueByNo();
}
