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
    
    //count total kasus yes
    int countTotalKasusYes();
    
    //count total kasus no
    int countTotalKasusNo();
    
    //count total kasus outlook dengan value yes
    int countOutlookByYes();
    
    //count total kasus outlook dengan value no
    int countOutlookByNo();
    
    //count total kasus humidity dengan value yes
    int countHumidityByYes();
    
    //count total kasus humidity dengan value no
    int countHumidityByNo();
    
    
}
