/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package object_models_practice;

import inheritancepractice.DrivingMode;

/**
 *
 * @author sliu11
 */
public class Car extends Vehicle{
    
    public Car(int y, String mod, String m, String t, String bs){
        year = y;
        model = mod;
        make = m;
        transmission = t;
    } 

   
    @Override
    public void turn(int deg) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    //gets the vehicle year
    @Override
    public int getVehicleYear() {
        return 1991;
    }

    //gets the vehicle driving mode
    public Car(DrivingMode sport) {
    }

    //gets teh vehicle weight
    public double getVehicleWeight() {
        return 3010;
    }

    //gets the height of the front bumper
    public double getFrontBumberHeight() {
        return 46.1;
    }

    //return what material the is made of
    public String frameMaterialIdentifer() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    //returns whether or not a airbag is present
    public boolean driverAirbagPresent() {
        return true;
    }

    //returns the length of the wheelbase 
    public double getLengthOfWheelBase() {
        return 99.6;
    }

    //gets the weigth of teh front
    public double getFrontWeightLevelWeight() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    //returns the height of the front when he vehicle is raised
    public double getFrontWeightWhenRaised() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    //returns the driving mode
    public DrivingMode getDrivingMode() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
