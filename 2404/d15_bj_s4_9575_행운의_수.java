package a2404;

import java.io.*;
import java.util.*;

public class d15_bj_s4_9575_행운의_수 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for(int t=0; t<T; t++){
            HashSet<Integer> set = new HashSet<>();

            int N = Integer.parseInt(br.readLine());
            int[] A = new int[N];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int n=0; n<N; n++){ A[n] = Integer.parseInt(st.nextToken()); }

            int M = Integer.parseInt(br.readLine());
            int[] B = new int[M];
            st = new StringTokenizer(br.readLine());
            for(int m=0; m<M; m++){ B[m] = Integer.parseInt(st.nextToken()); }

            int K = Integer.parseInt(br.readLine());
            int[] C = new int[K];
            st = new StringTokenizer(br.readLine());
            for(int k=0; k<K; k++){ C[k] = Integer.parseInt(st.nextToken()); }

            for(int n=0; n<N; n++){
                for(int m=0; m<M; m++){
                    for(int k=0; k<K; k++){
                        int sum = A[n] + B[m] + C[k];
                        if(getLucky(sum)){ set.add(sum); }
                    }
                }
            }
            sb.append(set.size()).append("\n");
        }
        System.out.println(sb);
    }

    static boolean getLucky(int sum){
        while(sum > 0){
            if(sum % 10 != 5 && sum % 10 != 8){ return false; }
            sum /= 10;
        }
        return true;
    }
}
