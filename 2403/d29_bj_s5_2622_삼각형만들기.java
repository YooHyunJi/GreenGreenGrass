package a2403;

import java.io.*;
import java.util.*;

public class d29_bj_s5_2622_삼각형만들기 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int cnt = 0;

        for(int a=1; a<N; a++){
            for(int b=a; b<N; b++){
                int c = N-a-b;
                if(c<b){ break; }
                if(b+a > c) cnt++;
            }
        }
        System.out.println(cnt);
    }
}