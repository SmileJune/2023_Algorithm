package Baekjoon;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

/**
 * Map에다 넣어놓고 키만 빼서 정렬한 뒤에 출력하면 되겠다.
 */
public class Q_20291 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static HashMap<String, Integer> map = new HashMap<>();

    public static void main(String[] args) throws IOException {
        int num = Integer.parseInt(br.readLine());

        //갯수만큼 받아서 각각 확장자 별로 갯수 저장
        for(int i=0; i<num; i++) {
            String str = br.readLine();
            String ext = str.split("\\.")[1];


            if(map.containsKey(ext)){
                map.put(ext, map.get(ext) + 1);
            } else {
                map.put(ext, 1);
            }
        }

        //키 배열만 꺼내서 정렬
        ArrayList<String> list = new ArrayList<>(map.keySet());
        Collections.sort(list);
        for(int i=0; i<list.size(); i++) {
            bw.write(list.get(i)+" "+map.get(list.get(i))+"\n");
        }

        bw.close();
    }
}
