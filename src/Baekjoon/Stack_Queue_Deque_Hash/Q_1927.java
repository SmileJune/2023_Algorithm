package Baekjoon.Stack_Queue_Deque_Hash;

import java.io.*;
import java.util.PriorityQueue;

public class Q_1927 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static PriorityQueue<Integer> pq = new PriorityQueue<>();

    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine());
        for(int i = 0; i < N; i++) {
            int order = Integer.parseInt(br.readLine());
            check(order);
        }

        bw.close();
    }

    private static void check(int order) throws IOException {
        if(order == 0) {
            if(!pq.isEmpty()){
                bw.write(pq.poll() + "\n");
                return;
            }
            bw.write(0 + "\n");
            return;
        }

        pq.offer(order);
    }
}
