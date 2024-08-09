package a2408;

import java.io.*;
import java.util.*;

public class d09_bj_g5_20437_문자열_게임_2 {
    public static void main(String[] args) throws Exception{
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for(int t=0; t<T; t++){
            char[] arr = br.readLine().toCharArray();
            int K = Integer.parseInt(br.readLine());
            if(K==1){
                sb.append("1 1\n");
                continue;
            }
            HashMap<Character, ArrayList<Integer>> map = new HashMap<>();
            for(int i=0; i<arr.length; i++){
                char c = arr[i];
                if(!map.containsKey(c)){ map.put(c, new ArrayList<>()); }
                map.get(c).add(i);
            }
            int min = 99_999;
            int max = -1;
            for(char c: map.keySet()){
                int S = map.get(c).size();
                if(S < K){ continue; }
                int gap = K-1;
                for(int i=gap; i<S; i++){
                    int diff = map.get(c).get(i) - map.get(c).get(i-gap) + 1;
                    min = Math.min(min, diff);
                    max = Math.max(max, diff);
                }
            }
            if(max == -1){ sb.append("-1\n"); }
            else{ sb.append(min).append(" ").append(max).append("\n"); }
        }
        System.out.println(sb);
    }
}
