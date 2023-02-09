package Baekjoon.Stack_Queue_Deque_Hash;

import java.io.*;
import java.util.Stack;

public class Q_9012 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static Stack<Character> stack;

    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine());
        for(int i = 0; i < N; i++) {
            bw.write(solution() + "\n");
        }
        bw.close();
    }

    private static String solution() throws IOException {
        String str = br.readLine();
        stack = new Stack<>();
        for(int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            // '(' 가 나오면 무조건 넣어
            if(ch == '(') {
                stack.push(ch);
                continue;
            }

            // ')' 인데 스택에 남은게 없어? NO!
            if(stack.isEmpty()) {
                return "NO";
            }

            //남은거 있으면 하나 빼
            stack.pop();
        }
        //다 돌렸는데 스택에 남은게 있어? NO!
        if(!stack.isEmpty()) {
            return "NO";
        }

        return "YES";
    }
}
