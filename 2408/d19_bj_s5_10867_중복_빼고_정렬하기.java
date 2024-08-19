package a2408;

import java.io.*;
import java.util.*;

public class d19_bj_s5_10867_중복_빼고_정렬하기 {
    public static void main(String[] args) throws Exception{
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for(int n=0; n<N; n++){ map.put(Integer.parseInt(st.nextToken()), 0); }
        for(int key: map.keySet()){ sb.append(key).append(" "); }
        System.out.println(sb);
    }
}
