package a2412;

import java.io.*;
import java.util.*;

public class d04_bj_b3_9610_사분면 {
    public static void main(String[] args) throws Exception{
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int q1 = 0;
        int q2 = 0;
        int q3 = 0;
        int q4 = 0;
        int axis = 0;
        for(int n=0; n<N; n++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            if(x == 0 ||  y == 0){
                axis++;
                continue;
            }
            if(0 < y){
                if(0 < x){ q1++; }
                else{ q2++; }
            }
            else{
                if(x < 0){ q3++; }
                else{ q4++; }
            }
        }
        sb.append("Q1: ").append(q1).append("\n")
                .append("Q2: ").append(q2).append("\n")
                .append("Q3: ").append(q3).append("\n")
                .append("Q4: ").append(q4).append("\n")
                .append("AXIS: ").append(axis);
        System.out.println(sb);
    }
}
