package a2401;

import java.io.*;
import java.util.*;

public class d11_bj_s5_2669_직사각형네개의합집합의면적구하기 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        boolean[][] paper = new boolean[101][101];
        int answer = 0;
        for(int n=0; n<4; n++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int lbx = Integer.parseInt(st.nextToken());
            int lby = Integer.parseInt(st.nextToken());
            int rtx = Integer.parseInt(st.nextToken());
            int rty = Integer.parseInt(st.nextToken());
            for(int x=lbx; x<rtx; x++) {
                for(int y=lby; y<rty; y++) {
                    if(paper[x][y]){ continue; }
                    paper[x][y] = true;
                    answer++;
                }
            }
        }
        System.out.println(answer);
    }
}
