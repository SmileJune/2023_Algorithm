package Baekjoon.Stack_Queue_Deque_Hash;

import java.io.*;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Q_18115 {
    static Deque<Integer> deque = new ArrayDeque<>();
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine());
        String command = new StringBuffer(br.readLine()).reverse().toString();
        StringTokenizer st = new StringTokenizer(command);

        for(int i = 1; i <= N; i++) {
            switch (Integer.parseInt(st.nextToken())) {
                case 1 : doOne(i); break;
                case 2 : doTwo(i); break;
                case 3 : doThree(i); break;
            }
        }

        while(!deque.isEmpty()) {
            bw.write(deque.poll() + " ");
        }
        bw.close();
    }

    private static void doOne(int i) {
        deque.offerFirst(i);
    }

    private static void doTwo(int i) {
        int temp = deque.pollFirst();
        deque.offerFirst(i);
        deque.offerFirst(temp);
    }

    private static void doThree(int i) {
        deque.offerLast(i);
    }

}
