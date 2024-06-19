package a2406;

import java.io.*;
import java.util.*;

public class d19_bj_s4_11399_ATM {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int n=0; n<N; n++){
            arr[n] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        int answer = arr[0];
        for(int n=1; n<N; n++){
            arr[n] += arr[n-1];
            answer += arr[n];
        }
        System.out.println(answer);
    }
}
