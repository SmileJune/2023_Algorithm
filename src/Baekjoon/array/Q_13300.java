package Baekjoon.array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 인덱스를 이용하자.
 * 7x2 배열을 만들고 1-6 학년 및 여학생 0, 남학생 1 각각 인원수 추가
 *  배열 돌면서 (k-1) 더해주고 k로 나눈 수를 결과값에 더해준다.
 *  그럼 0명 남은 것, 1명이 남은 것, k-1명이 남은 것 해결된다.
 */
public class Q_13300 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    public static void main(String[] args) throws IOException {
        int[][] map = new int[7][2];

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int gender = Integer.parseInt(st.nextToken());
            int grade = Integer.parseInt(st.nextToken());
            map[grade][gender]++;
        }

        int result = 0;

        for(int i = 1; i <= 6; i++) {
            for(int j = 0; j <= 1; j++) {
                result += ((map[i][j] + K - 1) / K);
            }
        }

        System.out.println(result);
    }
}
