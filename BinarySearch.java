/*
* This program generates 250 random numbers in an array
* and allows the user to search the array for a number.
*
* @author  Jacob Bonner
* @version 1.0
* @since   2020-12-11
*/

import java.util.Random;  // Import the Random class
import java.util.Scanner;  // Import the Scanner class

public class BinarySearch {
  /**
   * This function uses binary search to search an array for a specific number.
   */
  static String binarySearch(int[] userArray, int userNumber) {
    // Declaring variables to help in the search
    int lowIndex = 0;
    int highIndex = userArray.length - 1;
    int middleIndex = 0;

    // Loop that keeps reducing search range until number is found or not found
    while (lowIndex <= highIndex) {
      middleIndex  = (int) Math.floor((lowIndex + highIndex) / 2);
      if (userNumber > userArray[middleIndex]) {
        lowIndex = middleIndex + 1;
      } else if (userNumber < userArray[middleIndex]) {
        highIndex = middleIndex - 1;
      } else {
        // Returning the index spot of the number in the array
        String answer = Integer.toString(middleIndex);
        return answer;
      }
    }
    // Returning that the number could not be found in the array
    return "Number Not Found";
  }
  
  /**
   * This function sorts an array and returns the newly sorted array.
   */
  static int[] sort(int[] array) {
    // Sorting the array
    for (int arrayCounter = 0; arrayCounter < array.length; arrayCounter++) {
      for (int sortCounter = arrayCounter + 1; sortCounter < array.length; 
           sortCounter++) {
        if (array[arrayCounter] > array[sortCounter]) {
          int swapNumber = array[sortCounter];
          array[sortCounter] = array[arrayCounter];
          array[arrayCounter] = swapNumber;
        }
      }
    }
    // Returning the newly sorted array
    return array;
  }

  /**
   * This function allows the user to search a list of 250 numbers to find
   * a particular number.
   */
  public static void main(String[] args) {
    try {
      // Initializing the random class
      Random randNumber = new Random();

      // Initializing array of numbers
      int[] randomNumberArray = new int [250];

      // Adding numbers to the array
      for (int counter = 0; counter < randomNumberArray.length; counter++) {
        randomNumberArray[counter] = randNumber.nextInt(999) + 1;
      }

      // Sorting the array
      int[] numberArray = sort(randomNumberArray);

      // Getting user input as to what number they wish to search for
      Scanner userInput = new Scanner(System.in);
      System.out.print("What number are you searching for in the array");
      System.out.print(" (integer between 0 and 999): ");
      int searchNumber = userInput.nextInt();
      System.out.println();

      // Ensuring the user inputs an appropriate integer
      if (searchNumber > 999 || searchNumber < 0) {
        throw new Exception();
      } else {
        // Printing out the random number array
        String printList = "Array of Numbers: ";
        for (int printCounter = 0; printCounter < numberArray.length; 
             printCounter++) {
          printList = printList + numberArray[printCounter] + ", ";
        }
        System.out.println(printList);

        // Using binary search to find the user's chosen number in the array
        String searchResult = binarySearch(numberArray, searchNumber);

        // Outputing the results of the search
        System.out.println();
        System.out.println("Your number is in index: " + searchResult);
      }

      // Catches and tells the user that an error occured
    } catch (Exception e) {
      System.out.println();
      System.out.println("ERROR: Invalid Input");
    } 
  }
}
