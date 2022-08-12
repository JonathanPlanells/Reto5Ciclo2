package view;

import java.sql.ResultSet;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import java.awt.Image;
import java.awt.event.*;

import controller.SistemaController;

public class Informe1Ventana extends JFrame {

    // ATRIBUTOS
    private SistemaController sController;
    private JTable tabla1;
    private DefaultTableModel modelo;
    private JButton btnCerrar;
    private JLabel lblmensaje;
    private JLabel box;

    // CONSTRUCTOR
    public Informe1Ventana(SistemaController sController) {
        this.sController = sController;
        setTitle("INFORME 1");
        // TAMAÑO VETNANA
        setBounds(860, 100, 590, 480);
        getContentPane().setLayout(null);
        setResizable(false); 
        // MENSAJE
        String text = "<html><body>INFORMACIÓN RESPECTIVA<br> <strong><i>LÍDER - CIUDAD DE RESIDENCIA</i></strong></body></html>";
        lblmensaje = new JLabel(text);
        lblmensaje.setBounds(15, 38, 400, 30);
        add(lblmensaje);
        // IMAGEN
        imagen();
        // BOTON CERRAR
        btnCerrar();
        // TABLA
        inicializar();
        // VISIBILIDAD DE VENTANA
        setVisible(true);
    }

    // TABLA ------------------
    // ETIQUETA COLUMNAS

    public void inicializar() {
        Object columns[] = new Object[] { "ID LIDER", "NOMBRE", "PRIMER APELLIDO", "CIUDAD RESIDENCIA" };
        TableModel tmodelo = new DefaultTableModel(
                new Object[][] {},
                columns);
        tabla1 = new JTable(tmodelo);
        modelo = (DefaultTableModel) tabla1.getModel();
        // Jscroll y tamaño
        JScrollPane scroll = new JScrollPane(tabla1);
        // TAMAÑO TABLA
        scroll.setBounds(15, 90, 560, 300);
        mostrarInforme1();
        add(scroll);
    }

    // DATOS TABBLA

    public void mostrarInforme1() {
        ResultSet results = sController.getInforme1();
        try {
            while (results.next()) {
                String idLider = results.getString("id_lider");
                String nombre = results.getString("Nombre");
                String primerApellido = results.getString("Primer_Apellido");
                String ciudadResidencia = results.getString("Ciudad_Residencia");
                modelo.addRow(new Object[] { idLider, nombre, primerApellido, ciudadResidencia });

            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // IMAGEN SUPERIOR ------------------
    public void imagen() {

        ImageIcon img = new ImageIcon("src/Resources/LogoMinvivienda.png");
        Image imagen = img.getImage();
        ImageIcon imgEscalada = new ImageIcon(imagen.getScaledInstance(320, 70, Image.SCALE_SMOOTH));
        box = new JLabel();
        box.setIcon(imgEscalada);
        box.setBounds(265, 10, 320, 70);
        add(box);

    }

    // BOTON CERRAR ----------
    public void btnCerrar() {

        btnCerrar = new JButton("Cerrar");
        btnCerrar.setBounds(15, 400, 120, 40);

        // AÑADIR MANEJADOR DE EVENTOS
        btnCerrar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                eventBtnCerrar();
            }
        });

        // AGREGAR BOTÓN
        add(btnCerrar);
    }

    // EVENTO CERRAR ---------------
    public void eventBtnCerrar() {
        dispose();
    }

}
