package a2406;

import java.io.*;
import java.util.*;

public class d11_bj_b4_30802_웰컴_키트 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[6];
        for(int i=0; i<6; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        int T = Integer.parseInt(st.nextToken());
        int P = Integer.parseInt(st.nextToken());
        int t = 0, p1 = N/P, p2 = N%P;
        for(int i=0; i<6; i++){
            if(arr[i] == 0){ continue; }
            t += (arr[i]-1) / T + 1;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(t).append("\n").append(p1).append(" ").append(p2);
        System.out.println(sb);
    }
}
