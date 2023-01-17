package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q_16916 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        //S와 P를 입력받고
        String S = br.readLine();
        String P = br.readLine();

        // contains 사용하면 안되려나..
        // 최악의 경우 50만단어를 50만번 확인 25 * 10^10 이니까 안되겠네.
        // KMP 알고리즘 이용

        if(S.contains(P)) {
            System.out.println(1);
            return;
        }
        System.out.println(0);

    }
}
