package Baekjoon;

import java.io.*;
import java.util.*;

/**
 * 한 점에서 가능한 움직임 수는 총 3가지.
 * 모든 경우의 수를 판단해 봐야한다.
 * step 을 가지고 다니면서 체크하다가 K가 나오면 스탑
 * 초기 시작점 N에서는 step 0 이다.
 */
class Node {
    int num;
    int step;

    Node(int num, int step) {
        this.num = num;
        this.step = step;
    }
}

public class Q_1697 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static boolean[] visited = new boolean[100001];
    static Queue<Node> q = new LinkedList<>();
    static StringTokenizer st;
    static int N, K;

    public static void main(String[] args) throws Exception {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        // 하나 넣어두고 출발
        q.offer(new Node(N, 0));
        visited[N] = true;

        while(!q.isEmpty()) {
            Node node = q.poll();

            // 찾았으면 스톱
            if(node.num == K) {
                System.out.println(node.step);
                return;
            }

            // 못찾았으면 다음 단계 넣기
            // -1
            if(node.num - 1 >= 0 && visited[node.num - 1] == false) {
              q.offer(new Node(node.num - 1, node.step + 1));
              visited[node.num - 1] = true;
            }

            // +1
            if(node.num + 1 <= 100000 && visited[node.num + 1] == false) {
              q.offer(new Node(node.num + 1, node.step + 1));
              visited[node.num + 1] = true;
            }

            // *2
            if(node.num * 2 <= 100000 && visited[node.num * 2] == false) {
              q.offer(new Node(node.num * 2, node.step + 1));
              visited[node.num * 2] = true;
            }

        }

    }
}
