package app;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;

class HashTable {
    private static final int TABLE_SIZE = 1000;  
    private LinkedList<String>[] table;

    public HashTable() {
        table = new LinkedList[TABLE_SIZE];
        for (int i = 0; i < TABLE_SIZE; i++) {
            table[i] = new LinkedList<>();
        }
    }

    private int hashFunction(String word) {
        return word.length() % TABLE_SIZE;
    }

    public void insert(String word) {
        int index = hashFunction(word);
        table[index].add(word);
    }

    public SearchResult search(String word) {
        int index = hashFunction(word);
        LinkedList<String> bucket = table[index];

        int elementsInspected = 0;

        for (String w : bucket) {
            elementsInspected++;
            if (w.equals(word)) {
                return new SearchResult(true, elementsInspected);
            }
        }

        return new SearchResult(false, elementsInspected);
    }
}

class SearchResult {
    private boolean found;
    private int elementsInspected;

    public SearchResult(boolean found, int elementsInspected) {
        this.found = found;
        this.elementsInspected = elementsInspected;
    }

    public boolean isFound() {
        return found;
    }

    public int getElementsInspected() {
        return elementsInspected;
    }
}

public class Main {
    public static void main(String[] args) {
        HashTable hashTable = new HashTable();

        
        try (BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\austi\\Desktop\\Repositories (GitHub)\\CST-201\\Project 7\\Project7\\textt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] words = line.split("\\s+");
                for (String word : words) {
                    hashTable.insert(word);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

       
        
        String[] searchWords = {"it", "this", "him"};

        for (String word : searchWords) {
            SearchResult result = hashTable.search(word);
            System.out.println("Word: " + word + ", Found: " + result.isFound() +
                    ", Elements Inspected: " + result.getElementsInspected());
        }
    }
}
