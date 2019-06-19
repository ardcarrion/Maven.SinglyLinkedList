package com.zipcodewilmington.singlylinkedlist;
import java.util.Comparator;

/**
 * Created by leon on 1/10/18.
 */

public class SinglyLinkedList<T extends Comparable<T>> {
    private Node<T> head;
    private Node<T> tail;
    private int size;

    public SinglyLinkedList() {
        this.tail = null;
        this.head = null;
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
        if (size == 0) this.head = new Node<T>(this.tail, t);
        else {
            Node next = new Node<T>(this.head.next, this.head.data);
            this.head = new Node<T>(next, t);
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
            T data = (T)currentNode.data;
            if (data.equals(t)) return true;
        }
        return false;
    }

    public int find(int index) throws IndexOutOfBoundsException {
        checkValidIndex(index);
        Node currentNode = this.head;
        int i = 0;
        while (currentNode != null) {
            if (i == index) return index;
        }
        return -1;
    }

    public int size() {
        return this.size;
    }
    
    public T get(int index) throws IndexOutOfBoundsException {
        checkValidIndex(index);
        T foundData = null;
        Node currentNode = this.head;
        int i = 0;
        while (currentNode != null) {
            if (i == index) {
                foundData = (T)currentNode.data;
                break;
            }
        }
        return foundData;
    }

    public SinglyLinkedList<T> copy() {return this; }

    public void sort() {}

    private void checkValidIndex(int index) throws IndexOutOfBoundsException {
        if (index < 0 | index >= size) throw new IndexOutOfBoundsException();
    }

}
