package app;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class main {
    public static void main(String[] args) {
        String fileName = "C:\\Users\\austi\\Desktop\\Repositories (GitHub)\\CST-201\\Project Zero\\ProjectZero\\Text"; // Change this to the path of your input file
        int capacity = 10000; // Capacity for the string array

        try {
            // Open the file for reading
            BufferedReader br = new BufferedReader(new FileReader(fileName));

            String[] stringArray = new String[capacity];
            int stringCount = 0;

            // Read the file line by line
            String line;
            while ((line = br.readLine()) != null) {
                // Store each line as a string in the array
                stringArray[stringCount] = line;
                stringCount++;

                // Check if the array is full
                if (stringCount == capacity) {
                    System.err.println("Maximum capacity reached. Exiting.");
                    break;
                }
            }

            // Close the file
            br.close();

            // Print the stored strings
            for (int i = 0; i < stringCount; i++) {
                System.out.println(stringArray[i]);
            }
        } catch (IOException e) {
            System.err.println("An error occurred: " + e.getMessage());
        }
    }
}
