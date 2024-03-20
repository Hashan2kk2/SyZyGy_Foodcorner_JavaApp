/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.apx.syzygy.components;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.util.ArrayList;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableCellRenderer;

/**
 *
 * @author DELL
 */
public class TableDesign {

    public static TableCellRenderer centerAlignment = new TableContentAlign();

    public static void tableDesign(JTable table, ArrayList<Integer> columnIndexList) {
        JTableHeader table_header = table.getTableHeader();
        table.setBackground(Color.WHITE);

        Color table_header_color = new Color(41, 121, 255);
        Color table_header_font_color = new Color(91, 97, 135);

        table_header.setFont(new Font("Yu Gothic Ui", Font.BOLD, 14));

        DefaultTableCellRenderer cellRenderer = new DefaultTableCellRenderer() {
            @Override
            public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
                Component component = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);

                // Set the desired font
                Font font = new Font("Yu Gothic Ui", Font.PLAIN, 12);
                component.setFont(font);

                return component;
            }
        };

        // Apply the custom TableCellRenderer to all columns
        for (int i = 0; i < table.getColumnCount(); i++) {
            table.getColumnModel().getColumn(i).setCellRenderer(cellRenderer);
        }

        table_header.setBackground(table_header_color);
        table_header.setForeground(Color.WHITE);
        
        for (int index : columnIndexList) {
            table.getColumnModel().getColumn(index).setCellRenderer(centerAlignment);
        }

    }

}
