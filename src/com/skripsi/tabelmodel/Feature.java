/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.skripsi.tabelmodel;

import java.util.HashSet;
import java.util.stream.IntStream;

/**
 *
 * @author dickajava
 */
public class Feature {
    
    private String name = null;
    private HashSet<FeatureValue> featureValues = new HashSet<FeatureValue>();
    
    public Feature(String[][] data, int column){
        this.name = data[0][column];
        IntStream.range(1, data.length)
                .forEach(row -> featureValues.add(new FeatureValue(data[row][column])));
        
        featureValues.stream().forEach(featureValue -> {
            int counter = 0;
            for(int row = 1; row < data.length; row++)
                if(featureValue.getName() == data[row][column])
                    featureValue.setOccurences(++counter);
        });
    }
    
    public String getName(){
        return name;
    }
    
    public HashSet<FeatureValue> getFeatureValues(){
        return featureValues;
    }
    
    public String toString(){
        return name;
    }
}
