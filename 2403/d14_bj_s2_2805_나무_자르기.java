package a2403;

import java.io.*;
import java.util.*;

public class d14_bj_s2_2805_나무_자르기 {
    static int N, M, height;
    static int[] trees;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        trees = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int n=0; n<N; n++){ trees[n] = Integer.parseInt(st.nextToken()); }
        findHeight(0, 2_000_000_000);
        System.out.println(height);
    }

    static void findHeight(int start, int end){
        int mid = (start + end) / 2;
        System.out.println(start+" "+mid+" "+end);
        if(mid == height){ return; }
        long leftover = leftover(mid);
        height = mid;
        if(leftover == M){ return; }
        if(leftover < M){
            findHeight(start, mid);
            return;
        }
        findHeight(mid, end);
    }

    static long leftover(int height){
        long result = 0;
        for(int n=0; n<N; n++){ result += trees[n] <= height? 0: trees[n] - height; }
        return result;
    }
}
