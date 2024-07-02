package a2407;

import java.io.*;
import java.util.*;

public class d03_bj_s2_30804_과일_탕후루 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] tanghuru = new int[N];
        int[] cnt = new int[10];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            tanghuru[i] = Integer.parseInt(st.nextToken());
        }
        int l = 0, r = 0, type = 0, answer = 0, length = 0;
        while(true){
            if(r == N){
                System.out.println(r - l);
                return;
            }
            if(cnt[tanghuru[r]] == 0){ type++; }
            cnt[tanghuru[r]]++;
            length++;

            if(2 < type){
                cnt[tanghuru[l]]--;
                length--;
                if(cnt[tanghuru[l]] == 0){ type--; }
                l++;
            }
            answer = Math.max(answer, length);
            r++;
        }
    }
}
