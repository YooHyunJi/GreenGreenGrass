package a2406;

import java.io.*;
import java.util.*;

public class d19_bj_s2_18870_좌표_압축 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        SortedMap<Integer, Integer> map = new TreeMap<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int n=0; n<N; n++){
            arr[n] = Integer.parseInt(st.nextToken());
            map.put(arr[n], -1);
        }
        int idx = 0;
        for(int key: map.keySet()){
            map.put(key, idx++);
        }
        StringBuilder sb = new StringBuilder();
        for(int n=0; n<N; n++){
            sb.append(map.get(arr[n])).append(" ");
        }
        System.out.println(sb);
    }
}
