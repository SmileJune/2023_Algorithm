package Baekjoon.array;

import java.io.*;
import java.util.Stack;
import java.util.StringTokenizer;

/**
 * 스택을 활용하면 검색할 필요도 없고 해당 인덱스에서 왔다갔다하면서 추가 삭제와 비슷한 역할을 한다.
 */
public class Q_1406_2 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static Stack<Character> left = new Stack<>();
    static Stack<Character> right = new Stack<>();
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        String str = br.readLine();
        for(int i = 0; i < str.length(); i++) {
            left.push(str.charAt(i));
        }

        int M = Integer.parseInt(br.readLine());
        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            switch (st.nextToken()) {
                case "L" : runL(); break;
                case "D" : runD(); break;
                case "B" : runB(); break;
                case "P" : runP(); break;
            }
        }

        while(!left.isEmpty()) {
            right.push(left.pop());
        }

        while(!right.isEmpty()) {
            bw.write(right.pop());
        }

        bw.close();
    }

    private static void runL() {
        if(left.isEmpty()) {
            return;
        }
        right.push(left.pop());
    }

    private static void runD() {
        if(right.isEmpty()) {
            return;
        }
        left.push(right.pop());
    }

    private static void runB() {
        if(left.isEmpty()) {
            return;
        }
        left.pop();
    }

    private static void runP() {
        left.push(st.nextToken().charAt(0));
    }
}
