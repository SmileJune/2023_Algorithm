package Baekjoon.Stack_Queue_Deque_Hash;

import java.io.*;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

/**
 * 명령 수만큼 스위치케이스문 돌려서 작업
 */
public class Q_18258 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static Deque<Integer> q;

    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine());
        q = new LinkedList<>();

        for(int i = 0; i < N; i++) {
            //st에 담아놓고 토큰 하나 꺼내서 스위치케이스문으로 들어가기
            st = new StringTokenizer(br.readLine());

            switch (st.nextToken()) {
                case "push" :
                    q.add(Integer.parseInt(st.nextToken()));
                    break;
                case "pop" :
                    if(q.isEmpty()) {
                        bw.write(-1 + "\n");
                        continue;
                    }
                    bw.write(q.poll() + "\n");
                    break;
                case "size" :
                    bw.write(q.size() + "\n");
                    break;
                case "empty" :
                    if(q.isEmpty()) {
                        bw.write(1 + "\n");
                        continue;
                    }
                    bw.write(0 + "\n");
                    break;
                case "front" :
                    if(q.isEmpty()) {
                        bw.write(-1 + "\n");
                        continue;
                    }
                    bw.write(q.peek() + "\n");
                    break;
                case "back" :
                    if(q.isEmpty()) {
                        bw.write(-1 + "\n");
                        continue;
                    }
                    bw.write(q.getLast() + "\n");
                    break;
            }
        }

        bw.close();
    }
}
