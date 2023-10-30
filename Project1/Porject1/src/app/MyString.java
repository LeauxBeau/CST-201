package app;

public class MyString {
	private char[] charArray;
    private int currLength;

    // Constructors
    public MyString() {
        charArray = null;
        currLength = 0;
    }

    public MyString(String str) {
        charArray = str.toCharArray();
        currLength = str.length();
    }

    public MyString(MyString other) {
        charArray = other.charArray.clone();
        currLength = other.currLength;
    }

    // Returns the length of the string
    public int length() {
        return currLength;
    }

    // Private method to ensure capacity for the string
    private void ensureCapacity(int capacity) {
        if (charArray == null) {
            charArray = new char[capacity];
        } else if (charArray.length < capacity) {
            charArray = java.util.Arrays.copyOf(charArray, capacity);
        }
    }

    // Returns a String representation of the MyString object
    public String toString() {
        return new String(charArray, 0, currLength);
    }

    // Concatenates two MyString objects and returns a new MyString
    public MyString concat(MyString other) {
        MyString result = new MyString();
        result.ensureCapacity(currLength + other.currLength);
        System.arraycopy(charArray, 0, result.charArray, 0, currLength);
        System.arraycopy(other.charArray, 0, result.charArray, currLength, other.currLength);
        result.currLength = currLength + other.currLength;
        return result;
    }

    // Checks if this MyString is equal to another MyString
    public boolean equals(MyString other) {
        if (currLength != other.currLength) {
            return false;
        }
        for (int i = 0; i < currLength; i++) {
            if (charArray[i] != other.charArray[i]) {
                return false;
            }
        }
        return true;
    }

    // Compares this MyString with another MyString
    public int compareTo(MyString other) {
        int minLength = Math.min(currLength, other.currLength);
        for (int i = 0; i < minLength; i++) {
            if (charArray[i] != other.charArray[i]) {
                return charArray[i] - other.charArray[i];
            }
        }
        return currLength - other.currLength;
    }

    // Returns the character at a specific index
    public char get(int index) {
        if (index < 0 || index >= currLength) {
            throw new IndexOutOfBoundsException("Index out of bounds");
        }
        return charArray[index];
    }

    // Converts the MyString to uppercase
    public MyString toUpper() {
        MyString result = new MyString(this);
        for (int i = 0; i < currLength; i++) {
            result.charArray[i] = Character.toUpperCase(charArray[i]);
        }
        return result;
    }

    // Converts the MyString to lowercase
    public MyString toLower() {
        MyString result = new MyString(this);
        for (int i = 0; i < currLength; i++) {
            result.charArray[i] = Character.toLowerCase(charArray[i]);
        }
        return result;
    }

    // Returns a substring starting at the given index
    public MyString substring(int startIndex) {
        return substring(startIndex, currLength);
    }

    // Returns a substring from startIndex (inclusive) to endIndex (exclusive)
    public MyString substring(int startIndex, int endIndex) {
        if (startIndex < 0 || endIndex > currLength || startIndex > endIndex) {
            throw new IndexOutOfBoundsException("Invalid substring indices");
        }
        char[] subArray = new char[endIndex - startIndex];
        System.arraycopy(charArray, startIndex, subArray, 0, endIndex - startIndex);
        return new MyString(new String(subArray));
    }

    // Returns the starting index of the first occurrence of a substring in this MyString
    public int indexOf(MyString subString) {
        for (int i = 0; i <= currLength - subString.currLength; i++) {
            boolean found = true;
            for (int j = 0; j < subString.currLength; j++) {
                if (charArray[i + j] != subString.charArray[j]) {
                    found = false;
                    break;
                }
            }
            if (found) {
                return i;
            }
        }
        return -1; // Substring not found
    }

    // Returns the starting index of the last occurrence of a substring in this MyString
    public int lastIndexOf(MyString subString) {
        for (int i = currLength - subString.currLength; i >= 0; i--) {
            boolean found = true;
            for (int j = 0; j < subString.currLength; j++) {
                if (charArray[i + j] != subString.charArray[j]) {
                    found = false;
                    break;
                }
            }
            if (found) {
                return i;
            }
        }
        return -1; // Substring not found
    }
}
