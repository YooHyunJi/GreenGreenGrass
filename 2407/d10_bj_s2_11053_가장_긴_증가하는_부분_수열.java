package a2407;

import java.io.*;
import java.util.*;

public class d10_bj_s2_11053_가장_긴_증가하는_부분_수열 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        int[] lis = new int[N];
        int size = 0;
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int n=0; n<N; n++){ arr[n] = Integer.parseInt(st.nextToken()); }
        lis[0] = arr[0];
        for(int n=1; n<N; n++){
            if(lis[size] < arr[n]){
                lis[++size] = arr[n];
                continue;
            }
            int idx = binarySearch(lis, 0, size, arr[n]);
            lis[idx] = arr[n];
        }
        System.out.println(size+1);
    }

    static int binarySearch(int[] lis, int from, int to, int num) {
        while(from < to){
            int mid = (from + to) / 2;
            if(lis[mid] < num){ from = mid + 1; }
            else{ to = mid; }
        }
        return to;
    }
}
