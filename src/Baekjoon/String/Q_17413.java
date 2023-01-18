package Baekjoon.String;

import java.io.*;
import java.util.Stack;

/**
 * < 나올때 < 부터 스택에 담아놓고 > 나오면 >까지 담아놨다가 고대로 꺼내서 출력문에 담아준다.
 * 스택이 비어있을때는 sb에 쭉 담았다가 공백이나 < 나오면 돌려서 출력문에 담는다.
 */
public class Q_17413 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringBuffer sb;
    static Stack<Character> stack = new Stack<>();

    public static void main(String[] args) throws IOException {
        sb =  new StringBuffer();
        String str = br.readLine();
        for(int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);

            //비어있을 때
            if(stack.isEmpty()) {
                //혹시 공백이면 sb 돌려서 출력문에 넣고
                if(ch == ' ') {
                    bw.write(sb.reverse().toString()+" ");
                    sb = new StringBuffer();
                    continue;
                }

                //혹시 < 면 stack에 담고 sb 돌려서 출력문에 넣자
                if(ch == '<') {
                    stack.push('<');
                    bw.write(sb.reverse().toString());
                    sb = new StringBuffer();
                    continue;
                }

                //둘다 아니면 그냥 sb에 넣자.
                sb.append(ch);
                continue;
            }

            //채워져있을 때
            // > 아니면 그냥 채워
            if(ch != '>') {
                stack.push(ch);
                continue;
            }

            // > 면 다 꺼내서 출력문에 넣자
            stack.push(ch);
            while(!stack.isEmpty()) {
                sb.append(stack.pop());
            }
            bw.write(sb.reverse().toString());
            sb = new StringBuffer();

        }

        //다 끝났는데 sb에 들어있는건 돌려서 마무리
        bw.write(sb.reverse().toString());
        bw.close();
    }
}
