package Baekjoon.DFS_BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Q_2468 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static Set<Integer> set = new HashSet<>();
    static int[][] map;
    static boolean[][] visited;
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, 1, -1};
    static int result = 1;
    static int N, cnt;
    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];

        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                set.add(map[i][j]);
            }
        }
        List<Integer> list = new ArrayList<>(set);

        for(int i = 0; i < list.size(); i++) {
            solution(list.get(i));
        }

        System.out.println(result);

    }

    private static void solution(int height) {
        //모든 높이마다 확인
        visited = new boolean[N][N];
        cnt = 0;

        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                //방문했다면 넘어가
                if(visited[i][j] == true) {
                    continue;
                }

                //잠긴 곳이라면 방문처리하고 넘어가
                if(map[i][j] <= height) {
                    visited[i][j] = true;
                    continue;
                }

                //방문하지 않았고 섬이라면 체크
                cnt++;
                //모든 섬 체크
                dfs(i, j, height);
            }
        }

        result = Math.max(result, cnt);
    }

    private static void dfs(int i, int j, int height) {
        //모든 점에 대해서 확인 DFS로 확인해보자.
        //혹시 스택의 깊이가 어디까지 내려갈 수 있을까? 만개도 버틸 수 있나?

        //일단 범위 안에 들어 왔는지 체크
        if(!isInRange(i, j)) return;

        //방문 했는지 체크
        if(visited[i][j]) return;

        //잠긴 곳이라면 방문처리하고 넘어가
        if(map[i][j] <= height) {
            visited[i][j] = true;
            return;
        }

        visited[i][j] = true;

        for(int d = 0; d < 4; d++) {
            int nr = i + dr[d];
            int nc = j + dc[d];
            dfs(nr, nc, height);
        }

    }

    private static boolean isInRange(int i, int j) {
        if(i < 0 || N <= i || j < 0 || N <= j) {
            return false;
        }
        return true;
    }
}
