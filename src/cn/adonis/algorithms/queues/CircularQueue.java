package cn.adonis.algorithms.queues;

import cn.adonis.algorithms.node.Node;

/**
 * Created by wang on 2016/8/18.
 */
public class CircularQueue<Item> extends LinkedQueue<Item> {
    @Override
    public void enqueue(Item item){
        Node<Item> oldLast = last;
        last = new Node<Item>();
        last.previous = oldLast;
        last.value = item;
        if (isEmpty()){
            first = last;
        }else {
            oldLast.next = last;
        }
        last.next = first;
        first.previous = last;
        N++;
    }

    @Override
    public void delete(Node<Item> deleteNode){
        Node<Item> preNode = deleteNode.previous;
        Node<Item> nextNode = deleteNode.next;
        preNode.next = nextNode;
        nextNode.previous = preNode;
        if (deleteNode==first){
            //System.out.println("df");
            first = nextNode;
        }else if (deleteNode==last){
            //System.out.println("dl");
            last = preNode;
        }
        deleteNode = null;
        N--;
    }
}
