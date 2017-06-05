package com.scott.my;

/**
 * Created by scott on 2017/6/5.
 */
public class MyLinkedList<E> {
    transient int size = 0;
    transient Node<E> first;
    transient Node<E> last;

    public MyLinkedList() {

    }

    public boolean add(E e) {
        linkNode(e);
        return true;
    }

    public void linkNode(E e) {
        final Node<E> l = last;
        final Node<E> newNode = new Node<E>(l, e, null);
        last = newNode;
        if (l == null) {
            first = newNode;
        } else {
            l.next = newNode;
        }
        size++;
    }

    public static class Node<E> {
        E item;
        Node<E> prev;
        Node<E> next;

        public Node(Node<E> prev, E item, Node<E> next) {
            this.item = item;
            this.prev = prev;
            this.next = next;
        }
    }
}
