package a2401;

import java.io.*;
import java.util.*;

public class d15_bj_s5_7568_덩치 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] rank = new int[N];
        Arrays.fill(rank, 1);
        int[][] dc = new int[N][2];
        for(int n=0; n<N; n++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            dc[n] = new int[] {Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())};
        }
        for(int i=0; i<N; i++) { for(int j=0; j<N; j++) { if(dc[i][0]<dc[j][0] && dc[i][1]<dc[j][1]) { rank[i]++; } } }
        for(int r: rank) { System.out.print(r + " "); }
    }
}