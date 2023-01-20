package Baekjoon;

import java.io.*;
import java.util.StringTokenizer;

/**
 * 유클리드 호제법으로 최대 공약수 구하기
 */
public class Q_3036 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());

        int a = Integer.parseInt(st.nextToken());
        for(int i = 1; i < N; i++){
            int b = Integer.parseInt(st.nextToken());
            int gcd = gcd(a, b);
            bw.write(a / gcd + "/" + b / gcd + "\n");
        }

        bw.close();
    }

    private static int gcd(int a, int b) {
        if(b == 0){
            return a;
        }
        return gcd(b, a % b);
    }
}
