/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.shubham;

import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import static javax.ws.rs.HttpMethod.POST;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import static javax.ws.rs.client.Entity.xml;


import javax.ws.rs.core.MediaType;

/**
 *
 * @author shubham
 */
@Path("api")
public class Controller {
     
  @POST
  @Path("/register")
  @Produces(MediaType.APPLICATION_JSON)
  public String register(@FormParam("username") String username,
          @FormParam("firstname") String firstname,
          @FormParam("lastname") String lastname,
          @FormParam ("email") String email,
          @FormParam("password") String password)
  {
      Register reg=new Register();
      String result = reg.signUp(username, firstname, lastname, email, password);
      
   return result;   
}
          
    
    
    
}
