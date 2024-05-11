package a2405;

import java.io.*;
import java.util.*;

public class d11_bj_s4_2776_암기왕 {
    static int N;
    static int[] arrN;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for(int t=0; t<T; t++){
            N = Integer.parseInt(br.readLine());
            arrN = new int[N];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int n=0; n<N; n++){ arrN[n] = Integer.parseInt(st.nextToken()); }
            Arrays.sort(arrN);
            int M = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());
            for(int m=0; m<M; m++){
                int num = Integer.parseInt(st.nextToken());
                sb.append(binarySearch(num)).append("\n");
            }
        }
        System.out.println(sb);
    }

    static int binarySearch(int num){
        int from = 0;
        int to = N-1;

        while(from <= to){
            int mid = (from + to) / 2;
            int now = arrN[mid];

            if(now == num){ return 1; }
            else if(now < num){ from = mid + 1; }
            else{ to = mid - 1; }
        }
        return 0;
    }
}
