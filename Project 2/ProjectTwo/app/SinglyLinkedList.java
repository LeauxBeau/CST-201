package app;

public class SinglyLinkedList<T> {
    private Node<T> front;
    private Node<T> tail;
    private int size;

    public SinglyLinkedList() {
        front = null;
        tail = null;
        size = 0;
    }

    public SinglyLinkedList(SinglyLinkedList<T> aList) {
        this();
        Node<T> current = aList.front;
        while (current != null) {
            insert(current.getData());
            current = current.getNext();
        }
    }

    public void insert(T val) {
        Node<T> newNode = new Node<>(val);
        if (front == null) {
            front = newNode;
            tail = newNode;
        } else {
            tail.setNext(newNode);
            tail = newNode;
        }
        size++;
    }

    public void pop_front() {
        if (front != null) {
            front = front.getNext();
            size--;
            if (size == 0) {
                tail = null;
            }
        }
    }

    public void pop_back() {
        if (front != null) {
            if (front == tail) {
                front = null;
                tail = null;
                size = 0;
            } else {
                Node<T> current = front;
                while (current.getNext() != tail) {
                    current = current.getNext();
                }
                current.setNext(null);
                tail = current;
                size--;
            }
        }
    }

    public T front() {
        return (front != null) ? front.getData() : null;
    }

    public T back() {
        return (tail != null) ? tail.getData() : null;
    }

    public boolean empty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    public void reverse() {
        Node<T> prev = null;
        Node<T> current = front;
        Node<T> next;
        while (current != null) {
            next = current.getNext();
            current.setNext(prev);
            prev = current;
            current = next;
        }
        tail = front;
        front = prev;
    }

    public void merge(SinglyLinkedList<T> aList) {
        if (aList.front != null) {
            if (front == null) {
                front = aList.front;
                tail = aList.tail;
            } else {
                tail.setNext(aList.front);
                tail = aList.tail;
            }
            size += aList.size;
        }
    }

    // Node class
    private static class Node<T> {
        private T data;
        private Node<T> next;

        public Node(T data) {
            this.data = data;
            this.next = null;
        }

        public T getData() {
            return data;
        }

        public Node<T> getNext() {
            return next;
        }

        public void setNext(Node<T> next) {
            this.next = next;
        }
    }
}
