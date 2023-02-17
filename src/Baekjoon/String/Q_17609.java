package Baekjoon.String;

import java.io.*;

public class Q_17609 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int result;
    public static void main(String[] args) throws IOException {
        int T = Integer.parseInt(br.readLine());
        for(int tc = 1; tc <= T; tc++) {
            String str = br.readLine();
            result = 2;
            check(str, 0, str.length() - 1, 1);
            bw.write(result + "\n");
        }
        bw.close();
    }

    private static void check(String str, int start, int end, int joker) {
        //끝까지 왔다
        if(start >= end) {
            if(joker == 1) {
                result = 0;
                return;
            }

            result = 1;
            return;
        }

        //만약 같으면 다음 단계
        if(str.charAt(start) == str.charAt(end)) {
            check(str, start + 1, end - 1, joker);
            return;
        }

        //다르면 조커 있는지 확인
        if(joker == 0) {
            return;
        }

        //조커 있으면
        check(str, start + 1, end, 0);
        check(str, start, end - 1, 0);
    }

}
