package a2405;

import java.io.*;
import java.util.*;

public class d30_bj_s5_14582_오늘도_졌다 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] arr = new int[18];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<18; i+=2){ arr[i] = Integer.parseInt(st.nextToken()); }
        st = new StringTokenizer(br.readLine());
        for(int i=1; i<18; i+=2){ arr[i] = Integer.parseInt(st.nextToken()); }
        int scoreA = 0, scoreB = 0;
        for(int i=0; i<17; i++){
            if(i%2==0){ scoreA += arr[i]; }
            else{ scoreB += arr[i]; }
            if(scoreB < scoreA){
                System.out.println("Yes");
                return;
            }
        }
        System.out.println("No");
    }
}