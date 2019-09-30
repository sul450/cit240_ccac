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
public class VehicleLand {
    public static void main(String[] args) {
        
        Vehicle v = new Vehicle() {
            
        @Override
        public void turn (int deg){
        //placeholder implentation which just 
        //adds incoming degrees to current heading
        
        headingInDeg = headingInDeg + deg;
    }
        /* Determines the star rating. Should implement all methods from 
        crashtestable by using ct.getVehicleWeight();
        */
        public double crash(CrashTestable){
            
            
        }

            @Override
            public int getVehicleYear() {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public DrivingMode getDrivingMode() {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public double getVehicleWeight() {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public double getFrontBumberHeight() {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public String frameMaterialIdentifer() {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public boolean driverAirbagPresent() {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public double getLengthOfWheelBase() {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public double getFrontWeightLevelWeight() {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public double getFrontWeightWhenRaised() {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

        };
        Car firstCar = new Car(1991, "Acura", "NSX", "N/A", "Coupe");
        
    }
    
}
