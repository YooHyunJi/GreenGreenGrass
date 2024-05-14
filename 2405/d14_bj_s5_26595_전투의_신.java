package a2405;

import java.io.*;
import java.util.*;

public class d14_bj_s5_26595_전투의_신 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int A = Integer.parseInt(st.nextToken());
        int PA = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int PB = Integer.parseInt(st.nextToken());
        long answer = 0;
        int answerA = 0;
        int answerB = 0;
        for(int i=0; i<N; i++){
            int cntA = (N-i) / PA;
            int cntB = (i) / PB;
            long now = (long) cntA *A + (long) cntB *B;
            if(answer < now){
                answerA = cntA;
                answerB = cntB;
                answer = now;
            }
        }
        System.out.println(answerA + " " + answerB);
    }
}
