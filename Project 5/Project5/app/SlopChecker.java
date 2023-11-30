package app;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class SlopChecker {

    public static boolean isSlip(String str) {
        // Implement the logic for checking if str is a Slip
       
        if (str.isEmpty()) {
            return false;
        }

        if (str.charAt(0) == 'D' || str.charAt(0) == 'E') {
            int countF = 0;
            int index = 1;

            // Count consecutive 'F's
            while (index < str.length() && str.charAt(index) == 'F') {
                countF++;
                index++;
            }

            // After 'F's, it should be either a Slip or 'G'
            if (countF > 0) {
                return isSlip(str.substring(index));
            } else if (str.charAt(index) == 'G') {
                return true;
            }
        }

        return false;
    }

    public static boolean isSlap(String str) {
        // Implement the logic for checking if str is a Slap
        
        if (str.isEmpty()) {
            return false;
        }

        if (str.length() == 2 && str.charAt(1) == 'H') {
            return true;
        } else if (str.charAt(0) == 'A') {
            if (str.length() == 2 && str.charAt(1) == 'H') {
                return true;
            } else if (str.charAt(1) == 'B') {
                int indexC = str.indexOf('C', 2);

                if (indexC != -1) {
                    return isSlap(str.substring(2, indexC)) && str.charAt(indexC + 1) == 'C';
                }
            } else if (isSlip(str.substring(1))) {
                int indexC = str.indexOf('C', 1);

                if (indexC != -1) {
                    return true;
                }
            }
        }

        return false;
    }

    public static boolean isSlop(String str) {
        // Implement the logic for checking if str is a Slop
       
        if (str.isEmpty()) {
            return false;
        }

        if (str.charAt(0) == 'A') {
            if (str.length() == 2 && str.charAt(1) == 'H') {
                return false;
            } else {
                int indexC = str.indexOf('C', 1);
                if (indexC != -1) {
                    return isSlap(str.substring(0, indexC + 1)) && isSlip(str.substring(indexC + 1));
                }
            }
        }

        return false;
    }


    public static void main(String[] args) {
        // Read input from the file
        try {
            File inputFile = new File("C:\\Users\\austi\\Desktop\\Repositories (GitHub)\\CST-201\\Project 5\\Project5\\inputText");
            Scanner scanner = new Scanner(inputFile);

            int N = scanner.nextInt();
            scanner.nextLine();

            // Output header
            System.out.println("SLOPS OUTPUT");

            for (int i = 0; i < N; ++i) {
                // Read each string from the file
                String inputStr = scanner.next();

                // Check if the string is a Slop and output YES or NO
                if (isSlop(inputStr)) {
                    System.out.println("YES");
                } else {
                    System.out.println("NO");
                }
            }

            // Output footer
            System.out.println("END OF OUTPUT");

            // Close the scanner
            scanner.close();
        } catch (FileNotFoundException e) {
            System.err.println("Error opening input file.");
            e.printStackTrace();
        }
    }
}

