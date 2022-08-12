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

public class Informe3Ventana extends JFrame {
    // ATRIBUTOS
    private SistemaController sController;
    private JTable tabla1;
    private DefaultTableModel modelo;
    private JLabel lblmensaje;
    private JLabel lblmensaje2;
    
    private JButton btnCerrar;
    private JLabel box;

    // CONSTRUCTOR
    public Informe3Ventana(SistemaController sController) {
        this.sController = sController;
        setTitle("INFORME 3");
        // TAMAÑO VETNANA
        setBounds(860, 100, 590, 480);
        getContentPane().setLayout(null);
        setResizable(false);
        // MENSAJE
        String text = "<html><body>PROVEEDOR<br> <strong><i>HOMECENTER</i></strong> </body></html>";
        String text2 = "<html><body>CIUDAD <strong><i>SALENTO</i></strong></body></html> ";
        
        lblmensaje = new JLabel(text);
        lblmensaje.setBounds(15, 20, 400, 30);
        lblmensaje2 = new JLabel(text2);
        lblmensaje2.setBounds(15, 45, 400, 30);
    
        add(lblmensaje);
        add(lblmensaje2);
        // IMAGEN
        imagen();
        // BOTON CERRAR
        btnCerrar();
        // TABLA
        inicializar();
        // VISIBILIDAD DE VENTANA
        setVisible(true);
    }

    // TABLA --------------
    // Etiquetas columnas

    public void inicializar() {
        Object columns[] = new Object[] { "ID COMPRA", "CONTRUCTORA", "BANCO VINCULADO" };
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

    // Datos de la tabla

    public void mostrarInforme1() {
        ResultSet results = sController.getInforme3();
        try {
            while (results.next()) {
                String idCompra = results.getString("id_Compra");
                String constructora = results.getString("Constructora");
                String bancoVinculado = results.getString("Banco_Vinculado");
                modelo.addRow(new Object[] { idCompra, constructora, bancoVinculado });

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
