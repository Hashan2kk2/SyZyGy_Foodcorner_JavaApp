/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.apx.syzygy.process;


import java.util.ArrayList;

/**
 *
 * @author DELL
 */
public class FoodOrder {
    
    private String foodName;
    private double price;

    private Ingrediant ingrediant;
    private Toppings toppings;

    public FoodOrder(Builder builder) {
        this.ingrediant = builder.ingrediant;
        this.toppings = builder.toppings;
        this.foodName = builder.foodName;
        this.price = builder.price;
    }

    public String getFoodName() {
        return foodName;
    }

    public double getPrice() {
        return price;
    }

    public Ingrediant getIngrediant() {
        return ingrediant;
    }

    public Toppings getToppings() {
        return toppings;
    }

    @Override
    public String toString() {
        return "FoodOrder{" + "foodName=" + foodName +  ", price=" + price + ", ingrediant=" + ingrediant + ", toppings=" + toppings + '}';
    }

    public static class Builder {

        private String foodName;
        private double price;

        private Ingrediant ingrediant;
        private Toppings toppings;

        public Builder setFoodName(String foodName) {
            this.foodName = foodName;
            return this;
        }

        public Builder setPrice(double price) {
            this.price = price;
            return this;
        }

        public Builder setIngrediants(ArrayList<String> ingrediants) {
            this.ingrediant = Ingrediant.createInstance(ingrediants);
            return this;
        }

        public Builder setToppings(ArrayList<String> toppings) {
            this.toppings = Toppings.createInstance(toppings);
            return this;
        }

        public FoodOrder build() {
            return new FoodOrder(this);
        }

    }
    
}
