package com.zipcodewilmington.singlylinkedlist;

import org.junit.Assert;
import org.junit.Test;
import org.junit.Assert.*;

/**
 * Created by leon on 1/10/18.
 */
public class SinglyLinkedListTest {
    @Test
    public void add() {
        SinglyLinkedList<Integer> sll = new SinglyLinkedList<Integer>();
        Integer i = 1;
        sll.add(i);
        Assert.assertEquals(sll.size(), 1);
        Assert.assertEquals(sll.get(0), i);
    }
    @Test
    public void add2() {
        SinglyLinkedList<Integer> sll = new SinglyLinkedList<Integer>();
        Integer i = 1;
        sll.add(i);
        Integer j = 2;
        Integer k = 3;
        Integer x = 4;
        sll.add(j);
        sll.add(k);
        sll.add(x);
        Assert.assertEquals(sll.size(), 4);
       // Assert.assertEquals(sll.get(0), i);
    }

    @Test
    public void remove() {
        SinglyLinkedList sll = new SinglyLinkedList();
        Integer i = 1;
        sll.add(i);
        sll.remove(0);
        Assert.assertEquals(sll.size(), 0);
    }

    @Test
    public void contains() {
        SinglyLinkedList sll = new SinglyLinkedList();
        Integer i = 1;
        sll.add(i);
        Assert.assertTrue(sll.contains(i));
    }

    @Test
    public void find() {
        SinglyLinkedList sll = new SinglyLinkedList();
        Integer i = 10;
        sll.add(i);
        Assert.assertEquals(0, sll.find(0));
        Assert.assertEquals(-1, sll.find(1));
    }

    @Test
    public void size() {
        SinglyLinkedList sll = new SinglyLinkedList();
        Integer i = 1;
        sll.add(i);
        Integer j = 2;
        sll.add(j);
        sll.remove(j);
        Assert.assertEquals(sll.size(), 1);
    }

    @Test
    public void get() {
        SinglyLinkedList sll = new SinglyLinkedList();
        Integer i = 1;
        sll.add(i);
        Integer j = 2;
        sll.add(j);
        Assert.assertEquals(sll.get(0), i);
    }

    @Test
    public void copy() {
        SinglyLinkedList sll = new SinglyLinkedList();
    }

    @Test
    public void sort() {
        SinglyLinkedList sll = new SinglyLinkedList();
    }
}
