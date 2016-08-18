package cn.adonis.algorithms.stacks;

import java.util.Iterator;

/**
 * Created by Wang on 2016/8/16.
 */
public class ResizingArrayStack<Item> implements Iterable<Item> {

    private int N = 0;
    private Item[] items = (Item[])new Object[10];

    public int size(){
        return N;
    }

    public boolean isEmpty(){
        return N==0;
    }

    public void push(Item item){
        if (N==items.length){
            resize(2 * items.length);
        }
        items[N++] = item;
    }

    public Item pop(){
        Item item = items[--N];
        items[N] = null;
        if (N>0 && N==items.length/4){
            resize(items.length/2);
        }
        return item;
    }

    public void resize(int max){
        Item[] temp = (Item[]) new Object[max];
        for(int i=0; i<N; i++){
            temp[i] = items[i];
        }
        items = temp;
    }

    public int arraySize(){
        return items.length;
    }

    @Override
    public Iterator<Item> iterator() {
        return new ArrayStackIterator();
    }

    private class ArrayStackIterator implements Iterator<Item>{
        private int i = N;
        @Override
        public boolean hasNext() {
            return i>0;
        }

        @Override
        public Item next() {
            return items[--i];
        }
    }
}
