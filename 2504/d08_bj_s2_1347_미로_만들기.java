package a2504;

import java.io.*;
import java.util.*;

public class d08_bj_s2_1347_미로_만들기 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        br.readLine();
        char[] note = br.readLine().toCharArray();
        int r = 0;
        int c = 0;
        int d = 0;
        int min_r = 0;
        int min_c = 0;
        int max_r = 0;
        int max_c = 0;
        int[] dr = {1, 0, -1, 0};
        int[] dc = {0, -1, 0, 1};
        HashSet<int[]> set = new HashSet<>();
        set.add(new int[] {0, 0});
        for(char n: note){
            if(n == 'L'){
                d = (4 + d - 1) % 4;
            }
            else if(n == 'R'){
                d = (d + 1) % 4;
            }
            else{
                r += dr[d];
                c += dc[d];
                set.add(new int[] {r, c});
                min_r = Math.min(min_r, r);
                min_c = Math.min(min_c, c);
                max_r = Math.max(max_r, r);
                max_c = Math.max(max_c, c);
            }
        }
        int len_r = max_r - min_r + 1;
        int len_c = max_c - min_c + 1;
        min_r = min_r < 0? -min_r: 0;
        min_c = min_c < 0? -min_c: 0;
        for(int[] s: set){
            s[0] += min_r;
            s[1] += min_c;
        }

        boolean[][] visit = new boolean[len_r][len_c];
        for(int[] s: set){
            visit[s[0]][s[1]] = true;
        }
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<len_r; i++){
            for(int j=0; j<len_c; j++){
                sb.append(visit[i][j]? '.': '#');
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}