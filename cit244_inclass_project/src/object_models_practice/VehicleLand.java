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
public class VehicleLand {
    public static void main(String[] args) {
        
        Vehicle v = new Vehicle() {
        @Override
        public void turn (int deg){
        //placeholder implentation which just 
        //adds incoming degrees to current heading
        
        headingInDeg = headingInDeg + deg;
    }
        };
        Car firstCar = new Car(1991, "Acura", "NSX", "N/A", "Coupe");
        
        
    }
    
}
