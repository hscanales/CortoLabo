/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Hscanales.vista;

import com.Hscanales.dao.PeliculaDao;
import com.Hscanales.modelo.Pelicula;
import java.awt.*;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.table.*;

/**
 *
 * @author LN710Q
 */
public class VistaCorto extends JFrame {

    public JLabel lblNombre, lblDirector, lblPais, lblClasificacion, lblAnio, lblenProyeccion;
    public JTextField nombre, director, pais, anio;
    public JComboBox clasificacion;

    ButtonGroup proyeccion = new ButtonGroup();

    public JRadioButton no, si;
    public JTable resultados;

    public JPanel table;

    public JButton buscar, eliminar, insertar, actualizar;

    private static final int ANCHOC = 130, ALTOC = 30;

    DefaultTableModel tm;

    public VistaCorto() {
        super("Peliculas v0.1");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        agregarLabels();
        formulario();
        llenarTabla();
        Container container = getContentPane();
        container.add(lblNombre);
        container.add(lblDirector);
        container.add(lblPais);
        container.add(lblClasificacion);
        container.add(lblAnio);
        container.add(lblenProyeccion);
        container.add(nombre);
        container.add(director);
        container.add(pais);
        container.add(anio);
        container.add(clasificacion);
        container.add(no);
        container.add(si);
        container.add(buscar);
        container.add(eliminar);
        container.add(insertar);
        container.add(actualizar);
        container.add(table);
        setSize(800, 800);
        eventos();

    }

    private void agregarLabels() {
        lblNombre = new JLabel("Nombre");
        lblDirector = new JLabel("Director");
        lblPais = new JLabel("Pais");
        lblClasificacion = new JLabel("Clasificacion");
        lblAnio = new JLabel("Anio");
        lblenProyeccion = new JLabel("En proyeccion: ");
        
        lblNombre.setBounds(10, 10, ANCHOC, ALTOC);
        lblDirector.setBounds(10, 60, ANCHOC, ALTOC);
        lblPais.setBounds(10, 100, ANCHOC, ALTOC);
        lblClasificacion.setBounds(120, 10, ANCHOC, ALTOC);
        lblAnio.setBounds(120, 60, ANCHOC, ALTOC);
        lblenProyeccion.setBounds(120, 100, ANCHOC, ALTOC);
        
        
        
        
    }

    private void formulario() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void llenarTabla() {
        tm = new DefaultTableModel() {
            public Class<?> getColumnClass(int column) {
                switch (column) {
                    case 1:
                        return String.class;
                    case 2:
                        return String.class;
                    case 3:
                        return String.class;
                    case 4:
                        return String.class;
                    case 5:
                        return Integer.class;
                    default:
                        return Boolean.class;
                }
            }
        };

        tm.addColumn("nombre");
        tm.addColumn("Director");
        tm.addColumn("Pais");
        tm.addColumn("Clasificacion");
        tm.addColumn("Anio");
        tm.addColumn("en Proyeccion");

        PeliculaDao pd = new PeliculaDao();

        ArrayList<Pelicula> peliculas = pd.readAll();

        for (Pelicula pi : peliculas) {
            tm.addRow(new Object[]{pi.getNombre(), pi.getDirector(), pi.getPais(), pi.getClasificacion(), pi.getAnio(), pi.isEnProyeccion()});
        }
        resultados.setModel(tm);
    }

    private void eventos() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
