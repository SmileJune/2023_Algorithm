package Baekjoon;

import java.io.*;
import java.util.StringTokenizer;

/**
 * 약수 두번째 숫자 / 첫번째 숫자  나머지 0
 * 배수 첫번째숫자 / 두번째 숫자 나머지 0
 * 아니면 아무것도 아니다.
 */
public class Q_5086 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        while(true) {
            st = new StringTokenizer(br.readLine());
            int first = Integer.parseInt(st.nextToken());
            int second = Integer.parseInt(st.nextToken());

            if(first == 0 && second == 0) {
                break;
            }

            if(second % first == 0) {
                bw.write("factor\n");
                continue;
            }

            if(first % second == 0) {
                bw.write("multiple\n");
                continue;
            }

            bw.write("neither\n");
        }

        bw.close();
    }
}
