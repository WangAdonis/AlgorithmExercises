package cn.adonis.algorithms.queues;

import cn.adonis.algorithms.linkedlist.LinkedList;

/**
 * Created by Wang on 2016/8/17.
 */
public class LinkedQueue<Item> extends LinkedList<Item> {

    public void enqueue(Item item){
        super.addTail(item);
    }

    public Item dequeue(){
        Item item = first.value;
        first = first.next;
        if (isEmpty()){
            last = null;
        }
        N--;
        return item;
    }

//    @Override
//    public Iterator<Item> iterator() {
//        return new LinkedQueueIterator();
//    }
//
//
//    private class LinkedQueueIterator implements Iterator<Item>{
//        private Node currentNode = first;
//        @Override
//        public boolean hasNext() {
//            return currentNode != null;
//        }
//
//        @Override
//        public Item next() {
//            Item item = (Item) currentNode.value;
//            currentNode = currentNode.next;
//            return item;
//        }
//    }
}
