/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.jerseytutorial;

/**
 *
 * @author christopherking
 */
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;

@Path("/Calculator")
public class CalculatorService {
    
    // Using PathParam like http://localhost:49000/api/Calculator/monthlyPayment/100000/0.6/12.
    @GET
    @Path("/monthlyPayment/{param1}/{param2}/{param3}")
    public Response monthlyPayment(@PathParam("param1") float num1,@PathParam("param2") float num2, @PathParam("param3") float num3) {
        float result =0;
        result = num1*num2/num3;
        String output = num1 + " * "+ num2 +" / "+ num3 +" = "+ result;
        return Response.status(200).entity(output).build();
    }
        
    @GET
    @Path("/substract/{param1}/{param2}")
    public Response substract(@PathParam("param1") float num1,@PathParam("param2") float num2) {
        float result =0;
        result = num1-num2;
        String output = num1 + " - "+ num2 +" = "+ result;
        return Response.status(200).entity(output).build();
    }
    
    @GET
    @Path("/divide/{param1}/{param2}")
    public Response divide(@PathParam("param1") float num1,@PathParam("param2") float num2) {
        float result =0;
        result = num1/num2;
        String output = num1 + " / "+ num2 +" = "+ result;
        return Response.status(200).entity(output).build();
    }
    
    @GET
    @Path("/multiply/{param1}/{param2}")
    public Response multiply(@PathParam("param1") float num1,@PathParam("param2") float num2) {
        float result =0;
        result = num1*num2;
        String output = num1 + " * "+ num2 +" = "+ result;
        return Response.status(200).entity(output).build();
    }
    
    /* Using QueryParam like http://localhost:49000/api/Calculator?operation=add&num1=2&num2=4 */
    @GET
    public Response calculate(@QueryParam("operation") String op, 
                                  @QueryParam("num1") float num1,@QueryParam("num2") float num2 ) {
        String output = "";
        float result = 0;
        op = op.toLowerCase();
       
        if (op.equals("add") ) {
            result = num1+num2;
            output = num1 + " + "+ num2 +" = "+ result;
        } 
        else if (op.equals("substract")) {
            result = num1-num2;
            output = num1 + " - "+ num2 +" = "+ result;
        } 
        else if (op.equals("multiply") ) {
            result = num1*num2;
            output = num1 + " * "+ num2 +" = "+ result;
        } 
        else if (op.equals("divide") ) {
            result = num1/num2;
            output = num1 + " / "+ num2 +" = "+ result;
            } 
        else
         {
         output = "Undefined operation";
         }
        
        return Response.status(200).entity(output).build();
    }
}

