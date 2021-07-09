/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ryerson.ca.carsearch.persistence;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.HashSet;
import java.util.Set;
import ryerson.ca.carsearch.helper.*;
/**
 *
 * @author student
 */
public class Car_CRUD {
    private static Connection getCon(){
    Connection con=null;
     try{
         Class.forName("com.mysql.jdbc.Driver");
         con=DriverManager.getConnection("jdbc:mysql://localhost:3306/carsearch?autoReconnect=true&useSSL=false", "root", "student");
         System.out.println("Connection established.");
     }
     catch(Exception e){ System.out.println(e);}
     return con;
    }
    
    
    public static Set<Car> searchForCars(String query){
        Set<Car> cars = new HashSet<Car>();
        try{
            Connection con= getCon();
            
            String q = "select * from CAR NATURAL JOIN CAR_MANUFACTURER "
                    + "NATURAL JOIN MANUFACTURER WHERE model LIKE '%"+query+"%'"
                    + " OR manuname LIKE '%"+
                    query+"%' OR year LIKE '%"+
                    query+"%' OR country LIKE '%"+query+"%';";
System.out.println(q);
			PreparedStatement ps=con.prepareStatement(q);
			ResultSet rs=ps.executeQuery();
			while(rs.next()){
				//been= new UserInfo();
				String carid=rs.getString("carid");
				String model=rs.getString("model");
                                String manuname=rs.getString("manuname");
                                String year=rs.getString("year");
                                String country=rs.getString("country");
                                Manufacturer manu= new Manufacturer(manuname, country);
                           
                                Car car = new Car(carid,model,year, manu);
                                cars.add(car);
                                
                                }
			
			con.close();

		}catch(Exception e){System.out.println(e);}
            
        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>"+cars.size());
        return cars;
    }
    
}
