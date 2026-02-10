package labs.example.mammal;

public class Mammal {
    
    private String hairColor;
    private String eyeColor;
    private double bodyTemp;

    private int age;
    private double weight;
    private double height;


    public void run() {
        System.out.println("The mammal is running.");
    }

    public void eat() {
        System.out.println("The mammal is eating.");
    }

    public void sleep() {
        System.out.println("The mammal is sleeping.");
    }
    
    public void scratch() {
        System.out.println("The mammal is scratching.");
    }

    public void play() {
        System.out.println("The mammal is playing.");
    }

    public void protect() {
        System.out.println("The mammal is protecting.");
    }

    public void noise() {
        System.out.println("The mammal is making noise.");
    }

    public void dig() {
        System.out.println("The mammal is digging.");
    }

    public void smile() {
        System.out.println("The mammal is smiling.");
    }

    public void walk() {
        System.out.println("The mammal is walking.");
    }

    public int walk() {
        int south = 3;
        int east = 4;

        double distance = Math.sqrt(Math.pow(south, 2) + Math.pow(east, 2));
        double thetaRadians = Math.atan2(east, south);
        double thetaDegrees = Math.toDegrees(thetaRadians);

        System.out.println("Angle at longest line: " + thetaDegrees);
        return (int)distance;
    }
}
