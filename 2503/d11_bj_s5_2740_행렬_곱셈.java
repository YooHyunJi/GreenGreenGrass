package a2503;

import java.io.*;
import java.util.*;

public class d11_bj_s5_2740_행렬_곱셈 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[][] A = new int[N][M];
        for(int n=0; n<N; n++){
            st = new StringTokenizer(br.readLine());
            for(int m=0; m<M; m++){
                A[n][m] = Integer.parseInt(st.nextToken());
            }
        }

        st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[][] B = new int[M][K];
        for(int m=0; m<M; m++){
            st = new StringTokenizer(br.readLine());
            for(int k=0; k<K; k++){
                B[m][k] = Integer.parseInt(st.nextToken());
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int n=0; n<N; n++){
            for(int k=0; k<K; k++){
                int sum = 0;
                for(int m=0; m<M; m++){
                    sum += A[n][m] * B[m][k];
                }
                sb.append(sum).append(" ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}
