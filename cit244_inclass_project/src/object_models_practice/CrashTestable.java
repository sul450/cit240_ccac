/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package object_models_practice;

/**
 * collaboratively designed interface for specifying behaviors that aloow an 
 * object to be 
 * @author sliu11
 */
public interface CrashTestable {
    
    /**
     * release year 
     * @return release year 
     */
    public int getVehicleYear();
    
    /**
     * driving mode represents a grouping of settings related 
     * to the car's performance ex(eco, snow, sport);
     * @return 
     */
    public DrivingMode getDrivingMode();
    
    /**
     * 
     * @return 
     */
    public double getVehicleWeight();
    
    /**
     * vehicle off of the ground to the lowest height to the bumper
     * @return height in inches
     */
    public String getFrontBumperHeight();
    
    /**
     * possible return values includes: steel, aluminum, carbon fiber,
     * cool corvette stuff, 
     * @return material 
     */
    public String frameMaterialIdentifier();
    
    /**
     * boolean flag for working driver front collision airbag
     * @return presence of airbag
     */
    public boolean driverAirbagPresent();
    
    /**
     * center of the front wheel to the center of the back wheel 
     * @return value is in inches
     */
    public double getlengthWheelBase();
    
    /**
     * weight of the vehicle in pounds when the vehicle is leveled
     * @return weight in pounds
     */
    public double getFrontWeightLevelWeight();
    
    /**
     * 
     * @return 
     */
    public double getfrontWeightNonRaised();
    public double getfrontWeightWhenRaised(int raiseAngle);    
}
