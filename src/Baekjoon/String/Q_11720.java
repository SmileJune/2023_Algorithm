package Baekjoon.String;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q_11720 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int len = Integer.parseInt(br.readLine());
        String str = br.readLine();
        int sum = 0;

        for(int i = 0; i < len; i++){
            sum += Integer.parseInt(str.substring(i, i + 1));
        }

        System.out.println(sum);
    }
}
