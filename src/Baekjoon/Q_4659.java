package Baekjoon;

import java.io.*;

/**
 * 모음(a,e,i,o,u) 하나를 반드시 포함하여야 한다.
 * 모음이 3개 혹은 자음이 3개 연속으로 오면 안 된다.
 * 같은 글자가 연속적으로 두번 오면 안되나, ee 와 oo는 허용한다.
 *
 * 단어마다 처음부터 끝까지 돌면서 모음 갯수 체크, 다 돌고나서 0이면 out
 * 연속된 모음이나 자음이 3개 연속으로 왔는지 체크 out,
 * ee, oo 이외의 글자가 연속적으로 왔는지 체크 out
 *
 */
public class Q_4659 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        while(true){
            String str = br.readLine();
            if(str.equals("end")){
                break;
            }
            check(str);
        }
        bw.close();
    }

    private static void check(String str) throws IOException {
        int aeiou = 0;
        int series = 0;
        String ch = "";

        //str 판단
        for(int i=0; i<str.length(); i++) {
            //모음이면 모음갯수 추가
            if("aeiou".contains(str.substring(i, i+1))){
                aeiou++;

                //원래 있던 series가 양수면 ++ 아니면 1
                if(series > 0) series++;
                else series = 1;

                //만약에 series가 3 이상이다 아웃
                if(series >= 3) {
                    print(str, false);
                    return;
                }

                //연속된 문자인지 확인
                if(ch.equals(str.substring(i, i+1))) {
                    if(!ch.equals("e") && !ch.equals("o")){
                        print(str, false);
                        return;
                    }
                }

                ch = str.substring(i, i+1);
                continue;
            }
            //자음일때
            //원래 있던 series가 음수면 -- 아니면
            if(series < 0) series--;
            else series = -1;

            //만약에 series가 -3 이하다 아웃
            if(series <= -3) {
                print(str, false);
                return;
            }

            //연속된 문자인지 확인
            if(ch.equals(str.substring(i, i+1))) {
                if(!ch.equals("e") && !ch.equals("o")){
                    print(str, false);
                    return;
                }
            }

            ch = str.substring(i, i+1);

        }
        if(aeiou > 0){
            print(str, true);
        }
    }

    private static void print(String str, boolean b) throws IOException {
        if(b == true) {
            bw.write("<"+str+"> is acceptable.\n");
        } else {
            bw.write("<"+str+"> is not acceptable.\n");
        }
    }
}
