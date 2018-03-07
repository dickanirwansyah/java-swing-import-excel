/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.skripsi.entity;

import java.util.Objects;

/**
 *
 * @author dickajava
 */
public class Weather {
    
    private int idweather;
    private String outlook;
    private String temprature;
    private String humidity;
    private String windy;
    private String play;

    public int getIdweather() {
        return idweather;
    }

    public void setIdweather(int idweather) {
        this.idweather = idweather;
    }

    public String getOutlook() {
        return outlook;
    }

    public void setOutlook(String outlook) {
        this.outlook = outlook;
    }

    public String getTemprature() {
        return temprature;
    }

    public void setTemprature(String temprature) {
        this.temprature = temprature;
    }

    public String getHumidity() {
        return humidity;
    }

    public void setHumidity(String humidity) {
        this.humidity = humidity;
    }

    public String getWindy() {
        return windy;
    }

    public void setWindy(String windy) {
        this.windy = windy;
    }

    public String getPlay() {
        return play;
    }

    public void setPlay(String play) {
        this.play = play;
    }

    @Override
    public String toString() {
        return "Weather{" + "idweather=" + idweather + ", outlook=" + outlook + ", temprature=" + temprature + ", humidity=" + humidity + ", windy=" + windy + ", play=" + play + '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 41 * hash + this.idweather;
        hash = 41 * hash + Objects.hashCode(this.outlook);
        hash = 41 * hash + Objects.hashCode(this.temprature);
        hash = 41 * hash + Objects.hashCode(this.humidity);
        hash = 41 * hash + Objects.hashCode(this.windy);
        hash = 41 * hash + Objects.hashCode(this.play);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Weather other = (Weather) obj;
        if (this.idweather != other.idweather) {
            return false;
        }
        if (!Objects.equals(this.outlook, other.outlook)) {
            return false;
        }
        if (!Objects.equals(this.temprature, other.temprature)) {
            return false;
        }
        if (!Objects.equals(this.humidity, other.humidity)) {
            return false;
        }
        if (!Objects.equals(this.windy, other.windy)) {
            return false;
        }
        if (!Objects.equals(this.play, other.play)) {
            return false;
        }
        return true;
    }
    
    
    
}
