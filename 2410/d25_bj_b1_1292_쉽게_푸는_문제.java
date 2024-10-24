package a2410;

import java.io.*;
import java.util.*;

public class d25_bj_b1_1292_쉽게_푸는_문제 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        if(B == 1){
            System.out.println(1);
            return;
        }
        int[] arr = new int[B];
        arr[0] = 1;
        int idx = 1;
        for(int i=2; i<1000; i++){
            for(int j=0; j<i; j++){
                arr[idx] = arr[idx-1]+i;
                if(++idx == B){
                    int result = 0;
                    if(A == 1){ result = arr[B-1]; }
                    else{ result = arr[B-1] - arr[A-2]; }
                    System.out.println(result);
                    return;
                }
            }
        }
    }
}
