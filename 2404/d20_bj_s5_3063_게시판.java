package a2404;

import java.io.*;
import java.util.*;

public class d20_bj_s5_3063_게시판 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for(int t=0; t<T; t++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int[] lb1 = new int[] {Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())};
            int[] rt1 = new int[] {Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())};
            int[] lb2 = new int[] {Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())};
            int[] rt2 = new int[] {Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())};

            int w1 = rt1[0] - lb1[0];
            int h1 = rt1[1] - lb1[1];
            int w2 = rt2[0] - lb2[0];
            int h2 = rt2[1] - lb2[1];
            int whole = w1 * h1;

            if(lb2[0]>=rt1[0] || lb2[1]>=rt1[1] || rt2[0]<=lb1[0] || rt2[1]<=lb1[1]){
                sb.append(whole).append("\n");
                continue;
            }

            int rw = Math.max(rt1[0], rt2[0]) - Math.min(lb1[0], lb2[0]);
            int rh = Math.max(rt1[1], rt2[1]) - Math.min(lb1[1], lb2[1]);

            int w = w1 + w2 - rw;
            int h = h1 + h2 - rh;
            sb.append(whole - (w*h)).append("\n");
        }
        System.out.println(sb);
    }
}