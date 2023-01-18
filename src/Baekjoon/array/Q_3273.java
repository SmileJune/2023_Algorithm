package Baekjoon.array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 만약에 하나씩 뽑아서 전체 경우의 수를 다 본다면? 10^10 100초. 시간초과
 * 정렬한 뒤에 front, back 인덱스로부터 각각 출발.
 * 수가 부족하면 front++
 * 수가 충분하면 back--
 * front > back 이 되는 순간 탐색 종료
 */
public class Q_3273 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);

        int x = Integer.parseInt(br.readLine());

        int front = 0;
        int back = arr.length - 1;
        int result = 0;

        while(front < back) {
            //같다면 갯수 늘려주고 양쪽 다 움직인다.
            if(arr[front] + arr[back] == x) {
                result++;
                front++;
                back--;
                continue;
            }

            //부족하다면 front만 늘려준다.
            if(arr[front] + arr[back] < x) {
                front++;
                continue;
            }

            //넘친다면 back만 줄여준다.
            back--;
            continue;
        }

        System.out.println(result);
    }
}
