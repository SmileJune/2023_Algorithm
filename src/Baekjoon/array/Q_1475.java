package Baekjoon.array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 9를 6으로 취급하면 되겠다.
 * 0~8 숫자가 들어있고 6 만 2 개 들어있다.
 * 주어진 방번호를 배열에 담아놓고 9 -> 6 으로 바꾸고 2로 나눠 준 다음 최댓값 구하면되겠다.
 */
public class Q_1475 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int[] arr = new int[10];

    public static void main(String[] args) throws IOException {
        String str = br.readLine();
        for(int i = 0; i < str.length(); i++) {
            arr[str.charAt(i) - '0']++;
        }

        arr[6] += arr[9];

        //홀수일때는 1개가 더 필요하네 1 더해서 나눠줘야겠다.
        arr[6] = (arr[6] + 1) / 2;
        arr[9] = 0;

        int max = 0;
        for(int i = 0; i < arr.length; i++) {
            if(arr[i] > max) {
                max = arr[i];
            }
        }
        System.out.println(max);
    }
}
