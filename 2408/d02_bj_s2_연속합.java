package a2408;

import java.io.*;
import java.util.*;

public class d02_bj_s2_연속합 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        arr[0] = Integer.parseInt(st.nextToken());
        int answer = arr[0];
        for(int n=1; n<N; n++){
            int num = Integer.parseInt(st.nextToken());
            arr[n] = arr[n-1] < 0? num: arr[n-1] + num;
            answer = Math.max(answer, arr[n]);
        }
        System.out.println(answer);
    }
}
