package cn.adonis.algorithms.linkedlist;



import cn.adonis.algorithms.node.Node;
import cn.adonis.algorithms.exception.IllegalIndexException;

import java.util.Iterator;
import java.util.Random;

/**
 * Created by Wang on 2016/8/17.
 */
public class LinkedList<Item> implements Iterable<Item>{
    protected int N = 0;

    public Node<Item> getFirst() {
        return first;
    }

    public Node<Item> getLast() {
        return last;
    }

    protected Node<Item> first;
    protected Node<Item> last;

    public int size(){
        return N;
    }

    public boolean isEmpty(){
        return N==0;
    }

    public void insertAfter(int index, Item item) throws IllegalIndexException{
        if (index == 0){
            addHead(item);
        }else if (index == N){
            addTail(item);
        }else {
            Node<Item> node = getNode(index);
            Node<Item> nextNode = node.next;
            Node<Item> newNode = new Node<Item>();
            newNode.previous = node;
            newNode.next = nextNode;
            newNode.value = item;
            node.next = nextNode;
            nextNode.previous = newNode;
            N++;
        }
    }

    public void addHead(Item item){
        Node<Item> oldFirst = first;
        first = new Node<Item>();
        first.previous = null;
        first.next = oldFirst;
        first.value = item;
        if (isEmpty())
            last = first;
        N++;
    }

    public void addTail(Item item){
        Node<Item> oldLast = last;
        last = new Node<Item>();
        last.previous = oldLast;
        last.next = null;
        last.value = item;
        if (isEmpty()){
            first = last;
        }else {
            oldLast.next = last;
        }
        N++;
    }

    public void deleteTail(){
        Node<Item> newLast = last.previous;
        newLast.next = null;
        last = newLast;
        N--;
    }

    public void delete(int index) throws IllegalIndexException{
        Node<Item> deleteNode = getNode(index);
        Node<Item> preNode = deleteNode.previous;
        Node<Item> nextNode = deleteNode.next;
        preNode.next = nextNode;
        nextNode.previous = preNode;
        deleteNode = null;
        N--;
    }

    public void delete(Node<Item> deleteNode){
        Node<Item> preNode = deleteNode.previous;
        Node<Item> nextNode = deleteNode.next;
        if(deleteNode!=first)
            preNode.next = nextNode;
        else
            first = nextNode;
        if(deleteNode!=last)
            nextNode.previous = preNode;
        else
            preNode.next = null;
        deleteNode = null;
        N--;
    }

    public int find(Item item){
        Node<Item> n = first;
        for (int i = 0;i<N;i++){
            if (item.equals(n.value))
                return i+1;
            n = n.next;
        }
        return -1;
    }

    public Node getNode(int index) throws IllegalIndexException{
        Node<Item> n = first;
        if(index==0||index>N){
            throw new IllegalIndexException("illegal index references");
        }else if (index==1){
            return n;
        }else {
            for (int i=1; i<index;i++){
                n = n.next;
            }
            return n;
        }
    }

    public void remove(Item item){
        Node<Item> n = first;
        while (n!=null){
            if (item.equals(n.value))
                delete(n);
            n = n.next;
        }
    }

    public Item getValue(int index) throws IllegalIndexException{
        return (Item) getNode(index).value;
    }

    public void removeAfter(int index) throws IllegalIndexException{
        Node<Item> node = getNode(index);
        Node<Item> nextNode=node.next;
        nextNode.previous = null;
        node.next = null;
    }

    public int max(Node node, int maxValue){
        if (node !=null) {
            //if (node.value instanceof Integer) {
                if ((int)node.value > maxValue)
                    return max(node.next, (int)node.value);
                else
                    return max(node.next, maxValue);
            //}
        }else{
            return maxValue;
        }
    }

//    public Item[] toArray(){
//        Item[] items = (Item[]) new Object[N];
//        Node<Item> n = first;
//        for (int i=0; i<N; i++){
//            items[i] = n.value;
//            n = n.next;
//        }
//        return items;
//    }

    public Object[] toArray(){
        Object[] items =  new Object[N];
        Node<Item> n = first;
        for (int i=0; i<N; i++){
            items[i] = n.value;
            n = n.next;
        }
        return items;
    }

    public Object[] shuffle (Object[] items){
        Random random = new Random(System.currentTimeMillis());
        int capacity = items.length;
        for (int i=0; i<capacity; i++){
            int index = random.nextInt(capacity);
            Object temp = items[index];
            items[index] = items[i];
            items[i] = temp;
        }
        return  items;
    }

//    public int max(Node node){
//        if (node !=null) {
//            //if (node.value instanceof Integer) {
//            if ((int)node.value > max(node.next))
//                return max(node.next);
//            else
//        }else {
//            return 0;
//        }
//    }

    @Override
    public Iterator<Item> iterator() {
        return new LinkedListIterator();
    }

//    public class Node{
//        private Node previous;
//        private Node next;
//        private Item value;
//    }

    private class LinkedListIterator implements Iterator<Item>{
        private Node currentNode = first;
        @Override
        public boolean hasNext() {
            return currentNode != null;
        }

        @Override
        public Item next() {
            Item item = (Item) currentNode.value;
            currentNode = currentNode.next;
            return item;
        }
    }


}
