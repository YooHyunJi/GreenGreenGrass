package a2312;

import java.io.*;
import java.util.*;

public class d26_bj_s3_두수의합 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] nums = new int[N];
        boolean[] isExist = new boolean[1_000_001];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int n=0; n<N; n++){
            nums[n] = Integer.parseInt(st.nextToken());
            isExist[nums[n]] = true;
        }
        int X = Integer.parseInt(br.readLine());
        int answer = 0;
        for(int n=0; n<N-1; n++){
            if(1<=X-nums[n] && X-nums[n]<=1_000_000 && nums[n]!=X-nums[n] && isExist[nums[n]] && isExist[X-nums[n]]){
                isExist[nums[n]] = false;
                isExist[X-nums[n]] = false;
                answer++;
            }
        }
        System.out.println(answer);
    }
}