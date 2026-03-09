/*
@author: Collin Houfek
@date: 3/02/2026
@purpose: Week 8 Lab
*/

package labs.example.arrays;

//create new array, part one of lab
public class ArrayOperations {
    public void createNewArray(int baseValue) {
        int[] newArray = new int[10];
        for (int i = 0; i < newArray.length; i++) {
            newArray[i] = baseValue + i;
        }
    displayArray(newArray);
    }

//display array now
    private void displayArray(int[] arr) {
        System.out.println("I created a new array and it now has " + arr.length + " items in it.");
        System.out.println("The array items and their values are listed below: ");

        for (int i = 0; i < arr.length; i++) {
            System.out.println("Index " + i + ": " + arr[i]);
        }
        System.out.println("------------------------------------------------");
    }

//part 2 of lab, sort array, use bubble-sort
    public void sortArray(int[] arr) {
        int n = arr.length;

        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    
//print sorted array
    System.out.println("Sorted Array Output (Bubble Sort):");
    for (int i = 0; i < arr.length; i++) {
        System.out.print(arr[i] + " ");
    }
    System.out.println("\n------------------------------------------------");
    }

//part 3 of lab, get days and months
    public void getDaysAndMonths() {
    //string array for months
        String[] months = {
            "January", "February", "March", "April", "May", "June", 
            "July", "August", "September", "October", "November", "December"
        };

        int[] days = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        System.out.println("Days in each month:");
        
        for (int i = 0; i < months.length; i++) {
            System.out.println("There are " + days[i] + " days in " + months[i]);
        }
        System.out.println("------------------------------------------------");
    }
}