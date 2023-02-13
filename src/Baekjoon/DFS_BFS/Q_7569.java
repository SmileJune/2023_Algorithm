package Baekjoon.DFS_BFS;

import java.io.*;
import java.util.*;

class NNode {
    int c;
    int r;
    int h;
    int step;

    NNode(int c, int r, int h, int step) {
        this.c = c;
        this.r = r;
        this.h = h;
        this.step = step;
    }
}
public class Q_7569 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static int[][][] map;
    static boolean[][][] visited;
    static int M, N, H, result;
    static Queue<NNode> q = new LinkedList<>();
    static int[] dc = {-1, 1 , 0, 0, 0, 0};
    static int[] dr = {0, 0, -1, 1, 0, 0};
    static int[] dh = {0, 0, 0, 0, 1, -1};

    public static void main(String[] args) throws IOException {
        // 입력 받기
        st = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        int H = Integer.parseInt(st.nextToken());

        map = new int[N][M][H];
        visited = new boolean[N][M][H];
        for(int h = 0; h < H; h++) {
            for(int n = 0; n < N; n++) {
                st = new StringTokenizer(br.readLine());
                for(int m = 0; m < M; m++) {
                    int num = Integer.parseInt(st.nextToken());
                    map[n][m][h] = num;

                    //입력 받으면서 익은 토마토 있는 부분은 큐에 담아준다.
                    if(num == 1) {
                        q.offer(new NNode(n, m ,h, 0));
                        visited[n][m][h] = true;
                    }
                }
            }
        }

        while(!q.isEmpty()) {
            NNode node = q.poll();
            result = Math.max(node.step, result);
            for(int d = 0; d < 6; d++) {
                int nc = node.c + dc[d];
                int nr = node.r + dr[d];
                int nh = node.h + dh[d];

                //범위를 벗어났다면 패스
                if(!isInRange(nc, nr, nh)) continue;

                //이미 방문했다면 패스
                if(visited[nc][nr][nh] == true) continue;
                visited[nc][nr][nh] = true;

                //없다면 패스
                if(map[nc][nr][nh] == -1) continue;

                map[nc][nr][nh] = 1;
            }
        }

        //모두 확인이 끝났으면 남아있는 친구가 있는지 확인
        //남았으면 -1 출력 후 종료
        if(stillRemain()) {
            System.out.println(-1);
            return;
        }

        //안 남았으면 시간 출력
        System.out.println(result);

    }

    private static boolean stillRemain() {
        for(int h = 0; h < H; h++) {
            for(int n = 0; n < N; n++) {
                for(int m = 0; m < M; m++) {
                    if(map[n][m][h] == 0) {
                        return true;
                    }
                }
            }
        }

        return false;
    }

    private static boolean isInRange(int nc, int nr, int nh) {
        if(nc < 0 || M <= nc || nr < 0 || N <= nr || nh < 0 || H <= nh) {
            return false;
        }
        return true;
    }
}
