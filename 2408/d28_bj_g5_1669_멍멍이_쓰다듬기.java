package a2408;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class d28_bj_g5_1669_멍멍이_쓰다듬기 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int X = Integer.parseInt(st.nextToken());
        int Y = Integer.parseInt(st.nextToken());
        int diff = Y - X;
        if(diff <= 2){
            System.out.println(diff);
            return;
        }
        diff -= 2;
        int answer = 2;
        int[] num = new int[2];
        Arrays.fill(num, 1);
        for(int i=0; 0<diff; i++){
            int now = i % 2;
            if(num[now] < diff){
                num[now]++;
            }
            diff -= num[now];
            answer++;
        }
        System.out.println(answer);
    }
}
