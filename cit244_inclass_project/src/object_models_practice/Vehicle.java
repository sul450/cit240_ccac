/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package object_models_practice;

import inheritancepractice.CrashTestable;

/**
 *
 * @author sliu11
 */
public abstract class Vehicle implements Turnable, CrashTestable{
    
    //String variables
    String vin;
    String wheels;
    String licenseNumber;
    String make;
    String model;
    String transmission;
    String trim;
    String fuelType;
    
    //Double variables
    double headingInDeg;
    double price;
    double strengthToWeightRatio;
    
    //Int Variables
    int speed;
    int maxSpeed;
    int year;
    int curbWeight;
    int peakForce;
    int turn;
    
    
    public Vehicle(){
        speed = 0;
    }
    
    public Vehicle (int ms, int year, String ftype){
        speed = 0;
        maxSpeed = ms;
    }
}
