package Baekjoon.array;

import java.io.*;
import java.util.*;

public class Q_1158 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static Queue<Integer> q = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        for(int i = 1; i <= N; i++) {
            q.add(i);
        }

        List<Integer> list = new ArrayList<>();
        while(!q.isEmpty()) {
            for(int i = 0; i < K - 1; i++) {
                q.add(q.poll());
            }
            list.add(q.poll());
        }

        bw.write("<");
        String str = list.toString();
        bw.write(str.substring(1, str.length() - 1));
        bw.write(">");
        bw.close();
    }
}
