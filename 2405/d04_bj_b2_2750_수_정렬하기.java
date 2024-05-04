package a2405;

import java.io.*;
import java.util.*;

public class d04_bj_b2_2750_수_정렬하기 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        for(int n=0; n<N; n++){ arr[n] = Integer.parseInt(br.readLine()); }
        Arrays.sort(arr);
        for(int n=0; n<N; n++){ sb.append(arr[n]).append("\n"); }
        System.out.println(sb);
    }
}
