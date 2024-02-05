package a2402;

import java.io.*;
import java.util.*;

public class d05_bj_s4_1920_수찾기 {
    static int[] arr;
    static StringBuilder sb = new StringBuilder();

    static void divide(int start, int end, int num, boolean finish){
        if(finish){ return; }
        int mid = (start+end)/2;
        if(num==arr[mid]){
            sb.append("1\n");
            finish = true;
            return;
        }
        if(start>=end){
            sb.append("0\n");
            finish = true;
            return;
        }
        else if(num<arr[mid]) { divide(start, mid-1, num, finish);  }
        else{ divide(mid+1, end, num, finish); }
        return;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int n=0; n<N; n++) { arr[n] = Integer.parseInt(st.nextToken()); }
        Arrays.sort(arr);
        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for(int m=0; m<M; m++){ divide(0, N-1, Integer.parseInt(st.nextToken()), false); }
        System.out.println(sb);
    }
}
