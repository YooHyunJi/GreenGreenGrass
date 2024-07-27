package a2407;

import java.io.*;
import java.util.*;

public class d27_bj_s5_3060_욕심쟁이_돼지 {
    public static void main(String[] args) throws Exception{
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for(int t=0; t<T; t++){
            int N = Integer.parseInt(br.readLine());
            int[][] pigs = new int[2][6];
            StringTokenizer st = new StringTokenizer(br.readLine());
            int sum = 0;
            for(int i=0; i<6; i++){
                pigs[0][i] = Integer.parseInt(st.nextToken());
                sum += pigs[0][i];
            }
            if(N < sum){
                sb.append("1\n");
            }
            else{
                int day = 1;
                while(true){
                    day++;
                    int now = day % 2;
                    int nxt = (day+1) % 2;
                    sum = 0;
                    for(int i=0; i<6; i++){
                        pigs[nxt][i] = pigs[now][i] + pigs[now][(6+i-1)%6] + pigs[now][(i+1)%6] + pigs[now][(i+3)%6];
                        sum += pigs[nxt][i];
                    }
                    if(N < sum){ break; }
                }
                sb.append(day).append("\n");
            }
        }
        System.out.println(sb);
    }
}
