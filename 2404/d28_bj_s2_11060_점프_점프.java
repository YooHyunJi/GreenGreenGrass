package a2404;

import java.io.*;
import java.util.*;

public class d28_bj_s2_11060_점프_점프 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        boolean[] v = new boolean[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int n=0; n<N; n++){ arr[n] = Integer.parseInt(st.nextToken()); }
        ArrayDeque<int[]> queue = new ArrayDeque<>();
        v[0] = true;
        queue.offerLast(new int[] {0, 0});
        int answer = Integer.MAX_VALUE;
        while(!queue.isEmpty()){
            int[] now = queue.pollFirst();
            int idx = now[0];
            int round = now[1];
            if(idx == N-1){
                answer = round;
                break;
            }
            for(int i=1; i<=arr[idx]; i++){
                int nxtIdx = idx + i;
                if(N <= nxtIdx || v[nxtIdx]){ continue; }
                v[nxtIdx] = true;
                queue.offerLast(new int[] {nxtIdx, round+1});
            }
        }
        if(answer == Integer.MAX_VALUE){ answer = -1; }
        System.out.println(answer);
    }
}
