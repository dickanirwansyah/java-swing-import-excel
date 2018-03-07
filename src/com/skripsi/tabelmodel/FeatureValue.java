/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.skripsi.tabelmodel;

import java.util.Objects;

/**
 *
 * @author dickajava
 */
public class FeatureValue {
    
    private String name;
    private int occurences;
    
    public FeatureValue(String name){
        this.name = name;
    }
    
    public String getName(){
        return name;
    }
    
    public int getOccurences(){
        return occurences;
    }
    
    public void setOccurences(int occurences){
        this.occurences = occurences;
    }

    @Override
    public int hashCode() {
        int hash = 3;
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
        final FeatureValue other = (FeatureValue) obj;
        if (this.occurences != other.occurences) {
            return false;
        }
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return name;
    }
    
    
    
}
