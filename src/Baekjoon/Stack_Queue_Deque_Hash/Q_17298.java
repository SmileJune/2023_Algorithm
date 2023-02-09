package Baekjoon.Stack_Queue_Deque_Hash;

import java.io.*;
import java.util.*;

public class Q_17298 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static Stack<Integer> stack = new Stack<>();
    static int[] arr, result;

    public static void main(String[] args) throws Exception {
        int N = Integer.parseInt(br.readLine());
        arr = new int[N];
        result = new int[N];
        st = new StringTokenizer(br.readLine());

        for(int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for(int i = arr.length - 1; i >= 0; i--) {
            result[i] = check(arr[i]);
        }

        for(int i = 0; i < result.length; i++) {
            bw.write(result[i] + " ");
        }
        bw.close();

    }

    private static int check(int num) {
        //본인보다 큰 것이 나올 때까지 꺼내서 확인
        while(!stack.isEmpty()) {
            int next = stack.peek();
            if(next <= num) {
                stack.pop();
                continue;
            }

            //큰 것이 나왔을 때
            stack.push(num);
            return next;
        }

        // 전부 비었을 때
        stack.push(num);
        return -1;
    }
}
