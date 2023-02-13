package Baekjoon.DFS_BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

class Node {
    int r;
    int c;

    Node(int r, int c) {
        this.r = r;
        this.c = c;
    }
}

public class Q_1926 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static LinkedList<Node> q;
    static LinkedList<Node> cntQ;
    static int[][] map;
    static boolean[][] visited;
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};
    static int n, m;
    static int cnt, max;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[n][m];
        visited = new boolean[n][m];

        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

//        System.out.println(Arrays.deepToString(map));

        //모든 점에 대해서 확인
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                check(i, j);
            }
        }

        System.out.println(cnt);
        System.out.println(max);

    }

    private static void check(int i, int j) {
        //0 이면 리턴
        if(map[i][j] == 0) {
            visited[i][j] = true;
            return;
        }

        //방문했다면 리턴
        if(visited[i][j]) {
            return;
        }

        //방문 안했다면 체크 시작
        q =  new LinkedList<>();
        cntQ = new LinkedList<>();

        q.offer(new Node(i, j));
        visited[i][j] = true;

        while(!q.isEmpty()) {
            Node node = q.poll();
            cntQ.offer(node);

            for(int d = 0; d < 4; d++) {
                int nr = node.r + dr[d];
                int nc = node.c + dc[d];

                // 범위 확인
                if(!isInRange(nr, nc)) {
                    continue;
                }

                // 방문 확인
                if(visited[nr][nc]) {
                    continue;
                }

                // 방문 처리
                visited[nr][nc] = true;

                // 그림아니면 패스
                if(map[nr][nc] == 0) {
                    continue;
                }

                //그림이면 확인
                q.offer(new Node(nr, nc));
            }
        }
        cnt++;
        max = Math.max(max, cntQ.size());
    }

    private static boolean isInRange(int nr, int nc) {
        if(nr < 0 || n <= nr || nc < 0 || m <= nc) {
            return false;
        }
        return true;
    }
}
