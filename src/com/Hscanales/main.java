/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Hscanales;


import com.Hscanales.vista.VistaCorto;

/**
 * MOVIES DATABASE MANAGER v1.0
 * @author hscanales <00136317@uca.edu.sv>
 */
public class main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

    java.awt.EventQueue.invokeLater(new Runnable(){
            @Override
            public void run() {
            new VistaCorto().setVisible(true);
            }
    });

}
}
    