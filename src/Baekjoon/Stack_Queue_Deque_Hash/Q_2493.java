package Baekjoon.Stack_Queue_Deque_Hash;

import java.io.*;
import java.util.*;

class Node {
    int order;
    int num;

    Node(int order, int num) {
        this.order = order;
        this.num = num;
    }
}

public class Q_2493 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static Stack<Node> stack = new Stack<>();

    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());

        for(int i = 1; i <= N; i++) {
            int next = Integer.parseInt(st.nextToken());
            check(new Node(i, next));
        }

        bw.close();
    }

    private static void check(Node next) throws IOException {
        //본인보다 큰 것이 나올 때 까지 꺼내고 큰게 나오면 그 위에 들어가
        while(!stack.isEmpty()) {
            Node top = stack.peek();

            if(top.num > next.num) {
                bw.write(top.order + " ");
                stack.push(next);
                return;
            }

            stack.pop();
        }

        //끝까지 안나올 때
        bw.write(0 + " ");
        stack.push(next);
    }
}
