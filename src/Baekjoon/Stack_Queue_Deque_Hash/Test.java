package Baekjoon.Stack_Queue_Deque_Hash;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;

public class Test {
    static Deque<Integer> deque = new LinkedList<>();
    static Deque<Integer> deque1;
    public static void main(String[] args) {
        for(int i = 0; i < 10; i++) {
            deque.offerLast(i);
        }
        deque1 = new LinkedList<>(deque);
        System.out.println(deque);
        System.out.println(deque1);

    }
}
