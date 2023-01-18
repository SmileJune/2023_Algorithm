package Baekjoon.String;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 숫자는 다 빼고 문자가 존재하는지 확인, 길이가 짧으니까 contains 사용해도 될것같다.
 */
public class Q_16171 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        //둘다 입력받고
        String str1 = br.readLine();
        String str2 = br.readLine();

        //str1 돌면서 숫자 빼주자.
        StringBuffer sb = new StringBuffer();
        for(int i = 0; i< str1.length(); i++) {
            int num = (int) str1.charAt(i);

            //숫자면 넘어가고
            if('0' <= num && num <= '9'){
                continue;
            }

            //문자면 문자로 넣어주자
            sb.append((char) num);
        }

        if(sb.toString().contains(str2)) {
            System.out.println(1);
        } else {
            System.out.println(0);
        }
    }
}
