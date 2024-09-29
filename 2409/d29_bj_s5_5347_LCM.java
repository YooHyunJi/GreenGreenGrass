package a2409;

import java.io.*;
import java.util.*;

public class d29_bj_s5_5347_LCM {
    public static void main(String[] args) throws Exception{
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        for(int n=0; n<N; n++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            long a = Integer.parseInt(st.nextToken());
            long b = Integer.parseInt(st.nextToken());
            long A = Math.min(a, b);
            long B = Math.max(a, b);
            for(int i=1; i<=B; i++){
                long now = A * i;
                if(now % B == 0){
                    sb.append(now).append("\n");
                    break;
                }
            }
        }
        System.out.println(sb);
    }
}
