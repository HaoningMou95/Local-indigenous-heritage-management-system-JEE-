/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author mouhaoning
 */

@Path("testController")
public class testController {
    
    @GET
    @Path("/getData")
    @Produces(MediaType.APPLICATION_JSON)
    public ArrayList<testModel> getDataInJSON() throws ClassNotFoundException, SQLException{
        ArrayList<testModel> tmm = new ArrayList<>();
        Connection con = null;
        String query = "select * from customer";
        String username = "fit5042";
        String password = "fit5042";
        Class.forName("org.apache.derby.jdbc.ClientDriver");
        con = DriverManager.getConnection("jdbc:derby://localhost:1527/fit5042-a1", username, password);
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery(query);
        while(rs.next()){
            testModel tm = new testModel();
            tm.setCustomerID(rs.getInt("customer_ID"));
            tm.setCustomerName(rs.getString("customer_Name"));
            tm.setCustomerEmail(rs.getString("customer_Email"));
            tm.setPhoneNo(rs.getInt("customer_phoneno"));

            tmm.add(tm);
            
            
        }
        return tmm;
        
    }
}
