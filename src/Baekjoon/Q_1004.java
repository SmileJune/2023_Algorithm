package Baekjoon;

import java.io.*;
import java.util.StringTokenizer;

/**
 * 각 원마다 상태를 잘 봐야함
 * 중심으로부터 거리가 반지름보다 멀다 => 신경안써도 됨
 * 반지름보다 가깝다 => 일단 안에 있다.
 * 도착지점도 이 원안에 있으면 신경안써도 됨
 * 도착지점이 이 원 밖에 있으면 진입/이탈 횟수 ++
 *
 * 한 원에 대해서 두 점이 가질 수 있는 상태는 이 3가지 경우 뿐
 * 모든 원에 대해서 각각 도착지, 출발지에 대한 판단을 한다.
 */
public class Q_1004 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        int T = Integer.parseInt(br.readLine());
        for(int tc = 1; tc <= T; tc++) {
            solution();
        }

        bw.close();
    }

    private static void solution() throws IOException {
        st = new StringTokenizer(br.readLine());
        int[] start = new int[]{Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())};
        int[] end =new int[]{Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())};

        int num = Integer.parseInt(br.readLine());
        int ans = 0;

        for(int i = 0; i < num; i++) {
            // in에 1 주고 out에 -1 주고 곱이 음수이면 ++
            st = new StringTokenizer(br.readLine());
            int[] circle = new int[]{
                    Integer.parseInt(st.nextToken()),
                    Integer.parseInt(st.nextToken()),
                    Integer.parseInt(st.nextToken())
            };

            int a = check(start, circle);
            int b = check(end, circle);

            if(a * b < 0) {
                ans++;
            }
        }

        bw.write(ans + "\n");
    }

    private static int check(int[] dot, int[] circle) {
        if( Math.pow(dot[0] - circle[0], 2) + Math.pow(dot[1] - circle[1], 2) < Math.pow(circle[2], 2)) {
            return 1;
        }
        return -1;
    }
}
