package Baekjoon.Stack_Queue_Deque_Hash;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Q_9934 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static int K;
    static List<ArrayList<Integer>> list = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        K = Integer.parseInt(br.readLine());

        for(int i = 0; i < K + 1; i++) {
            list.add(new ArrayList<>());
        }

        st = new StringTokenizer(br.readLine());

        check(1, 1);

        for(int i = 1; i <= K; i++) {
            ArrayList<Integer> levelList = list.get(i);
            for(int j = 0; j < levelList.size(); j++) {
                bw.write(levelList.get(j)+" ");
            }
            bw.write("\n");
        }

        bw.close();
    }

    private static void check(int index, int level) {
        if(index > Math.pow(2, K) - 1) {
            return;
        }

        check(index * 2 , level + 1);
        list.get(level).add(Integer.parseInt(st.nextToken()));
        check(index * 2 + 1, level + 1);
    }
}
