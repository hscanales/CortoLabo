/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Hscanales.modelo;

/**
 *
 *  @author hscanales <00136317@uca.edu.sv>
 */
public class Pelicula {
    private int id; //1
    private String nombre; //2
    private String director; //3
    private String pais; //4
    private String clasificacion; //5
    private int anio; //6
    private boolean enProyeccion; //7

    public Pelicula(int id, String nombre, String director, String pais, String clasificacion, int anio, boolean enProyeccion) {
        this.id = id;
        this.nombre = nombre;
        this.director = director;
        this.pais = pais;
        this.clasificacion = clasificacion;
        this.anio = anio;
        this.enProyeccion = enProyeccion;
    }

    
    
    public Pelicula(String nombre, String director, String pais, String clasificacion, int anio, boolean enProyeccion) {
        this.nombre = nombre;
        this.director = director;
        this.pais = pais;
        this.clasificacion = clasificacion;
        this.anio = anio;
        this.enProyeccion = enProyeccion;
    }

    public Pelicula() {
    }

    public Pelicula(String director, String pais, String clasificacion, int anio, boolean enProyeccion) {
        this.director = director;
        this.pais = pais;
        this.clasificacion = clasificacion;
        this.anio = anio;
        this.enProyeccion = enProyeccion;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public String getClasificacion() {
        return clasificacion;
    }

    public void setClasificacion(String clasificacion) {
        this.clasificacion = clasificacion;
    }

    public int getAnio() {
        return anio;
    }

    public void setAnio(int anio) {
        this.anio = anio;
    }

    public boolean isEnProyeccion() {
        return enProyeccion;
    }

    public void setEnProyeccion(boolean enProyeccion) {
        this.enProyeccion = enProyeccion;
    }
    
    
    
    
}
