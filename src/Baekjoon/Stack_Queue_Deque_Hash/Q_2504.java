package Baekjoon.Stack_Queue_Deque_Hash;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

/**
 * 스택을 사용하겠다.
 * (, [ 는 무조건 넣고
 * 숫자 넣는 메서드 => 제일 위에 글자 확인하고 숫자 있으면 더해서 넣는다. 반복
 * ), ] => 제일 위에 글자 확인하고 숫자 있으면 한번 더 빼서 짝이 맞으면 숫자 계산해서 숫자 넣기 메서드
 *
 */
public class Q_2504 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static Stack<Character> stack;

    public static void main(String[] args) throws IOException {
        stack = new Stack<>();
        String str = br.readLine();

        for(int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);

            //만약 (, [ 일 때
            if("([".contains(ch + "")) {
                stack.push(ch);
                continue;
            }

            // ), ] 일 때
            //비었으면 0 출력
            if(stack.isEmpty()) {
                System.out.println(0);
                return;
            }

            //맨 위 확인
            char top = stack.peek();

            //숫자 있으면 빼놓고
            if(!"([".contains(top + "")) {
                int num = Integer.parseInt(stack.pop() + "");

                if(ch == ')') {
                    if(stack.pop() == '('){
                        put(2 * num);
                    } else {
                        System.out.println(0);
                        return;
                    }
                    continue;
                }

                if(ch == ']') {
                    if(stack.pop() == '['){
                        put(3 * num);
                    } else {
                        System.out.println(0);
                        return;
                    }
                    continue;
                }
            }

                //숫자가 아니면
            if(ch == ')') {
                if(stack.pop() == '('){
                    put(2);
                } else {
                    System.out.println(0);
                    return;
                }
                continue;
            }

            if(ch == ']') {
                if(stack.pop() == '['){
                    put(3);
                } else {
                    System.out.println(0);
                    return;
                }
                continue;
            }
        }

            //끝나고 만약 남은게 하나가 아니다, 하나 남아도 ([ 이다? 아웃
        if(stack.size() > 1 || "([".contains(stack.peek() + "")) {
            System.out.println(0);
            return;
        }

        System.out.println(stack.pop());
    }


    private static void put(int n) {
        if(stack.isEmpty() || "([".contains(stack.peek() + "")) {
            stack.push((char) n);
            return;
        }

        stack.push((char) (Integer.parseInt(stack.pop()+"") * n));
    }
}
