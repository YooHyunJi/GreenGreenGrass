package a2407;

import java.io.*;
import java.util.*;

public class d04_bj_g4_7662_이중_우선순위_큐 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for(int t=0; t<T; t++){
            int K = Integer.parseInt(br.readLine());
            TreeMap<Integer, Integer> map = new TreeMap<>();
            for(int k=0; k<K; k++){
                StringTokenizer st = new StringTokenizer(br.readLine());
                String op = st.nextToken();
                int num = Integer.parseInt(st.nextToken());
                if(op.equals("I")){
                    map.put(num, map.getOrDefault(num, 0) + 1);
                }
                else{
                    if(map.isEmpty()){ continue; }
                    int n = num == 1? map.lastKey(): map.firstKey();
                    map.put(n, map.get(n) - 1);
                    if(map.get(n) == 0){ map.remove(n); }
                }
            }
            if(map.isEmpty()){ sb.append("EMPTY").append("\n"); }
            else{ sb.append(map.lastKey()).append(" ").append(map.firstKey()).append("\n"); }
        }
        System.out.println(sb);
    }
}