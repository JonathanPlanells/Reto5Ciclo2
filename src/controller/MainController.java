package controller;

import model.ConexionDB;
import view.VentanaMenu;



public class MainController {

    public MainController() {
        // CONEXION BD
        ConexionDB conexionDB = new ConexionDB();
        // CONTROLADOR
        SistemaController sController = new SistemaController(conexionDB);
        // GUI
        VentanaMenu menuJframe = new VentanaMenu(sController);
        
       

    }

}
