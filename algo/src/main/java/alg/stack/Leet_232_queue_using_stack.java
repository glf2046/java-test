package alg.stack;

import java.util.Stack;

//https://leetcode-cn.com/problems/implement-queue-using-stacks/
public class Leet_232_queue_using_stack {
    public static void main(String[] args) {
        QueueUsingStack1<String> queueUsingStack1 = new QueueUsingStack1<>();
        queueUsingStack1.add("1");
        queueUsingStack1.add("2");
        queueUsingStack1.add("3");

        System.out.println(queueUsingStack1.pop());
        System.out.println(queueUsingStack1.pop());
        System.out.println(queueUsingStack1.pop());
    }

    static class QueueUsingStack1<E>{
        Stack<E> input = new Stack<>();
        Stack<E> output = new Stack<>();

        public void add(E e) {
            input.push(e);
        }

        public E pop(){
            if (output.isEmpty()) {
                while (!input.isEmpty()) {
                    output.push(input.pop());
                }
            }

            return output.pop();
        }
    }

}
