package cn.adonis.algorithms.stacks;

import java.util.Iterator;

/**
 * Created by Wang on 2016/8/16.
 */
public class LinkedStack<Item> implements Iterable<Item>{
    private int N = 0;
    private Node first;

    public void push(Item item){
        Node oldFirst = first;
        first = new Node();
        first.next = oldFirst;
        first.value = item;
        N++;
    }

    public Item pop(){
        Item item = first.value;
        first = first.next;
        N--;
        return item;
    }

    public int size(){
        return N;
    }

    public boolean isEmpty(){
        return N==0;
    }

    private class Node{
        Node next;
        Item value;
    }

    @Override
    public Iterator<Item> iterator() {
        return new LinkedStackIterator();
    }

    private class LinkedStackIterator implements Iterator<Item>{
        private Node currentNode = first;
        @Override
        public boolean hasNext() {
            return currentNode!=null;
        }

        @Override
        public Item next() {
            Item item = currentNode.value;
            currentNode = currentNode.next;
            return item;
        }
    }
}
