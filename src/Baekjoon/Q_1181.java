package Baekjoon;

import java.io.*;
import java.util.*;

/**
 * 비교기준을 만들어주고 정렬하자.
 */
public class Q_1181 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int num;
    static HashSet<String> set;
    static ArrayList<String> list;
    public static void main(String[] args) throws IOException {
        num = Integer.parseInt(br.readLine());
        set = new HashSet<>();
        for(int i=0; i<num; i++) {
            set.add(br.readLine());
        }
        list = new ArrayList<>(set);
        Collections.sort(list, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if(o1.length() != o2.length()) {
                    return o1.length() - o2.length();
                }
                return o1.compareTo(o2);
            }
        });

        for(int i=0; i<list.size(); i++) {
            bw.write(list.get(i)+"\n");
        }

        bw.close();
    }
}
