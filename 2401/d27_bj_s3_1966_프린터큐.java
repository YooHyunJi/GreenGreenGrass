package a2401;

import java.io.*;
import java.util.*;

public class d27_bj_s3_1966_프린터큐 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for(int t=0; t<T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            int[] queue = new int[N];
            st = new StringTokenizer(br.readLine());
            for(int n=0; n<N; n++) { queue[n] = Integer.parseInt(st.nextToken()); }
            if(N==1) {
                sb.append("1\n");
                continue;
            }
            int answer = 0;
            int find = 0;
            int now = 0;
            while(true) {
                boolean canPrint = true;
                for(int i=1; i<N; i++) {
                    find = (now+i)%N;
                    if(queue[find] > queue[now]) {
                        canPrint = false;
                        break;
                    }
                }
                if(canPrint) {
                    answer++;
                    if(now == M) {
                        sb.append(answer).append("\n");
                        break;
                    }
                    queue[now] = 0;
                }
                now = (now+1)%N;
            }
        }
        System.out.println(sb);
    }
}
