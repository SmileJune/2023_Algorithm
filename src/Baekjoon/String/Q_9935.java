package Baekjoon.String;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class Q_9935 {
    //두 줄 받을 거라 오랜만에 Scanner 사용해보자.
    static Scanner sc = new Scanner(System.in);

    //백만개 스택에 담을 수 있나..? 일단 큐를 사용하자. 끝 쪽 추가 삭제를 주로 할테니까 ArrayDeque
    static Deque<Character> mainDeque = new ArrayDeque<>();
    static Deque<Character> subDeque = new ArrayDeque<>();
    static String str, keyword;
    public static void main(String[] args) {
        str = sc.nextLine();
        keyword = sc.nextLine();

        for(int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            mainDeque.offerLast(ch);
            if(ch == keyword.charAt(keyword.length() - 1)) {
                check();
            }

        }
        //전부 확인 했다면 mainDeque에 있는 것들을 한 문장으로 출력
        //아무것도 없다면 "FRULA" 출력
        if(mainDeque.isEmpty()) {
            System.out.println("FRULA");
            return;
        }

        StringBuilder sb = new StringBuilder();
        while(!mainDeque.isEmpty()) {
            sb.append(mainDeque.pollFirst());
        }
        System.out.println(sb);

    }

    private static void check() {
        //갯수가 적다면 무조건 안되니까 패스
        if(mainDeque.size() < keyword.length()) {
            return;
        }

        //하나씩 꺼내서 확인
        for(int i = keyword.length() - 1; i >= 0; i--) {
            char ch = mainDeque.pollLast();
            subDeque.offerFirst(ch);

            //만약 다르면 돌려놓고 나와.
            if(ch != keyword.charAt(i)) {
                backToMainDeque();
                return;
            }
        }

        //전부 확인했는데 같다? => subDeque 초기화하고 다음 작업
        subDeque = new ArrayDeque<>();
    }

    private static void backToMainDeque() {
        while(!subDeque.isEmpty()) {
            mainDeque.offerLast(subDeque.pollFirst());
        }
    }
}
