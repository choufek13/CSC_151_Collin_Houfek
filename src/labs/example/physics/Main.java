/*
@author: Collin Houfek
@date: 2/15/2026
@purpose: Week 5 Lab
*/

package labs.example.physics;
import java.text.DecimalFormat;

public class Main {
//call each method 
    public static void main(String[] args) {
        Physics physics = new Physics();
        
        double distance = physics.getDistance(10, 2);
        double velocity = physics.getVelocity(5, 3);
        double momentum = physics.getMomentum(4, 9);
        double force = physics.getForce(10, 6);
        double work = physics.getWork(12, 4);
        double KineticEnergy = physics.getKineticEnergy(8, 2);
        double PotentialEnergy = physics.getPotentialEnergy(9, 3);
    
//print return value with proper unit
    System.out.println("Distance:" + distance + "miles" );
    System.out.println("Velocity:" + velocity + "mph");
    System.out.println("Momentum:" + momentum + "kg m/s");
    System.out.println("Force:" + force + "kg m/s * s");
    System.out.println("Work:" + work + "Joules");
    System.out.println("Kinteic Energy:" + kineticEnergy + "Joules");
    System.out.println("Potential Energy:" + potentialEnergy + "Joules");
    }
}