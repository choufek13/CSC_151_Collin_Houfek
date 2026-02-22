/*
@author: Collin Houfek
@date: 2/15/2026
@purpose: Week 5 Lab
*/

package labs.example.physics;
import java.lang.Math;

public class Physics {

    final static double GRAVITY = 9.81;
    
//write the methods and equations

    public static double getDistance(int velocity, int time) {
        double distance = velocity * time;
        return distance;
    }

    public static double getVelocity(int distance, int time) {
        double velocity = distance / time;
        return velocity;
    }

    public static double getMomentum(int mass, int velocity) {
        double momentum = mass * velocity;
        return momentum;
    }

    public static double getForce(int mass, int acceleration) {
        double force = mass * acceleration;
        return force;
    }

    public static double getWork(int force, int distance) {
        double work = force * distance;
        return work;
    }

    public static double getKineticEnergy(int mass, int velocity) {
        double kineticEnergy = 0.5 * mass * velocity * velocity;
        return kineticEnergy;
    }

    public static double getPotentialEnergy(int mass, int gravity, int height) {
        double potentialEnergy = mass * gravity * height;
        return potentialEnergy;
    }
//write one for theta
    public static double getTheta(int xVal, int yVal) {
        double theta = Math.atan2(xVal,yVal) * 180/3.1415;
        return theta;
    }
//write one for angles
    public double calculateAngleInDegrees(int opposite, int adjacent) {
        double angleRadians = Math.atan(opposite / adjacent);
        return Math.toDegrees(angleRadians);
    }
    public void logInvalidAngleInfo(double angleInDegrees) {
        System.out.println("logging the angle " + angleInDegrees + "degrees. This is not a right angle.");
    }
    public void logValidAngleInfo(double angleInDegrees) {
        System.out.println("logging the angle " + angleInDegrees + "degrees. This is a valid 3-4-5 triangle.");
    }

//write one for getLightSpeedInMPH
    public static double getLightSpeedInMPH() {
        //186282 miles per second, so convert to miles per hour
        return 186282 * 3600
    }
//write one for getTimeFromSunToEarthInHours
    public static double getTimeFromSunToEarthInHours() {
        //takes about 8.317 minutes for light to reach earth
        double minutes = 8.317
        return mintues / 60.0;
    }

    public static double getKnownDistanceToEarth() {
        return 92947266.72;
    }

    public void logEarthToSunInvalidDistance(double distance) {
        System.out.println("The calculated distance" + distance + "miles is invalid.");
    }
}