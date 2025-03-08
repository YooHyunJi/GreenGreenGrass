package a2503;

import java.io.*;
import java.util.*;

public class d08_bj_s5_1268_임시_반장_정하기 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] students = new int[N][5];
        for(int n=0; n<N; n++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int d=0; d<5; d++){
                students[n][d] = Integer.parseInt(st.nextToken());
            }
        }
        int max_cnt = 0;
        int answer = 1;
        for(int n=0; n<N; n++){
            boolean[] visit = new boolean[N];
            int cnt = 0;
            for(int d=0; d<5; d++){
                for(int nn=0; nn<N; nn++){
                    if(n == nn || visit[nn]){
                        continue;
                    }
                    if(students[n][d] == students[nn][d]){
                        visit[nn] = true;
                        cnt++;
                    }
                }
            }
            if(max_cnt < cnt){
                max_cnt = cnt;
                answer = n + 1;
            }
        }
        System.out.println(answer);
    }
}
