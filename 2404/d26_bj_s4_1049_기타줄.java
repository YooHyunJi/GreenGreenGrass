package a2404;

import java.io.*;
import java.util.*;

public class d26_bj_s4_1049_기타줄 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[][] price = new int[M][3];
        int minSix = 1111, minOne = 1111;
        for(int m=0; m<M; m++){
            st = new StringTokenizer(br.readLine());
            int six = Integer.parseInt(st.nextToken());
            int one = Integer.parseInt(st.nextToken());
            price[m] = new int[] {one, one*6, six};
            minSix = Math.min(minSix,(Math.min(one*6, six)));
            minOne = Math.min(minOne, one);
        }
        int valueSix = N/6;
        int valueOne = N%6;
        int answer = 0;
        if(valueOne*minOne > minSix){ answer = (valueSix+1)*minSix; }
        else{ answer = valueSix*minSix + valueOne*minOne; }
        System.out.println(answer);
    }
}
