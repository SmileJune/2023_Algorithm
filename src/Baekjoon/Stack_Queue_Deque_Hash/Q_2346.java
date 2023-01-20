package Baekjoon.Stack_Queue_Deque_Hash;

import java.io.*;
import java.util.*;

/**
 * Deque이용해서 구현
 * 메모리초과.. 천개의 Ball 인스턴스를 만드는게 부담이 컸나... 필요한 값이 같은 타입이니까 클래스를 배열로 바꿔보자.
 * 그래도 메모리초과.
 * 순차적인 데이터 추가 삭제를 하는 Deque는 ArrayList (ArrayDeque)를 사용하는 것이 더 효과적이다.
 *
 * 그럼 Queue는 왜 LinkedList로 구현할까?
 * https://devlog-wjdrbs96.tistory.com/246
 */

public class Q_2346 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static Deque<int[]> dq;


    public static void main(String[] args) throws IOException {
        dq = new ArrayDeque<>();
        int N = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for(int i = 1; i <= N; i++) {
            dq.offer(new int[]{i, Integer.parseInt(st.nextToken())});
        }

        //맨 처음 공 보고 num이 양수인지 음수인지 확인하고 두가지 메서드 시작
        while(true) {
            int[] ball = dq.pollFirst();
            bw.write(ball[0]+" ");

            if(dq.isEmpty()) {
                break;
            }

            if(ball[1] < 0) {
                for(int i = 0; i < -ball[1]; i++) {
                    dq.offerFirst(dq.pollLast());
                }
            } else {
                for(int i = 0; i < ball[1] - 1; i++) {
                    dq.offerLast(dq.pollFirst());
                }
            }
        }

        bw.close();


    }
}
