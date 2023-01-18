package Baekjoon.array;

import java.io.*;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

/**
 * 인덱스를 이용해야겠다.
 * L 은 인덱스 한칸 내리기 만약 내렸을 때 -1보다 작으면 -1로 설정
 * D 는 인덱스 한칸 올리기 만약 올렸을 때 list size -1 보다 크면 list size -1 로 설정
 * B 는 커서 해당 인덱스 문자 삭제 후 인덱스 내리기
 * P $ 는 해당 인덱스 자리에 문자 추가하고 인덱스 올리기
 *
 * 이론적으로는 맞는데 시간 초과네... 10만자를 늘렸다 줄였다하는게 힘들다?
 * ArrayList -> LinkedList 로 변경
 * 시간초과 => 삽입 삭제가 유리하긴 하지만 인덱스로 찾아가는 과정에서 head나 tail에서 부터 올라가야 하기 때문에 검색이 오래걸린다.
 *
 *
 * sb로 출력하는게 오래걸리나보다 bw에 바로 넣어서 출력해보자.
 * 시간초과
 *
 */
public class Q_1406 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static List<Character> list;
    static String str;
    static int idx;

    public static void main(String[] args) throws IOException {
        //원래 문자열 입력 받고 인덱스 조정
        str = br.readLine();
        idx = str.length() - 1;

        //리스트 형태로 바꾸자.
        list = new LinkedList<>();
        for(int i = 0; i < str.length(); i++) {
            list.add(str.charAt(i));
        }

        //실행 갯수 받고 해당 갯수만큼
        int M = Integer.parseInt(br.readLine());
        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            switch (st.nextToken()) {
                case "P" : runP(); break;
                case "L" : runL(); break;
                case "B" : runB(); break;
                case "D" : runD(); break;
            }
        }

        for(int i = 0; i < list.size(); i++) {
            bw.write(list.get(i));
        }

        bw.close();
    }

    private static void runD() {
        if(idx == list.size() - 1) {
            return;
        }
        idx++;
    }

    private static void runB() {
        if(idx == -1) {
            return;
        }
        list.remove(idx);
        idx--;
    }

    private static void runL() {
        if(idx == -1) {
            return;
        }
        idx--;
    }

    private static void runP() {
        list.add(idx + 1, st.nextToken().charAt(0));
        idx++;
    }
}
