package Baekjoon.String;

import java.io.*;
import java.util.Arrays;

public class Q_10798 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int[][] map;

    public static void main(String[] args) throws IOException {
        map = new int[5][15];

        //-1 채우고 입력받은 값 채우기
        for(int i = 0; i < 5; i++) {
            Arrays.fill(map[i], -1);
            String str = br.readLine();
            for(int j=0; j<str.length(); j++) {
                map[i][j] = str.charAt(j);
            }
        }

        for(int i=0; i<15; i++) {
            for(int j=0; j<5; j++) {
                //만약 -1이라면 넘겨
                if(map[j][i] == -1){
                    continue;
                }

                //만약 0에서 9 사이면 숫자로 출력
                if(0 <= map[j][i] && map[j][i] <= 9) {
                    bw.write(map[j][i]);
                    continue;
                }

                //아니면 문자로 출력
                bw.write((char)map[j][i]);
            }
        }

        bw.close();


    }
}
