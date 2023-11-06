package app;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * provided file for DLinkedList Assignment 
 *
 * @author lkfritz
 */
public class DLinkedList<T extends Comparable<T>> {

    public static void main(String[] args) throws FileNotFoundException {
    	DLinkedList<String> lst1 = new DLinkedList<>();
        DLinkedList<String> lst2 = new DLinkedList<>();        

        Scanner fin = new Scanner(new File("C:\\Users\\austi\\Desktop\\Repositories (GitHub)\\CST-201\\Project 3\\Project3\\Text1.txt"));
        String str;

        while (fin.hasNext()) {
            str = fin.next();
            str = cleanUp(str);           
            lst1.insertOrderUnique(str);           
        }
        fin.close();

        fin = new Scanner(new File("C:\\Users\\austi\\Desktop\\Repositories (GitHub)\\CST-201\\Project 3\\Project3\\Text2.txt"));
        while (fin.hasNext()) {
            str = fin.next();
            str = cleanUp(str);
            lst2.insertOrderUnique(str);           
        }

        System.out.println("List 1:  " + lst1);
        System.out.println("List 2:  " + lst2);
        
        
        DLinkedList combined = lst1.merge(lst2);
        
        System.out.println("\nAFTER MERGE");
        System.out.println("List 1:  " + lst1);
        System.out.println("List 2:  " + lst2);
        System.out.println("\n" + combined);
    }

    /**
     * ASSIGNED
     * @param str
     * @return str in all lower case with LEADING and TRAILING non-alpha
     * chars removed
     */
    public static String cleanUp(String str) {
        str = str.toLowerCase().replaceAll("^[^a-z]+|[^a-z]+$", "");
        return str;
    }

    //inner DNode class:  PROVIDED
    private class DNode {

        private DNode next, prev;
        private T data;

        private DNode(T val) {
            this.data = val;
            next = prev = this;
        }
    }

    //DLinkedList fields:  PROVIDED
    private DNode header;

    //create an empty list:  PROVIDED
    public DLinkedList() {
        header = new DNode(null);
    }

    /**
     * PROVIDED add
     *
     * @param item return ref to newly inserted node
     */
    public DNode add(T item) {
        //make a new node
        DNode newNode = new DNode(item);
        //update newNode
        newNode.prev = header;
        newNode.next = header.next;
        //update surrounding nodes
        header.next.prev = newNode;
        header.next = newNode;
        return newNode;
    }

    //PROVIDED
    public String toString() {
        String str = "[";
        DNode curr = header.next;
        while (curr != header) {
            str += curr.data + " ";
            curr = curr.next;
        }
        str = str.substring(0, str.length() - 1);
        return str + "]";
    }

    /**
     * ASSIGNED
     * remove val from the list
     *
     * @param val
     * @return true if successful, false otherwise
     */
    public boolean remove(T val) {
    	DNode curr = header.next;
        while (curr != header) {
            if (curr.data.equals(val)) {
                curr.prev.next = curr.next;
                curr.next.prev = curr.prev;
                return true;
            }
            curr = curr.next;
        }
        return false;
    }    
            

    /**
     * ASSIGNED
     *
     * @param item
     */
    public void insertOrder(T item) {
    	 DNode newNode = new DNode(item);
    	    DNode curr = header.next;
    	    while (curr != header && item.compareTo(curr.data) > 0) {
    	        curr = curr.next;
    	    }
    	    newNode.prev = curr.prev;
    	    newNode.next = curr;
    	    curr.prev.next = newNode;
    	    curr.prev = newNode;
    	}       
 

    /**
     * ASSIGNED
     *
     * @param item
     */
    public boolean insertOrderUnique(T item) {
    	  DNode curr = header.next;
    	    while (curr != header) {
    	        int comparison = item.compareTo(curr.data);
    	        if (comparison == 0) {
    	            return false; // Item is not unique
    	        } else if (comparison < 0) {
    	            break;
    	        }
    	        curr = curr.next;
    	    }
    	    DNode newNode = new DNode(item);
    	    newNode.prev = curr.prev;
    	    newNode.next = curr;
    	    curr.prev.next = newNode;
    	    curr.prev = newNode;
    	    return true;
    	}

    /**
     * ASSIGNED
     * PRE:  this and rhs are sorted lists
     * @param rhs
     * @return list that contains this and rhs merged into a sorted list
     * POST:  returned list will not contain duplicates
     */
    public DLinkedList merge(DLinkedList rhs) {
        DLinkedList result = new DLinkedList();
        DNode left = this.header.next;
        DNode right = rhs.header.next;

        while (left != this.header && right != rhs.header) {
            if (left.data.compareTo(right.data) < 0) {
                result.add(left.data);
                left = left.next;
            } else if (left.data.compareTo(right.data) > 0) {
                result.add(right.data);
                right = right.next;
            } else {
                // Skip duplicates
                left = left.next;
                right = right.next;
            }
        }

        while (left != this.header) {
            result.add(left.data);
            left = left.next;
        }

        while (right != rhs.header) {
            result.add(right.data);
            right = right.next;
        }

        // Empty the original lists
        this.header.next = this.header.prev = this.header;
        rhs.header.next = rhs.header.prev = rhs.header;

        return result;
    }

}
        


