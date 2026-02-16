/*
@author: Collin Houfek
@date: 2/15/2026
@purpose: Week 5 Lab
*/

package labs.example.physics;
import java.text.DecimalFormat;

public class Main { 
    public static void main(String[] args) {
        Physics physics = new Physics();

        double angleInDegrees = physics.getTheta(3, 4);

        double speedOfLightInMPH = physics.getLightSpeedInMPH();
        double timeToEarth = physics.getTimeFromSunToEarthInHours();
        double distance = physics.getDistance(speedOfLightInMPH, timeToEarth);

//week 6 lab, create if else statement for 3-4-5 triangle
    if(angleInDegrees > 37 || angleInDegrees < 36.87) {
        physics.logInivalidAngleInfo(angleInDegrees);
        System.out.println("logging the angle xy degrees. This is not a right angle.");
    }
    else {
        physics.logValidAngleInfo(angleInDegrees);
        System.out.println("logging the angle  xy degrees. This is a valid 3-4-5 triangle.");
    }

    DecimalFormat DecimalFormat = new DecimalFormat ("#,###.##");
    
        double distance = physics.getDistance(10, 2);
        double velocity = physics.getVelocity(5, 3);
        double momentum = physics.getMomentum(4, 9);
        double force = physics.getForce(10, 6);
        double work = physics.getWork(12, 4);
        double KineticEnergy = physics.getKineticEnergy(8, 2);
        double PotentialEnergy = physics.getPotentialEnergy(9, 3, 5);
    
//print return value with proper unit
    System.out.println("Distance:" + distance + "miles" );
    System.out.println("Velocity:" + velocity + "mph");
    System.out.println("Momentum:" + momentum + "kg m/s");
    System.out.println("Force:" + force + "kg m/s * s");
    System.out.println("Work:" + work + "Joules");
    System.out.println("Kinteic Energy:" + kineticEnergy + "Joules");
    System.out.println("Potential Energy:" + potentialEnergy + "Joules");

//part 2 of week 6 lab
    if(distance < 92947266.72) {
        physics.logEarthToSunInvalidDistance(distance);
    }
    else(distance >= 92947366.72) {
        physics.logEarthToSunValidDistance(distance);
    }
    }
}