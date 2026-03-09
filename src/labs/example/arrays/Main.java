/*
@author: Collin Houfek
@date: 3/02/2026
@purpose: Week 8 Lab
*/

package labs.example.arrays;

import java.util.Random;

public class Main {
    public static void main(String[] args) {
        ArrayOperations operations = new ArrayOperations();
        System.out.println("--- Testing createNewArray ---");
        operations.createNewArray(100);

        System.out.println("--- Testing sortArray ---");
        int[] unsortedArray = new int[50];
        Random rand = new Random();

        System.out.println("Unsorted Array (before method call):");
        for (int i = 0; i < unsortedArray.length; i++) {
            unsortedArray[i] = rand.nextInt(1000) + 1;
            System.out.println(unsortedArray[i] + " ");
        }
        System.out.println("/n");

        operations.sortArray(unsortedArray);

        System.out.println("--- Testing getDaysAndMonths ---");
        operations.getDaysAndMonths();
    }
}