package Baekjoon.Stack_Queue_Deque_Hash;

import java.io.*;
import java.util.*;

/**
 * indexOf 메서드를 이용해 미리 위치를 찾아낼 수 있구나!! 다시 풀이
 */
public class Q_1021 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static Deque<Integer> deque = new ArrayDeque<>();
    static Deque<Integer> deque1;
    static Deque<Integer> deque2;
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
            int right = checkRight(num);
            int left = checkLeft(num);
            if(right <= left) {
                deque = deque1;
                sum += right;
            } else {
                deque = deque2;
                sum += left;
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
        while(!deque1.isEmpty() && deque2.peekFirst() != num) {
            deque2.offerLast(deque2.pollFirst());
            n++;
        }
        deque2.poll();
        return n;
    }
}
