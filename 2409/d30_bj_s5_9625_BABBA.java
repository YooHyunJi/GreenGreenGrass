package a2409;

import java.io.*;

public class d30_bj_s5_9625_BABBA {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int K = Integer.parseInt(br.readLine());
        int A = 1;
        int B = 0;
        for(int k=0; k<K; k++){
            int a = B;
            int b = A + B;
            A = a;
            B = b;
        }
        System.out.println(A+" "+B);
    }
}
