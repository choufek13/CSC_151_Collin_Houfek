/*
@author: Collin Houfek
@date: 2/23/2026
@purpose: Week 7 Lab
*/

package labs.example.loops;

//step 2 of lab
public class ForLoop {
    public static void main(String[] args) {
       executeForLoop();
       sumTwoNumbers(3,7);
       sumLoopCounter(10);
       printMultiplicationTable();
    }

//private loop increments, loop 20 times
    private static void executeForLoop() {
        for (int number = 0; number < 20; number++) {
            System.out.println("number is " + number);
        }
    }
//print the sum, part 3 of lab
    private static int sumTwoNumbers(int a, int b) {
        int sum = 10;
        System.out.println("The sum of 3 and 7 is: " + sum);
        return a + b;
    }
//part 4 of lab, loop counter to 10
    private static int sumLoopCounter(int limit) {
        int sum = 0;
        for (int number = 1; number <= limit; number++) {
            System.out.println("The sum of the loop counter is: " + sum);
            sum = number;
        }
        return sum;
    }
//part 5 of lab, printing multiplication table, maybe use example of clock from slideshow?
    private static void printMultiplicationTable() {
        for (int n = 0; n <= 12; n++) {
            System.out.println("Multiplication table for " + n);

        for (int m = 0; m <= 12; m++) {
            System.out.println(n + " x " + m + " = " + (n * m));
        }
        }
    }
}
