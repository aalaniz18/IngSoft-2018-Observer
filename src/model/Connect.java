package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Connect {
    String url = "localhost"; 
    String user = "root";
    String pass = "1234";
    ResultSet rs ;
    Statement s ;
    Connection cnx;
        public Connect() throws SQLException {
         try {            

            Class.forName("com.mysql.cj.jdbc.Driver");
          cnx= DriverManager.getConnection(url, user, pass) ;

            
            s = cnx.createStatement();
                rs = s.executeQuery ("select * from usuarios");          
                           while (rs.next()) 
{ 
                        System.out.printf("User :"+rs.getString (2)+ "|| Pass: " + rs.getString(3) + "\n");   //JOptionPane.showMessageDialog(null,rs.getString (1)+ "/"+ rs.getString (2));
} 
           
           
           
           
         } catch (ClassNotFoundException ex) {
            throw new ClassCastException(ex.getMessage());
         }
        }
        public Connection getConnection(){
        return cnx;
        }
}
