package view;

import javax.swing.*;

import controller.SistemaController;
import model.ConexionDB;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.*;
import java.awt.Image;
import javax.swing.ImageIcon;


public class VentanaMenu extends JFrame {

    ConexionDB objcoon = new ConexionDB();
    private SistemaController sController;

    // ATRIBUTOS
    private JButton btnMostrar1;
    private JButton btnMostrar2;
    private JButton btnMostrar3;
    private JButton btnSalir;

    private JLabel lblEstadoConexion;
    private JLabel lblEstadoConexionD;
    private JLabel lblconexion;
    private JLabel lblmensaje;
    private JLabel lblmensaje2;
    private JLabel box;

    // CONSTRUCTOR

    public VentanaMenu(SistemaController sController) {
        this.sController = sController;

        // TITULO VENTANA
        setTitle("Sistema de Informes");
        // COORDENADAS DE VENTANA
        setBounds(400, 100, 440, 260);
        getContentPane().setLayout(null);
        setResizable(false);
        // CERRAR VENTANA
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        // CAJA IMAGEN

        ImageIcon img = new ImageIcon("src/Resources/minvivienda.png");
        Image imagen = img.getImage();
        ImageIcon imgEscalada = new ImageIcon(imagen.getScaledInstance(160, 45, Image.SCALE_SMOOTH));
        box = new JLabel();
        box.setIcon(imgEscalada);
        box.setBounds(135, 15, 160, 45);
        add(box);

        

        //// TITULO PANEL ----------------------------------

        // MENSAJE
        lblmensaje = new JLabel("BIENVENIDO AL SISTEMA DE INFORMES");
        lblmensaje.setBounds(100, 70, 400, 30);
        add(lblmensaje);
        // MENSAJE2
        lblmensaje2 = new JLabel("DEL MINISTERIO DE VIVIENDA");
        lblmensaje2.setBounds(120, 85, 400, 30);
        add(lblmensaje2);

        //// BOTONES INFORMES ----------------------------------

        // BOTON 1
        btnMostrar1 = new JButton("INFORME 1");
        btnMostrar1.setBounds(20, 125, 120, 40);
        add(btnMostrar1);
        // BOTON 2
        btnMostrar2 = new JButton("INFORME 2");
        btnMostrar2.setBounds(160, 125, 120, 40);
        add(btnMostrar2);
        // BOTON 3
        btnMostrar3 = new JButton("INFORME 3");
        btnMostrar3.setBounds(300, 125, 120, 40);
        add(btnMostrar3);

        // ESTADO DE CONEXIÓN
        estadoConexion();

        // BOTON SALIR
        btnSalir = new JButton("SALIR");
        btnSalir.setBounds(260, 180, 120, 30);
        add(btnSalir);

        //// -----------------------------------

        // MANEJADORES DE EVENTOS
        btnMostrar1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (objcoon.getFlag() == true) {
                    eventInforme1();
                } else {
                    eventBtnConexion();
                }

            }
        });

        btnMostrar2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (objcoon.getFlag() == true) {
                    eventInforme2();
                } else {
                    eventBtnConexion();
                }

            }
        });

        btnMostrar3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (objcoon.getFlag() == true) {
                    eventInforme3();
                } else {
                    eventBtnConexion();
                }

            }
        });

        btnSalir.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                eventBtnSair();
            }
        });

        // MOSTRAR JFRAME
        setVisible(true);

    }

    // EVENTOS ---------

    public void eventInforme1() {
        new Informe1Ventana(sController);
    }

    public void eventInforme2() {
        new Informe2Ventana(sController);
    }

    public void eventInforme3() {
        new Informe3Ventana(sController);
    }

    public void eventBtnConexion() {
        JOptionPane.showMessageDialog(this, "Error al conectarse a la base de datos. \nPor favor contacte a soporte.");

    }

    public void eventBtnSair() {
        int respuesta = JOptionPane.showConfirmDialog(this, "ESTA SEGURO QUE DESEA SALIR", "ALERTA",
                JOptionPane.OK_CANCEL_OPTION);
        if (respuesta == 0) {
            dispose();
            System.exit(0);
        }

    }

    // EXTRAS ---------

    public void estadoConexion() {

        // TEXTO CONEXION
        lblconexion = new JLabel("Conexión a BD: ");
        lblconexion.setBounds(20, 180, 120, 40);
        add(lblconexion);
        // ESTADO DE CONEXION CONECTADO
        lblEstadoConexion = new JLabel("En Línea...");
        lblEstadoConexion.setFont(new Font(null, Font.BOLD, 12));
        lblEstadoConexion.setForeground(new Color(76, 156, 0));
        lblEstadoConexion.setBounds(120, 180, 120, 40);
        // ESTADO DE CONXION DESCONECTADO
        lblEstadoConexionD = new JLabel("Desconectado");
        lblEstadoConexionD.setForeground(new Color(255, 0, 0));
        lblEstadoConexionD.setFont(new Font(null, Font.BOLD, 12));
        lblEstadoConexionD.setBounds(120, 180, 120, 40);

        if (objcoon.getFlag() == true) {
            add(lblEstadoConexion);
        } else {
            add(lblEstadoConexionD);
        }

    }

}
