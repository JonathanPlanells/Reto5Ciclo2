package controller;

import java.sql.ResultSet;
import model.ConexionDB;
import model.dao.SistemaDao;

public class SistemaController {
    // ATRIBUTOS
    private ConexionDB conexionDB;

    // CONSTRUCTOR

    public SistemaController(ConexionDB conexionDB) {
        this.conexionDB = conexionDB;
    }

    // ACCIONES
    // Logica para capturar datos

    public ResultSet getInforme1() {
        return SistemaDao.informe1(conexionDB.getConexion());
    }

    public ResultSet getInforme2() {
        return SistemaDao.informe2(conexionDB.getConexion());
    }

    public ResultSet getInforme3() {
        return SistemaDao.informe3(conexionDB.getConexion());
    }

    

    
}
