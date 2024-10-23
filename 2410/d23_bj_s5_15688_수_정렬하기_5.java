package a2410;

import java.io.*;
import java.util.*;

public class d23_bj_s5_15688_수_정렬하기_5 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        for(int n=0; n<N; n++){
            arr[n] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(arr);
        StringBuilder sb = new StringBuilder();
        for(int n=0; n<N; n++){
            sb.append(arr[n]).append("\n");
        }
        System.out.println(sb);
    }
}
