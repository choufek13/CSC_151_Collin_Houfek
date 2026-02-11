package labs.example.physics;

public class main {
    
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