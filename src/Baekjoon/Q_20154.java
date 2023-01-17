package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 그냥 단계마다 다 계산해버려도 될까?
 * 10000줄이라고 했을때
 */
public class Q_20154 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int[] arr = new int[]{3, 2, 1, 2,3,3,3,3,1,1,3,1,3,3,1,2,2,2,1,2,1,1,2,2,2,1};
    static String str;
    static StringBuffer sb;

    public static void main(String[] args) throws IOException {
        // 입력받고 치환
        str = br.readLine();
        sb = new StringBuffer();
        for(int i=0; i<str.length(); i++) {
            sb.append(arr[str.charAt(i)-'A']);
        }

        //길이가 1이 될때까지 진행
        while(sb.length() > 1) {
            sb = cal(sb);
        }

        //마지막으로 확인
        if(Integer.parseInt(sb.toString()) % 2 == 1) {
            System.out.println("I'm a winner!");
        } else {
            System.out.println("You're the winner?");
        }
    }

    private static StringBuffer cal(StringBuffer sb) {
        StringBuffer result = new StringBuffer();

        for(int i = 0; i < sb.length() / 2; i ++) {
            int sum = Integer.parseInt(sb.substring(2 * i,2 * i + 1))
                    + Integer.parseInt(sb.substring(2 * i + 1, 2 * i + 2));
            result.append(sum % 10);
        }

        if(sb.length() % 2 == 1){
            result.append(sb.substring(sb.length()-1, sb.length()));
        }

        return result;
    }
}
