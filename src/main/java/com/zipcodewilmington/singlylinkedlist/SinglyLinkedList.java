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

    public SinglyLinkedList(int size) {
        this.size = size;
        this.head = new Node<T>(null, null);
        Node currentNode = this.head;
        for (int i = 0; i < size; i++) {
            currentNode.next = new Node(null, null);
            currentNode = currentNode.next;
        }
        this.last = currentNode;

    }


    public SinglyLinkedList() {
        this.head = null;
        this.last = null;
        this.size = 0;
    }

    public class Node<T> {
        Node<T> next;
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
        SinglyLinkedList<T> reversed = new SinglyLinkedList<T>(this.size);
        Node reverseNode = reversed.head;
        int i = this.size-1;
        while (reverseNode != null && i >= 0) {
            reverseNode.data = this.get(i);
            reverseNode = reverseNode.next;
            i--;
        }
        return reversed;
    }

    public SinglyLinkedList<T> copy() {
        SinglyLinkedList<T> duplicated = new SinglyLinkedList<T>(this.size);
        Node originalNode = this.head;
        Node copyNode = duplicated.head;
        while (originalNode != null) {
            copyNode.data = originalNode.data;
            originalNode = originalNode.next;
            copyNode = copyNode.next;
        }
        return duplicated;
    }

    public void sort() {
        if (size <= 1) return;
        Node currentNode = this.head;
        Node nextNode = this.head.next;
        while (!isSorted(this)) {
            T value = (T)currentNode.data;
            T nextValue = (T)nextNode.data;
            if (value.compareTo(nextValue) > 0) {
                currentNode.data = nextValue;
                nextNode.data = value;
            }
            currentNode = nextNode;
            if (nextNode.equals(last))  nextNode = this.head;
            else nextNode = nextNode.next;
        }
    }

    protected static Boolean isSorted(SinglyLinkedList sll) {
        for (int i =0; i < sll.size-1; i++) {
            if (sll.get(i).compareTo(sll.get(i+1)) > 0) return false;
        }
        return true;
    }

    private void checkValidIndex(int index) throws IndexOutOfBoundsException {
        if (index < 0 | index >= size) throw new IndexOutOfBoundsException();
    }


}
