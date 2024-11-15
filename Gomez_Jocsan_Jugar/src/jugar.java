
import java.util.Random;
import javax.swing.JOptionPane;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */

/**
 *
 * @author DELL
 */
public class jugar extends javax.swing.JFrame {
    
    private final String[] palabras = {"AMIGAZOS", "PROGRAMADORES", "REINICIANDO", "CARRUCEL", "INTELIGENCIA", "DESOXIRRIBONUCLEICO", "TECLADO", "MONITOR", "SISTEMAS", "BALEADAS"};
    private String palabraSecreta;
    private StringBuilder palabraOculta;
    private int intentosRestantes;

    public jugar() {
        initComponents();
        iniciarJuego();
    }
    private void iniciarJuego() {
        Random random = new Random();
        palabraSecreta = palabras[random.nextInt(palabras.length)];
        palabraOculta = new StringBuilder("_ ".repeat(palabraSecreta.length()));
        intentosRestantes = 5;
        lblPalabraOculta.setText(palabraOculta.toString());
        zzz.setText("Intentos restantes: " + intentosRestantes);
    }
    
    private void actualizarEstadoJuego() {
        lblPalabraOculta.setText(palabraOculta.toString());
        zzz.setText("Intentos restantes: " + intentosRestantes);

        if (palabraOculta.toString().equals(palabraSecreta)) {
            JOptionPane.showMessageDialog(this, "Felicidades!, Has adivinado la palabra: " + palabraSecreta);
            iniciarJuego();
        } else if (intentosRestantes == 0) {
            JOptionPane.showMessageDialog(this, "Has perdido! La palabra era: " + palabraSecreta);
            iniciarJuego();
        }
    }
    
    
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTextField1 = new javax.swing.JTextField();
        btnReiniciar = new javax.swing.JButton();
        lblPalabraOculta = new javax.swing.JLabel();
        zzz = new javax.swing.JLabel();
        lblIntentos1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });

        btnReiniciar.setText("REINICIAR");
        btnReiniciar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReiniciarActionPerformed(evt);
            }
        });

        lblPalabraOculta.setText("Palabra Oculta");

        zzz.setText("Ingrese letra:");

        lblIntentos1.setText("Intentos");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(28, 28, 28)
                                .addComponent(btnReiniciar, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(44, 44, 44)
                                .addComponent(lblPalabraOculta, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblIntentos1, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(153, 153, 153)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(zzz)
                            .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(130, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblPalabraOculta, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblIntentos1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 33, Short.MAX_VALUE)
                .addComponent(zzz)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(52, 52, 52)
                .addComponent(btnReiniciar)
                .addGap(35, 35, 35))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
        String letra = jTextField1.getText().toUpperCase().trim();
        jTextField1.setText(""); 

        if (letra.length() != 1 || !Character.isLetter(letra.charAt(0))) {
            JOptionPane.showMessageDialog(this, "Por favor, Ingrese una sola letra valida.");
            return;
        }

        boolean letraEncontrada = false;
        for (int i = 0; i < palabraSecreta.length(); i++) {
            if (palabraSecreta.charAt(i) == letra.charAt(0)) {
                palabraOculta.setCharAt(i, letra.charAt(0));
                letraEncontrada = true;
            }
        }

        if (!letraEncontrada) {
            intentosRestantes--;
            JOptionPane.showMessageDialog(this, "La palabra no contiene la letra '" + letra + "'.");
        } else {
            JOptionPane.showMessageDialog(this, "Adivinaste un caracter!");
        }

        actualizarEstadoJuego();
    }//GEN-LAST:event_jTextField1ActionPerformed

    private void btnReiniciarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReiniciarActionPerformed
        // TODO add your handling code here:
        Random random = new Random();
    palabraSecreta = palabras[random.nextInt(palabras.length)];

    // Crear la representación oculta de la palabra con guiones bajos
    palabraOculta = new StringBuilder("_".repeat(palabraSecreta.length()));

    // Reiniciar el número de intentos restantes
    intentosRestantes = 5;

    // Actualizar los componentes visuales
    lblPalabraOculta.setText(palabraOculta.toString().replace("", " ").trim());
    lblIntentos1.setText("Intentos restantes: " + intentosRestantes);
    jTextField1.setText(""); // Limpiar el campo de texto

    // Mostrar un mensaje opcional
    JOptionPane.showMessageDialog(this, "Se ha reiniciado el juego. Buena suerte!");
    }//GEN-LAST:event_btnReiniciarActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(jugar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(jugar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(jugar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(jugar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new jugar().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnReiniciar;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JLabel lblIntentos1;
    private javax.swing.JLabel lblPalabraOculta;
    private javax.swing.JLabel zzz;
    // End of variables declaration//GEN-END:variables
}