package a2408;

import java.io.*;
import java.util.*;

public class d31_bj_s3_18429_근손실 {

    static int N, K, answer = 0;
    static int[] arr, result;
    static boolean[] visit;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        arr = new int[N];
        result = new int[N];
        visit = new boolean[N];
        st = new StringTokenizer(br.readLine());
        for(int n=0; n<N; n++){
            arr[n] = Integer.parseInt(st.nextToken());
        }
        makePerm(0);
        System.out.println(answer);
    }

    static boolean isPossible(){
        int init = 500;
        for(int n=0; n<N; n++){
            init = init + result[n] - K;
            if(init < 500){
                return false;
            }
        }
        return true;
    }

    static void makePerm(int cnt){
        if(cnt == N){
            if(isPossible()){
                answer++;
            }
            return;
        }
        for(int n=0; n<N; n++){
            if(visit[n]){
                continue;
            }
            visit[n] = true;
            result[cnt] = arr[n];
            makePerm(cnt + 1);
            visit[n] = false;
        }
    }
}
