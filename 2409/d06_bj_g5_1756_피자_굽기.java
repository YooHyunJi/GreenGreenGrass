package a2409;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class d06_bj_g5_1756_피자_굽기 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int D = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        int[] oven = new int[D];
        int[] pizzas = new int[N];
        boolean[] visit = new boolean[D];
        st = new StringTokenizer(br.readLine());
        for(int d=0; d<D; d++){
            oven[d] = Integer.parseInt(st.nextToken());
            if(0 < d && oven[d-1] < oven[d]){
                oven[d] = oven[d-1];
            }
        }
        System.out.println(Arrays.toString(oven));
        st = new StringTokenizer(br.readLine());
        for(int n=0; n<N; n++){
            pizzas[n] = Integer.parseInt(st.nextToken());
        }
        if(oven[0] < pizzas[0]){
            System.out.println(0);
            return;
        }
        int from = D-1;
        int answer = 0;
        int cnt = 0;
        for(int n=0; n<N; n++){
            for(int d=from; 0<=d; d--){
                if(oven[d] < pizzas[n]){
                    continue;
                }
                from = d - 1;
                answer = d + 1;
                cnt++;
                break;
            }
        }
        if(cnt < N){
            System.out.println(0);
        }
        else{
            System.out.println(answer);
        }
    }
}
