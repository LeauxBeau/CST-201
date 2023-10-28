package app;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class main {
	public static void main(String[] args) {
		  String[] words = new String[10000];
	        int size = 0;

	        // Read strings from the file and store them in the array
	        try (BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\austi\\Desktop\\Repositories (GitHub)\\CST-201\\Project Zero\\ProjectZero\\Text"))) {
	            String line;
	            while ((line = br.readLine()) != null && size < 10000) {
	                words[size++] = line;
	            }
	        } catch (IOException e) {
	            System.err.println("Error reading the file: " + e.getMessage());
	            System.exit(1);
	        }

	        // Print the unsorted array
	        System.out.println("Unsorted Array:");
	        for (int i = 0; i < size; i++) {
	            System.out.println(words[i]);
	        }

	        // Sort the array using bubble sort
	        bubbleSort(words, size);

	        // Print the sorted array
	        System.out.println("\nSorted Array:");
	        for (int i = 0; i < size; i++) {
	            System.out.println(words[i]);
	        }

	        // Search for words using binary search
	        Scanner scanner = new Scanner(System.in);
	        while (true) {
	            System.out.print("\nEnter a word to search for (or type 'exit' to quit): ");
	            String target = scanner.nextLine();

	            if (target.equals("exit")) {
	                break;
	            }

	            int index = binarySearch(words, size, target);

	            if (index != -1) {
	                System.out.println("Word found at index: " + index);
	            } else {
	                System.out.println("Word not in the list.");
	            }
	        }
	    }

	    // Bubble sort to sort the array
	    private static void bubbleSort(String[] arr, int size) {
	        for (int i = 0; i < size - 1; i++) {
	            for (int j = 0; j < size - i - 1; j++) {
	                if (arr[j].compareTo(arr[j + 1]) > 0) {
	                    String temp = arr[j];
	                    arr[j] = arr[j + 1];
	                    arr[j + 1] = temp;
	                }
	            }
	        }
	    }

	    // Binary search to search for a word in the sorted array
	    private static int binarySearch(String[] arr, int size, String target) {
	        int left = 0;
	        int right = size - 1;

	        while (left <= right) {
	            int mid = left + (right - left) / 2;

	            int cmp = target.compareTo(arr[mid]);

	            if (cmp == 0) {
	                return mid; // Found
	            } else if (cmp < 0) {
	                right = mid - 1;
	            } else {
	                left = mid + 1;
	            }
	        }

	        return -1; // Not found
	    }
	}