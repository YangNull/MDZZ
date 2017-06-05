package com.scott.my;

/**
 * Created by scott on 2017/6/5.
 */
public class My {
    public int index = 0;

    public My() {
    }

    public static void main(String[] args) {
        MyLinked<String> myLinked = new MyLinked<String>();
        myLinked.add("A");
        myLinked.add("B");
        myLinked.add("C");
        myLinked.add("D");
        myLinked.add("E");
        myLinked.add("F");
        myLinked.add("G");
        myLinked.printNode();
        myLinked.addFirst("0");
        myLinked.printNode();
        myLinked.addLast("Z");
        myLinked.printNode();
        myLinked.add("C0", 3);
        myLinked.printNode();
        MyLinked.Node<String> node=myLinked.node(5);
        System.out.println(node.item);
    }
}
