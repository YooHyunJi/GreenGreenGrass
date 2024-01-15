package a2401;

import java.io.*;
import java.util.*;

public class d16_bj_s5_10431_줄세우기 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int P = Integer.parseInt(br.readLine());
        int[] height = new int[20];
        for(int p=1; p<=P; p++) {
            int answer = 0;
            Arrays.fill(height, 0);
            StringTokenizer st = new StringTokenizer(br.readLine());
            sb.append(st.nextToken()).append(" ");
            for(int h=0; h<20; h++) {
                int num = Integer.parseInt(st.nextToken());
                for(int f=0; f<h; f++) {
                    if(height[f] > num) {
                        answer += h-f;
                        for(int m=h; m>f; m--) { height[m] = height[m-1];}
                        height[f] = num;
                        break;
                    }
                }
                if(height[h]==0) { height[h] = num; }
            }
            sb.append(answer).append("\n");
        }
        System.out.println(sb);
    }
}