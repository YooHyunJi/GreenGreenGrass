package a2406;

import java.io.*;
import java.util.*;

public class d25_bj_s3_9375_패션왕_신해빈 {
    public static void main(String[] args) throws Exception{
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for(int t=0; t<T; t++){
            int N = Integer.parseInt(br.readLine());
            HashMap<String, Integer> map = new HashMap<>();
            for(int n=0; n<N; n++){
                StringTokenizer st = new StringTokenizer(br.readLine());
                st.nextToken();
                String key = st.nextToken();
                if(!map.containsKey(key)){ map.put(key, 1); }
                map.put(key, map.get(key) + 1);
            }
            int answer = 1;
            for(int value: map.values()){
                answer *= value;
            }
            sb.append(answer - 1).append("\n");
        }
        System.out.println(sb);
    }
}