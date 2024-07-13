package a2407;

import java.io.*;
import java.util.*;

public class d13_bj_s3_15652_N과_M_12 {
    static int N, M, S;
    static Integer[] arr;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        TreeSet<Integer> set = new TreeSet<>();
        for(int n=0; n<N; n++){ set.add(Integer.parseInt(st.nextToken())); };
        S = set.size();
        arr = set.toArray(new Integer[0]);
        makePerm(0, 0, "");
        System.out.println(sb);
    }

    static void makePerm(int from, int cnt, String result){
        if(cnt == M){
            sb.append(result).append("\n");
            return;
        }
        for(int i=from; i<S; i++){
            makePerm(i, cnt+1, cnt==0? arr[i]+"": result+" "+arr[i]);
        }
    }
}
