package Baekjoon.String;

import java.io.*;

public class Q_11365 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        //반복 입력
        while(true) {
            String str = br.readLine();
            //END가 나올때까지
            if(str.equals("END")) {
                break;
            }
            //아니면 돌려서 출력
            StringBuffer sb = new StringBuffer(str);
            bw.write(sb.reverse().toString());
            bw.write("\n");
        }
        bw.close();
    }
}
