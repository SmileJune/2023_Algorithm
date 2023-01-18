package Baekjoon.array;

import java.io.*;
import java.util.StringTokenizer;

/**
 * 알파벳 갯수가 같으면 되니까 각각 넣어놓고 갯수가 같은지 확인하면 되겠네
 */
public class Q_11328 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine());
        for(int i = 0; i < N; i++) {
            solution();
        }
        bw.close();
    }

    private static void solution() throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        String str1 = st.nextToken();
        String str2 = st.nextToken();

        int[] arr1 = new int['z' - 'a' + 1];
        int[] arr2 = new int['z' - 'a' + 1];

        for(int i = 0; i < str1.length(); i++) {
            arr1[str1.charAt(i) - 'a']++;
        }

        for(int i = 0; i < str2.length(); i++) {
            arr2[str2.charAt(i) - 'a']++;
        }

        check(arr1, arr2);
    }

    private static void check(int[] arr1, int[] arr2) throws IOException {
        for(int i = 0; i < arr1.length; i++) {
            //같으면 다음 인덱스 확인
            if(arr1[i] == arr2[i]) {
                continue;
            }

            //다르면 아웃
            bw.write("Impossible\n");
            return;
        }

        //끝까지 같다. 성공
        bw.write("Possible\n");
    }
}
