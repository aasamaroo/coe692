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
public class User_Car_Rent_CRUD {
    
    
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
    
    public static Set<CarRent> getRentedCars(String username){
        Set<CarRent> cars= new HashSet<CarRent>();
        try{
            Connection con= getCon();
            String q;
            if(username.isEmpty()){
               q="select * from User_Car_Rent "
                 +";";
            }
            else
             q = "select * from User_Car_Rent "
                    + " WHERE username LIKE '"+username+"'"+";";

			PreparedStatement ps=con.prepareStatement(q);
			ResultSet rs=ps.executeQuery();
			while(rs.next()){

				String carid=rs.getString("carid");
			
                                String date=rs.getDate("rentDate").toString();
                                
                                
                                CarRent car = new CarRent(carid,date, username);
                                cars.add(car);
                                
                                }
			
			con.close();

		}catch(Exception e){System.out.println(e);}
           
        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>"+cars.size());
        return cars;
        
    }
    
    public static CarRent getRentedCars(String username, String carid){
        CarRent car=null;
        try{
            Connection con= getCon();
            
            String q = "select * from User_Car_Rent "
                    + " WHERE username LIKE '"+username+"'"+" and "
                    + "carid LIKE '"+carid+"';";

			PreparedStatement ps=con.prepareStatement(q);
			ResultSet rs=ps.executeQuery();
			if(rs.next()){

				
				
                                String date=rs.getDate("rentDate").toString();
                                
                                
                                 car = new CarRent(carid,date,username);
                                
                                
                                }
			
			con.close();

		}catch(Exception e){System.out.println(e);}
            
    
        return car;
        
    }
    
    public static boolean rent(String username, String carid){
      
        try{
            Connection con= getCon();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
             LocalDate date = LocalDate.now();
            System.out.println(date.format(formatter));
            String q = "insert into User_Car_Rent "
                    + "(carid, username, rentDate) values "
                    + "('"+carid+"', '"+username+"', '"+date.format(formatter)+"');";
            Statement stmt = con.createStatement(); 
            stmt.execute(q);
            
			con.close();
                        return true;

		}catch(Exception e){System.out.println(e);
                return false;
                }
 
        
    }
}
