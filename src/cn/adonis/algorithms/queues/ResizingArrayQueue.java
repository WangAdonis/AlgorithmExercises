package cn.adonis.algorithms.queues;

import java.util.Iterator;

/**
 * Created by chun on 2016/8/16.
 */
public class ResizingArrayQueue<Item> implements Iterable {
    private int N = 0;
    private Item[] queue = (Item[]) new Object[10];

    public int size(){
        return N;
    }

    public boolean isEmpty(){
        return N==0;
    }

    public void enqueue(Item item){
        if (N==queue.length){
            resize(2 * queue.length);
        }
        queue[N] = item;
        N++;
    }

    public Item dequeue(){
        Item item = queue[0];
        for (int i=1; i<N; i++){
            queue[i-1] = queue[i];
        }
        queue[N-1] = null;
        N--;
        if (N>0 && N==queue.length/4){
            resize(queue.length/2);
        }
        return item;
    }

    public int queueSize(){
        return queue.length;
    }

    private void resize(int max){
        Item[] newQueue = (Item[]) new Object[max];
        for (int i=0; i<N; i++){
            newQueue[i] = queue[i];
        }
        queue = newQueue;
    }

    @Override
    public Iterator<Item> iterator() {
        return new ArrayQueueIterator();
    }

    private class ArrayQueueIterator implements Iterator<Item>{
        private int i = 0;
        @Override
        public boolean hasNext() {
            return i<N;
        }

        @Override
        public Item next() {
            return queue[i++];
        }
    }
}
