package Baekjoon.Stack_Queue_Deque_Hash;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

/**
 * 갯수만큼의 변환표를 만들어 놓고
 * 하나씩 읽으면서 영대문자면 변환해서 넣어놓고 (피연산자)
 * 그게아니라면 (연산자) 앞에 들어갔던 두개 빼서 계산 후 다시 집어 넣기
 */
public class Q_1935 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static Stack<Double> stack;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine());
        stack = new Stack<>();
        arr = new int[N];
        String command = br.readLine();

        for(int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        for(int i = 0; i < command.length(); i++) {
            char ch = command.charAt(i);

            //영대문자면 변환해서 스택에 넣기
            if('A' <= ch && ch <= 'Z') {
                stack.push((double) arr[ch - 'A']);
                continue;
            }

            //영대문자가 아니라면 수식계산
            switch (ch + "") {
                case "+" :
                    stack.push(stack.pop() + stack.pop());
                    break;
                case "-" :
                    stack.push( -stack.pop() + stack.pop());
                    break;
                case "*" :
                    stack.push(stack.pop() * stack.pop());
                    break;
                case "/" :
                    stack.push(1/stack.pop() * stack.pop());
                    break;
            }
        }

        System.out.printf("%.2f", stack.pop());
    }
}
