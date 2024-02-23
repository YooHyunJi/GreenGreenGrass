package a2402;

import java.io.*;
import java.util.*;

public class d23_bj_b2_1009_분산처리 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int[][] arr = {
            {10},
            {1},
            {2, 4, 8, 6},
            {3, 9, 7, 1},
            {4, 6},
            {5},
            {6},
            {7, 9, 3, 1},
            {8, 4, 2, 6},
            {9, 1}
        };
        int T = Integer.parseInt(br.readLine());
        for(int t=0; t<T; t++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken())%10;
            int b = Integer.parseInt(st.nextToken());
            if(a==1 || a==5 || a==6){ sb.append(a).append("\n"); }
            else{ sb.append(arr[a][(arr[a].length+b-1)%arr[a].length]).append("\n"); }
        }
        System.out.println(sb);
    }
}