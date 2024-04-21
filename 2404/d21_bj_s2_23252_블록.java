package a2404;

import java.io.*;
import java.util.*;

public class d21_bj_s2_23252_블록 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for(int t=0; t<T; t++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            int C = Integer.parseInt(st.nextToken());
            sb.append(getResult(A, B, C)).append("\n");
        }
        System.out.println(sb);
    }
    static String getResult(int A, int B, int C){
        if(A==0){
            // C
            if(B==0){ return "No"; }
            // B
            else if(C==0){
                if(B%2 == 0){ return "Yes"; }
                else{ return "No"; }
            }
            // B, C
            else{ return "No"; }
        }
        else if(B==0){
            // A
            if(C==0){
                if(A%2==0){ return "Yes"; }
                else{ return "No"; }
            }
            // A, C
            else{
                if(A<C){ return "No"; }
                else if((A-C)%2==0){ return "Yes"; }
                else{ return "No"; }
            }
        }
        // A, B
        else if(C==0){
            if(A%2==0){ return "Yes"; }
            else{ return "No"; }
        }
        // A, B, C
        else{
            if(A<C){ return "No"; }
            else if(A==C){ return "Yes"; }
            else{
                if((A-C)%2==0){ return "Yes"; }
                else{ return "No"; }
            }
        }
    }
}
