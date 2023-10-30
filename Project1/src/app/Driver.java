package app;

public class Driver {

    public static void main(String[] args) {
        // Create MyString objects
        MyString str1 = new MyString("Hello, World!");
        MyString str2 = new MyString("Hello, Java!");
        MyString str3 = new MyString(str1); // Copy constructor

        // Test basic operations
        System.out.println("str1: " + str1.toString());
        System.out.println("Length of str1: " + str1.length());

        // Concatenation
        MyString concatenatedStr = str1.concat(str2);
        System.out.println("Concatenated String: " + concatenatedStr.toString());

        // Equality check
        System.out.println("str1 equals str2? " + str1.equals(str2));
        System.out.println("str1 equals str3? " + str1.equals(str3));

        // Comparison
        System.out.println("str1 compareTo str2: " + str1.compareTo(str2));
        System.out.println("str2 compareTo str1: " + str2.compareTo(str1));
        System.out.println("str1 compareTo str3: " + str1.compareTo(str3));

        // Uppercase and lowercase
        MyString uppercaseStr = str1.toUpper();
        MyString lowercaseStr = str1.toLower();
        System.out.println("Uppercase str1: " + uppercaseStr.toString());
        System.out.println("Lowercase str1: " + lowercaseStr.toString());

        // Substring
        MyString substring1 = str1.substring(7);
        MyString substring2 = str1.substring(7, 12);
        System.out.println("Substring from index 7: " + substring1.toString());
        System.out.println("Substring from index 7 to 12: " + substring2.toString());

        // Index of
        MyString searchString = new MyString("World");
        int indexOfWorld = str1.indexOf(searchString);
        int lastIndexOfWorld = str1.lastIndexOf(searchString);
        System.out.println("Index of 'World' in str1: " + indexOfWorld);
        System.out.println("Last Index of 'World' in str1: " + lastIndexOfWorld);
	    }
	}

