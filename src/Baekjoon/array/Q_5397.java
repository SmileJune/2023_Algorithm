package Baekjoon.array;

import java.io.*;
import java.util.Stack;

/**
 * < , > , - 세가지일 경우만 조심해서 나타내자.
 *
 * 문자열이 기니까 검색 속도가 느린 LinkedList, 삽입,삭제가 느린 ArrayList로는 불가능
 * 스택을 이용하자.
 */
public class Q_5397 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static Stack<Character> left;
    static Stack<Character> right;

    public static void main(String[] args) throws IOException {
        int T = Integer.parseInt(br.readLine());

        for(int i = 1; i <= T; i++) {
            left = new Stack<>();
            right = new Stack<>();
            String command = br.readLine();

            for(int j = 0; j < command.length(); j++) {
                char ch = command.charAt(j);

                if(!"<>-".contains(ch + "")) {
                    left.push(ch);
                    continue;
                }

                switch (ch + "") {
                    case "<" : moveForward(); break;
                    case ">" : moveBackward(); break;
                    case "-" : delete(); break;
                }
            }

            while(!left.isEmpty()) {
                right.push(left.pop());
            }

            while(!right.isEmpty()) {
                bw.write(right.pop());
            }

            bw.write("\n");
        }

        bw.close();
    }

    private static void delete() {
        if(left.isEmpty()) {
            return;
        }
        left.pop();
    }

    private static void moveBackward() {
        if(right.isEmpty()) {
            return;
        }
        left.push(right.pop());
    }

    private static void moveForward() {
        if(left.isEmpty()) {
            return;
        }
        right.push(left.pop());
    }
}
