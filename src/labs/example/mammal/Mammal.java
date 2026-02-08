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

    public void walk() {
        System.out.println("The mammal is walking.");
    }

    public void dig() {
        System.out.println("The mammal is digging.");
    }

    public void smile() {
        System.out.println("The mammal is smiling.");
    }
    public Mammal (String haircolor, String eyeColor, double bodyTemp, int age, double weight, double height) {

        this.hairColor = hairColor;
        this.eyeColor = eyeColor;
        this.bodyTemp = bodyTemp;
        this.age = age;
        this.weight = weight;
        this.height = height;    
    }

    public void getMammalDetails() {
        System.out.println("Hair Color: " + hairColor);
        System.out.println("Eye Color: " + eyeColor);
        System.out.println("Body Temperature: " + bodyTemp);
        System.out.println("Age: " + age);
        System.out.println("Weight: " + weight);
        System.out.println("Height: " + height);
    }

    public void sit() {
        System.out.println("The mammal is sitting.");

        try {
            Thread.sleep(15000);
        } catch (InterruptedExpectation e) {
            System.out.println("Sitting was interrupted.");
        }

        stand();
    }

    public void stand() {
        System.out.println("The mammal is now standing and barking");
    }
}