package Baekjoon.String;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

/**
 * 각각 정렬해서 인덱스 차근히 올라가면서 비교해야겠다.
 * 같으면 idx1, dix2 둘다 올려주고 명단에 추가
 * 2가 더 높으면 idx1을 올려주고 1이 더 높으면 idx2을 올려주자
 */
public class Q_1764 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static ArrayList<String> list1, list2, result;
    static StringTokenizer st;
    static int N, M;

    public static void main(String[] args) throws IOException {
        list1 = new ArrayList<>();
        list2 = new ArrayList<>();
        result = new ArrayList<>();

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        for(int i=0; i<N; i++) {
            list1.add(br.readLine());
        }
        for(int i=0; i<M; i++) {
            list2.add(br.readLine());
        }

        Collections.sort(list1);
        Collections.sort(list2);

        int idx1 = 0;
        int idx2 = 0;

        while(true) {
            //사이즈 넘어가면 그만
            if(idx1 >= list1.size() || idx2 >= list2.size()) {
                break;
            }

            //같을때
            if(list1.get(idx1).equals(list2.get(idx2))){
                result.add(list1.get(idx1));
                idx1++;
                idx2++;
                continue;
            }

            //다를때
            if(list1.get(idx1).compareTo(list2.get(idx2)) > 0) {
                idx2++;
            } else {
                idx1++;
            }
        }

        bw.write(result.size()+"\n");
        for(int i=0; i<result.size(); i++) {
            bw.write(result.get(i)+"\n");
        }
        bw.close();
    }
}
