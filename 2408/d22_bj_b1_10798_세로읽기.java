package a2408;

import java.io.*;

public class d22_bj_b1_10798_세로읽기 {
    public static void main(String[] args) throws Exception{
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[][] arr = new char[5][15];
        int max = 0;
        for(int r=0; r<5; r++){
            arr[r] = br.readLine().toCharArray();
            max = Math.max(max, arr[r].length);
        }
        for(int i=0; i<max; i++){
            for(int r=0; r<5; r++){
                if(arr[r].length - 1 < i){ continue; }
                sb.append(arr[r][i]);
            }
        }
        System.out.println(sb);
    }
}