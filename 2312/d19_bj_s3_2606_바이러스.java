package a2312;

import java.io.*;
import java.util.*;

public class d19_bj_s3_2606_바이러스 {
    static int[] p;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int C = Integer.parseInt(br.readLine());
        int N = Integer.parseInt(br.readLine());
        p = new int[C+1];
        for(int c=1; c<=C; c++) p[c] = c;
        for(int n=0; n<N; n++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            union(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }
        int p1 = find(1), answer = 0;
        for(int c=2; c<=C; c++) if(find(c)==p1) answer++;
        System.out.println(answer);
    }

    static void union(int x, int y){
        int px = find(x), py = find(y);
        if(px==py) return;
        p[py] = px;
    }

    static int find(int x){
        if(x==p[x]) return x;
        return p[x]=find(p[x]);
    }
}