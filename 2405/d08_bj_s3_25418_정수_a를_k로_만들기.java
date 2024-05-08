package a2405;

import java.io.*;
import java.util.*;

public class d08_bj_s3_25418_정수_a를_k로_만들기 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int A = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        boolean[] v = new boolean[K+1];
        ArrayDeque<int[]> queue = new ArrayDeque<>();
        queue.offerLast(new int[] {A, 0});
        while(!queue.isEmpty()){
            int[] now = queue.pollFirst();
            int val = now[0];
            int cnt = now[1];
            if(K < val || v[val]){ continue; }
            if(val == K){
                System.out.println(cnt);
                return;
            }
            v[val] = true;
            queue.offerLast(new int[] { 1+val, cnt+1 });
            queue.offerLast(new int[] { 2*val, cnt+1 });
        }
    }
}
