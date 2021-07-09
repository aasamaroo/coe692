/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ryerson.ca.holdcar.persistence;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashSet;
import java.util.Set;
import ryerson.ca.holdcar.helper.*;
/**
 *
 * @author student
 */
public class Car_Hold_CRUD {
    
     private static Connection getCon() throws ClassNotFoundException, SQLException{
    Connection con=null;

         //String connection="localhost:3306";
         String connection = System.getenv("DB_URL");
         System.out.println(connection);
         
         Class.forName("com.mysql.cj.jdbc.Driver");
       
         con=DriverManager.getConnection("jdbc:mysql://"+connection+"/hold_CARS?allowPublicKeyRetrieval=true&useSSL=false", "root", "student" );
       System.out.println("Connection established.");
    return con;
    }
     
     public static boolean addHold(String carid, String username) throws ClassNotFoundException, SQLException{
      
       
           Connection con= getCon();
           DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
             LocalDate date = LocalDate.now();
            String q = "insert into Car_Hold "
                    + "(carid, username, startdate) values "
                    + "('"+carid+"', "
                    +"'"+username+"', "
                    +"'"+date.format(formatter)+"');";
            Statement stmt = con.createStatement();   
            System.out.println(q);
            stmt.execute(q);
			con.close();
                        return true;
     }
     
      public static CarHold getHoldCar(String carid){
        CarHold car=null;
        try{
            Connection con= getCon();
            
            String q = "select * from Car_Hold "
                    + " WHERE "
                    
                    + "carid = '"+carid+"';";
            System.out.println(q);

			PreparedStatement ps=con.prepareStatement(q);
			ResultSet rs=ps.executeQuery();
			if(rs.next()){

				
				
                                String date=rs.getDate("startdate").toString();
                                String username=rs.getString("username").toString();
                                
                                 car = new CarHold(carid,date,username);
                                
                                
                                }
			
			con.close();

		}catch(Exception e){System.out.println(e);}
            
    
        return car;
        
    }
      
      public static boolean addHold(String carid, String username, String holddate) throws ClassNotFoundException, SQLException {
      return( addHold(carid, username));
    }
     
     
}
