package Baekjoon.array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 알파벳 개수 차이만큼 쭉 더해서 값 내주면 되겠다.
 */
public class Q_1919 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        String str1 = br.readLine();
        String str2 = br.readLine();

        int[] arr1 = new int['z' - 'a' + 1];
        int[] arr2 = new int['z' - 'a' + 1];

        for(int i = 0; i < str1.length(); i++) {
            arr1[str1.charAt(i) - 'a']++;
        }
        for(int i = 0; i < str2.length(); i++) {
            arr2[str2.charAt(i) - 'a']++;
        }

        int result = 0;
        for(int i = 0; i < arr1.length; i++) {
            result += Math.abs(arr1[i] - arr2[i]);
        }

        System.out.println(result);
    }
}
