/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package menu;

import exploradordelavida.logic.Cell;
import exploradordelavida.logic.GameFrame;
import exploradordelavida.logic.Position;
import java.io.File;
import java.io.IOException;
import java.util.TreeMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author EDER H
 */
public class Menu extends javax.swing.JFrame {

    /**
     * Creates new form Menu
     */
    //-------------Contructor--------------
    private Memoria recuerda;
    private FileNameExtensionFilter filtro = new FileNameExtensionFilter("Partidas guardas .EJI", "EJI");
    private GameFrame aux;

    public Menu() {
        initComponents();
        this.recuerda = new Memoria();
        this.setLocationRelativeTo(null);

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    //--------------------------------------------------------------------- IGNORAR
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jDialog1 = new javax.swing.JDialog();
        instruccionesBoton = new javax.swing.JToggleButton();
        nuevoBoton = new javax.swing.JToggleButton();
        CreditosBoton = new javax.swing.JToggleButton();
        salirBoton = new javax.swing.JToggleButton();
        cargarBoton = new javax.swing.JToggleButton();
        jLabel1 = new javax.swing.JLabel();

        javax.swing.GroupLayout jDialog1Layout = new javax.swing.GroupLayout(jDialog1.getContentPane());
        jDialog1.getContentPane().setLayout(jDialog1Layout);
        jDialog1Layout.setHorizontalGroup(
            jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        jDialog1Layout.setVerticalGroup(
            jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Menu Explorador De La Vida");
        setMaximumSize(new java.awt.Dimension(320, 480));
        setMinimumSize(new java.awt.Dimension(320, 480));
        setPreferredSize(new java.awt.Dimension(320, 480));
        getContentPane().setLayout(null);

        instruccionesBoton.setBackground(new java.awt.Color(51, 51, 51));
        instruccionesBoton.setFont(new java.awt.Font("Papyrus", 3, 14)); // NOI18N
        instruccionesBoton.setForeground(new java.awt.Color(204, 204, 204));
        instruccionesBoton.setText("Instrucciones");
        instruccionesBoton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                instruccionesBotonActionPerformed(evt);
            }
        });
        getContentPane().add(instruccionesBoton);
        instruccionesBoton.setBounds(50, 220, 230, 31);

        nuevoBoton.setBackground(new java.awt.Color(51, 51, 51));
        nuevoBoton.setFont(new java.awt.Font("Papyrus", 3, 14)); // NOI18N
        nuevoBoton.setForeground(new java.awt.Color(204, 204, 204));
        nuevoBoton.setText("Nuevo Juego");
        nuevoBoton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nuevoBotonActionPerformed(evt);
            }
        });
        getContentPane().add(nuevoBoton);
        nuevoBoton.setBounds(50, 50, 230, 31);

        CreditosBoton.setBackground(new java.awt.Color(51, 51, 51));
        CreditosBoton.setFont(new java.awt.Font("Papyrus", 3, 14)); // NOI18N
        CreditosBoton.setForeground(new java.awt.Color(204, 204, 204));
        CreditosBoton.setText("Creditos");
        CreditosBoton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CreditosBotonActionPerformed(evt);
            }
        });
        getContentPane().add(CreditosBoton);
        CreditosBoton.setBounds(50, 310, 230, 31);

        salirBoton.setBackground(new java.awt.Color(51, 51, 51));
        salirBoton.setFont(new java.awt.Font("Papyrus", 3, 14)); // NOI18N
        salirBoton.setForeground(new java.awt.Color(204, 204, 204));
        salirBoton.setText("Salir");
        salirBoton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                salirBotonActionPerformed(evt);
            }
        });
        getContentPane().add(salirBoton);
        salirBoton.setBounds(50, 390, 230, 31);

        cargarBoton.setBackground(new java.awt.Color(51, 51, 51));
        cargarBoton.setFont(new java.awt.Font("Papyrus", 3, 14)); // NOI18N
        cargarBoton.setForeground(new java.awt.Color(204, 204, 204));
        cargarBoton.setText("Cargar Partida");
        cargarBoton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cargarBotonActionPerformed(evt);
            }
        });
        getContentPane().add(cargarBoton);
        cargarBoton.setBounds(50, 140, 230, 31);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/nyarlathotepTran.jpg"))); // NOI18N
        jLabel1.setText("jLabel1");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(0, 0, 320, 480);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents
//------------------------------------------------------------------------- Boton de salida, cierra todo
    private void salirBotonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_salirBotonActionPerformed
        System.exit(0);
    }//GEN-LAST:event_salirBotonActionPerformed
//------------------------------------------------------------------------- Explorador de archivos
    private void cargarBotonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cargarBotonActionPerformed
        JFileChooser filechooser = new JFileChooser();
        filechooser.setFileFilter(filtro);// Muestra solo los archivos de formato .EJI 
        int opciones = filechooser.showOpenDialog(this);
        if (opciones == JFileChooser.APPROVE_OPTION) { // Cuando selecciónan un archivo
            File archivoSeleccionado = filechooser.getSelectedFile();
            this.recuerda.setNombre(archivoSeleccionado.getAbsolutePath());
            try {
                this.recuerda.abrir();
            } catch (IOException ex) {
                Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);
            }
            this.aux = new GameFrame(this.recuerda.getMemorisa());

        } else if (opciones == JFileChooser.CANCEL_OPTION) {//En caso de que cancelen la operación  solo cierre esa ventana
            filechooser.hide();
        }
    }//GEN-LAST:event_cargarBotonActionPerformed
//--------------------------Iniciar una nueva partida-------------------------
    private void nuevoBotonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nuevoBotonActionPerformed
        this.aux = new GameFrame();
        hide();
    }//GEN-LAST:event_nuevoBotonActionPerformed

    private void instruccionesBotonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_instruccionesBotonActionPerformed
        JFrame Instrucciones = new Instrucciones();
        Instrucciones.setVisible(true);
    }//GEN-LAST:event_instruccionesBotonActionPerformed

    private void CreditosBotonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CreditosBotonActionPerformed
        JFrame creditos = new Creditos();
        creditos.setVisible(true);
    }//GEN-LAST:event_CreditosBotonActionPerformed

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
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Menu().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JToggleButton CreditosBoton;
    private javax.swing.JToggleButton cargarBoton;
    private javax.swing.JToggleButton instruccionesBoton;
    private javax.swing.JDialog jDialog1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JToggleButton nuevoBoton;
    private javax.swing.JToggleButton salirBoton;
    // End of variables declaration//GEN-END:variables
}
