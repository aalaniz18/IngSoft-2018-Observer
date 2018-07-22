package main.java.view;

import java.awt.Image;
import java.awt.event.ActionEvent;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import main.java.controller.*;
import main.java.controller.ControllerInterface;

public class CompraTickets_v1 extends javax.swing.JFrame {
	
	private javax.swing.JComboBox<String> asientoBox;
    private javax.swing.JButton backButton;
    private javax.swing.JButton buyButton;
    private javax.swing.JButton chargeButton;
    private javax.swing.JComboBox<String> filaBox;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JComboBox<String> movieBox;
    private javax.swing.JButton nextButton1;
    private javax.swing.JButton skipButton;
    ControllerInterface controller;
    private int idPelicula;
    
    public CompraTickets_v1(ControllerInterface controller) throws SQLException {
    	this.controller=controller;
        initComponents();
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(this.EXIT_ON_CLOSE);
        this.setResizable(false);

        setmovieBox();
        
       // this.getContentPane().setBackground(Color.orange);
    }
       
    private void initComponents() {

    	jPanel1 = new javax.swing.JPanel();
        buyButton = new javax.swing.JButton();
        filaBox = new javax.swing.JComboBox<String>();
        asientoBox = new javax.swing.JComboBox<String>();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        backButton = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        movieBox = new javax.swing.JComboBox();
        skipButton = new javax.swing.JButton();
        chargeButton = new javax.swing.JButton();
        nextButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        buyButton.setText("COMPRAR");
        buyButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                try {
					buyButtonActionPerformed(evt);
				} catch (SQLException e) {
					e.printStackTrace();
				}
            }
        });

        filaBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { " " }));
        filaBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                filaBoxActionPerformed(evt);
            }
        });

        asientoBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { " " }));

        jLabel1.setText("  FILA");

        jLabel2.setText("  ASIENTO");

        backButton.setText("VOLVER");
        backButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backButtonActionPerformed(evt);
            }
        });

        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/main/java/view/400.400.jpg"))); // NOI18N
        jLabel3.setBorder(javax.swing.BorderFactory.createCompoundBorder());

        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("PELICULA");

        movieBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        skipButton.setText("SALTAR");
        skipButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                skipButtonActionPerformed(evt);
            }
        });

        chargeButton.setText("CARGAR ASIENTOS DISPONIBLES");
        chargeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                try {
					chargeButtonActionPerformed(evt);
				} catch (SQLException e) {
					e.printStackTrace();
				}
            }
        });

        nextButton1.setText("SIGUIENTE");
        nextButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nextButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(backButton)
                        .addGap(302, 302, 302)
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(327, 327, 327)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(filaBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(51, 51, 51)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(asientoBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(90, 90, 90)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(skipButton)
                                .addGap(195, 195, 195)
                                .addComponent(buyButton))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(movieBox, javax.swing.GroupLayout.PREFERRED_SIZE, 341, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 111, Short.MAX_VALUE)
                                .addComponent(chargeButton)))))
                .addGap(90, 90, 90))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 392, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(218, 218, 218))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                    .addContainerGap(663, Short.MAX_VALUE)
                    .addComponent(nextButton1)
                    .addGap(79, 79, 79)))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(backButton)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addComponent(jLabel4)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(chargeButton, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(movieBox, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 7, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(asientoBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(filaBox, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(buyButton)
                    .addComponent(skipButton))
                .addGap(17, 17, 17))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                    .addContainerGap(551, Short.MAX_VALUE)
                    .addComponent(nextButton1)
                    .addGap(7, 7, 7)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
       }

    protected void chargeButtonActionPerformed(ActionEvent evt) throws SQLException {
    	String elegida = (String) movieBox.getSelectedItem();
    	idPelicula= controller.getModel().getIdPelicula(elegida);
        filaBox.removeAllItems();
        filaBox.addItem("A");
        filaBox.addItem("B");
        filaBox.addItem("C");
        filaBox.addItem("D");
        filaBox.addItem("E");
        filaBox.addItem("F");
        filaBox.addItem("G");
        filaBox.addItem("H");
        filaBox.addItem("I");
        filaBox.addItem("J");
        
        asientoBox.removeAllItems();
        asientoBox.addItem("1");
        asientoBox.addItem("2");
        asientoBox.addItem("3");
        asientoBox.addItem("4");
        asientoBox.addItem("5");
        asientoBox.addItem("6");
        asientoBox.addItem("7");
        asientoBox.addItem("8");
	}

	private void buyButtonActionPerformed(java.awt.event.ActionEvent evt)throws SQLException {
		String fila= (String) filaBox.getSelectedItem();
		int asiento= Integer.parseInt((String) asientoBox.getSelectedItem());
		int idAsiento= controller.getModel().getIdAsiento(fila, asiento);
		if(controller.getModel().estaOcupado(idPelicula,idAsiento)){
        	JOptionPane.showMessageDialog(null, "Asiento ocupado, por favor seleccione otro.");
		}
		else{
			controller.iniciarCompra(idPelicula,fila,asiento);
        	JOptionPane.showMessageDialog(null, "Asiento reservado con exito.");
		}	
    }

    private void filaBoxActionPerformed(java.awt.event.ActionEvent evt) {
    }

    private void backButtonActionPerformed(java.awt.event.ActionEvent evt) {
    	controller.cambiarAHome2(this);
    }

    private void skipButtonActionPerformed(java.awt.event.ActionEvent evt) {
    	controller.cambiarACompra(this);
    }
    
    private void nextButton1ActionPerformed(java.awt.event.ActionEvent evt) {
    	controller.cambiarACompra(this);
    }
    
    private void setmovieBox() throws SQLException{
    	movieBox.removeAllItems();
    	ResultSet pelis=controller.setPelisBox();
    	while(pelis.next()){
    		movieBox.addItem(pelis.getString(2)); 
    	}
    }
}
