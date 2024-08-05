package a2408;

import java.io.*;
import java.util.*;

public class d05_bj_s2_2512_예산 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] request = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int n=0; n<N; n++){
            request[n] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(request);
        int whole = Integer.parseInt(br.readLine());
        int from = 1;
        int to = request[N-1];
        while(from <= to){
            int limit = (from + to) / 2;
            int sum = 0;
            int cnt = 0;
            for(int n=0; n<N; n++){
                if(limit < request[n]){
                    cnt = N -n;
                    break;
                }
                sum += request[n];
            }
            sum += limit * cnt;
            if(sum <= whole){ from = limit+1; }
            else{ to = limit-1; }
        }
        System.out.println(to);
    }
}
