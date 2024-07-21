package a2407;

import java.io.*;
import java.util.*;

public class d21_bj_s5_1251_단어_나누기 {
    public static void main(String[] args) throws Exception{
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        for(int n=0; n<N; n++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int T = Integer.parseInt(st.nextToken());
            HashMap<Long, Integer> map = new HashMap<>();
            for(int t=0; t<T; t++){
                long num = Long.parseLong(st.nextToken());
                map.put(num, map.getOrDefault(num, 0)+1);
            }
            boolean isConquered = false;
            for(Map.Entry<Long, Integer> entry: map.entrySet()){
                if(T/2 < entry.getValue()){
                    sb.append(entry.getKey()).append("\n");
                    isConquered = true;
                    break;
                }
            }
            if(isConquered){ continue; };
            sb.append("SYJKGW\n");
        }
        System.out.println(sb);
    }
}
