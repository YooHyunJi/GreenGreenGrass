package a2409;

import java.io.*;
import java.util.*;

public class d28_bj_s4_1940_주몽 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        int[] nums = new int[N];
        int answer = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int n=0; n<N; n++){
            int num = Integer.parseInt(st.nextToken());
            nums[n] = num;
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        for(int n=0; n<N; n++){
            int now = nums[n];
            int other = M - now;
            if(!map.containsKey(other)){
                continue;
            }
            if(now == other && map.get(now) < 2){
                continue;
            }
            if(map.get(now) == 0 || map.get(other) == 0){
                continue;
            }
            map.put(now, map.get(now) - 1);
            map.put(other, map.get(other) - 1);
            answer++;
        }
        System.out.println(answer);
    }
}
