/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.apx.syzygy.process;

import java.util.ArrayList;

/**
 *
 * @author Vidhura
 */
public class FinalOrder {

    private ArrayList<String> itemNameList;
    private double grandTotal;

    public FinalOrder(Builder builder) {
        this.itemNameList = builder.itemNameList;
        this.grandTotal = builder.grandTotal;
    }

    public ArrayList<String> getItemNameList() {
        return itemNameList;
    }

    public double getGrandTotal() {
        return grandTotal;
    }

    @Override
    public String toString() {
        return "FinalOrder : " + String.join(" , ", itemNameList) + " | Grand Total = " + grandTotal + "0";
    }

    public static class Builder {

        private ArrayList<String> itemNameList;
        private double grandTotal;

        public Builder setItemNameList(ArrayList<String> itemNameList) {
            this.itemNameList = itemNameList;
            return this;
        }

        public Builder setGrandTotal(double grandTotal) {
            this.grandTotal = grandTotal;
            return this;
        }

        public FinalOrder build() {
            return new FinalOrder(this);
        }

    }

}
