/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package object_models_practice;

/**
 *
 * @author sliu11
 */
public class Car extends Vehicle {
    
    private String bodyStyle;
    private int currentGear;
    private double totalMiles;
    private int numOfDoors;
    
    public Car(int y, String mod, String m, String t, String bs){
        year = y;
        model = mod;
        make = m;
        trim = t;
        bodyStyle = bs;
  
    } 
    
    @Override
    public void turn (int deg){
        //placeholder implentation which just 
        //adds incoming degrees to current heading
        
        headingInDeg = headingInDeg + deg;
    }
}
