/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ryerson.ca.rentcar.persistence;

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
import ryerson.ca.rentcar.helper.CarRent;
/**
 *
 * @author student
 */
public class Car_Hold_CRUD {
    
    public static Connection getCon() throws ClassNotFoundException, SQLException{
       Connection con=null;
     try{
         Class.forName("com.mysql.jdbc.Driver");
        String connection=System.getenv("DB_URL");
        //String connection ="localhost:3306";
         con=DriverManager.getConnection("jdbc:mysql://"+connection+"/rent_CARS?allowPublicKeyRetrieval=true&useSSL=false", "root", "student" );
        
         
         System.out.println("Connection established.");
     }
     catch(Exception e){ System.out.println(e);}
     return con;
     
    }
    
    public static boolean isOnHold(String carid){
       boolean result;
        try{
            Connection con= getCon();
            
        
            
            String q = "select * from Car_Hold "
                    + " WHERE carid LIKE '"+carid+"';";

			PreparedStatement ps=con.prepareStatement(q);
			ResultSet rs=ps.executeQuery();
			if(rs.next()){

			result=true;
                                
                                }
                        else
                            result=false;
			
			con.close();

		}catch(Exception e){return false;}
            return result;
    }
    
     public static Set<CarRent>  getHolds(){
        Set<CarRent> cars= new HashSet<CarRent>();
        

        try{
            Connection con= getCon();
            
        
            
            String q = "select * from Car_Hold "
                    +";";
                        System.out.println(q);
			PreparedStatement ps=con.prepareStatement(q);
			ResultSet rs=ps.executeQuery();
			while(rs.next()){

				String carid=rs.getString("carid");
			
                                 
                                
                                CarRent car = new CarRent(carid,null, null);
                                cars.add(car);
                                
                                }
			
			
			con.close();

		}catch(Exception e){return cars;}
            return cars;
    }
     
     public static void addHold(String carid) throws ClassNotFoundException, SQLException{
      
        
            Connection con= getCon();
          
            String q = "insert into Car_Hold "
                    + "(carid) values "
                    + "('"+carid+"');";
            Statement stmt = con.createStatement(); 
           
            stmt.execute(q);
			con.close();
           
    }
     
     public static void addHold(String carid, String username, String date) throws ClassNotFoundException, SQLException{
      
        
            Connection con= getCon();
          
            String q = "insert into Car_Hold "
                    + "(carid, username, date) values "
                    + "("+
                    "'" +carid+"'"+ ","
                    +"'"+username+"'" + ","
                    +"'"+date+"'"
                    +"');";
            Statement stmt = con.createStatement(); 
           
            stmt.execute(q);
			con.close();
    }
}
