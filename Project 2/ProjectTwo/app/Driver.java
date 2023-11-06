package app;


public class Driver {
    public static void main(String[] args) {
        SinglyLinkedList<Integer> myList = new SinglyLinkedList<>();
        myList.insert(5);
        myList.insert(3);
        myList.insert(8);

        System.out.println("Front element: " + myList.front());
        System.out.println("Back element: " + myList.back());
        System.out.println("Size: " + myList.size());

        myList.pop_front();
        myList.pop_back();

        System.out.println("After popping front and back:");
        System.out.println("Front element: " + myList.front());
        System.out.println("Back element: " + myList.back());
        System.out.println("Size: " + myList.size());

        myList.reverse();
        System.out.println("Reversed List:");
        System.out.println("Front element: " + myList.front());
        System.out.println("Back element: " + myList.back());
        System.out.println("Size: " + myList.size());

        SinglyLinkedList<Integer> anotherList = new SinglyLinkedList<>(myList);
        System.out.println("Copied List:");
        System.out.println("Front element: " + anotherList.front());
        System.out.println("Back element: " + anotherList.back());
        System.out.println("Size: " + anotherList.size());

        myList.merge(anotherList);
        System.out.println("Merged List:");
        System.out.println("Front element: " + myList.front());
        System.out.println("Back element: " + myList.back());
        System.out.println("Size: " + myList.size());
    }
}

