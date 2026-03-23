/*
@author: Collin Houfek
@date: 3/22/2026
@purpose: Week 10 Lab
*/

public class ArrayLab {

    public static void main(String[] args) {

        int[] firstArray = {1, 2, 3, 4, 5};
        int[] secondArray = {1, 2, 3, 4, 5};

        checkArrays(firstArray, secondArray);

        int[] arr1 = new int[25];
        int[] arr2 = new int[25];
        int[] arr3 = new int[25];
// Fill arrays with sample values
    for (int i = 0; i < 25; i++) {
        arr1[i] = i + 1;
        arr2[i] = i + 2;
        arr3[i] = i + 3;
    }
    sumAndCompareArrays(arr1, arr2, arr3);
        int[] myArray = new int[50];
        for (int i = 0; i < 50; i++) {
            myArray[i] = (int)(Math.random() * 100);
        }

        findMax(myArray);
        String testCard = "4532015112830366"; // valid Visa test number
        checkCreditCard(testCard);
    }

    public static void checkArrays(int[] firstArray, int[] secondArray) {
        boolean sameLength = false;
        boolean sameValues = true;
// Check length
    if (firstArray.length == secondArray.length) {
        sameLength = true;
    }
// Check values manually
    if (sameLength) {
        for (int i = 0; i < firstArray.length; i++) {
            if (firstArray[i] != secondArray[i]) {
                sameValues = false;
                break;
            }
        }
    } else {
        sameValues = false;
    }

// Print results
    if (sameValues) {
        System.out.println("Yes, these arrays contain the same values");
    } else {
        System.out.println("No, these arrays do not contain the same values");
    }
    if (sameLength) {
        System.out.println("Yes, these arrays are the same length");
    } else {
        System.out.println("No, these arrays are not the same length");
    }
}

    public static void sumAndCompareArrays(int[] arr1, int[] arr2, int[] arr3) {
        int sum1 = 0, sum2 = 0, sum3 = 0;
        for (int i = 0; i < arr1.length; i++) {
            sum1 += arr1[i];
            sum2 += arr2[i];
            sum3 += arr3[i];
        }
        System.out.println("Sum of arr1: " + sum1);
        System.out.println("Sum of arr2: " + sum2);
        System.out.println("Sum of arr3: " + sum3);

// Find largest
        int max = sum1;
        String arrayName = "arr1";

        if (sum2 > max) {
            max = sum2;
            arrayName = "arr2";
        }

        if (sum3 > max) {
            max = sum3;
            arrayName = "arr3";
        }
        System.out.println(arrayName + " has the highest value: " + max);
    }

    public static void findMax(int[] myArray) {

        int max = myArray[0];

        for (int i = 1; i < myArray.length; i++) {
            if (myArray[i] > max) {
                max = myArray[i];
            }
        }
        System.out.println("The highest value in the myArray object is: " + max);
    }

    public static void checkCreditCard(String cardNumber) {
        int sum = 0;
        boolean alternate = false;
// Loop from right to left
    for (int i = cardNumber.length() - 1; i >= 0; i--) {
        int n = cardNumber.charAt(i) - '0';
        if (alternate) {
            n *= 2;
            if (n > 9) {
                n -= 9;
            }
        }
        sum += n;
        alternate = !alternate;
        }
    if (sum % 10 == 0) {
        System.out.println("Credit Card " + cardNumber + " is valid.");
    } else {
        System.out.println("Credit Card " + cardNumber + " is not valid.");
    }
    }
}