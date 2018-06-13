/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Hscanales.modelo;

/**
 *
 * @author estudiante
 */
public class Filtro {
    private int id;
    private String codigo;
    private String marca;
    private int stock;
    private boolean existencia;


    public Filtro() {
    }

    public Filtro(int id, String codigo, String marca, int stock, boolean existencia) {
        this.id = id;
        this.codigo = codigo;
        this.marca = marca;
        this.stock = stock;
        this.existencia = existencia;
    }

    public Filtro(String codigo, String marca, int stock, boolean existencia) {
        this.codigo = codigo;
        this.marca = marca;
        this.stock = stock;
        this.existencia = existencia;
    }

    public Filtro(String marca, int stock, boolean existencia) {
        this.marca = marca;
        this.stock = stock;
        this.existencia = existencia;
    }

    public String getCodigo() {
    return this.codigo;
    }

    public String getMarca() {
    return this.marca;
    }

    public int getStock() {
    return this.stock;
    }

    public boolean getExistencia() {
    return this.existencia;
    }

    public void setExistencia(boolean b) {
    this.existencia = b;
    }
    
    
    
}
