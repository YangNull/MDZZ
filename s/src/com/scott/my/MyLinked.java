package com.scott.my;

/**
 * Created by scott on 2017/6/5.
 */
public class MyLinked<E> {
    /**
     * 第一个结点
     */
    private Node<E> first;
    /**
     * 最后的一个结点
     */
    private Node<E> last;

    private int size;

    public boolean add(E e) {
        linkLast(e);
        return true;
    }

    public boolean add(E e, int i) {
        addBefore(e, node(i));
        return true;
    }

    public boolean addFirst(E e) {
        linkFirst(e);
        return true;
    }

    public boolean addLast(E e) {
        linkLast(e);
        return true;
    }

    private void addBefore(E e, Node<E> refNode) {
        if (refNode == null) {
            throw new NullPointerException("refNode is null");
        }
        final Node<E> prev = refNode.prev;
        final Node<E> newNode = new Node<E>(prev, e, refNode);
        prev.next = newNode;
        refNode.prev = newNode;
        size++;
//        Node<E> targetNode = first;
//        boolean flag = false;
//        if (targetNode == null) {
//            throw new NullPointerException("first Node is null");
//        }
//        while (targetNode != null) {
//            if (targetNode.item.equals(targetE)) {
//                flag = true;
//                break;
//            }
//            targetNode = targetNode.next;
//        }
//        if (flag) {
//            final Node<E> prevNode = targetNode.prev;
//            targetNode.prev = null;
//            Node<E> newNode = new Node<E>(prevNode, e, targetNode);
//            targetNode.prev = newNode;
//        } else {
//            throw new NullPointerException("not node in the linked");
//        }
    }

    public E remove() {
        return removeFirst();
    }

    public E removeFirst() {
        Node<E> f = first;
        if (f == null) {
            throw new NullPointerException("first node is null");
        }
//        if (first != null) {
//            final Node<E> f = first;
//            Node<E> next = first.next;
//            next.prev = null;
//            first = next;
//            return f.item;
//        }
        return unLinkFirst(f);
    }

    public int getSize() {
        return size;
    }

    public E removeLast() {
        return null;
    }

    public void printNode() {
        Node<E> root = first;
        while (root != null) {
            System.out.print(root.item + "\t");
            root = root.next;
        }
        System.out.println();
    }

    private void linkFirst(E e) {
        final Node<E> f = first;
        final Node<E> newNode = new Node<E>(null, e, f);
        first = newNode;
        if (f == null) {
            last = newNode;
        } else {
            f.prev = newNode;
        }
        size++;
    }

    /**
     * 向链表后面添加内容
     *
     * @param e
     */
    private void linkLast(E e) {
        final Node<E> l = last;//保存最后的一个结点
        //上一个结点是last，下一个结点永远是null
        final Node<E> newNode = new Node<E>(l, e, null);
        last = newNode;
        if (first == null) {
            //根结点为空则将新的结点给根，第一个结点是根结点同时也是最后的一个结点
            first = newNode;
        } else {
            l.next = newNode;
        }
        size++;
    }

    public E unLinkFirst(Node<E> f) {
        final E e = f.item;
        final Node<E> next = f.next;
        f.item = null;
        f.next = null;
        first = next;
        if (next == null) {
            last = null;
        } else {
            next.prev = null;
        }
        size--;
        return e;
    }

    public E unLinkLast() {
        return null;
    }

    public Node<E> node(int index) {
        /**
         * 分而治之查找
         */
        if (index < (size >> 1)) {
            Node<E> node = first;
            for (int i = 0; i < index; i++) {
                node = node.next;
            }
            return node;
        } else {
            Node<E> node = last;
            for (int i = size - 1; i > index; i--) {
                node = node.prev;
            }
            return node;
        }
//        Node<E> node = first;
//        int i = 0;
//        while (node != null) {
//            if (i == index) {
//                break;
//            }
//            i++;
//            node = node.next;
//        }
//        return node;
    }

    public static class Node<E> {
        /**
         * 下级引用
         */
        public Node<E> next;
        /**
         * 上级引用
         */
        public Node<E> prev;
        /**
         * 数据项
         */
        public E item;

        public Node(E item) {
            this.item = item;
        }

        public Node(Node<E> prev, E item, Node<E> next) {
            this.prev = prev;
            this.item = item;
            this.next = next;
        }
    }
}
