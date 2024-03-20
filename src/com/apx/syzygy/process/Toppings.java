/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.apx.syzygy.process;

import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author vidhu
 */
public class Toppings {

    private ArrayList<String> toppings;

    public Toppings() {
    }

    public Toppings(ArrayList<String> toppings) {
        Toppings.createInstance(toppings);
    }

    private static final HashMap<String, Toppings> TOPPINGS_POOL = new HashMap<>();

    public static Toppings createInstance(ArrayList toppings) {

        String mapKey = String.join(",", toppings);

        Toppings instance = TOPPINGS_POOL.get(mapKey);

        if (instance == null) {
            System.out.println("New topping created");
            instance = new Toppings();
            instance.toppings = toppings;
            TOPPINGS_POOL.put(mapKey, instance);
        }

        return instance;

    }

    @Override
    public String toString() {
        return toppings.toString();
    }

}
