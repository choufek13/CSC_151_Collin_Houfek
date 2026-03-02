/*
@author: Collin Houfek
@date: 3/02/2026
@purpose: Week 8 Lab
*/

package labs/example.arrays;

public class ArrayOperations {
    public static void main(String[] args) {
        createNewArray();
        displayArray();
        sortArray();
        getDaysAndMonths();
    }
//part one of lab, create loop
    public static void createNewArray(int 4) {

    }

    private static void displayArray() {

    }

//part 2 of lab
    public static void sortArray() {

    }

//part 3 of lab, print out how many days each month has
    public static void getDaysAndMonths() {
        int[] days = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };

        for (int index = 0; index < 12; index++)
        {
            System.out.println("Month " + (index + 1) + " has " + days[index] + " days.");
        }
    }
}