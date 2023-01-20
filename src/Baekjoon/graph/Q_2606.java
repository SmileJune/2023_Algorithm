package Baekjoon.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 * 먼저 그래프를 표현하고
 */
public class Q_2606 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int[] visited;
    static int ans = 0;
    static ArrayList<ArrayList<Integer>> graph;

    public static void main(String[] args) throws IOException {

        int N = Integer.parseInt(br.readLine());
        visited = new int[N + 1];
        graph = new ArrayList<>();
        for(int i = 0; i < N + 1; i++) {
            graph.add(new ArrayList<>());
        }

        int num = Integer.parseInt(br.readLine());
        for(int i = 0; i < num; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph.get(a).add(b);
            graph.get(b).add(a);
        }

        check(1);

        System.out.println(ans - 1);
    }

    private static void check(int n) {
        if(visited[n] >= 1) {
            return;
        }

        visited[n]++;
        ans++;

        ArrayList<Integer> list = graph.get(n);
        for(int i = 0; i < list.size(); i++) {
            check(list.get(i));
        }
    }
}
