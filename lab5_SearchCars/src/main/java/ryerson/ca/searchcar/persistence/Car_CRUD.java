/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ryerson.ca.searchcar.persistence;

import java.util.*;
import ryerson.ca.searchcar.helper.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author student
 */
public class Car_CRUD {
    
    public Car_CRUD(){
        
    }
    
    private static Connection getCon() {
        Connection con = null;
        try {

            Class.forName("com.mysql.jdbc.Driver");
            String connection = System.getenv("DB_URL");
            //  String connection ="localhost:3306";
            con = DriverManager.getConnection("jdbc:mysql://" + connection
                    + "/search_CARS?allowPublicKeyRetrieval=true&useSSL=false", "root", "student");

            System.out.println("Connection established.");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return con;
    }
    
    public static Set<Car> searchForCars(String query) throws SQLException{
        
        String carid = "";
        String year = "";
        String manufacturer = "";
        String model = "";
        
        Set<Car> cars = new HashSet<Car>();
        
        try{
        Connection con = getCon();
        String q = "SELECT * FROM CAR WHERE year like '%"+query+"%' OR manufacturer LIKE '%"+query+"%' OR model LIKE '%"+query+"%';";
        PreparedStatement ps = con.prepareStatement(q);
        ResultSet rs = ps.executeQuery();
        
        while(rs.next()){
            
            carid = rs.getString("carid");
            year = rs.getString("year");
            manufacturer = rs.getString("manufacturer");
            model = rs.getString("model");
            
            Car car = new Car(carid, year, manufacturer, model);
            cars.add(car);
        }
        
        con.close();
       
        
    }catch(SQLException e){
        e.printStackTrace();
    }
    
   return cars;
}
}