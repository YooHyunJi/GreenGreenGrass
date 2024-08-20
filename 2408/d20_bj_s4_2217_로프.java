package a2408;

import java.io.*;
import java.util.*;

public class d20_bj_s4_2217_로프 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        for(int n=0; n<N; n++){ arr[n] = Integer.parseInt(br.readLine()); }
        Arrays.sort(arr);
        int  answer = 0;
        for(int n=N-1, k=1; n>=0; n--, k++){
            answer = Math.max(answer, arr[n] * k);
        }
        System.out.println(answer);
    }
}
