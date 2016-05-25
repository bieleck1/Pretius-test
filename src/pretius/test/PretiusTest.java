/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pretius.test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 *
 * @author abc
 */
public class PretiusTest {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        double amount = 0;
        
        try {
            FileReader in = new FileReader(args[0]);
            BufferedReader buffReader = new BufferedReader(in);
            String line = null;

            while ((line = buffReader.readLine()) != null) {
                String[] words = line.split(":");
                words[words.length - 1] = words[words.length - 1].replace(",", ".");
                if (words[words.length - 1].isEmpty() == false) {
                    StringBuffer buffer = new StringBuffer(words[words.length - 1]);
                    buffer.delete(buffer.length() - 3, buffer.length());
                    double price = Double.parseDouble(buffer.substring(0));
                    price = Math.round(price);
                    amount += price;
                }
            }

            System.out.println("Suma kwot zapisanych w pliku: " + amount + "PLN");
            in.close();
        } catch (IOException e) {
            System.out.println("Problem: " + e);
        }
    }

}
