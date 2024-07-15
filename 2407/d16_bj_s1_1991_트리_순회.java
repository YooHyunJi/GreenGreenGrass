package a2407;

import java.io.*;
import java.util.*;

public class d16_bj_s1_1991_트리_순회 {
    static int LIMIT;
    static char[] tree;
    static StringBuilder sb = new StringBuilder();

    static void pre(int idx){
        if(LIMIT <= idx || tree[idx] == '.'){ return; }
        sb.append(tree[idx]);
        pre(2*idx);
        pre(2*idx+1);
    }

    static void mid(int idx){
        if(LIMIT <= idx || tree[idx] == '.'){ return; }
        mid(2*idx);
        sb.append(tree[idx]);
        mid(2*idx+1);
    }

    static void post(int idx){
        if(LIMIT <= idx || tree[idx] == '.'){ return; }
        post(2*idx);
        post(2*idx+1);
        sb.append(tree[idx]);
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        HashMap<Character, Integer> map = new HashMap<>();
        map.put('A', 1);

        LIMIT = (int)(Math.pow(2, N));
        tree = new char[LIMIT];
        for(int i=1; i<=N; i++){
            char[] line = br.readLine().toCharArray();
            int mid = map.get(line[0]);
            int left = mid*2;
            int right = mid*2+1;
            tree[mid] = line[0];
            if(LIMIT <= left){ continue; }
            tree[left] = line[2];
            tree[right] = line[4];
            if(line[2] != '.'){ map.put(line[2], left); }
            if(line[4] != '.'){ map.put(line[4], right); }
        }
        pre(1); sb.append("\n");
        mid(1); sb.append("\n");
        post(1);
        System.out.println(sb);
    }
}
