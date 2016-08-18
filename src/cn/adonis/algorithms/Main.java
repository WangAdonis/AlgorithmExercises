package cn.adonis.algorithms;

import cn.adonis.algorithms.linkedlist.LinkedList;
import cn.adonis.algorithms.node.Node;
import cn.adonis.algorithms.queues.CircularQueue;
import cn.adonis.algorithms.queues.LinkedQueue;
import cn.adonis.algorithms.stacks.LinkedStack;

import java.util.ArrayList;
import java.util.Random;


public class Main {

    public static void main(String[] args) {
//        LinkedList<Integer> list = new LinkedList<>();
//        for (int i=0; i<10; i++){
//            list.addTail(i);
//        }
//        Object[] a =  list.toArray();
//        for(Object c: a){
//           System.out.print(c+",");
//        }
        josephus(7,2);
    }

    public static void josephus(int n, int m){
        CircularQueue<Integer> queue = new CircularQueue<>();
        for (int i=0; i<n; i++){
            queue.enqueue(i);
        }
        Node<Integer> node = queue.getFirst();
        while (queue.size()>1){
            for (int j=0; j<m; j++){
                if (j!=0)
                    node = node.next;
            }
            System.out.print(node.value+",");
            queue.delete(node);
            node = node.next;
        }
        System.out.println();
        System.out.print(queue.getFirst().value);
    }

    public static int[] shuffle (int[] items){
        Random random = new Random(System.currentTimeMillis());
        int capacity = items.length;
        for (int i=0; i<capacity; i++){
            int index = random.nextInt(capacity);
            int temp = items[index];
            items[index] = items[i];
            items[i] = temp;
        }
        return  items;
    }

    public static void testQueue(){
        //ResizingArrayQueue<Integer> queue = new ResizingArrayQueue<Integer>();
        LinkedQueue<Integer> queue = new LinkedQueue<>();
        for(int i=0;i<20;i++){
            queue.enqueue(i);
        }
        for(int i : queue){
            System.out.print(i+",");
        }
        System.out.println();
        while (!queue.isEmpty()){
            System.out.print(queue.dequeue()+",");
        }
        System.out.println();
        System.out.println(queue.size());
        //System.out.println(queue.queueSize());
        for(int i=0;i<20;i++){
            queue.enqueue(i);
        }
        while (!queue.isEmpty()){
            System.out.print(queue.dequeue()+",");
        }
        //System.out.println(queue.queueSize());
    }

    public static void testStack(){
        //ResizingArrayStack<Integer> stack = new ResizingArrayStack<>();
        LinkedStack<Integer> stack = new LinkedStack<>();
        for(int i=0;i<20;i++){
            stack.push(i);
        }
        for(int i : stack){
            System.out.print(i+",");
        }
        System.out.println();
        while (!stack.isEmpty()){
            System.out.print(stack.pop()+",");
        }
        System.out.println();
        System.out.println(stack.size());
        //System.out.println(stack.arraySize());
    }

    public static boolean parentheses(String args){
        LinkedStack<Character> stack = new LinkedStack<>();
        for (int i=0; i<args.length(); i++){
            char c = args.charAt(i);
            if (c=='{'||c=='['||c=='('){
                stack.push(c);
            }else if (c=='}'){
                if (stack.pop()!='{')
                    return false;
            }else if (c==']'){
                if (stack.pop()!='[')
                    return false;
            }else if (c==')'){
                if (stack.pop()!='(')
                    return false;
            }
        }
        return true;
    }

    public static void testLinkedList(){
        LinkedList<Integer> list = new LinkedList<>();
        for(int i=1;i<=20;i++){
            list.addTail(i);
        }
        System.out.print(list.max(list.getFirst(),0));
//        for(int i : list){
//            System.out.print(i+",");
//        }
//        System.out.println(list.size());
//        list.deleteTail();
//        for(int i : list){
//            System.out.print(i+",");
//        }
//        System.out.println(list.size());
//        try {
//            list.delete(2);
//        } catch (IllegalIndexException e) {
//            e.printStackTrace();
//        }
//        //list.remove(1);
//        for(int i : list){
//            System.out.print(i+",");
//        }
//        System.out.println();
//        System.out.println(list.size());
//        System.out.println(list.find(5));
//        System.out.println(list.find(7));
    }
}
