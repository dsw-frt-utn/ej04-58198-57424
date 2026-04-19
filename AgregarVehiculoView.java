package views;

import java.util.ArrayList;
import javax.swing.*;

public class AgregarVehiculoView extends javax.swing.JFrame {

    public AgregarVehiculoView() {
        initComponents();
        cargarSucursales();
    }

    private void cargarSucursales() {
        ArrayList<String> sucursales = Controlador.getSucursales();
        for (String sucursal : sucursales) {
            cmbSucursal.addItem(sucursal);
        }
    }

    private void initComponents() {
        lblTipo = new JLabel("Tipo de Vehículo:");
        cmbTipo = new JComboBox<>(new String[]{"COMBUSTIBLE", "ELECTRICO"});
        lblPatente = new JLabel("Patente:");
        txtPatente = new JTextField();
        lblMarca = new JLabel("Nombre Marca:");
        txtMarca = new JTextField();
        lblPais = new JLabel("País Marca:");
        txtPais = new JTextField();
        lblModelo = new JLabel("Modelo:");
        txtModelo = new JTextField();
        lblAnio = new JLabel("Año:");
        txtAnio = new JTextField();
        lblCapacidad = new JLabel("Capacidad de Carga:");
        txtCapacidad = new JTextField();
        lblSucursal = new JLabel("Sucursal:");
        cmbSucursal = new JComboBox<>();
        lblKmLitro = new JLabel("Km por Litro:");
        txtKmLitro = new JTextField();
        lblLitrosExtra = new JLabel("Litros Extra:");
        txtLitrosExtra = new JTextField();
        lblKmKwh = new JLabel("Km por kWh:");
        txtKmKwh = new JTextField();
        btnGuardar = new JButton("Guardar");
        btnVolver = new JButton("Volver");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Logística - Agregar Vehículo");
        setSize(400, 500);

        cmbTipo.addActionListener(e -> actualizarCampos());

        btnGuardar.addActionListener(e -> guardar());

        btnVolver.addActionListener(e -> {
            new MenuPrincipalView().setVisible(true);
            dispose();
        });

        JPanel panel = new JPanel(new java.awt.GridLayout(12, 2, 5, 5));
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        panel.add(lblTipo);       panel.add(cmbTipo);
        panel.add(lblPatente);    panel.add(txtPatente);
        panel.add(lblMarca);      panel.add(txtMarca);
        panel.add(lblPais);       panel.add(txtPais);
        panel.add(lblModelo);     panel.add(txtModelo);
        panel.add(lblAnio);       panel.add(txtAnio);
        panel.add(lblCapacidad);  panel.add(txtCapacidad);
        panel.add(lblSucursal);   panel.add(cmbSucursal);
        panel.add(lblKmLitro);    panel.add(txtKmLitro);
        panel.add(lblLitrosExtra); panel.add(txtLitrosExtra);
        panel.add(lblKmKwh);      panel.add(txtKmKwh);
        panel.add(btnVolver);     panel.add(btnGuardar);

        add(panel);
        actualizarCampos();
        pack();
    }

    private void actualizarCampos() {
        boolean esCombustible = cmbTipo.getSelectedItem().equals("COMBUSTIBLE");
        lblKmLitro.setVisible(esCombustible);
        txtKmLitro.setVisible(esCombustible);
        lblLitrosExtra.setVisible(esCombustible);
        txtLitrosExtra.setVisible(esCombustible);
        lblKmKwh.setVisible(!esCombustible);
        txtKmKwh.setVisible(!esCombustible);
    }

    private void guardar() {
        try {
            String tipo = (String) cmbTipo.getSelectedItem();
            String patente = txtPatente.getText();
            String marca = txtMarca.getText();
            String pais = txtPais.getText();
            String modelo = txtModelo.getText();
            int anio = Integer.parseInt(txtAnio.getText());
            double capacidad = Double.parseDouble(txtCapacidad.getText());
            String sucursal = (String) cmbSucursal.getSelectedItem();
            double kmLitro = txtKmLitro.getText().isEmpty() ? 0 : Double.parseDouble(txtKmLitro.getText());
            double litrosExtra = txtLitrosExtra.getText().isEmpty() ? 0 : Double.parseDouble(txtLitrosExtra.getText());
            double kmKwh = txtKmKwh.getText().isEmpty() ? 0 : Double.parseDouble(txtKmKwh.getText());

            Controlador.agregarVehiculo(tipo, patente, marca, pais, modelo, anio, capacidad, sucursal, kmLitro, litrosExtra, kmKwh);
            JOptionPane.showMessageDialog(this, "Vehículo agregado correctamente!");
            
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Por favor verificá que los campos numéricos sean válidos.");
        }
    }

    private JLabel lblTipo, lblPatente, lblMarca, lblPais, lblModelo, lblAnio, lblCapacidad, lblSucursal, lblKmLitro, lblLitrosExtra, lblKmKwh;
    private JComboBox<String> cmbTipo, cmbSucursal;
    private JTextField txtPatente, txtMarca, txtPais, txtModelo, txtAnio, txtCapacidad, txtKmLitro, txtLitrosExtra, txtKmKwh;
    private JButton btnGuardar, btnVolver;
}