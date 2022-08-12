package model.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class SistemaDao {

    public SistemaDao() {
    }

    public static ResultSet informe1(Connection connexion){
        ResultSet result = null;
        try {
            String query = "SELECT ID_Lider , Nombre ,Primer_Apellido, Ciudad_Residencia  \n"
            + "FROM Lider l ORDER BY Ciudad_Residencia ASC ;";
            Statement st = connexion.createStatement();
            result = st.executeQuery(query);

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;

    }

    public static ResultSet informe2(Connection connexion){
        ResultSet result = null;
        try {
            String query = "SELECT ID_Proyecto, Constructora, Numero_Habitaciones, Ciudad  \n"
            + "FROM Proyecto p WHERE Clasificacion = 'Casa Campestre' \n"
            + "AND Ciudad IN ('Santa Marta','Cartagena','Barranquilla') ORDER BY Ciudad ASC;";
            Statement st = connexion.createStatement();
            result = st.executeQuery(query);

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;

    }

    public static ResultSet informe3(Connection connexion){
        ResultSet result = null;
        try {
            String query = "SELECT c.ID_Compra, p.Constructora, p.Banco_Vinculado \n" +
            "FROM Compra c INNER JOIN Proyecto p ON p.ID_Proyecto = c.ID_Proyecto \n" +
            "WHERE c.Proveedor = 'Homecenter' AND p.Ciudad = 'Salento';";
            Statement st = connexion.createStatement();
            result = st.executeQuery(query);

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;

    }


    
}
