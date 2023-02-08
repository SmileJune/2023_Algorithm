package Baekjoon.Stack_Queue_Deque_Hash;

import java.io.*;
import java.util.*;

/**
 *  indexOf 를 이용해 방향을 정해놓고 한 방향으로만 구하자.
 */
public class Q_1021_2 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static LinkedList<Integer> deque = new LinkedList<>();
    static LinkedList<Integer> deque1;
    static LinkedList<Integer> deque2;
    static int sum = 0;
    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        for(int i = 1; i <= N; i++) {
            deque.offerLast(i);
        }

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < M; i++) {
            int num = Integer.parseInt(st.nextToken());
            double half = (double)deque.size() / 2;
            if(deque.indexOf(num) < half) {
                sum += checkLeft(num);
                deque = deque2;
            } else {
                sum += checkRight(num);
                deque = deque1;
            }
        }

        System.out.println(sum);
    }

    private static int checkRight(int num) {
        deque1 = new LinkedList<>(deque);
        int n = 0;
        while(!deque1.isEmpty() && deque1.peekFirst() != num) {
            deque1.offerFirst(deque1.pollLast());
            n++;
        }
        deque1.poll();
        return n;
    }

    private static int checkLeft(int num) {
        deque2 = new LinkedList<>(deque);
        int n = 0;
        while(!deque2.isEmpty() && deque2.peekFirst() != num) {
            deque2.offerLast(deque2.pollFirst());
            n++;
        }
        deque2.poll();
        return n;
    }
}
