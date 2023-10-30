package app;

public class Driver {
	 public static void main(String[] args) {
	        // Create MyString objects
	        MyString str1 = new MyString("This is a test.");
	        MyString str2 = new MyString("This is not a test.");
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
	        MyString substring1 = str1.substring(5);
	        MyString substring2 = str1.substring(7, 12);
	        System.out.println("Substring from index 5: " + substring1.toString());
	        System.out.println("Substring from index 7 to 12: " + substring2.toString());

	        // Index of
	        MyString searchString = new MyString("is");
	        int indexOfIs = str1.indexOf(searchString);
	        int lastIndexOfIs = str1.lastIndexOf(searchString);
	        System.out.println("Index of 'is' in str1: " + indexOfIs);
	        System.out.println("Last Index of 'is' in str1: " + lastIndexOfIs);
		    }
}
