package views;

import javax.swing.*;

public class MenuPrincipalView extends javax.swing.JFrame {

    public MenuPrincipalView() {
        initComponents();
    }

    private void initComponents() {
        btnListar = new JButton("Listar Vehículos");
        btnAgregar = new JButton("Agregar Vehículo");
        titulo = new JLabel("Menú Principal");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Logística - Menú Principal");
        setSize(300, 200);

        titulo.setFont(new java.awt.Font("Tahoma", 1, 18));
        titulo.setHorizontalAlignment(SwingConstants.CENTER);

        btnListar.addActionListener(e -> {
            new ListarVehiculosView().setVisible(true);
            dispose();
        });

        btnAgregar.addActionListener(e -> {
            new AgregarVehiculoView().setVisible(true);
            dispose();
        });

        JPanel panel = new JPanel(new java.awt.GridLayout(3, 1, 5, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(20, 50, 20, 50));
        panel.add(titulo);
        panel.add(btnListar);
        panel.add(btnAgregar);

        add(panel);
        pack();
    }

    private JButton btnListar, btnAgregar;
    private JLabel titulo;
}