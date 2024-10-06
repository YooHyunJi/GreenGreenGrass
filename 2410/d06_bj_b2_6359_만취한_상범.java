package a2410;

import java.io.*;
import java.util.*;

public class d06_bj_b2_6359_만취한_상범 {
    public static void main(String[] args) throws Exception{
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for(int t=0; t<T; t++){
            int N = Integer.parseInt(br.readLine());
            boolean[] visit = new boolean[N];
            for(int n=1; n<=N; n++){
                for(int i=n-1; i<N; i+=n){
                    visit[i] = !visit[i];
                }
            }
            int answer = 0;
            for(int i=0; i<N; i++){
                if(visit[i]){
                    answer++;
                }
            }
            sb.append(answer).append("\n");
        }
        System.out.println(sb);
    }
}