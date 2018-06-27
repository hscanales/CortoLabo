
package com.Hscanales.conexion;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author hscanales <00136317@uca.edu.sv>
 */
public class Conexion {

    private String user;
    private String pass;
    private String driver;
    private String url;

    private Connection cnx;
    public static Conexion instance;

    public synchronized static Conexion conectar(){
        if (instance == null) {
            return new Conexion();
        }
        return instance;
    }

    private Conexion(){
        cargarCredenciales();
        try {
            Class.forName(this.driver);
            cnx = (Connection) DriverManager.getConnection(this.url, this.user, this.pass);
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void cargarCredenciales() {
        user = "root";
        pass = "";
        driver = "com.mysql.jdbc.Driver";
        url = "jdbc:mysql://localhost/peliculas";
    }

    public Connection getCnx() {
        return cnx;

    }

    public void cerrarConexion() {
        instance = null;
    }
}
