package a2408;

import java.io.*;

public class d01_bj_s3_1913_달팽이 {
    public static void main(String[] args) throws Exception{
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int K = Integer.parseInt(br.readLine());
        int[][] arr = new int[N][N];
        int r = N/2;
        int c = N/2;
        int num = 1;
        int answerR = r+1;
        int answerC = c+1;
        arr[r--][c--] = num++;
        int[] dr = {0, 1, 0, -1}, dc= {1, 0, -1, 0};

        int cnt = 2;
        while(num <= N*N){
            for(int d=0; d<4; d++){
                for(int i=0; i<cnt; i++){
                    r += dr[d];
                    c += dc[d];
                    if(num == K){
                        answerR = r+1;
                        answerC = c+1;
                    }
                    arr[r][c] = num++;
                }
            }
            cnt+=2;
            r--;
            c--;
        }
        for(int rr=0; rr<N; rr++){
            for(int cc=0; cc<N; cc++){
                sb.append(arr[rr][cc]).append(" ");
            }
            sb.append("\n");
        }
        sb.append(answerR).append(" ").append(answerC);
        System.out.println(sb);
    }
}
