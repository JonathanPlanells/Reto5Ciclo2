package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionDB {

    
    // ATRIBUTOS
    private Connection conexion;
    private boolean flag = false;

    
    // CONSTRUCTORES
    public ConexionDB() {
        try {
            conexion = DriverManager.getConnection("jdbc:sqlite:ProyectosConstruccion.db");//"jdbc:sqlite:ProyectosConstruccion.db"
            if (conexion != null) {
                //System.out.println("Conexion exitosa");
                flag = true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    

    // CONSULTORES ----------------------
    public Connection getConexion() {
        return conexion;
    }

    public boolean getFlag(){
        return flag;

    }


    

}
