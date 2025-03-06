package a2503;

import java.io.*;
import java.util.*;

public class d06_bj_s2_14627_파닭파닭 {

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int S = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        int[]length = new int[S];
        long totalLength = 0;
        for(int s=0; s<S; s++){
            length[s] = Integer.parseInt(br.readLine());
            totalLength += length[s];
        }
        long left = 1;
        long right = 1_000_000_000;
        long maxLen = 0;
        while(left <= right){
            long mid = (left + right) / 2;
            int cnt = 0;
            for(int s=0; s<S; s++){
                cnt += (int) (length[s] / mid);
            }
            if(C <= cnt){
                maxLen = mid;
                left = mid + 1;
            }
            else {
                right = mid - 1;
            }
        }

        long totalNeed = maxLen * C;
        System.out.println(totalLength - totalNeed);
    }
}
