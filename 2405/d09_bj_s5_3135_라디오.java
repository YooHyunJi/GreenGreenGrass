package a2405;

import java.io.*;
import java.util.*;

public class d09_bj_s5_3135_라디오 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(br.readLine());
        int answer = Math.abs(A-B);
        for(int n=0; n<N; n++){
            int diff = Math.abs(B-Integer.parseInt(br.readLine()));
            if(diff < answer){ answer = diff + 1; }
        }
        System.out.println(answer);
    }
}
