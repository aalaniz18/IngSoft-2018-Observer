package main.java.view;

import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.table.DefaultTableModel;
import main.java.controller.ControllerInterface;
import main.java.model.ModelSubject;

public class ConsultaStock extends javax.swing.JFrame implements ViewObserver {
    
	DefaultTableModel   consultaStock;
    ControllerInterface controller;
    ModelSubject model;
    private javax.swing.JButton jButton1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    
    public ConsultaStock(ControllerInterface controller, ModelSubject model) {
        this.controller=controller;
        this.model=model;
    	consultaStock=new DefaultTableModel(null, getColumnas());
        try {
			this.setFilas();
		} catch (SQLException e) {
			e.printStackTrace();
		}
        initComponents();
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        
    }

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
    }

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {
    	controller.cambiarAHomeAdmin(this);
    }
    
    private String[] getColumnas() {//OK!
        String Columna[] = new String[]{"id Producto", "Nombre de Producto", "Precio", "Cantidad", "Tipo", "Descripcion"}; //To change body of generated methods, choose Tools | Templates.
        return Columna;
    }

    private void setFilas() throws SQLException{//OK!
        Object Datos[]= new Object[6];
        //ResultSet Stock=controller.getModel().CargarStock();
        ResultSet stock=controller.getRSStock();
        while(stock.next()){
            for(int i=0; i<6; i++){
            Datos[i]= stock.getObject(i+1);
            }	
        consultaStock.addRow(Datos);
        }
    }

    private void cleanRows(){//OK!
        int a= consultaStock.getRowCount()-1;
        for(int i=a; i>=0; i--){
            consultaStock.removeRow(consultaStock.getRowCount()-1);
        }
    } 

	@Override
	public void update() {//OK!
		try {
			this.cleanRows();
			this.setFilas();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
}