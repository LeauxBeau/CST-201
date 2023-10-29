package app;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        String[] wordArray = new String[10000];
        int wordCount = 0;

        // Step 1: Read from a text file and store words in the array
        try {
            BufferedReader reader = new BufferedReader(new FileReader("C:\\Users\\austi\\Desktop\\Repositories (GitHub)\\CST-201\\Project Zero\\ProjectZero\\Text"));
            String line;
            while ((line = reader.readLine()) != null) {
                String[] words = line.split(" ");
                for (String word : words) {
                    if (wordCount < 10000) {
                        wordArray[wordCount] = word;
                        wordCount++;
                    }
                }
            }
            reader.close();
        } catch (IOException e) {
            System.err.println("Error reading the file: " + e.getMessage());
        }	
        System.out.println("Unsorted Array: ");
        printArray(wordArray);

        // Step 2: Check if the array is full and print it
        if (wordCount >= 10000) {
            System.out.println("Unsorted Array:");
            printArray(wordArray);
        }

        // Step 3: Implement a selective sort method to sort the array
        selectiveSort(wordArray, wordCount);

        // Step 4: Implement a binary search method to search for words
        binarySearch(wordArray, wordCount);
    }

    // Print the array
    public static void printArray(String[] arr) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != null) {
                System.out.println(arr[i]);
            }
        }
    }

    // Sort the array alphabetically using selective sort
    public static void selectiveSort(String[] arr, int size) {
        for (int i = 0; i < size - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < size; j++) {
                if (arr[j].compareTo(arr[minIndex]) < 0) {
                    minIndex = j;
                }
            }
            String temp = arr[i];
            arr[i] = arr[minIndex];
            arr[minIndex] = temp;
        }
        System.out.println("Sorted Array:");
        printArray(arr);
    }

    // Implement binary search
    public static void binarySearch(String[] arr, int size) {
    	   Scanner scanner = new Scanner(System.in);
    	    String searchWord;

    	    while (true) {
    	        System.out.print("Enter a word to search (or type 'exit' to quit): ");
    	        searchWord = scanner.nextLine();

    	        if (searchWord.equalsIgnoreCase("exit")) {
    	            System.out.println("Exiting search.");
    	            break;
    	        }

    	        int result = binarySearchWord(arr, size, searchWord);
    	        if (result != -1) {
    	            System.out.println("Word '" + searchWord + "' found at index " + result);
    	        } else {
    	            System.out.println("Word '" + searchWord + "' not found in the list.");
    	        }
    	    }

    	    scanner.close();
    	}

    	// Binary search method for searching a word in the sorted array
    	public static int binarySearchWord(String[] arr, int size, String searchWord) {
    	    int left = 0;
    	    int right = size - 1;

    	    while (left <= right) {
    	        int mid = left + (right - left) / 2;
    	        int compareResult = searchWord.compareTo(arr[mid]);

    	        if (compareResult == 0) {
    	            return mid; // Word found at index mid
    	        }

    	        if (compareResult < 0) {
    	            right = mid - 1;
    	        } else {
    	            left = mid + 1;
    	        }
    	    }

    	    return -1; // Word not found
    	}	
}
