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
public class Ingrediant {

    private ArrayList<String> ingrediants;

    public Ingrediant() {
    }

    public Ingrediant(ArrayList<String> ingrediants) {
        Ingrediant.createInstance(ingrediants);
    }

    private static final HashMap<String, Ingrediant> INGREDIANTS_POOL = new HashMap<>();

    public static Ingrediant createInstance(ArrayList ingrediants) {

        String mapKey = String.join(",", ingrediants);

        Ingrediant instance = INGREDIANTS_POOL.get(mapKey);

        if (instance == null) {
            System.out.println("New ingrediant created");
            instance = new Ingrediant();
            instance.ingrediants = ingrediants;
            INGREDIANTS_POOL.put(mapKey, instance);
        }

        return instance;

    }

    @Override
    public String toString() {
        return ingrediants.toString();
    }

}
