package a2501;

import java.io.*;
import java.util.*;

public class d01_bj_b2_2511_카드놀이 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int resultA = 0;
        int[] A = new int[10];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<10; i++){
            A[i] = Integer.parseInt(st.nextToken());
        }

        int resultB = 0;
        int[] B = new int[10];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<10; i++){
            B[i] = Integer.parseInt(st.nextToken());
        }

        for(int i=0; i<10; i++){
            if(A[i] > B[i]){
                resultA += 3;
            }
            else if(A[i] < B[i]){
                resultB += 3;
            }
            else{
                resultA++;
                resultB++;
            }
        }
        StringBuilder sb = new StringBuilder();
        sb.append(resultA).append(" ").append(resultB).append("\n");
        if(resultA > resultB){
            sb.append("A");
        }
        else if(resultA < resultB){
            sb.append("B");
        }
        else{
            boolean isFound = false;
            for(int i=9; i>=0; i--){
                if(A[i] > B[i]){
                    sb.append("A");
                    isFound = true;
                    break;
                }
                else if(A[i] < B[i]){
                    sb.append("B");
                    isFound = true;
                    break;
                }
            }
            if(!isFound){
                sb.append("D");
            }
        }
        System.out.println(sb);
    }
}
