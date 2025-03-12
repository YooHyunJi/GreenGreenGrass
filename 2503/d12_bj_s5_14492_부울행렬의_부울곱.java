package a2503;

import java.io.*;
import java.util.*;

public class d12_bj_s5_14492_부울행렬의_부울곱 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] A = new int[N][N];
        int[][] B = new int[N][N];
        for(int r=0; r<N; r++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int c=0; c<N; c++){
                A[r][c] = Integer.parseInt(st.nextToken());
            }
        }
        for(int r=0; r<N; r++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int c=0; c<N; c++){
                B[r][c] = Integer.parseInt(st.nextToken());
            }
        }
        int answer = 0;
        for(int r=0; r<N; r++){
            for(int c=0; c<N; c++){
                int cnt = 0;
                for(int d=0; d<N; d++){
                   cnt += A[r][d] * B[d][c];
                }
                answer += 0 < cnt? 1: 0;
            }
        }
        System.out.println(answer);
    }
}
