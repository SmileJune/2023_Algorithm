package Baekjoon.array;

import java.io.*;

/**
 * 최댓값의 범위를 먼저 확인하자.
 * 10^9 2^30 정도네 int로 가능
 */
public class Q_2577 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        int a = Integer.parseInt(br.readLine());
        int b = Integer.parseInt(br.readLine());
        int c = Integer.parseInt(br.readLine());

        int[] arr = new int[10];

        String mul = a * b * c + "";
        for(int i = 0; i < mul.length(); i++) {
            arr[mul.charAt(i) - '0']++;
        }

        for(int i = 0; i < arr.length; i++) {
            bw.write(arr[i]+"\n");
        }
        
        bw.close();
    }
}
