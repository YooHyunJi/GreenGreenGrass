package a2410;

import java.io.*;
import java.util.HashMap;

public class d09_bj_s4_11652_카드 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        HashMap<Long, Integer> map = new HashMap<>();
        for(int n=0; n<N; n++){
            long key = Long.parseLong(br.readLine());
            map.put(key, map.getOrDefault(key, 0) + 1);
        }
        long num = Long.MAX_VALUE;
        int cnt = 0;
        for(long key: map.keySet()){
            int now_cnt = map.get(key);
            if(cnt == now_cnt){
                if(key < num){
                    num = key;
                }
                continue;
            }
            if(cnt < now_cnt){
                cnt = now_cnt;
                num = key;
            }
        }
        System.out.println(num);
    }
}
