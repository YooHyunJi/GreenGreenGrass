package a2408;

import java.io.*;
import java.util.*;

public class d05_bj_s4_17266_어두운_굴다리 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        int[] light = new int[M];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int m=0; m<M; m++){
            light[m] = Integer.parseInt(st.nextToken());
        }
        int answer = light[0];
        for(int m=1; m<M-1; m++){
            answer = Math.max(answer, (int)(Math.ceil((light[m]-light[m-1])/2.0)));
        }
        answer = Math.max(answer, N-light[M-1]);
        System.out.println(answer);
    }
}