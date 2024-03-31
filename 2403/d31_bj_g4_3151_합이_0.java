package a2403;

import java.io.*;
import java.util.*;

public class d31_bj_g4_3151_합이_0 {
    static int N;
    static int[] scores;

    public static void main(String[] args) throws Exception{
        long answer = 0;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        scores = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int n=0; n<N; n++){ scores[n] = Integer.parseInt(st.nextToken()); }
        Arrays.sort(scores);

        for(int i=0; i<N-2; i++){
            int target = -scores[i];
            int idxS = i+1, idxE = N-1;
            while(idxS < idxE){
                int sum = scores[idxS] + scores[idxE];
                if(sum == target){
                    if(scores[idxS] == scores[idxE]){
                        int diff = idxE - idxS + 1;
                        answer += ((long) diff * (diff-1))/2;
                        break;
                    }
                    else{
                        long sumS = 1, sumE = 1;
                        while(scores[idxS] == scores[idxS+1] && idxS+1 < idxE){
                            idxS++;
                            sumS++;
                        }
                        while(scores[idxE] == scores[idxE-1] && idxS < idxE-1){
                            idxE--;
                            sumE++;
                        }
                        answer += (sumS * sumE);
                    }
                    idxS++;
                    idxE--;
                }
                else if(sum < target){ idxS++; }
                else{ idxE--; }
            }
        }
        System.out.println(answer);
    }
}