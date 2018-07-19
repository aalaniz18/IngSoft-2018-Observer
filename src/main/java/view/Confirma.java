package main.java.view;
import main.java.controller.*;
import main.java.controller.ControllerInterface;

public class Confirma extends javax.swing.JFrame {
    
	ControllerInterface controller;
	private javax.swing.JButton backButton;
	private javax.swing.JButton endButton;
	private javax.swing.JLabel resumen;
	
    public Confirma(ControllerInterface controller) {
    	this.controller=controller;
        initComponents();
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(this.EXIT_ON_CLOSE);
    }

    private void initComponents() {

        endButton = new javax.swing.JButton();
        resumen = new javax.swing.JLabel();
        backButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(800, 600));

        endButton.setLabel("FINALIZAR COMPRA");
        endButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                endButtonActionPerformed(evt);
            }
        });

        resumen.setText("<html> As the music dies, <br /> something in your eyes Calls to mind <br /> the silver screen And all <br /> its sad good-byes <br /> I'm never gonna dance again");
        resumen.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        backButton.setText("VOLVER");
        backButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(285, 285, 285)
                        .addComponent(endButton, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addComponent(resumen, javax.swing.GroupLayout.PREFERRED_SIZE, 720, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(backButton)))
                .addContainerGap(40, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(backButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                .addComponent(resumen, javax.swing.GroupLayout.PREFERRED_SIZE, 461, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(endButton, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26))
        );

        resumen.getAccessibleContext().setAccessibleName("r");

        pack();
    }// </editor-fold>                        

//    public void cambiarController(ControllerInterface con) {
//   	 controller=con;
//    }
    
    private void endButtonActionPerformed(java.awt.event.ActionEvent evt) {
    	//controller.cambiarAHome2(this);
    }                                         

    private void backButtonActionPerformed(java.awt.event.ActionEvent evt) {
    	//controller.cambiarAFormaPago(this);
    }

}
