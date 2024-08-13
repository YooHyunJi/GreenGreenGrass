package a2408;

import java.io.*;
import java.util.*;

public class d13_bj_s1_2531_회전_초밥 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int D = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        int[] sushiBelt = new int[N];
        int[] sushiCount = new int[D+1];
        int answer = 0;
        int count = 0;
        for(int i=0; i<N; i++){
            sushiBelt[i] = Integer.parseInt(br.readLine());
        }
        for(int i=0; i<K; i++){
            int sushi = sushiBelt[i];
            if(sushiCount[sushi]++ == 0){ count++; }
        }
        answer = sushiCount[C] == 0? count + 1: count;
        for(int i=0; i<N-1; i++){
            int first = sushiBelt[i];
            int last = sushiBelt[(i+K)%N];
            if(--sushiCount[first] == 0){ count--; }
            if(sushiCount[last]++ == 0){ count++; }
            answer = Math.max(answer, sushiCount[C] == 0? count + 1: count);
        }
        System.out.println(answer);
    }
}
