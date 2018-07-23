/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.java.view;

import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.table.DefaultTableModel;

import main.java.controller.ControllerInterface;
import main.java.model.ModelSubject;

/**
 *
 * @author perez
 */
public class ConsultaStock extends javax.swing.JFrame implements ViewObserver {
    DefaultTableModel   consultaStock;
    ControllerInterface controller;
    ModelSubject model;
    /**
     * Creates new form ConsultaStock
     */
    public ConsultaStock(ControllerInterface controller, ModelSubject model) {
        this.controller=controller;
        this.model=model;
    	consultaStock=new DefaultTableModel(null, getColumnas());
        try {
			this.setFilas();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        initComponents();
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jButton1.setText("VOLVER");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jTable1.setBorder(javax.swing.BorderFactory.createCompoundBorder());
        jTable1.setModel(consultaStock);
        jScrollPane2.setViewportView(jTable1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(93, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 616, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(91, 91, 91))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 506, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(53, Short.MAX_VALUE))
        );

        pack();
        model.registerObserver(this);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
    	controller.cambiarAHomeAdmin(this);
    }//GEN-LAST:event_jButton1ActionPerformed
    
    private String[] getColumnas() {//OK!
        String Columna[] = new String[]{"id Producto", "Nombre de Producto", "Precio", "Cantidad", "Tipo", "Descripcion"}; //To change body of generated methods, choose Tools | Templates.
        return Columna;
    }

    private void setFilas() throws SQLException{
        Object Datos[]= new Object[6];
        ResultSet Stock=controller.getModel().CargarStock();
        while(Stock.next()){
            for(int i=0; i<6; i++){
            Datos[i]= Stock.getObject(i+1);
            }	
        consultaStock.addRow(Datos);
        }
    }

    private void cleanRows(){
        int a= consultaStock.getRowCount()-1;
        for(int i=a; i>=0; i--){
            consultaStock.removeRow(consultaStock.getRowCount()-1);
        }
    }
//    /**
//     * @param args the command line arguments
//     */
//    public static void main(String args[]) {
//        /* Set the Nimbus look and feel */
//        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
//        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
//         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
//         */
//        try {
//            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
//                if ("Nimbus".equals(info.getName())) {
//                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
//                    break;
//                }
//            }
//        } catch (ClassNotFoundException ex) {
//            java.util.logging.Logger.getLogger(ConsultaStock.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(ConsultaStock.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(ConsultaStock.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(ConsultaStock.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new ConsultaStock().setVisible(true);
//            }
//        });
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;

	@Override
	public void update() {
		try {
			this.cleanRows();

			this.setFilas();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}