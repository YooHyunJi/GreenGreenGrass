package a2312;

import java.io.*;
import java.util.*;

public class d21_bj_s3_14501_퇴사 {
    static class day{
        int T;
        int P;

        public day(int T, int P){
            this.T = T;
            this.P = P;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        day[] schedule = new day[N+1];
        int[] maxArr = new int[N+2];
        for(int n=1; n<=N; n++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            schedule[n] = new day(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
            if(n+schedule[n].T-1>N) schedule[n].P = 0;
        }
        for(int n=N; n>=1; n--){
            int maxFirst  = n+1<=N? maxArr[n+1]: 0;
            int maxSecond = n+schedule[n].T<=N? maxArr[n+schedule[n].T]: 0;
            maxArr[n] = Math.max(maxFirst, schedule[n].P+maxSecond);
        }
        System.out.println(maxArr[1]);
    }
}
