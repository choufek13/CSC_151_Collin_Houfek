/*
@author: Collin Houfek
@date: 2/23/2026
@purpose: Week 7 Lab
*/

package labs.example.loops;

//step 1 of lab
public class WhileLoop {
    public static void main(String[] args) {
        executeWhileLoop();

    }

    private static void executeWhileLoop() {
        int number = 0;
        while (number < 10) {
            number++;
        }
        System.out.println("The loop executed " + number + " times and is now complete");
        return;
    }
}