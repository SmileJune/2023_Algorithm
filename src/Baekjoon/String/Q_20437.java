package Baekjoon.String;

import java.io.*;
import java.util.ArrayList;

public class Q_20437 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        int num = Integer.parseInt(br.readLine());
        for(int i = 0; i < num; i++) {
            solution();
        }
        bw.close();
    }

    private static void solution() throws IOException {
        //문자열 받고
        String str = br.readLine();
        //기준 값 받고
        int K = Integer.parseInt(br.readLine());

        int min = str.length();
        int max = 0;

        //한번에 알파벳별 인덱스 위치 정리
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        for(int i = 0; i < 'Z' - 'A' + 1; i++) {
            list.add(new ArrayList<>());
        }

        for(int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            list.get(ch-'a').add(i);
        }

        for(int i = 0; i < 'Z' - 'A' + 1; i++) {
            //갯수보다 적으면 패스
            if(list.get(i).size() < K) continue;

            //갯수보다 많으면 인덱스 움직여가면서 확인
            for(int j=0; j<list.get(i).size()-K+1; j++) {
                int len = list.get(i).get(j+K-1)
                        - list.get(i).get(j) + 1;

                if(len > max) {
                    max = len;
                }

                if(len < min) {
                    min = len;
                }
            }
        }

        if( min > max ) {
            bw.write(-1+"\n");
        } else {
            bw.write(min+" "+max+"\n");
        }
    }
}
