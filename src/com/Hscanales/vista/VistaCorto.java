
package com.Hscanales.vista;

import com.Hscanales.dao.PeliculaDao;
import com.Hscanales.modelo.Pelicula;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.table.*;

/**
 *
 *  @author hscanales <00136317@uca.edu.sv>
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
        super("Peliculas v1.0");
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
        lblAnio = new JLabel("Año");
        lblenProyeccion = new JLabel("En proyeccion: ");

        lblNombre.setBounds(10, 10, ANCHOC, ALTOC);
        lblDirector.setBounds(10, 60, ANCHOC, ALTOC);
        lblPais.setBounds(10, 100, ANCHOC, ALTOC);
        lblClasificacion.setBounds(200, 10, ANCHOC, ALTOC);
        lblAnio.setBounds(280, 60, ANCHOC, ALTOC);
        lblenProyeccion.setBounds(320, 100, ANCHOC, ALTOC);

    }

    private void formulario() {
        nombre = new JTextField();
        director = new JTextField();
        pais = new JTextField();
        anio = new JTextField();
        clasificacion = new JComboBox();
        si = new JRadioButton("si", true);
        no = new JRadioButton("no", false);
        resultados = new JTable();
        buscar = new JButton("Buscar");
        insertar = new JButton("Insertar");
        eliminar = new JButton("Eliminar");
        actualizar = new JButton("Actualizar");

        table = new JPanel();

        clasificacion.addItem("G");
        clasificacion.addItem("PG-13");
        clasificacion.addItem("14A");
        clasificacion.addItem("18A");
        clasificacion.addItem("R");
        clasificacion.addItem("A");

        proyeccion = new ButtonGroup();
        proyeccion.add(si);
        proyeccion.add(no);

        nombre.setBounds(60, 10, ANCHOC, ALTOC);
        director.setBounds(60, 60, ANCHOC, ALTOC);
        pais.setBounds(60, 100, ANCHOC, ALTOC);
        clasificacion.setBounds(320, 10, ANCHOC, ALTOC);
        anio.setBounds(320, 60, ANCHOC, ALTOC);
        
        si.setBounds(440, 100, ANCHOC, ALTOC);
        no.setBounds(490, 100, ANCHOC, ALTOC);

        
        buscar.setBounds(10, 210,  ANCHOC, ALTOC);
        insertar.setBounds(120, 210,  ANCHOC, ALTOC);
        eliminar.setBounds(240, 210,  ANCHOC, ALTOC);
        actualizar.setBounds(360, 210,  ANCHOC, ALTOC);
        
        resultados = new JTable();
        table.setBounds(10,250,700,300);
        table.add(new JScrollPane(resultados));
        
        
    }

    private void llenarTabla() {
        tm = new DefaultTableModel() {
            public Class<?> getColumnClass(int column) {
                switch (column) {
                    case 0:
                        return String.class;
                    case 1:
                        return String.class;
                    case 2:
                        return String.class;
                    case 3:
                        return String.class;
                    case 4:
                        return String.class;
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
            tm.addRow(new Object[]{pi.getNombre(), pi.getDirector(), pi.getPais(), pi.getClasificacion(), pi.getAnio(),  pi.isEnProyeccion()});
        }
        resultados.setModel(tm);
    }

    private void eventos() {
        
        insertar.addActionListener( new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            PeliculaDao pd = new PeliculaDao();
            Pelicula f = new Pelicula(nombre.getText(),director.getText(),pais.getText(),clasificacion.getSelectedItem().toString(),Integer.parseInt(anio.getText()),true);
            
            if(no.isSelected()){
                f.setEnProyeccion(false);
            }
            if(pd.create(f)){
                JOptionPane.showMessageDialog(null, "Pelicula registrada con exito");
                limpiarCampos();
                llenarTabla();
            }else{
                JOptionPane.showMessageDialog(null, "JAJA se mamo");
            }
            
            }    
        });

        actualizar.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                PeliculaDao fd = new PeliculaDao();
                Pelicula f = new Pelicula(nombre.getText(), director.getText(), pais.getText(), clasificacion.getSelectedItem().toString(),Integer.parseInt(anio.getText()), true);
                
                if (no.isSelected()){
                    f.setEnProyeccion(false);
                }
                
                if(fd.update(f)){
                    JOptionPane.showMessageDialog(null, "Pelicula Modificada con exito");
                    limpiarCampos();
                    llenarTabla();
                }else{
                    JOptionPane.showMessageDialog(null, "Ocurrio un problema al momento de modificar la pelicula");
                }
            }
        });

        buscar.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                PeliculaDao pd = new PeliculaDao();
                Pelicula f = pd.read(nombre.getText());
                if ( f ==null){
                    JOptionPane.showMessageDialog(null, "This are not the jedi you are lookin for");
                }else{
                    nombre.setText(f.getNombre());
                    director.setText(f.getDirector());
                    pais.setText(f.getPais());
                    clasificacion.setSelectedItem(f.getClasificacion());
                    anio.setText(Integer.toString(f.getAnio()));
                    if(f.isEnProyeccion()){
                        si.setSelected(true);
                    }else{
                        no.setSelected(true);
                    }
                }
            
            }
            
        });
        
                eliminar.addActionListener(new ActionListener() {
            @Override 
            public void actionPerformed(ActionEvent e){
                PeliculaDao fd = new PeliculaDao();
                if (fd.delete(nombre.getText())){
                JOptionPane.showMessageDialog(null, "Pelicula Eliminada con exito");
                limpiarCampos();
                llenarTabla();
            }else{
                    JOptionPane.showMessageDialog(null, "Ocurrio un problema al momento de eliminar la pelicula");
                }
            }
        });
        
    }

    
            private void limpiarCampos() {
            nombre.setText("");
            director.setText("");
            pais.setText("");
            clasificacion.setSelectedItem("R");
            anio.setText("");
            
            }

 
}
