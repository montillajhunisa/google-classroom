package googleclassroom;

import java.util.NoSuchElementException;
import java.util.Objects;

public class MySinglyLinkedList <T> {
    private int size;
    Node <T> head;

    Node <T> tail;
    T data;

    public int getSize() {
        int size = 0;
        Node <T> node = head;

        while (node != null) {
            if (node.getData() != null) {
                size++;
            }
            node = node.getNext();
        }
        return size;
    }



    public void add(T data){
        Node<T> newNode = new Node<>(data);

        if (head == null) {
            head = newNode;

        } else {
            tail.setNext(newNode);
        }
        tail = newNode;

    }


    public T getElement(T data) throws NoSuchElementException {
        var current = head;
        try { // in cases where user decides to get an element before even inserting one
            if (Objects.deepEquals(tail.getData(), data)) {
                System.out.println("The announcement has been found! You can now reuse this post.");
                System.out.println("The announcement has been reposted!\n");
                return tail.getData();
            }
        /* While head is not null and is not equal to tail, get head's
           next value and compare to the data being fetched until both
           are equal, then return head
         */
            try {
                while (current != null && current != tail) {
                    if (Objects.deepEquals(current.getData(), data)) {
                        System.out.println("The announcement has been found! You can now reuse this post.");
                        System.out.println("The announcement has been reposted!\n");
                        return current.getData();
                    } else {
                        throw new NoSuchElementException();
                    }
                }
            } catch (NoSuchElementException e) {
                System.out.print("Element '" + data + "' was not found! " + e + "\n\n");
            }
        } catch (NullPointerException e) {
            System.out.println("The List is Empty! Exception Occurred: " + e + "\n\n");
        }
        return (T) current;
    }


    public boolean delete(T data) {
        boolean value = false;
        try {
            if (head != null) {
                var prevNode = (Node<T>) null;
                var current = head;

                while (current != null) {
                    if (Objects.deepEquals(current.getData(), data)) {
                        if (prevNode != null) {
                            prevNode.setNext(current.getNext());
                        }

                        if (head == current) {
                            head = current.getNext();
                        }

                        if (tail == current){
                            tail = prevNode;
                        }
                        size--;

                        value = true;
                        break;
                    }
                    prevNode = current;
                    current = current.getNext();
                }
            }
        } catch (NullPointerException e) {
            System.out.println("The List is Empty! Exception Occurred: " + e);
        }
        return value;
    }


    public boolean search (T data) {
        boolean isThere = false;
        try {   // in cases where user decides to search for an element before even inserting one
            Node<T> node = head;

            for (int i = 0; node.getData() != data && node.getNext() != null; i++) {
                node = node.getNext();
            }
            if (node.getData() == data) {
                isThere = true;
            }
        } catch (NullPointerException e) {
            System.out.println("The List is Empty! Exception Occurred: " + e);
        }
        return isThere;
    }

    public void print(){
        Node <T> node = head;
        if(node == null) {
            System.out.println("No classes found!");
        }
        while (node != null) {
            System.out.println(node.getData());
            node = node.getNext();
        }
    }
}
