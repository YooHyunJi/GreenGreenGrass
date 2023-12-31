package a2312;

import java.io.*;

public class d31_bj_b2_27494_2023년은검은토끼의해 {
    static int lotto(int N){
        if(N<2023){ return 0; }
        int cnt = 0;
        int[] nums = {3, 2, 0, 2};
        for(int n=2023; n<=N; n++){
            int num = n;
            int idx = 0;
            while (num>0){
                if(num%10==nums[idx]){ idx++; }
                if(idx==4){
                    cnt++;
                    break;
                }
                num/=10;
            }
        }
        return cnt;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        System.out.println(lotto(N));
    }
}
