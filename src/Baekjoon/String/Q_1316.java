package Baekjoon.String;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 하나 나올때 체크해두고 다음에 또 나오면 아웃
 */
public class Q_1316 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int[] arr;
    static int num;
    static int cnt = 0;

    public static void main(String[] args) throws IOException {
        //판단해야하는 단어의 갯수 받아서 확인
        num = Integer.parseInt(br.readLine());
        for(int i = 0; i < num; i++) {
            check();
        }

        //정답 출력
        System.out.println(cnt);
    }

    static void check() throws IOException {
        //알파벳 갯수만큼 배열 선언
        arr = new int['z' - 'a' + 1];
        int letter = -1;

        //단어 받아서 판단
        String str = br.readLine();

        //돌면서 확인
        for(int i=0; i<str.length(); i++) {
            //전 문자와 값이 같으면 패스
            if(letter == str.charAt(i)){
                continue;
            }

            //만약 이미 방문했다.
            if(arr[str.charAt(i) - 'a'] > 0) {
                return;
            }

            //처음 방문한다. 방문처리 해주고
            arr[str.charAt(i) - 'a']++;
            letter = str.charAt(i);
        }

        //끝까지 돌았다.
        cnt++;
    }
}
