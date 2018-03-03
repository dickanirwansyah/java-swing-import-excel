/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.skripsi;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DecimalFormat;

/**
 *
 * @author dickajava
 */
public class c45 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String filepath = null;
        try {
            System.out.print("Masukkan file csv atau xsls : ");
            filepath = br.readLine();
        } catch (IOException ioe) {
            System.out.println("Maaf file ini bukan csv atau xsls");
            System.exit(1);
        }
        
        File file = new File(filepath);
        FileInputStream fin = null;
        try {
            fin = new FileInputStream(file);
            byte fileContent[] = new byte[(int) file.length()];

            fin.read(fileContent);

            int[] frequency_array = new int[256];
            int fileContentLength = fileContent.length - 1;

            for (int i = 0; i < fileContentLength; i++) {
                byte byteValue = fileContent[i];
                frequency_array[byteValue]++;
            }
            double entropy = 0;
            for (int i = 0; i < frequency_array.length; i++) {
                if (frequency_array[i] != 0) {

                    double probabilityOfByte = (double) frequency_array[i] / (double) fileContentLength;

                    double value = probabilityOfByte * (Math.log(probabilityOfByte) / Math.log(2));
                    entropy = entropy + value;
                } else {
                }
            }
            entropy *= -1;

            DecimalFormat df = new DecimalFormat("#.#####");
            System.out.println("Entropy is: " + df.format(entropy) + " bits per byte");
        } catch (FileNotFoundException e) {
            System.out.println("File not found" + e);
        } catch (IOException ioe) {
            System.out.println("Exception while reading file " + ioe);
        } finally {

            try {
                if (fin != null) {
                    fin.close();
                }
            } catch (IOException ioe) {
                System.out.println("Error while closing stream: " + ioe);
            }

        }
        
        }

    }
