package Baekjoon;

import java.io.*;

public class Q_9046 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static void main(String[] args) throws IOException {

        int cnt = Integer.parseInt(br.readLine());
        // 주어진 횟수만큼 반복
        for(int i = 0; i < cnt; i++) {
            //입력 받고 공백 없애고
            String str = br.readLine();
            str = str.replaceAll(" ","");

            // 갯수 센 다음
            int[] arr = new int['z' - 'a' + 1];
            for(int j = 0; j < str.length(); j++) {
                int idx = str.charAt(j) - 'a';
                arr[idx]++;
            }

            //최댓값 찾기
            int max = 0;
            for(int j = 0; j < arr.length; j++) {
                if(arr[j] > max) {
                    max = arr[j];
                }
            }

            // 최댓값 인덱스랑 갯수 확인
            int maxIdx = -1;
            int maxCnt = 0;
            for(int j=0; j < arr.length; j++) {
                if(arr[j] == max) {
                    maxIdx = j;
                    maxCnt++;
                }
            }

            //최댓값이 두개면 ? 출력
            if(maxCnt > 1) {
                bw.write("?\n");
                continue;
            }

            //최댓값이 하나면 해당 알파벳 출력
            bw.write((char)(maxIdx + 'a')+"\n");
        }
        bw.close();
    }
}
