package a2407;

import java.io.*;
import java.util.*;

public class d11_bj_s2_15663_N과_M_9 {
    static StringBuilder sb = new StringBuilder();
    static int N, M;
    static int[] arr;
    static boolean[] visit;
    static Set<String> set = new TreeSet<>();

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N];
        visit = new boolean[N];
        st = new StringTokenizer(br.readLine());
        for(int n=0; n<N; n++){
            arr[n] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        makePerm(0, "");
        System.out.println(sb);
    }

    static void makePerm(int cnt, String result){
        if(cnt == M){
            if(!set.contains(result)){
                sb.append(result).append("\n");
                set.add(result);
            }
            return;
        }
        for(int i=0; i<N; i++){
            if(visit[i]){ continue; }
            visit[i] = true;
            makePerm(cnt+1, cnt==0? String.valueOf(arr[i]) : result+" "+arr[i]);
            visit[i] = false;
        }
    }
}
