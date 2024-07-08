package a2407;

import java.io.*;
import java.util.*;

public class d08_bj_s1_6064_카잉_달력 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for(int t=0; t<T; t++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int M = Integer.parseInt(st.nextToken());
            int N = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int num = x;
            boolean isFind = false;
            while(num <= M * N){
                if(num % N == y || (y == N && num % N == 0)){
                    isFind = true;
                    break;
                }
                num += M;
            }
            if(!isFind){ num = -1; }
            sb.append(num).append("\n");
        }
        System.out.println(sb);
    }
}
