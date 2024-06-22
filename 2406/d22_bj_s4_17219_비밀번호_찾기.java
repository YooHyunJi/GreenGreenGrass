package a2406;

import java.io.*;
import java.util.*;

public class d22_bj_s4_17219_비밀번호_찾기 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        HashMap<String, String> map = new HashMap<>();
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        for(int n=0; n<N; n++){
            st = new StringTokenizer(br.readLine());
            map.put(st.nextToken(), st.nextToken());
        }
        for(int m=0; m<M; m++){
            sb.append(map.get(br.readLine())).append("\n");
        }
        System.out.println(sb);
    }
}
