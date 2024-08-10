package a2408;

import java.io.*;
import java.util.*;

public class d10_bj_s1_20922_겹치는_건_싫어 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[] arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int n=0; n<N; n++){
            int num = Integer.parseInt(st.nextToken());
            arr[n] = num;
        }
        HashMap<Integer, Integer> map = new HashMap<>();
        int answer = 0;
        int from = 0;
        int to = 0;
        while(to < N){
            int num = arr[to];
            map.put(num, map.getOrDefault(num, 0) + 1);
            while (K < map.get(num)) {
                map.put(arr[from], map.get(arr[from]) - 1);
                from++;
            }
            to++;
            answer = Math.max(answer, to-from);
        }
        System.out.println(answer);
    }
}
