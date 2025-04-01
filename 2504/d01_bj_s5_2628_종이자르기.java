package a2504;

import java.io.*;
import java.util.*;

public class d01_bj_s5_2628_종이자르기 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int W = Integer.parseInt(st.nextToken());
        int H = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(br.readLine());
        boolean[] width_b = new boolean[W];
        boolean[] height_b = new boolean[H];
        for(int n=0; n<N; n++){
            st = new StringTokenizer(br.readLine());
            int d = Integer.parseInt(st.nextToken());
            int num = Integer.parseInt(st.nextToken());
            if(d == 0){
                height_b[num] = true;
            }
            else{
                width_b[num] = true;
            }
        }
        List<Integer> width_l = new ArrayList<>();
        List<Integer> height_l = new ArrayList<>();
        int start = 0;
        for(int i=1; i<=W; i++){
            if(i == W || width_b[i]){
                int length = i - start;
                width_l.add(length);
                start = i;
            }
        }
        start = 0;
        for(int i=1; i<=H; i++){
            if(i == H || height_b[i]){
                int length = i - start;
                height_l.add(length);
                start = i;
            }
        }
        int answer = 0;
        for(int w: width_l){
            for(int h: height_l){
                int size = w * h;
                answer = Math.max(answer, size);
            }
        }
        System.out.println(answer);
    }
}
