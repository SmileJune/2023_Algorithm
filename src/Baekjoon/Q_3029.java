package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q_3029 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        //입력
        String start = br.readLine();
        String end = br.readLine();

        //최대 24시간 기다릴 수 있다.
        if(start.equals(end)){
            System.out.println("24:00:00");
            return;
        }

        //초단위로 차이를 구한다.
        int diff = timeToSecond(end) - timeToSecond(start);

        //만약 차이가 음수라면 24시간 추가
        if(diff < 0) {
            diff += 24 * 60 * 60;
        }
        //출력 형태 맞춰준다.
        StringBuffer sb = new StringBuffer();
        //시간
        int hour = diff / 3600;
        diff -= hour * 3600;

        //분
        int minute = diff / 60;
        diff -= minute * 60;

        System.out.printf("%02d:%02d:%02d",hour,minute,diff);
    }

    static int timeToSecond(String str) {
        String[] arr = str.split(":");
        return Integer.parseInt(arr[0]) * 60 * 60 +
                Integer.parseInt(arr[1]) * 60 +
                Integer.parseInt(arr[2]);
    }
}
