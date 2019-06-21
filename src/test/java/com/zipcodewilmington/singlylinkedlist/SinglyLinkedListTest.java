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
        Integer j = 10;
        sll.add(j);
        Assert.assertTrue(sll.contains(1));
        Assert.assertTrue(sll.contains(10));
    }

    @Test
    public void contains2() {
        SinglyLinkedList<String> why = new SinglyLinkedList();
        String s = "s";
        String t = "t";
        String u = "u";
        why.add(s);
        why.add(t);
        why.add(u);
        Assert.assertTrue(why.contains("u"));
        Assert.assertTrue(why.contains(u));
    }

    @Test
    public void find() {
        SinglyLinkedList sll2 = new SinglyLinkedList();
        Integer i = 10;
        sll2.add(i);
        Assert.assertTrue(sll2.contains(i));
        int actual = sll2.find(10);
        Assert.assertEquals(0, actual);
    }

    @Test
    public void find2() {
        SinglyLinkedList sll2 = new SinglyLinkedList();
        Integer i = 10;
        Integer j = 20;
        Integer k = 30;
        sll2.add(i);
        sll2.add(j);
        sll2.add(k);
        int actual = sll2.find(5);
        Assert.assertEquals(-1, actual);
    }

    @Test
    public void find3() {
        SinglyLinkedList<String> why = new SinglyLinkedList();
        String s = "s";
        String t = "t";
        String u = "u";
        why.add(s);
        why.add(t);
        why.add(u);
        int expected = 2;
        int actual = why.find(u);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void size() {
        SinglyLinkedList sll = new SinglyLinkedList();
        Integer i = 1;
        sll.add(i);
        Integer j = 2;
        sll.add(j);
        sll.remove(1);
        Assert.assertEquals(sll.size(), 1);
    }

    @Test
    public void get() {
        SinglyLinkedList sll = new SinglyLinkedList();
        Integer i = 1;
        sll.add(i);
        Assert.assertEquals(i, sll.get(0));
    }

    @Test
    public void get2() {
        SinglyLinkedList sll = new SinglyLinkedList();
        Integer i = 1;
        Integer j = 2;
        Integer k = 3;
        sll.add(i);
        sll.add(j);
        sll.add(k);
        Assert.assertEquals(k, sll.get(2));
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
