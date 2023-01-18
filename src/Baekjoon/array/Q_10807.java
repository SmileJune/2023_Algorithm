package Baekjoon.array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 인덱스 이용하고 싶은데 -100 ~ 100 까지니까 0 ~ 200 으로 바꿔서 계산하자.
 */
public class Q_10807 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine());

        int[] arr = new int[201];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            arr[Integer.parseInt(st.nextToken()) + 100]++;
        }

        int v = Integer.parseInt(br.readLine());
        System.out.println(arr[v + 100]);

    }
}
