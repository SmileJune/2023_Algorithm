package Baekjoon.array;

import java.io.*;

public class Q_10808 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        int[] arr = new int['z' - 'a' + 1];
        String str = br.readLine();

        for(int i = 0; i < str.length(); i++) {
            arr[str.charAt(i) - 'a']++;
        }

        for(int i = 0; i < arr.length; i++) {
            bw.write(arr[i] + " ");
        }

        bw.close();
    }
}
