/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.apx.syzygy.process;

import com.apx.syzygy.gui.Breakfast;
import static com.apx.syzygy.gui.Ordering.summeryTable;
import java.text.DecimalFormat;
import java.util.ArrayList;
import javax.swing.JOptionPane;

interface Expression {

    void interpret(FoodOrder.Builder orderBuilder);
}

class AddExtraToppingsExpression implements Expression {

    private final ArrayList<String> updatedToppings;
    private final double previousTotalPrice;

    public AddExtraToppingsExpression(ArrayList<String> previousToppings, double previousTotalPrice, String topping) {
        this.updatedToppings = previousToppings;
        this.previousTotalPrice = previousTotalPrice;
        this.updatedToppings.add(topping);
    }

    @Override
    public void interpret(FoodOrder.Builder orderBuilder) {

        DecimalFormat decimalFormatter = new DecimalFormat("0.00");

        double totalToppingPrice = 0.0;

        for (String topping : updatedToppings) {

            Double toppingPrice = Breakfast.toppingsMap.get(topping);
            totalToppingPrice = totalToppingPrice + toppingPrice;

        }

        FoodOrder order = orderBuilder.setToppings(updatedToppings).setPrice(totalToppingPrice + previousTotalPrice).build();

        int selectedRow = summeryTable.getSelectedRow();

        if (selectedRow != -1) {

            summeryTable.setValueAt(String.join(",", updatedToppings), selectedRow, 6);
            summeryTable.setValueAt(decimalFormatter.format(totalToppingPrice), selectedRow, 7);
            summeryTable.setValueAt(decimalFormatter.format(totalToppingPrice + previousTotalPrice), selectedRow, 8);

        } else {
            System.out.println("Customize Order : Process failed");
        }

        System.out.println("Customized Order : " + order);
        System.out.println("Customize Order : Successfully customize the order");

    }

}

public class CustomCommandInterpretter implements Expression {

    private final ArrayList<Expression> expressions;
    private final ArrayList<String> previousToppings;
    private final double previousTotalPrice;

    public CustomCommandInterpretter(ArrayList<String> previousToppings, double previousTotalPrice) {
        expressions = new ArrayList<>();
        this.previousToppings = previousToppings;
        this.previousTotalPrice = previousTotalPrice;
    }

    public void parseCommand(String command) {

        if (command.startsWith("Add")) {
            String newTopping = command.substring(4).trim();

            if (Breakfast.toppingsMap.get(newTopping) != null) {
                expressions.add(new AddExtraToppingsExpression(previousToppings, previousTotalPrice, newTopping));
            } else {
                JOptionPane.showMessageDialog(summeryTable, "Invalid command. Please try again", "Warning", JOptionPane.WARNING_MESSAGE);
            }

        }

    }

    @Override
    public void interpret(FoodOrder.Builder orderBuilder) {
        for (Expression command : expressions) {
            command.interpret(orderBuilder);
        }
    }

}
