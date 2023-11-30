package app;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

class Node {
    String data;
    Node left, right;

    public Node(String item) {
        data = item;
        left = right = null;
    }
}

class BinarySearchTree {
    private Node root;

    public BinarySearchTree() {
        root = null;
    }

    public void insert(String key) {
        root = insertRec(root, key);
    }

    private Node insertRec(Node root, String key) {
        if (root == null) {
            root = new Node(key);
            return root;
        }

        int compareResult = key.compareTo(root.data);

        if (compareResult < 0) {
            root.left = insertRec(root.left, key);
        } else if (compareResult > 0) {
            root.right = insertRec(root.right, key);
        }

        return root;
    }

    public void inOrderTraversal() {
        inOrderTraversal(root);
    }

    private void inOrderTraversal(Node root) {
        if (root != null) {
            inOrderTraversal(root.left);
            System.out.print(root.data + " ");
            inOrderTraversal(root.right);
        }
    }

    public boolean search(String key) {
        return searchRec(root, key);
    }

    private boolean searchRec(Node root, String key) {
        if (root == null) {
            return false;
        }

        int compareResult = key.compareTo(root.data);

        if (compareResult == 0) {
            return true;
        } else if (compareResult < 0) {
            return searchRec(root.left, key);
        } else {
            return searchRec(root.right, key);
        }
    }

    public void remove(String key) {
        root = removeRec(root, key);
    }

    private Node removeRec(Node root, String key) {
        if (root == null) {
            return root;
        }

        int compareResult = key.compareTo(root.data);

        if (compareResult < 0) {
            root.left = removeRec(root.left, key);
        } else if (compareResult > 0) {
            root.right = removeRec(root.right, key);
        } else {
            if (root.left == null) {
                return root.right;
            } else if (root.right == null) {
                return root.left;
            }

            root.data = minValue(root.right);

            root.right = removeRec(root.right, root.data);
        }

        return root;
    }

    private String minValue(Node root) {
        String minValue = root.data;
        while (root.left != null) {
            minValue = root.left.data;
            root = root.left;
        }
        return minValue;
    }
}

public class Main {
    public static void main(String[] args) {
        BinarySearchTree bst = new BinarySearchTree();

        // Read text from file and insert into BST
        try (BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\austi\\Desktop\\Repositories (GitHub)\\CST-201\\Project 6\\Project6\\inputText"))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] words = line.split("\\s+");
                for (String word : words) {
                    // Ensure that duplicate words are not inserted
                    if (!bst.search(word)) {
                        bst.insert(word);
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Print contents of the tree using in-order traversal
        System.out.println("Contents of the tree:");
        bst.inOrderTraversal();
        System.out.println();

        // Search for words entered by the user
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter words to search (separated by space):");
        String[] searchWords = scanner.nextLine().split("\\s+");
        for (String word : searchWords) {
            boolean found = bst.search(word);
            System.out.println(word + " found: " + found);
        }

        // Remove words entered by the user and print the updated tree
        System.out.println("Enter words to remove (separated by space):");
        String[] removeWords = scanner.nextLine().split("\\s+");
        for (String word : removeWords) {
            bst.remove(word);
            System.out.println("Contents of the tree after removing " + word + ":");
            bst.inOrderTraversal();
            System.out.println();
        }
    }
}

