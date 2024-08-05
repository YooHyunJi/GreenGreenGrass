package a2408;

import java.io.*;
import java.util.*;

public class d05_bj_s3_21921_블로그 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken());
        int[] total = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            total[i] = Integer.parseInt(st.nextToken());
        }
        int nowTotal = 0;
        int day = 1;
        for(int i=0; i<X; i++){ nowTotal += total[i]; }
        int maxTotal = nowTotal;
        for(int i=0; i<N-X; i++){
            nowTotal -= total[i];
            nowTotal += total[i+X];
            if(maxTotal < nowTotal){
                maxTotal = nowTotal;
                day = 1;
            }
            else if(maxTotal == nowTotal){
                day++;
            }
        }
        if(maxTotal == 0){
            System.out.println("SAD");
        }
        else{
            System.out.println(maxTotal);
            System.out.println(day);
        }
    }
}
