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
        
        double distance = physics.getDistance();
        double velocity = physics.getVelocity();
        double momentum = physics.getMomentum();
        double force = physics.getForce();
        double work = physics.getWork();
        double KineticEnergy = physics.getKineticEnergy();
        double PotentialEnergy = physics.getPotentialEnergy();
    }
}