/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package adivina.vista;

import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

/**
 *
 * @author ferre
 */
public class VistaSwing extends javax.swing.JFrame implements IVista{

    public VistaSwing(String titulo) {
        super(titulo);
        initComponents();
        setLocationRelativeTo(null);
    }
    
    @Override
    public void addHandlerJugar(ActionListener al){
        this.jButtonJugar.addActionListener(al);
    }
    
    @Override
    public int getNumeroIngresado() {
        return Integer.parseInt(this.jTextFieldNumero.getText());
    }

    @Override
    public void notificarUsuario(String mensaje) {
        JOptionPane.showMessageDialog(this, mensaje);
    }
    
    @Override
    public void notificarUsuarioError(String mensaje) {
        JOptionPane.showMessageDialog(this, mensaje, "ERROR", JOptionPane.ERROR_MESSAGE);
    }

    @Override
    public void setAyuda(String ayuda) {
        this.jLabelAyuda.setText(ayuda);
    }

    @Override
    public void setIntentos(int i) {
        this.jTextFieldIntentos.setText(i+"");
    }

    @Override
    public void resetNumero() {
        this.jTextFieldNumero.setText(null);
    }

    @Override
    public void resetIntentos() {
        this.jTextFieldIntentos.setText(null);
    }
    
    @Override
    public void addHandlerReiniciar(ActionListener al){
        this.jButtonReiniciar.addActionListener(al);
    }
    
    @Override
    public void iniciar() {
        setVisible(true);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabelIingrese = new javax.swing.JLabel();
        jTextFieldNumero = new javax.swing.JTextField();
        jButtonJugar = new javax.swing.JButton();
        jButtonReiniciar = new javax.swing.JButton();
        jLabelIntentos = new javax.swing.JLabel();
        jTextFieldIntentos = new javax.swing.JTextField();
        jLabelAyuda = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabelIingrese.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        jLabelIingrese.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabelIingrese.setText("Ingrese número:");

        jTextFieldNumero.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        jButtonJugar.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        jButtonJugar.setText("Jugar");

        jButtonReiniciar.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        jButtonReiniciar.setText("Reiniciar");

        jLabelIntentos.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        jLabelIntentos.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabelIntentos.setText("Intentos restantes:");

        jTextFieldIntentos.setEditable(false);
        jTextFieldIntentos.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        jLabelAyuda.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelAyuda)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabelIingrese)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextFieldNumero, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jButtonJugar)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButtonReiniciar))
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jLabelIntentos)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jTextFieldIntentos, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(21, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldNumero, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelIingrese))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabelAyuda)
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelIntentos)
                    .addComponent(jTextFieldIntentos, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonJugar)
                    .addComponent(jButtonReiniciar))
                .addGap(24, 24, 24))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonJugar;
    private javax.swing.JButton jButtonReiniciar;
    private javax.swing.JLabel jLabelAyuda;
    private javax.swing.JLabel jLabelIingrese;
    private javax.swing.JLabel jLabelIntentos;
    private javax.swing.JTextField jTextFieldIntentos;
    private javax.swing.JTextField jTextFieldNumero;
    // End of variables declaration//GEN-END:variables

}

