package com.zipcodewilmington.singlylinkedlist;
import java.util.Comparator;
import java.util.List;


/**
 * Created by leon on 1/10/18.
 */

/**
 * Null terminated singly linked list
 * @param <T> must extend Comparable for sorting
 */
public class SinglyLinkedList<T extends Comparable<T>> {
    private Node<T> head;
    private Node<T> last;
    private int size;

    public SinglyLinkedList() {
        this.head = null;
        this.last = null;
        this.size = 0;
    }

    public class Node<T> {
        Node next;
        T data;

        Node(Node next, T data) {
            this.next = next;
            this.data = data;
        }
    }

    public void add(T t) {
        Node newNode = new Node<T>(null, t);
        if (size == 0) {
            this.head = newNode;
            this.last = this.head;
        }
        else {
            Node prevLast = this.last;
            this.last = newNode;
            prevLast.next = this.last;
        }
        this.size++;
    }

    public void remove(int index) throws IndexOutOfBoundsException{
        checkValidIndex(index);
        if (index == 0) {
            this.head = this.head.next;
        } else {
            Node prevNode = this.head;
            Node currentNode = this.head.next;
            int i = 1;
            while (currentNode != null) {
                if (i == index) {
                    prevNode.next = currentNode.next;
                    break;
                }
                currentNode = currentNode.next;
            }
        }
        this.size--;
    }

    public boolean contains(T t) {
        Node currentNode = this.head;
        while (currentNode != null) {
            if (currentNode.data.equals(t)) return true;
            currentNode = currentNode.next;
        }
        return false;
    }

    public int find(T t) {
        Node currentNode = this.head;
        int i = 0;
        while (currentNode != null) {
            if (currentNode.data.equals(t)) return i;
            currentNode = currentNode.next;
            i++;
        }
        return -1;
    }

    public int size() {
        return this.size;
    }

    public T get(int index) throws IndexOutOfBoundsException {
        checkValidIndex(index);
        Node currentNode = this.head;
        int i = 0;
        while (currentNode != null) {
            if (i == index) return  (T)currentNode.data;
            currentNode = currentNode.next;
            i++;
        }
        return null;
    }

    public SinglyLinkedList<T> reverse() {
        return null;
    }

    public SinglyLinkedList<T> copy() {
        return this; }

    public void sort(Comparable comparable) {

    }

    private void checkValidIndex(int index) throws IndexOutOfBoundsException {
        if (index < 0 | index >= size) throw new IndexOutOfBoundsException();
    }


}
