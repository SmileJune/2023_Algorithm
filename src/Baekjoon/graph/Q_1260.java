package Baekjoon.graph;

import java.io.*;
import java.util.*;

/**
 * dfs bfs 기본 문제
 */
public class Q_1260 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static ArrayList<ArrayList<Integer>> graph;
    static Queue<Integer> q;
    static boolean[] visited;
    static int N, M, V;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        V = Integer.parseInt(st.nextToken());

        graph = new ArrayList<>();
        for(int i = 0; i < N + 1; i++) {
            graph.add(new ArrayList<>());
        }

        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            graph.get(a).add(b);
            graph.get(b).add(a);
        }

        for(int i = 0; i < N + 1; i++) {
            Collections.sort(graph.get(i));
        }

        visited = new boolean[N + 1];
        dfs(V);
        bw.write("\n");

        visited = new boolean[N + 1];
        q = new LinkedList<>();
        q.offer(V);
        bfs();

        bw.close();
    }

    private static void dfs(int V) throws IOException {
        if(visited[V] == true) {
            return;
        }

        visited[V] = true;
        bw.write(V + " ");

        ArrayList<Integer> list = graph.get(V);
        for(int i = 0; i < list.size(); i++) {
            dfs(list.get(i));
        }
    }

    private static void bfs() throws IOException {
        while(!q.isEmpty()) {
            int n = q.poll();
            if(visited[n] == true){
                continue;
            }

            visited[n] = true;
            bw.write(n + " ");
            ArrayList<Integer> list = graph.get(n);
            for(int i = 0; i < list.size(); i++) {
                q.offer(list.get(i));
            }
        }
    }
}
